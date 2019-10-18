package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.common.utility.math.PermCombTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.*;

public class LhcWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {


    /**
     * 特码的彩种玩法[特码/特码大小/特码单双/特码半特/特码合数大小/特码合数单双/特码尾数大小/特码色波/特肖]
     */
    private static List<String> specialPlayList = new ArrayList<>(9);
    /**
     * 总和的彩种玩法[总和大小/总和单双]
     */
    private static List<String> sum7PlayList = new ArrayList<>(2);
    /**
     * 正码1-6的投注玩法[正码一,正码二,正码三,正码四,正码五,正码六]
     */
    private static List<String> positiveBettingList = new ArrayList<>(6);
    /**
     * 正码1-6的彩种玩法[特码,大小,单双,色波,合数大小,合数单双,尾数大小]
     */
    private static List<String> positivePlayList = new ArrayList<>(7);

    /**
     * 半波的彩种玩法[大小,单双]
     */
    private static List<String> halfColourPlayList = new ArrayList<>(2);

    /**
     * 红波集合
     */
    private static List<String> redList = new ArrayList<>();
    /**
     * 蓝波集合
     */
    private static List<String> blueList = new ArrayList<>();
    /**
     * 绿波集合
     */
    private static List<String> greenList = new ArrayList<>();
    /**
     * 合肖投注方式
     */
    private static List<LotteryBettingEnum> sumZodiacBetList = new ArrayList<>();
    /**
     * 连码投注方式与玩法
     */
    private static Map<LotteryPlayEnum,LotteryBettingEnum> linkCodeMap = new HashMap<>();
    /**
     * 连肖投注方式与玩法
     */
    private static Map<LotteryPlayEnum,LotteryBettingEnum> linkZodiacMap = new HashMap<>();
    /**
     * 尾数连投注方式与玩法
     */
    private static Map<LotteryPlayEnum,LotteryBettingEnum> mantissaLinkMap = new HashMap<>();
    /**
     * 全不中投注方式与玩法
     */
    private static Map<LotteryPlayEnum,LotteryBettingEnum> allNoInMap = new HashMap<>();

    static {
        specialPlayList.add(LotteryPlayEnum.SPECIAL_DIGITAL.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_BIG_SMALL.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_SINGLE_DOUBLE.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_HALF.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_SUM_BIG_SMALL.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_SUM_SINGLE_DOUBLE.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_MANTISSA_BIG_SMALL.getCode());
        specialPlayList.add(LotteryPlayEnum.SPECIAL_COLOUR.getCode());

        sum7PlayList.add(LotteryPlayEnum.SEVEN_SUM_BIG_SMALL.getCode());
        sum7PlayList.add(LotteryPlayEnum.SEVEN_SUM_SINGLE_DOUBLE.getCode());

        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FIRST.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_SECOND.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_THIRD.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FOURTH.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FIFTH.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_SIXTH.getCode());

        positivePlayList.add(LotteryPlayEnum.POSITIVE_SPECIAL_DIGITAL.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_BIG_SMALL.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_SINGLE_DOUBLE.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_COLOUR.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_SUM_BIG_SMALL.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_SUM_SINGLE_DOUBLE.getCode());
        positivePlayList.add(LotteryPlayEnum.POSITIVE_MANTISSA_BIG_SMALL.getCode());

        halfColourPlayList.add(LotteryPlayEnum.LHC_HALF_COLOUR_BIG_SMALL.getCode());
        halfColourPlayList.add(LotteryPlayEnum.LHC_HALF_COLOUR_SINGLE_DOUBLE.getCode());

        redList.add("01");
        redList.add("02");
        redList.add("07");
        redList.add("08");
        redList.add("12");
        redList.add("13");
        redList.add("18");
        redList.add("19");
        redList.add("23");
        redList.add("24");
        redList.add("29");
        redList.add("30");
        redList.add("34");
        redList.add("35");
        redList.add("40");
        redList.add("45");
        redList.add("46");

        blueList.add("03");
        blueList.add("04");
        blueList.add("09");
        blueList.add("10");
        blueList.add("14");
        blueList.add("15");
        blueList.add("20");
        blueList.add("25");
        blueList.add("26");
        blueList.add("31");
        blueList.add("36");
        blueList.add("37");
        blueList.add("41");
        blueList.add("42");
        blueList.add("47");
        blueList.add("48");

