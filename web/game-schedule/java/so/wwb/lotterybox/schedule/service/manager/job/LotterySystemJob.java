package so.wwb.lotterybox.schedule.service.manager.job;


import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.common.IMessageService;
import so.wwb.lotterybox.iservice.manager.sys.ISysSiteGroupService;
import so.wwb.lotterybox.iservice.manager.sys.ISysSiteService;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryOperationEnum;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteGroupVo;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.Future;

/**
 * 系统彩父类
 * Created by steady on 2018-09-07
 */
public class LotterySystemJob {

    private static final Log LOG = LogFactory.getLog(LotterySystemJob.class);

    private static final String ALL = "all";
    //东八区
    private static int GTM8 = 8;

    @Autowired
    private ISysSiteGroupService groupService;
    @Autowired
    private ISysSiteService sysSiteService;
    @Autowired
    private IMessageService messageService;//消息推送

    /**
     * 自动生成,不读取开奖结果
     * 00:01:00为系统彩第1期，24:00:00为系统彩第1440期
     * @return 当前需要开奖的期数
     */
    protected static String caculteExpect(String code) {
        String expect = null;
        if (LotteryEnum.JISK3.getCode().equals(code) || LotteryEnum.FFSSC.getCode().equals(code) ||
                LotteryEnum.JSPK10.getCode().equals(code)) {
            Date date = DateTool.addSeconds(new Date(),10);
            date = DateTool.addHours(date,8);
            int dd = Integer.valueOf(DateTool.formatDate(date, "yyyyMMdd"));
            int hh = Integer.valueOf(DateTool.formatDate(date, "HH")) * 60;
            int mm = Integer.valueOf(DateTool.formatDate(date, "mm"));
            if (hh == 0 && mm == 0){
                //允许最大延迟10s
                expect = DateTool.formatDate(DateTool.addSeconds(date, -20), "yyyyMMdd") + "1440";
            } else {
                expect = String.valueOf(dd) + StringTool.leftPad(String.valueOf(hh + mm), 4, "0");
            }
        } else if (LotteryEnum.JSLHC.getCode().equals(code)) {
            Date date = DateTool.addSeconds(new Date(),30);
            date = DateTool.addHours(date,8);
            int dd = Integer.valueOf(DateTool.formatDate(date, "yyyyMMdd"));
            int hh = Integer.valueOf(DateTool.formatDate(date, "HH")) * 60;
            int mm = Integer.valueOf(DateTool.formatDate(date, "mm"));
            if (hh == 0 && mm == 0){
                //允许最大延迟10s
                expect = DateTool.formatDate(DateTool.addSeconds(date, -40), "yyyyMMdd") + "0288";
            } else {
                expect = String.valueOf(dd) + StringTool.leftPad(String.valueOf((hh + mm)/5), 4, "0");
            }
        }
        return expect;
    }

    /**
     * @param group 分组代号
     * @return 站点ID集合，不允许重复ID
     *         若分组代号为空，则返回所有站点ID
     *         否则返回该分组所有站点ID
     *         group 为all是所有站点
     */
    protected List<Integer> fetchGroupSite(String group) {
        List<Integer> list = new ArrayList<>();

        if (ALL.equals(group) || StringTool.isEmpty(group)) {
            Map<String, SysSite> map = CacheBase.getSysSite();
            map.forEach((k,v) -> findAvaliableSite (k,v,list));
        } else {
            SysSiteGroupVo groupVo = new SysSiteGroupVo();
            groupVo.getSearch().setCode(group);
            groupVo = groupService.getGroupByCode(groupVo);
            if (groupVo.getResult() != null) {
                if (groupVo.getResult().getSites() != null) {
                    if (groupVo.getResult().getSites().length > 0) {
                        list.addAll(Arrays.asList(groupVo.getResult().getSites()));
                    } else {
                        Map<String, SysSite> map = CacheBase.getSysSite();
                        map.forEach((k, v) -> findAvaliableSite(k, v, list));
                    }
                } else {
                    Map<String, SysSite> map = CacheBase.getSysSite();
                    map.forEach((k,v) -> findAvaliableSite (k,v,list));
                }
            } else {
                Map<String, SysSite> map = CacheBase.getSysSite();
                map.forEach((k,v) -> findAvaliableSite (k,v,list));
            }
        }

        return list;
    }

