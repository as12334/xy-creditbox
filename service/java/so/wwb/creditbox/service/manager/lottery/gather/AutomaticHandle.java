package so.wwb.creditbox.service.manager.lottery.gather;

import com.alibaba.fastjson.JSONObject;
import org.soul.commons.collections.MapTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.constants.common.Const;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherOriginEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.model.company.lottery.po.LotteryRule;
import so.wwb.creditbox.model.company.lottery.vo.LotteryResultNumberVo;

import java.security.SecureRandom;
import java.util.*;

/**
 *
 * Created by aaa on 17-8-23.
 */
public class AutomaticHandle implements ILotteryGatherHandle {

    private static Log LOG = LogFactory.getLog(AutomaticHandle.class);

    private SecureRandom secureRandom = new SecureRandom();

    private static final String JSPK10 = "jspk10";

    private static final String FFSSC = "ffssc";

    private static final String JISK3 = "jisk3";

    private static final String JSLHC = "jslhc";

    private static final String JIS11X5 = "jis11x5";

    @Override
    public LotteryResultListVo doMakeUp(LotteryGatherParam gatherParam) {
        return null;
    }

    @Override
    public Object doGather(LotteryGatherParam gatherParam) {
        LotteryResultNumberVo numberVo = new LotteryResultNumberVo();
        Date curDate = new Date();
        String openCode = getOpenCode(gatherParam.getCode(),gatherParam.getLotteryRule());
        LotteryResultNumber number = new LotteryResultNumber();
        number.setGatherTime(curDate);
        number.setGather(Const.SYSTEM_OPERATOR);
        number.setGatherOrigin(LotteryGatherOriginEnum.AUTO.getCode());
        number.setOpenCode(openCode);
        number.setOpenCodeMemo(getOpenCodeMemo(gatherParam.getCode(),openCode));
        numberVo.setResult(number);
        return numberVo;
    }

    /**
     * 根据自主彩杀率规则生产开奖结果
     * @param killRate
     * @return
     */
    public String getOpenCode(String code,LotteryRule killRate) {
        switch (code) {
            case JSPK10:
                return openPk10(killRate);
            case FFSSC:
                return openSsc(killRate);
            case  JISK3:
                return openK3(killRate);
            case JSLHC:
                return openLHC(killRate);
            case JIS11X5:
                return openJIS11X5(killRate);
            default:
                return null;
        }
//        return (LotteryEnum.JSPK10.getCode().equals(code)) ?
//                openPk10(killRate) : openSsc(killRate);
    }


    private String openPk10(LotteryRule lotteryKillrate){
        List<String> resultList = new ArrayList<>(10);
//        if(lotteryKillrate != null && LotteryKillRateStatusEnum.NORMAL.getCode().equals(lotteryKillrate.getStatus())
//                && StringTool.isNotBlank(lotteryKillrate.getRuleJson())){
//            resultList =  openPk10ByRule(lotteryKillrate.getRuleJson());
//        }
        if (resultList.isEmpty()){
            resultList = openPk10ByRandom();
        }
        return StringTool.join(",", resultList.toArray());
    }

    private String openSsc(LotteryRule lotteryKillrate){
        List<String> resultList = new ArrayList<>(10);
//        if(lotteryKillrate != null && LotteryKillRateStatusEnum.NORMAL.getCode().equals(lotteryKillrate.getStatus())
//                && StringTool.isNotBlank(lotteryKillrate.getRuleJson())){
//            resultList =  openSscByRule(lotteryKillrate.getRuleJson());
//        }
        if (resultList.isEmpty()){
            resultList = openSscByRandom();
        }
        return StringTool.join(",", resultList.toArray());
    }