        greenList.add("05");
        greenList.add("06");
        greenList.add("11");
        greenList.add("16");
        greenList.add("17");
        greenList.add("21");
        greenList.add("22");
        greenList.add("27");
        greenList.add("28");
        greenList.add("32");
        greenList.add("33");
        greenList.add("38");
        greenList.add("39");
        greenList.add("43");
        greenList.add("44");
        greenList.add("49");

        sumZodiacBetList.add(LotteryBettingEnum.LHC_TWO_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_THREE_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_FOUR_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_FIVE_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_SIX_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_SEVEN_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_EIGHT_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_NINE_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_TEN_ZODIAC);
        sumZodiacBetList.add(LotteryBettingEnum.LHC_ELEVEN_ZODIAC);

        linkCodeMap.put(LotteryPlayEnum.LHC_FOUR_ALL_IN, LotteryBettingEnum.LHC_FOUR_ALL_IN);
        linkCodeMap.put(LotteryPlayEnum.LHC_THREE_ALL_IN, LotteryBettingEnum.LHC_THREE_ALL_IN);
        linkCodeMap.put(LotteryPlayEnum.LHC_THREE_IN_TWO, LotteryBettingEnum.LHC_THREE_IN_TWO);
        linkCodeMap.put(LotteryPlayEnum.LHC_TWO_ALL_IN, LotteryBettingEnum.LHC_TWO_ALL_IN);
        linkCodeMap.put(LotteryPlayEnum.LHC_TWO_IN_SPECIAL, LotteryBettingEnum.LHC_TWO_IN_SPECIAL);
        linkCodeMap.put(LotteryPlayEnum.LHC_SPECIAL_STRAND, LotteryBettingEnum.LHC_SPECIAL_STRAND);

        linkZodiacMap.put(LotteryPlayEnum.LHC_TWO_ZODIAC_LINK, LotteryBettingEnum.LHC_TWO_ZODIAC_LINK);
        linkZodiacMap.put(LotteryPlayEnum.LHC_THREE_ZODIAC_LINK, LotteryBettingEnum.LHC_THREE_ZODIAC_LINK);
        linkZodiacMap.put(LotteryPlayEnum.LHC_FOUR_ZODIAC_LINK, LotteryBettingEnum.LHC_FOUR_ZODIAC_LINK);
        linkZodiacMap.put(LotteryPlayEnum.LHC_FIVE_ZODIAC_LINK, LotteryBettingEnum.LHC_FIVE_ZODIAC_LINK);

        mantissaLinkMap.put(LotteryPlayEnum.LHC_TWO_MANTISSA_LINK, LotteryBettingEnum.LHC_TWO_MANTISSA_LINK);
        mantissaLinkMap.put(LotteryPlayEnum.LHC_THREE_MANTISSA_LINK, LotteryBettingEnum.LHC_THREE_MANTISSA_LINK);
        mantissaLinkMap.put(LotteryPlayEnum.LHC_FOUR_MANTISSA_LINK, LotteryBettingEnum.LHC_FOUR_MANTISSA_LINK);
        mantissaLinkMap.put(LotteryPlayEnum.LHC_FIVE_MANTISSA_LINK, LotteryBettingEnum.LHC_FIVE_MANTISSA_LINK);