    private void findAvaliableSite (String key, SysSite sysSite, List<Integer> list) {
        if ("merchant".equals(sysSite.getSiteClassifyKey()) || "merchant-api".equals(sysSite.getSiteClassifyKey())) {
            list.add(Integer.valueOf(key));
        }
    }
    /**
     * @return 极速PK10的合法随机开奖号码
     */
    public static List<String> randomJspk10(){
        SecureRandom secureRandom = new SecureRandom();
        List<String> pk10CodeList = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            pk10CodeList.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 10) {
            secureRandom.setSeed(secureRandom.nextLong());
            int index = secureRandom.nextInt(pk10CodeList.size());
            codeSet.add(pk10CodeList.get(index));
            pk10CodeList.remove(index);
        }
        return new ArrayList<>(codeSet);
    }


    /**
     * @return 分分时时彩的合法随机开奖号码
     */
    public static List<String> randomFfssc(){
        SecureRandom secureRandom = new SecureRandom();
        String [] resultArray = new String [5];
        for (int i = 0; i < resultArray.length; i++) {
            secureRandom.setSeed(secureRandom.nextLong());
            resultArray[i] = String.valueOf(secureRandom.nextInt(10));
        }
        return Arrays.asList(resultArray);
    }

    /**
     * @return 极速快3的合法随机开奖号码
     */
    public static List<String> randomJsk3(){
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        List<String> nums = new ArrayList<>(6);
        for (int i = 1; i <= 6; i++) {
            nums.add(String.valueOf(i));
        }
        List<String> codeList = new ArrayList<>(3);
        while (codeList.size() != 3) {
            int index = secureRandom.nextInt(nums.size());
            codeList.add(nums.get(index));
        }
        Collections.sort(codeList);
        return codeList;
    }

    /**
     * @return 极速六合彩的合法随机开奖号码
     */
    /**
     * jslhc随机开号
     * @return list
     */
    private static List<String> randomJslhc(){
        SecureRandom secureRandom = new SecureRandom();
        List<String> jslhc = new ArrayList<>(49);
        for (int i = 1; i <= 49; i++) {
            jslhc.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        secureRandom.setSeed(secureRandom.nextLong());
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 7) {
            int index = secureRandom.nextInt(jslhc.size());
            codeSet.add(jslhc.get(index));
            jslhc.remove(index);
        }
        return new ArrayList<>(codeSet);
    }

    protected void initSiteLottery (Integer siteId, List<Lottery> list, String code) {
        Lottery lottery = CacheBase.getLottery(siteId,code);
        if (lottery != null) {
            list.add(lottery);
        }
    }

    public static List<String> randomOpenCodes (String code) {
        List<String> list = new ArrayList<>();
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class,code);
        switch (lotteryEnum){
            case JSPK10: list = LotterySystemJob.randomJspk10();
                break;
            case JISK3: list = LotterySystemJob.randomJsk3();
                break;
            case FFSSC: list = LotterySystemJob.randomFfssc();
                break;
            case JSLHC: list = LotterySystemJob.randomJslhc();
                break;
        }
        return list;
    }


    public void validateResultList(List<Future<LotteryResultNumberVo>> futures) {

        for (Future<LotteryResultNumberVo> future : futures){
            LotteryResultNumberVo lotteryResultNumberVo = null;
            try {
                lotteryResultNumberVo = future.get();
            } catch (Exception e) {
                LOG.error(e, "获取线程返回结果异常");
            }
            if (lotteryResultNumberVo != null && lotteryResultNumberVo.isSuccess()) {
                SysSiteVo sysSiteVo = new SysSiteVo();
                sysSiteVo.getSearch().setId(lotteryResultNumberVo._getSiteId());
                sysSiteService.get(sysSiteVo);
                if (SubSysCodeEnum.COMPANY.getCode().equals(sysSiteVo.getResult().getSiteClassifyKey())) {
                    sendApiMessage(getApiMsgBody(
                            lotteryResultNumberVo._getSiteId().toString(),
                            lotteryResultNumberVo.getResult().getCode(),
                            lotteryResultNumberVo.getResult().getExpect()));
                }
            }
        }
    }

    /**
     * 消息发送
     */
    private void sendApiMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.MERCHANT_API.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToApiMsg(message);
    }

    /**
     * 设置失败消息主体内容
     */
    private static String getApiMsgBody(String siteId, String code, String expect) {
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("siteId", siteId);
        map.put("code", code);
        map.put("expect", expect);
        return JsonTool.toJson(map);
    }
}

