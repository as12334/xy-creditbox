package so.wwb.creditbox.service.manager.gather;

import com.alibaba.fastjson.JSONObject;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryOwnRuleService;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryOriginEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOwnRule;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryOwnRuleVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.security.SecureRandom;
import java.util.*;

/**
 * Created by aaa on 17-8-23.
 */
public class AutomaticHandle implements ILotteryGatherHandle {

    private static Log LOG = LogFactory.getLog(AutomaticHandle.class);

    @Override
    public LotteryResultListVo doCollection(LotteryGatherParam gatherParam) {
        return null;
    }

    @Override
    public LotteryResultVo doGather(LotteryGatherParam gatherParam) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        String code = gatherParam.getCode();
        String expect = gatherParam.getExpect();
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, code);
        lotteryResultVo.getSearch().setCode(code);
        lotteryResultVo.getSearch().setExpect(expect);
        lotteryResultVo = SpringTool.getBean(ILotteryResultService.class).search(lotteryResultVo);
        if (lotteryResultVo.getResult() != null && StringTool.isNotBlank(lotteryResultVo.getResult().getOpenCode())) {
            return lotteryResultVo;
        }
        LOG.info("开始采集:彩种:{0},期数:{1}",code,expect);
        LotteryResult lotteryresult = new LotteryResult();
        lotteryresult.setCode(code);
        lotteryresult.setType(lotteryEnum.getType());
        lotteryresult.setExpect(expect);
        lotteryresult.setGatherTime(new Date());
        lotteryresult.setOrigin(LotteryOriginEnum.AUTO.getCode());
        String openCode = getOpenCode(code, expect);
        lotteryresult.setOpenCode(openCode);
        lotteryResultVo.setResult(lotteryresult);
        LOG.info("采集结束:彩种:{0},期数:{1}",code,expect);
        return lotteryResultVo;
    }

    public String getOpenCode(String code, String expect) {
        LotteryOwnRuleVo lotteryOwnRuleVo = new LotteryOwnRuleVo();
        lotteryOwnRuleVo.getSearch().setCode(code);
        lotteryOwnRuleVo = SpringTool.getBean(ILotteryOwnRuleService.class).search(lotteryOwnRuleVo);
        LotteryOwnRule lotteryOwnRule = lotteryOwnRuleVo.getResult();
        String openCode = (LotteryEnum.JSPK10.getCode().equals(code)) ?
                openPk10(lotteryOwnRule, expect) : openSsc(lotteryOwnRule, expect);
        return openCode;
    }

    private String openPk10(LotteryOwnRule lotteryOwnRule, String expect) {
        String openNum = null;
        if (lotteryOwnRule != null && StringTool.isNotEmpty(lotteryOwnRule.getExpect()) &&
                StringTool.isNotEmpty(lotteryOwnRule.getOpenNum()) && lotteryOwnRule.getExpect().equals(expect)) {
            openNum = lotteryOwnRule.getOpenNum();
        }
        if (StringTool.isEmpty(openNum)) {
            List<String> resultList = openPk10ByRandom();
            openNum = StringTool.join(",", resultList.toArray());
        }
        return openNum;
    }

    private String openSsc(LotteryOwnRule lotteryOwnRule, String expect) {
        String openNum = null;
        if (lotteryOwnRule != null && StringTool.isNotEmpty(lotteryOwnRule.getExpect()) &&
                StringTool.isNotEmpty(lotteryOwnRule.getOpenNum()) && lotteryOwnRule.getExpect().equals(expect)) {
            openNum = lotteryOwnRule.getOpenNum();
        }
        if (StringTool.isEmpty(openNum)) {
            List<String> resultList = openSscByRandom();
            openNum = StringTool.join(",", resultList.toArray());
        }
        return openNum;
    }

    private List<String> openSscByRule(String rule) {
        String[] resultArray = new String[5];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        long start = System.currentTimeMillis();
        try {
            Map<String, String> ruleMap = JSONObject.parseObject(rule, Map.class);
            for (String key : ruleMap.keySet()) {
                int ruleIndex = Integer.valueOf(key);
                if (ruleIndex < 1 || ruleIndex > 5) {
                    continue;
                }
                String excludeCode = ruleMap.get(key);
                List<String> excludeCodeList = Arrays.asList(excludeCode.split(","));
                if (excludeCodeList.isEmpty() || excludeCodeList.size() >= 10) {
                    continue;
                }
                while (StringTool.isBlank(resultArray[ruleIndex - 1]) || excludeCodeList.contains(resultArray[ruleIndex - 1])) {
                    int random = secureRandom.nextInt(10);
                    resultArray[ruleIndex - 1] = String.valueOf(random);
                    if (System.currentTimeMillis() - start > 500) {
                        LOG.info("分分彩开奖-规则开奖耗时:{0}", System.currentTimeMillis() - start);
                        throw new RuntimeException("分分彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
            for (int i = 0; i < resultArray.length; i++) {
                while (StringTool.isBlank(resultArray[i])) {
                    int random = secureRandom.nextInt(10);
                    resultArray[i] = String.valueOf(random);
                    if (System.currentTimeMillis() - start > 800) {
                        LOG.info("分分彩开奖-规则开奖耗时:{0}", System.currentTimeMillis() - start);
                        throw new RuntimeException("分分彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
        } catch (Exception e) {
            LOG.info("分分彩开奖-规则开奖异常，改为全随机开奖!");
            return new ArrayList<>();
        }
        return Arrays.asList(resultArray);
    }

    private List<String> openSscByRandom() {
        String[] resultArray = new String[5];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < resultArray.length; i++) {
            secureRandom.setSeed(secureRandom.nextLong());
            resultArray[i] = String.valueOf(secureRandom.nextInt(10));
        }
        return Arrays.asList(resultArray);
    }

    /**
     * 按设置的规则进行号码生成
     *
     * @param rule
     * @return
     */
    private static List<String> openPk10ByRule(String rule) {
        String[] codeArray = new String[10];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        long start = System.currentTimeMillis();
        try {
            Map<String, String> ruleMap = JSONObject.parseObject(rule, Map.class);
            Set<Integer> hasOpenCode = new HashSet<>();
            for (String key : ruleMap.keySet()) {
                int ruleIndex = Integer.valueOf(key);
                if (ruleIndex < 1 || ruleIndex > 10) {
                    continue;
                }
                String excludeCode = ruleMap.get(key);
                List<String> excludeCodeList = Arrays.asList(excludeCode.split(","));
                if (excludeCodeList.isEmpty() || excludeCodeList.size() >= 10) {
                    continue;
                }
                while (StringTool.isBlank(codeArray[ruleIndex - 1]) || excludeCodeList.contains(codeArray[ruleIndex - 1])) {
                    int random = secureRandom.nextInt(11);
                    if (random == 0 || hasOpenCode.contains(Integer.valueOf(random))) {
                        continue;
                    }
                    hasOpenCode.add(random);
                    codeArray[ruleIndex - 1] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 500) {
                        LOG.info("极速pk10开奖-规则开奖耗时:{0}", System.currentTimeMillis() - start);
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
            for (int i = 0; i < codeArray.length; i++) {
                List<String> codeList = Arrays.asList(codeArray);
                while (StringTool.isBlank(codeArray[i])) {
                    int random = secureRandom.nextInt(11);
                    if (random == 0) {
                        continue;
                    }
                    if (codeList.contains(StringTool.leftPad(String.valueOf(random), 2, '0'))) {
                        continue;
                    }
                    codeArray[i] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 800) {
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
        } catch (Exception e) {
            LOG.info("极速pk10开奖-规则有误，改为全随机开奖!");
            return new ArrayList<>();
        }
        return Arrays.asList(codeArray);
    }

    /**
     * JSPK10随机开号
     *
     * @return
     */
    private static List<String> openPk10ByRandom() {
        List<String> codeList = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            codeList.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        SecureRandom secureRandom = new SecureRandom();
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 10) {
            secureRandom.setSeed(secureRandom.nextLong());
            int index = secureRandom.nextInt(codeList.size());
            codeSet.add(codeList.get(index));
            codeList.remove(index);
        }
        return new ArrayList<>(codeSet);
    }

    @Override
    public void doValid(LotteryGatherConf gatherConf) {

    }

}