    private  List<String> openSscByRule(String rule){
        String [] resultArray = new String [5];
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
                    if (System.currentTimeMillis() - start > 500){
                        LOG.info("分分彩开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("分分彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
            for (int i = 0; i < resultArray.length; i++) {
                while (StringTool.isBlank(resultArray[i])){
                    int random = secureRandom.nextInt(10);
                    resultArray[i] = String.valueOf(random);
                    if (System.currentTimeMillis() - start > 800){
                        LOG.info("分分彩开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
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

    private List<String> openSscByRandom(){
        String [] resultArray = new String [5];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < resultArray.length; i++) {
            secureRandom.setSeed(secureRandom.nextLong());
            resultArray[i] = String.valueOf(secureRandom.nextInt(10));
        }
        return Arrays.asList(resultArray);
    }

    /**
     * 按设置的规则进行号码生成
     * @param rule
     * @return
     */
    private static List<String> openPk10ByRule(String rule){
        String [] codeArray = new String [10];
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
                    if (random == 0 || hasOpenCode.contains(Integer.valueOf(random)) ){
                        continue;
                    }
                    hasOpenCode.add(random);
                    codeArray[ruleIndex - 1] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 500){
                        LOG.info("极速pk10开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }

            }
            for (int i = 0; i < codeArray.length; i++) {
                List<String> codeList = Arrays.asList(codeArray);
                while (StringTool.isBlank(codeArray[i])){
                    int random = secureRandom.nextInt(11);
                    if(random == 0){
                        continue;
                    }
                    if (codeList.contains(StringTool.leftPad(String.valueOf(random), 2, '0'))){
                        continue;
                    }
                    codeArray[i] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 800){
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
     * @return
     */
    private static List<String> openPk10ByRandom(){
        List<String> codeList = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            codeList.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 10) {
            int index = secureRandom.nextInt(codeList.size());
            codeSet.add(codeList.get(index));
            codeList.remove(index);
        }
        return new ArrayList<>(codeSet);
    }
    /**
     * 获取pk10开奖号码
     * @return
     */
    private String pk10OpenCode() {
        Set<String> pk10Set = new LinkedHashSet<>();
        while (pk10Set.size() != 10) {
            String num = String.valueOf(secureRandom.nextInt(11)) ;
            if (!pk10Set.contains(num)&&!"0".equals(num)) {
                pk10Set.add(StringTool.leftPad(num, 2, '0'));
            }
        }
        String openNUm = StringTool.join(",", pk10Set.toArray());
        return openNUm;
    }

    private String randomNum() {
        return String.valueOf(secureRandom.nextInt(10));
    }

    @Override
    public void doValid(LotteryGatherConf gatherConf) {

    }

    /**
     * 极速pk10开奖号码规则生成
     * @param rule
     * @return
     */
    private static List<String> openPk10ByRuleNew(String rule){
        String [] codeArray = new String [10];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        long start = System.currentTimeMillis();
        try {
            Map<String, Object> ruleMap = JSONObject.parseObject(rule, Map.class);
            //不包含
            Map<String, String> notIncludeMap = (Map)ruleMap.get("notInclude");
            //包含
            Map<String, String> includeMap = (Map)ruleMap.get("include");

            Set<String> hasOpenCode = new HashSet<>();
            if (MapTool.isNotEmpty(includeMap) || (MapTool.isNotEmpty(includeMap) && includeMap.keySet().size() > 0)) {
                initInclude(includeMap, codeArray, secureRandom, hasOpenCode, start, 10);
            } else if (MapTool.isEmpty(includeMap) && MapTool.isNotEmpty(notIncludeMap) && notIncludeMap.keySet().size() > 0) {
                initNotInclude(notIncludeMap, codeArray, secureRandom, hasOpenCode, start, 10);
            }
            initAnother(codeArray, secureRandom, start, 10);

        } catch (Exception e) {
            LOG.info("极速pk10开奖-规则有误，改为全随机开奖!");
            return new ArrayList<>();
        }
        return Arrays.asList(codeArray);
    }

    private static void initAnother (String [] codeArray, SecureRandom secureRandom, long start, int num) {
        for (int i = 0; i < codeArray.length; i++) {
            List<String> codeList = Arrays.asList(codeArray);
            while (StringTool.isBlank(codeArray[i])){
                if (num == 10) {
                    int random = secureRandom.nextInt(11);
                    if(random == 0){
                        continue;
                    }
                    if (codeList.contains(StringTool.leftPad(String.valueOf(random), 2, '0'))){
                        continue;
                    }
                    codeArray[i] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 800){
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                } else if (num == 5) {
                    int random = secureRandom.nextInt(10);
                    if(random == 0){
                        continue;
                    }
                    if (codeList.contains(String.valueOf(random))){
                        continue;
                    }
                    codeArray[i] = String.valueOf(random);
                    if (System.currentTimeMillis() - start > 800){
                        throw new RuntimeException("分分时时彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
        }
    }

    /**
     * 分分时时彩开奖号码规则生成
     * @param rule
     * @return
     */
    private  List<String> openSscByRuleNew(String rule){
        String [] resultArray = new String [5];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        long start = System.currentTimeMillis();
        try {
            Map<String, Object> ruleMap = JSONObject.parseObject(rule, Map.class);

            //不包含
            Map<String, String> notIncludeMap = (Map)ruleMap.get("notInclude");
            //包含
            Map<String, String> includeMap = (Map)ruleMap.get("include");

            Set<String> hasOpenCode = new HashSet<>();
            if (MapTool.isNotEmpty(includeMap) || (MapTool.isNotEmpty(includeMap) && includeMap.keySet().size() > 0)) {
                initInclude(includeMap, resultArray, secureRandom, hasOpenCode, start, 5);
            } else if (MapTool.isEmpty(includeMap) && MapTool.isNotEmpty(notIncludeMap) && notIncludeMap.keySet().size() > 0) {
                initNotInclude(notIncludeMap, resultArray, secureRandom, hasOpenCode, start, 5);
            }

            initAnother(resultArray, secureRandom, start, 5);
        } catch (Exception e) {
            LOG.info("分分彩开奖-规则开奖异常，改为全随机开奖!");
            return new ArrayList<>();
        }
        return Arrays.asList(resultArray);
    }

    //包含开奖号码生成
    private static void initInclude(Map<String, String> includeMap, String [] codeArray, SecureRandom secureRandom, Set<String> hasOpenCode, long start, int num) {
        for (String key : includeMap.keySet()) {
            int ruleIndex = Integer.valueOf(key);
            if (ruleIndex < 1 || ruleIndex > num) {
                continue;
            }
            String excludeCode = includeMap.get(key);
            String [] arr = excludeCode.split(",");
            List<String> excludeCodeList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                excludeCodeList.add(arr[i]);
            }
            if (excludeCodeList.isEmpty() || excludeCodeList.size() > 10) {
                continue;
            }

            while (StringTool.isBlank(codeArray[ruleIndex - 1]) || (excludeCodeList.size() > 0 && !excludeCodeList.contains(codeArray[ruleIndex - 1]))) {
                int random = secureRandom.nextInt(excludeCodeList.size());
                if (hasOpenCode.contains(excludeCodeList.get(random))){
                    continue;
                }
                hasOpenCode.add(excludeCodeList.get(random));
                codeArray[ruleIndex - 1] = excludeCodeList.get(random);
                excludeCodeList.remove(random);
                if (System.currentTimeMillis() - start > 500){
                    if (num == 10) {
                        LOG.info("极速pk10开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    } else if (num == 5) {
                        LOG.info("分分时时彩开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("分分时时彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
        }
    }
    //不包含开奖号码生成
    private static void initNotInclude(Map<String, String> notIncludeMap, String [] codeArray, SecureRandom secureRandom, Set<String> hasOpenCode, long start ,int num) {
        for (String key : notIncludeMap.keySet()) {
            int ruleIndex = Integer.valueOf(key);
            if (ruleIndex < 1 || ruleIndex > num) {
                continue;
            }
            String excludeCode = notIncludeMap.get(key);
            List<String> excludeCodeList = Arrays.asList(excludeCode.split(","));
            if (excludeCodeList.isEmpty() || excludeCodeList.size() > 10) {
                continue;
            }
            while (StringTool.isBlank(codeArray[ruleIndex - 1]) || excludeCodeList.contains(codeArray[ruleIndex - 1])) {
                int random = 0;
                if (num == 10) {
                    random = secureRandom.nextInt(11);
                    if (random == 0 || hasOpenCode.contains(StringTool.leftPad(String.valueOf(random), 2, '0')) ){
                        continue;
                    }
                    hasOpenCode.add(StringTool.leftPad(String.valueOf(random), 2, '0'));
                    codeArray[ruleIndex - 1] = StringTool.leftPad(String.valueOf(random), 2, '0');
                    if (System.currentTimeMillis() - start > 500){
                        LOG.info("极速pk10开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("极速pk10开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                } else if (num == 5) {
                    random = secureRandom.nextInt(10);
                    if (random == 0 || hasOpenCode.contains(random)){
                        continue;
                    }
                    hasOpenCode.add(String.valueOf(random));
                    codeArray[ruleIndex - 1] = String.valueOf(random);
                    if (System.currentTimeMillis() - start > 500){
                        LOG.info("分分时时彩开奖-规则开奖耗时:{0}" ,System.currentTimeMillis() - start);
                        throw new RuntimeException("分分时时彩开奖-规则开奖耗时过长，改为全随机开奖！");
                    }
                }
            }
        }
    }

    /**
     * 极速快3开奖号码
     * @param lotteryKillrate
     * @return
     */
    private String openK3(LotteryRule lotteryKillrate){
        List<String> resultList = new ArrayList<>(3);
//        if(lotteryKillrate != null && LotteryKillRateStatusEnum.NORMAL.getCode().equals(lotteryKillrate.getStatus())
//                && StringTool.isNotBlank(lotteryKillrate.getRuleJson())){
//            resultList =  openPk10ByRule(lotteryKillrate.getRuleJson());
//        }
        if (resultList.isEmpty()){
            resultList = openK3ByRandom();
        }
        return StringTool.join(",", resultList.toArray());
    }


    /**
     * jisk3随机开号
     * @return
     */
    private static List<String> openK3ByRandom(){
        List<String> nums = new ArrayList<>(6);
        for (int i = 1; i <= 6; i++) {
            nums.add(String.valueOf(i));
        }
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        List<String> codeList = new ArrayList<>(3);
        while (codeList.size() != 3) {
            int index = secureRandom.nextInt(nums.size());
            codeList.add(nums.get(index));
        }
        Collections.sort(codeList);
        return codeList;
    }

    /**
     * 极速快3开奖号码
     * @param lotteryKillrate
     * @return
     */
    private String openLHC(LotteryRule lotteryKillrate){
        List<String> resultList = new ArrayList<>(7);
//        if(lotteryKillrate != null && LotteryKillRateStatusEnum.NORMAL.getCode().equals(lotteryKillrate.getStatus())
//                && StringTool.isNotBlank(lotteryKillrate.getRuleJson())){
//            resultList =  openPk10ByRule(lotteryKillrate.getRuleJson());
//        }
        if (resultList.isEmpty()){
            resultList = openLhcByRandom();
        }
        return StringTool.join(",", resultList.toArray());
    }


    /**
     * jilhc随机开号
     * @return list
     */
    private static List<String> openLhcByRandom(){
        List<String> numList = new ArrayList<>(49);
        for (int i = 1; i <= 49; i++) {
            numList.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 7) {
            int index = secureRandom.nextInt(numList.size());
            codeSet.add(numList.get(index));
            numList.remove(index);
        }
        return new ArrayList<>(codeSet);
    }

    /**
     * 根据开奖号码获取开奖号码备注，暂时保存六合彩生肖
     * @return
     */
    private String getOpenCodeMemo(String code,String openCode){
        String result = null;
        if(StringTool.isNotEmpty(code) && StringTool.isNotEmpty(openCode)){
            if(LotteryEnum.JSLHC.getCode().equals(code)){
                List<String> zodicList = CacheBase.getLotteryLhcZodiacList(StringTool.split(openCode,","));
                result = StringTool.join(zodicList,",");
            }
        }
        return result;
    }

    /**
     * 极速11选5开奖号码
     */
    private String openJIS11X5(LotteryRule lotteryKillrate){
        List<String> resultList = new ArrayList<>(3);
        if (resultList.isEmpty()){
            resultList = openJIS11X5ByRandom();
        }
        return StringTool.join(",", resultList.toArray());
    }

    /**
     * 极速11选5随机开号
     */
    private static List<String> openJIS11X5ByRandom(){
        List<String> codeList = new ArrayList<>(11);
        for (int i = 1; i <= 11; i++) {
            codeList.add(StringTool.leftPad(String.valueOf(i), 2, '0'));
        }
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.nextLong());
        Set<String> codeSet = new LinkedHashSet<>();
        while (codeSet.size() != 5) {
            int index = secureRandom.nextInt(codeList.size());
            codeSet.add(codeList.get(index));
            codeList.remove(index);
        }
        return new ArrayList<>(codeSet);
    }
}
