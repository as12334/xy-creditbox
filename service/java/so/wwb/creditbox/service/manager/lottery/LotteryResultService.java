package so.wwb.creditbox.service.manager.lottery;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;
import org.soul.model.security.privilege.vo.SysResourceListVo;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.lottery.LotteryResultMapper;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryResultTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResultRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryTypeInfo;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultRecordVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.*;


/**
 * 开奖结果主表服务
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public class LotteryResultService extends BaseService<LotteryResultMapper, LotteryResultListVo, LotteryResultVo, LotteryResult, Integer> implements ILotteryResultService {
    private Log LOG = LogFactory.getLog(LotteryResultService.class);
    @Autowired
    LotteryResultPayoutService lotteryResultPayoutService;
    @Autowired
    LotteryWinningRecordService lotteryWinningRecordService;
//endregion your codes 1

    //region your codes 2
    //开奖间隔
    private final int offset = 30;

    @Autowired
    LotteryResultRecordService lotteryResultRecordService;

    private static JedisClientProxy jedisTemplate = (JedisClientProxy) SpringTool.getBean("jedisTemplateData");

    @Override
    public Map<String, Map<String, LotteryResult>> load(LotteryResultVo vo) {
        Map<String, Map<String, LotteryResult>> result = new LinkedHashMap<>();
        LotteryResultSo resultSo = vo.getSearch();
        if (resultSo != null && StringTool.isNotBlank(resultSo.getCode())) {
            List<LotteryResult> list = mapper.getCurLotteryResult(resultSo);
            if (CollectionTool.isNotEmpty(list)) {
                Map<String, LotteryResult> resultMap = CollectionTool.toEntityMap(list, LotteryResult.PROP_EXPECT, String.class);
                result.put(resultSo.getCode(), resultMap);
            }
        }
        return result;
    }


    @Override
    public List<LotteryResult> queryRecentResult(LotteryResultVo vo) {
        return this.mapper.queryRecentResult();
    }

    @Override
    public List<LotteryResult> queryRecentOpenResult(LotteryResultListVo listVo) {
        return this.mapper.queryRecentOpenResult(listVo);
    }

    @Override
    public List<LotteryResult> queryFiveRecentOpenResult(LotteryResultVo lotteryResultVo) {
        return mapper.queryFiveRecentOpenResult(lotteryResultVo.getSearch());
    }

    @Override
    public Boolean doInitLotteryJob(Date initDate) {
        Boolean init = excuteInit(initDate);
        if (init) {
            init = excuteInit(DateTool.addDays(initDate, 1));
        }
        return init;
    }

    private Boolean excuteInit(Date initDate) {
        CallableStatement cs = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            DruidDataSource dataSource = (DruidDataSource) SpringTool.getBean("bossDataSource");
            conn = dataSource.getConnection();
            cs = conn.prepareCall("SELECT  f_init_lottery_result(?)");
            cs.setDate(1, new java.sql.Date(initDate.getTime()));
            String currentDate = DateTool.formatDate(initDate, DateTool.yyyyMMdd);
            LOG.info("彩票初始化开奖结果，调用f_init_lottery_result过程的参数为：{0}", currentDate);
            boolean rtn = cs.execute();
            LOG.info("彩票初始化开奖结果执行结果:{0}", rtn);
            return rtn;
        } catch (Exception ex) {
            LOG.error(ex);
        } finally {
            DatasourceTool.release(conn, cs, null);
        }
        return false;
    }


    @Override
    public List<LotteryResult> searchCurLotteryResult(LotteryResultVo resultVo) {
        return mapper.searchCurLotteryResult(resultVo.getSearch());
    }
    @Override
    public void saveLotterResult(LotteryResultVo lotterResultVo) {
        openLotteryResult(lotterResultVo);
    }

    @Override
    public LotteryResultVo openLotteryResult(LotteryResultVo resultVo) {
        LotteryResultService resultService = SpringTool.getBean(LotteryResultService.class);
        resultVo = resultService.buildLotteryResult(resultVo);
        String msg = resultVo.isSuccess() ? resultVo.getOkMsg() : resultVo.getErrMsg();
        LOG.info("保存开奖结果是否成功:{0},原因:{1}", resultVo.isSuccess() ? "是" : "否", msg);
        if (resultVo.isSuccess()) {
            boolean flag = lotteryResultPayoutService.payoutForAll(resultVo);
            if (flag) {
                resultVo.setSuccess(true);
                resultVo.setOkMsg("派彩成功");
                LOG.info("派彩成功");
            } else {
                resultVo.setSuccess(false);
                resultVo.setErrMsg("派彩失败");
                LOG.error("派彩失败");
            }
            msg = resultVo.isSuccess() ? resultVo.getOkMsg() : resultVo.getErrMsg();
            LOG.info("派彩是否成功:{0}", resultVo.isSuccess() ? "是" : "否", msg);
        }
        return resultVo;
    }

    @Override
    @Transactional
    public LotteryResultVo buildLotteryResult(LotteryResultVo resultVo) {
        if (validLotteryResult(resultVo)) {
            return resultVo;
        }
        resultVo = saveUpdateLotteryResult(resultVo);
        return resultVo;
    }

    @Override
    public List<Integer> queryBossIds(SysResourceListVo listVo) {
        return this.mapper.queryBossIds(listVo.getSearch());
    }
    @Override
    public LotteryResult searchByCurTime(LotteryResultVo resultVo) {
        return mapper.searchByCurTime(resultVo.getSearch());
    }
    @Override
    public boolean validLotteryResult(LotteryResultVo resultVo) {
        LOG.info("彩票开奖信息:{0}", JsonTool.toJson(resultVo));
        if (resultVo.getResult() == null || StringTool.isBlank(resultVo.getResult().getExpect())
                || StringTool.isBlank(resultVo.getResult().getCode())
                || StringTool.isBlank(resultVo.getResult().getOpenCode())
                || StringTool.isBlank(resultVo.getResult().getType())
                || resultVo.getResult().getOpenTime() == null) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖信息不全");
            LOG.info("彩票开奖信息:{0}", JsonTool.toJson(resultVo));
            return true;
        }
        if (resultVo.getResult().getOpenTime().getTime() > System.currentTimeMillis()) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未到开奖时间！");
            LOG.info("未到开奖时间！");
            return true;
        }
        String openCode = resultVo.getResult().getOpenCode();
        String[] numbers = openCode.split(",");
        int num = numbers.length;
        String code = resultVo.getResult().getCode();
        String type = resultVo.getResult().getType();
        if (StringTool.equals(type, LotteryEnum.CQSSC.getType()) && num != 5) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(type, LotteryEnum.JSK3.getType()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.CQXYNC.getCode()) && num != 8) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.BJKL8.getCode()) && num != 20) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.XY28.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.GDKL10.getCode()) && num != 8) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.BJPK10.getCode()) && num != 10) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.XYFT.getCode()) && num != 10) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.TCPL3.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.FC3D.getCode()) && num != 3) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        } else if (StringTool.equals(code, LotteryEnum.HKLHC.getCode()) && num != 7) {
            resultVo.setSuccess(false);
            resultVo.setErrMsg("开奖号码不全");
            return true;
        }
        if (StringTool.equals(resultVo.getSearch().getCode(), LotteryEnum.HKLHC.getCode()) ||
                StringTool.equals(code, LotteryEnum.CQXYNC.getCode()) ||
                StringTool.equals(code, LotteryEnum.GDKL10.getCode()) ||
                StringTool.equals(code, LotteryEnum.XYFT.getCode()) ||
                StringTool.equals(code, LotteryEnum.BJKL8.getCode()) ||
                StringTool.equals(code, LotteryEnum.BJPK10.getCode()) ||
                StringTool.equals(code, LotteryEnum.JSPK10.getCode())) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (StringTool.equals(numbers[i], numbers[j])) {
                        resultVo.setSuccess(false);
                        resultVo.setErrMsg("开奖号码不能相同");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public LotteryResultVo saveUpdateLotteryResult(LotteryResultVo resultVo) {
        Criteria criteria = Criteria.add(LotteryResult.PROP_EXPECT, Operator.EQ, resultVo.getResult().getExpect());
        criteria.addAnd(LotteryResult.PROP_CODE, Operator.EQ, resultVo.getResult().getCode());
        criteria.addAnd(LotteryResult.PROP_TYPE, Operator.EQ, resultVo.getResult().getType());
        List<LotteryResult> search = mapper.search(criteria);

        LotteryResult result = null;
        boolean success = false;
        if (search != null && search.size() == 1) {
            result = search.get(0);
            LOG.info("{0}开奖记录已存在，进行修改,彩集时间:{1}", result.getExpect(), resultVo.getResult().getGatherTime());
            List<String> proList = new ArrayList<>();
            proList.add(LotteryResult.PROP_OPEN_CODE);
            proList.add(LotteryResult.PROP_OPEN_TIME);
            proList.add(LotteryResult.PROP_ORIGIN);
            if (resultVo.getResult().getOpeningTime() != null) {
                result.setOpeningTime(resultVo.getResult().getOpeningTime());
                proList.add(LotteryResult.PROP_OPENING_TIME);
            }
            if (resultVo.getResult().getCloseTime() != null) {
                result.setCloseTime(resultVo.getResult().getCloseTime());
                proList.add(LotteryResult.PROP_CLOSE_TIME);
            }
            if (resultVo.getResult().getGatherTime() != null) {
                result.setGatherTime(resultVo.getResult().getGatherTime());
                proList.add(LotteryResult.PROP_GATHER_TIME);
            }

            String property = CollectionTool.toString(proList);
            String[] properties = property.split(",");
            result.setOpenCode(resultVo.getResult().getOpenCode());
            result.setOpenTime(resultVo.getResult().getOpenTime());
            result.setOrigin(resultVo.getResult().getOrigin());
            Boolean hash = checkLotteryResultHash(result, LotteryResultTypeEnum.UPDATE.getCode(), resultVo.getUpdateUserName());
            success = (hash) ? mapper.updateOnly(result, properties) : false;
            result = mapper.get(result.getId());
        } else {
            LOG.info("新增一条开奖记录:");
            result = resultVo.getResult();
            Boolean hash = checkLotteryResultHash(result, LotteryResultTypeEnum.INSERT.getCode(), resultVo.getUpdateUserName());
            success = (hash) ? mapper.insert(result) : false;
        }
        resultVo.setResult(result);
        resultVo.setSuccess(success);

        return resultVo;
    }
    //保存开奖结果记录
    private Boolean checkLotteryResultHash(LotteryResult lotteryResult, String type, String userName) {
        boolean validOffsetHash = checkOffsetHash(lotteryResult);
        LotteryResultRecordVo lotteryResultRecordVo = new LotteryResultRecordVo();
        lotteryResultRecordVo.setSuccess(false);
        if (validOffsetHash) {
            LotteryResultRecord lotteryResultRecord = new LotteryResultRecord();
            lotteryResultRecord.setCode(lotteryResult.getCode());
            lotteryResultRecord.setExpect(lotteryResult.getExpect());
            lotteryResultRecord.setOpenCode(lotteryResult.getOpenCode());
            lotteryResultRecord.setCreateTime(new Date());
            String updateUserName = (StringTool.isNotBlank(userName)) ? userName : "采集任务";
            lotteryResultRecord.setUserName(updateUserName);
            lotteryResultRecord.setRecordType(type);
            String resultHash = getPayOutHash(lotteryResult);
            lotteryResultRecord.setHash(resultHash);
            lotteryResultRecordVo.setResult(lotteryResultRecord);
            try {
                lotteryResultRecordVo = lotteryResultRecordService.insert(lotteryResultRecordVo);
                jedisTemplate.setex(getHashKey(lotteryResult), 60, resultHash);
            } catch (Exception e) {
                LOG.info("保存开奖日志频繁,参数:{0},{1}", lotteryResult.getCode(), lotteryResult.getExpect());
                return false;
            }
        }
        return lotteryResultRecordVo.isSuccess();
    }
    /**
     * 是否开奖间隔内满足hash
     *
     * @param lotteryResult
     * @return
     */
    private boolean checkOffsetHash(LotteryResult lotteryResult) {
        String key = getHashKey(lotteryResult);
        String lastHash = jedisTemplate.get(key);
        String offsetHash = getPayOutHash(lotteryResult, DateTool.addSeconds(new Date(), -offset));
        String currentHash = getPayOutHash(lotteryResult);
        LOG.info("参数:{0},上次开奖hash:{1},间隔hash:{2},当前hash:{3},结果:{4}", key, lastHash, offsetHash, currentHash, offsetHash.equals(lastHash));
        if (StringTool.isNotBlank(lastHash) && (offsetHash.equals(lastHash) || currentHash.equals(lastHash))) {
            return false;
        }
        return true;
    }
    private String getHashKey(LotteryResult lotteryResult) {
        return lotteryResult.getCode() + "@" + lotteryResult.getExpect();
    }
    //保存开奖结果记录
    private LotteryResultRecordVo checkLotteryResultHashs(LotteryResult lotteryResult, String type, String userName) {

        LotteryResultRecordVo lotteryResultRecordVo = new LotteryResultRecordVo();
        lotteryResultRecordVo.setSuccess(false);

        LotteryResultRecord lotteryResultRecord = new LotteryResultRecord();
        lotteryResultRecord.setCode(lotteryResult.getCode());
        lotteryResultRecord.setExpect(lotteryResult.getExpect());
        lotteryResultRecord.setOpenCode(lotteryResult.getOpenCode());
        lotteryResultRecord.setCreateTime(new Date());
        String updateUserName = (StringTool.isNotBlank(userName)) ? userName : "采集任务";
        lotteryResultRecord.setUserName(updateUserName);
        lotteryResultRecord.setRecordType(type);
        String resultHash = getPayOutHash(lotteryResult);
        lotteryResultRecord.setHash(resultHash);
        lotteryResultRecordVo.setResult(lotteryResultRecord);
        try {
            lotteryResultRecordVo = lotteryResultRecordService.insert(lotteryResultRecordVo);
            lotteryResultRecordVo.setSuccess(true);
        } catch (Exception e) {
            LOG.info("保存开奖日志频繁,参数:{0},{1}", lotteryResult.getCode(), lotteryResult.getExpect());
            lotteryResultRecordVo.setSuccess(false);
            lotteryResultRecordVo.setErrMsg("10秒内不可重复操作");
        }

        return lotteryResultRecordVo;
    }
    private String getPayOutHash(LotteryResult result) {
        return getPayOutHash(result, new Date());
    }
    private String getPayOutHash(LotteryResult result, Date date) {
        int ss = (int) (date.getTime() / 1000 / offset);
        return MessageFormat.format("{0}_{1}_{2}_{3}", result.getCode(), result.getType(),
                result.getExpect(), ss);
    }
    //endregion your codes 2

}