        allNoInMap.put(LotteryPlayEnum.LHC_FIVE_NO_IN, LotteryBettingEnum.LHC_FIVE_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_SIX_NO_IN, LotteryBettingEnum.LHC_SIX_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_SEVEN_NO_IN, LotteryBettingEnum.LHC_SEVEN_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_EIGHT_NO_IN, LotteryBettingEnum.LHC_EIGHT_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_NINE_NO_IN, LotteryBettingEnum.LHC_NINE_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_TEN_NO_IN, LotteryBettingEnum.LHC_TEN_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_ELEVEN_NO_IN, LotteryBettingEnum.LHC_ELEVEN_NO_IN);
        allNoInMap.put(LotteryPlayEnum.LHC_TWELVE_NO_IN, LotteryBettingEnum.LHC_TWELVE_NO_IN);
    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createSpecial(number));
        lotteryWinningRecordList.addAll(createSeven(number));
        lotteryWinningRecordList.addAll(createPositive(number));
        lotteryWinningRecordList.addAll(createPositive16(number));
        lotteryWinningRecordList.addAll(createHalfColour(number));
        lotteryWinningRecordList.addAll(createOneZodic(number));
        lotteryWinningRecordList.addAll(createSpecialZodiac(number));
        lotteryWinningRecordList.addAll(createLinkCode(number));
        lotteryWinningRecordList.addAll(createSumZodiac(number));
        lotteryWinningRecordList.addAll(createLinkZodiac(number));
        lotteryWinningRecordList.addAll(createLinkMantissa(number));
        lotteryWinningRecordList.addAll(createAllNoIn(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);

        return winningRecord;
    }

    /**
     * 生成全不中的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createAllNoIn(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String winningNum = generateAllNoInWinNum(lotteryResult.getOpenCode());
        for(LotteryPlayEnum playEnum : allNoInMap.keySet()){
            LotteryBettingEnum betEnum = allNoInMap.get(playEnum);
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, playEnum, betEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playEnum, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private String generateAllNoInWinNum(String openCode){
        String winnum = null;
        if(StringTool.isNotEmpty(openCode)){
            List<String> openCodeList = Arrays.asList(openCode.split(","));
            if(CollectionTool.isNotEmpty(openCodeList)){
                List<String> list = new ArrayList<>();
                for(int i = 1; i < 50; i++){
                    String num = String.valueOf(i);
                    if(i < 10){
                        num = "0"+num;
                    }
                    if(!openCodeList.contains(num)){
                        list.add(num);
                    }
                }
                winnum = StringTool.join(list,",");
            }
        }
        return winnum;
    }

    private List<LotteryWinningRecord> createWinningRecordList(LotteryResultNumber lotteryResult, List<String> winningNumList, LotteryPlayEnum playEnum, LotteryBettingEnum betEnum){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        for(String winningNum : winningNumList){
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, playEnum, betEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playEnum, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成尾数连的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createLinkMantissa(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<String> mantissaList = new ArrayList<>();
        for (String openCode : openCodes) {
            String mantissa = generateMantissa(openCode);
            if(!mantissaList.contains(mantissa)){
                mantissaList.add(mantissa);
            }
        }
        Collections.sort(mantissaList);
        for(LotteryPlayEnum playEnum : mantissaLinkMap.keySet()){
            LotteryBettingEnum betEnum = mantissaLinkMap.get(playEnum);
            List<String> winningNumList = new ArrayList<>();
            switch(playEnum){
                case LHC_TWO_MANTISSA_LINK:{
                    if(mantissaList.size() >= 2){
                        winningNumList = PermCombTool.combinationSelect(mantissaList,2);
                    }
                    break;
                }case LHC_THREE_MANTISSA_LINK:{
                    if(mantissaList.size() >= 3){
                        winningNumList = PermCombTool.combinationSelect(mantissaList,3);
                    }
                    break;
                }case LHC_FOUR_MANTISSA_LINK:{
                    if(mantissaList.size() >= 4){
                        winningNumList = PermCombTool.combinationSelect(mantissaList,4);
                    }
                    break;
                }case LHC_FIVE_MANTISSA_LINK:{
                    if(mantissaList.size() >= 5){
                        winningNumList = PermCombTool.combinationSelect(mantissaList,5);
                    }
                    break;
                }
                default:break;
            }
            lotteryWinningRecordList.addAll(createWinningRecordList(lotteryResult,winningNumList,playEnum,betEnum));
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成连肖的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createLinkZodiac(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<String> zodicList = new ArrayList<>();
        for (String openCode : openCodes) {
            String zodic = CacheBase.getLotteryLhcZodiacMap().get(openCode);
            if(!zodicList.contains(zodic)){
                zodicList.add(zodic);
            }
        }
        sortZodiac(zodicList,false);
        for(LotteryPlayEnum playEnum : linkZodiacMap.keySet()){
            LotteryBettingEnum betEnum = linkZodiacMap.get(playEnum);
            List<String> winningNumList = new ArrayList<>();
            switch(playEnum){
                case LHC_TWO_ZODIAC_LINK:{
                    if(zodicList.size() >= 2){
                        winningNumList = PermCombTool.combinationSelect(zodicList,2);
                    }
                    break;
                }case LHC_THREE_ZODIAC_LINK:{
                    if(zodicList.size() >= 3){
                        winningNumList = PermCombTool.combinationSelect(zodicList,3);
                    }
                    break;
                }case LHC_FOUR_ZODIAC_LINK:{
                    if(zodicList.size() >= 4){
                        winningNumList = PermCombTool.combinationSelect(zodicList,4);
                    }
                    break;
                }case LHC_FIVE_ZODIAC_LINK:{
                    if(zodicList.size() >= 5){
                        winningNumList = PermCombTool.combinationSelect(zodicList,5);
                    }
                    break;
                }
                default:break;
            }
            lotteryWinningRecordList.addAll(createWinningRecordList(lotteryResult,winningNumList,playEnum,betEnum));
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生肖排序
     * @param zodiacLst 生肖列表
     * @param isDesc    是否降序
     * @return
     */
    private void sortZodiac(List<String> zodiacLst,boolean isDesc){
        final String [] zodiacs = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
        Collections.sort(zodiacLst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer num1 = 0, num2 = 0;
                for(int i = 0; i < zodiacs.length; i++){
                    if(zodiacs[i].equals(o1)){
                        num1 = i;
                    }if(zodiacs[i].equals(o2)){
                        num2 = i;
                    }
                }
                return num1.compareTo(num2);
            }
        });
        if(isDesc){
            Collections.reverse(zodiacLst);
        }
    }


    /**
     * 生成合肖的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSumZodiac(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        if(openCodes != null && openCodes.length != 0){
            String winningNum = generateZodia(openCodes[openCodes.length-1]);
            for (LotteryBettingEnum sumZodiac : sumZodiacBetList) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.LHC_SUM_ZODIAC, sumZodiac, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", LotteryPlayEnum.LHC_SUM_ZODIAC, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成连码的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createLinkCode(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String[] numList = new String[openCodes.length-1];
        System.arraycopy(openCodes, 0, numList, 0,numList.length);//实现复制
        if(openCodes != null && openCodes.length != 0){
            for (LotteryPlayEnum playEnum : linkCodeMap.keySet()) {
                LotteryBettingEnum betEnum = linkCodeMap.get(playEnum);
                List<String> winningNumList = new ArrayList<>();
                switch (playEnum) {
                    case LHC_FOUR_ALL_IN:
                        winningNumList.addAll(generateFourAllIn(numList));
                        break;
                    case LHC_THREE_ALL_IN:
                        winningNumList.addAll(generateThreeAllIn(numList));
                        break;
                    case LHC_TWO_ALL_IN:
                        winningNumList.addAll(generateTwoAllIn(numList));
                        break;
                    case LHC_THREE_IN_TWO:
                        winningNumList.add(StringTool.join(",",numList));
                        break;
                    case LHC_TWO_IN_SPECIAL:
                        winningNumList.addAll(generateTwoInSpecial(numList,openCodes));
                        break;
                    case LHC_SPECIAL_STRAND:
                        winningNumList.addAll(generateSpecialStrand(openCodes));
                        break;
                    default:
                        break;
                }
                for(int i = 0; i < winningNumList.size(); i++){
                    String winningNum = winningNumList.get(i);
                    LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, playEnum, betEnum, winningNum);
                    if (lotteryWinningRecord != null) {
                        log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playEnum, lotteryWinningRecord.toString());
                        lotteryWinningRecordList.add(lotteryWinningRecord);
                    }
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 特串结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateSpecialStrand(String[] openCodes){
        List<String> result = new ArrayList<>();
        String specialCode = openCodes[openCodes.length-1];
        for(int i = 0 ; i < openCodes.length-1; i++){
            String resultStr = openCodes[i]+","+specialCode;
            if(Integer.valueOf(openCodes[i]) > Integer.valueOf(specialCode)){
                resultStr = specialCode+","+openCodes[i];
            }
            result.add(resultStr);
        }
        return result;
    }

    /**
     * 二中特结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateTwoInSpecial(String[] numList,String[] openCodes){
        List<String> result = new ArrayList<>();
        result.addAll(generateAllIn(numList, 2));
        String specialCode = openCodes[openCodes.length-1];
        for(int i = 0 ; i < openCodes.length-1; i++){
            result.add(openCodes[i]+";"+specialCode);
        }
        return result;
    }

    /**
     * 四全中结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateFourAllIn(String[] openCodes) {
        return generateAllIn(openCodes, 4);
    }

    /**
     * 三全中结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateThreeAllIn(String[] openCodes) {
        return generateAllIn(openCodes, 3);
    }

    /**
     * 二全中结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateTwoAllIn(String[] openCodes) {
        return generateAllIn(openCodes, 2);
    }

    /**
     * N全中结果列表
     * @param openCodes
     * @return
     */
    private List<String> generateAllIn(String[] openCodes,int num) {
        Arrays.sort(openCodes);
        return PermCombTool.combinationSelect(openCodes, num);
    }

    /**
     * 生成一肖的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneZodic(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Set<String> zodicWinningSet = new LinkedHashSet<>();
        for (String openCode : openCodes) {
            zodicWinningSet.add(CacheBase.getLotteryLhcZodiacMap().get(openCode));
        }
        for (String winningNum : zodicWinningSet) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.LHC_ONE_ZODIAC, LotteryBettingEnum.LHC_ONE_ZODIAC, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", LotteryPlayEnum.LHC_ONE_ZODIAC.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }
    /**
     * 生成特肖的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSpecialZodiac(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String specialCode = openCodes[6];
        String winningNum = CacheBase.getLotteryLhcZodiacMap().get(specialCode);
        LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class,  LotteryPlayEnum.LHC_SPECIAL_ZODIAC.getCode());
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult,lotteryPlayEnum, LotteryBettingEnum.SPECIAL, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", lotteryPlayEnum.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成半波的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createHalfColour(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String specialCode = openCodes[6];
        for (String playCode : halfColourPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case LHC_HALF_COLOUR_BIG_SMALL:
                    winningNum = generateHalfColourBigSmall(specialCode);
                    break;
                case LHC_HALF_COLOUR_SINGLE_DOUBLE:
                    winningNum = generateHalfColourSingleDouble(specialCode);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.LHC_HALF_COLOUR, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 是否为49号,不是则返回对应号码的生肖
     * @param openCode
     * @return
     */
    private String generateZodia(String openCode) {
        return isDraw(openCode) ? LotteryWinningNum.DRAW : CacheBase.getLotteryLhcZodiacMap().get(openCode);
    }

    private String generateHalfColourSingleDouble(String specialCode) {
        if ("49".equals(specialCode)) {
            return LotteryWinningNum.DRAW;
        } else if (Integer.parseInt(specialCode) % 2 == 0) {
            if (redList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_RED_DOUBLE;
            } else if (blueList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_BLUE_DOUBLE;
            } else {
                return LotteryWinningNum.LHC_HALFCOLOUR_GREEN_DOUBLE;
            }
        } else {
            if (redList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_RED_SINGLE;
            } else if (blueList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_BLUE_SINGLE;
            } else {
                return LotteryWinningNum.LHC_HALFCOLOUR_GREEN_SINGLE;
            }
        }
    }

    private String generateHalfColourBigSmall(String specialCode) {
        if ("49".equals(specialCode)) {
            return LotteryWinningNum.DRAW;
        } else if (Integer.valueOf(specialCode) >= 25) {
            if (redList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_RED_BIG;
            } else if (blueList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_BLUE_BIG;
            } else {
                return LotteryWinningNum.LHC_HALFCOLOUR_GREEN_BIG;
            }
        } else {
            if (redList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_RED_SMALL;
            } else if (blueList.contains(specialCode)) {
                return LotteryWinningNum.LHC_HALFCOLOUR_BLUE_SMALL;
            } else {
                return LotteryWinningNum.LHC_HALFCOLOUR_GREEN_SMALL;
            }
        }
    }

    /**
     * 构造特码的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSpecial(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String specialCode = openCodes[6];
        for (String playCode : specialPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case SPECIAL_DIGITAL:
                    winningNum = specialCode;
                    break;
                case SPECIAL_BIG_SMALL:
                    winningNum = generateBigSmallNum(specialCode);
                    break;
                case SPECIAL_SINGLE_DOUBLE:
                    winningNum = generateSingleDoubleNum(Integer.valueOf(specialCode));
                    break;
                case SPECIAL_HALF:
                    winningNum = generateSpecialHalfNum(specialCode);
                    break;
                case SPECIAL_SUM_BIG_SMALL:
                    winningNum = generateSpecialSumBigSmallNum(generateSingleSum(specialCode));
                    break;
                case SPECIAL_SUM_SINGLE_DOUBLE:
                    winningNum = generateSpecialSumSingleDoubleNum(generateSingleSum(specialCode));
                    break;
                case SPECIAL_MANTISSA_BIG_SMALL:
                    winningNum = generateMantissaBigSmallNum(specialCode);
                    break;
                case SPECIAL_COLOUR:
                    winningNum = generateColourNum(specialCode);
                    break;

                default:
                    break;
            }
            LotteryWinningRecord specialaWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SPECIAL_A, winningNum);
            LotteryWinningRecord specialbWinningRecord  = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SPECIAL_B, winningNum);
            if (specialaWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playCode, specialaWinningRecord.toString());
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playCode, specialbWinningRecord.toString());
                lotteryWinningRecordList.add(specialaWinningRecord);
                lotteryWinningRecordList.add(specialbWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    /**
     * 构造总和的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSeven(LotteryResultNumber lotteryResult) {
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        Integer sevenSum = generateTotalSum(openCodes);
        for (String playCode : sum7PlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            if (LotteryPlayEnum.SEVEN_SUM_BIG_SMALL.equals(lotteryPlayEnum)) {
                winningNum = generateTotalBigSmallNum(sevenSum);
            } else if (LotteryPlayEnum.SEVEN_SUM_SINGLE_DOUBLE.equals(lotteryPlayEnum)) {
                winningNum = generateTotalSingleDoubleNum(sevenSum);
            }

            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SEVEN_SUM, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造正码的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createPositive(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < 6; i++) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.POSITIVE_DIGITAL, LotteryBettingEnum.POSITIVE, openCodes[i]);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", LotteryPlayEnum.POSITIVE_DIGITAL.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造正码1~6的中奖结果
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createPositive16(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < positiveBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, positiveBettingList.get(i));
            for (String playCode : positivePlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case POSITIVE_SPECIAL_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case POSITIVE_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case POSITIVE_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case POSITIVE_COLOUR:
                        winningNum = generateColourNum(openCodes[i]);
                        break;
                    case POSITIVE_SUM_BIG_SMALL:
                        winningNum = generateSpecialSumBigSmallNum(generateSingleSum(openCodes[i]));
                        break;
                    case POSITIVE_SUM_SINGLE_DOUBLE:
                        winningNum = generateSpecialSumSingleDoubleNum(generateSingleSum(openCodes[i]));
                        break;
                    case POSITIVE_MANTISSA_BIG_SMALL:
                        winningNum = generateMantissaBigSmallNum(openCodes[i]);
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.六合彩.{0},生成中奖记录:{1}", lotteryPlayEnum, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    @Override
    String generateBigSmallNum(String openCode) {
        return isDraw(openCode) ? LotteryWinningNum.DRAW : super.generateBigSmallNum(openCode);
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 25;
    }

    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 175;
    }

    @Override
    String generateSingleDoubleNum(Integer num) {
        return isDraw(String.valueOf(num)) ? LotteryWinningNum.DRAW : super.generateSingleDoubleNum(num);
    }

    @Override
    String generateMantissaBigSmallNum(String openCode) {
        return isDraw(openCode) ? LotteryWinningNum.DRAW : super.generateMantissaBigSmallNum(openCode);
    }

    /**
     * 是否平局
     *
     * @param openCode
     * @return
     */
    private boolean isDraw(String openCode) {
        return "49".equals(openCode);
    }

    private String generateSpecialHalfNum(String openCode) {
        if (Integer.valueOf(openCode) == 49) {
            return LotteryWinningNum.DRAW;
        } else if (Integer.parseInt(openCode) % 2 == 0 && Integer.parseInt(openCode) >= 25) {
            return LotteryWinningNum.BIG_DOUBLE;
        } else if (Integer.parseInt(openCode) % 2 == 0 && Integer.parseInt(openCode) < 25) {
            return LotteryWinningNum.SMALL_DOUBLE;
        } else if (Integer.parseInt(openCode) % 2 != 0 && Integer.parseInt(openCode) >= 25) {
            return LotteryWinningNum.BIG_SINGLE;
        } else {
            return LotteryWinningNum.SMALL_SINGLE;
        }
    }

    private String generateSpecialSumBigSmallNum(Integer specialSum) {
        if (specialSum == 13) {
            return LotteryWinningNum.DRAW;
        } else if (specialSum >= 7) {
            return LotteryWinningNum.SINGLE_SUM_BIG;
        } else {
            return LotteryWinningNum.SINGLE_SUM_SMALL;
        }
    }

    private String generateSpecialSumSingleDoubleNum(Integer specialSum) {
        if (specialSum == 13) {
            return LotteryWinningNum.DRAW;
        } else if (specialSum % 2 == 0) {
            return LotteryWinningNum.SINGLE_SUM_DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE_SUM_SINGLE;
        }
    }

    private String generateColourNum(String specialCode) {
        if (redList.contains(specialCode)) {
            return LotteryWinningNum.RED_WAVE;
        } else if (blueList.contains(specialCode)) {
            return LotteryWinningNum.BLUE_WAVE;
        } else {
            return LotteryWinningNum.GREEN_WAVE;
        }
    }

}
