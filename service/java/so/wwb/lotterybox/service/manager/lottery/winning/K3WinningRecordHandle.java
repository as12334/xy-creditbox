package so.wwb.lotterybox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryWinningNum;
import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K3WinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> pointPlayList = new ArrayList<>(9);

    private static List<String> dicePlayList = new ArrayList<>(2);


    static {
        pointPlayList.add(LotteryPlayEnum.POINTS_BIG_SMALL.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_SINGLE_DOUBLE.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_318.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_417.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_516.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_615.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_714.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_813.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_912.getCode());
        pointPlayList.add(LotteryPlayEnum.POINTS_1011.getCode());

        dicePlayList.add(LotteryPlayEnum.DICE.getCode());
        dicePlayList.add(LotteryPlayEnum.FULL_DICE.getCode());
    }


    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }

        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createPoints(number));
        lotteryWinningRecordList.addAll(createArmedForces(number));
        lotteryWinningRecordList.addAll(createDiceFullDice(number));
        lotteryWinningRecordList.addAll(createLongCard(number));
        lotteryWinningRecordList.addAll(createShortCard(number));
        lotteryWinningRecordList.addAll(createGfwfRecord(number));//官方玩法开奖记录生成
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);

        return winningRecord;
    }

    /**
     * 生成点数的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createPoints(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer threeSum = generateTotalSum(openCodes);
        for (String playCode : pointPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case POINTS_BIG_SMALL:
                    winningNum = generatePointsBigSmallNum(openCodes);
                    break;
                case POINTS_SINGLE_DOUBLE:
                    winningNum = generatePointsSingleDoubleNum(openCodes);
                    break;
                case POINTS_318:
                    if (threeSum == 3 || threeSum == 18) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_417:
                    if (threeSum == 4 || threeSum == 17) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_516:
                    if (threeSum == 5 || threeSum == 16) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_615:
                    if (threeSum == 6 || threeSum == 15) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_714:
                    if (threeSum == 7 || threeSum == 14) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_813:
                    if (threeSum == 8 || threeSum == 13) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_912:
                    if (threeSum == 9 || threeSum == 12) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                case POINTS_1011:
                    if (threeSum == 10 || threeSum == 11) {
                        winningNum = String.valueOf(threeSum);
                    }
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.POINTS, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快3.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成三军的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createArmedForces(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Set<String> openCodeSet = new HashSet<>();
        for (String openCode : openCodes) {
            openCodeSet.add(openCode);
        }
        for (String openCode : openCodeSet) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.ARMED_FORCES, LotteryBettingEnum.ARMED_FORCES, openCode);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快3.{0},生成中奖记录:{1}", LotteryPlayEnum.ARMED_FORCES.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成围骰全骰的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createDiceFullDice(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = null;
        for (String playCode : dicePlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            if (LotteryPlayEnum.DICE.getCode().equals(playCode)) {
                winningNum = generateDiceNum(openCodes);
            } else if (LotteryPlayEnum.FULL_DICE.getCode().equals(playCode)) {
                winningNum = generateFullDiceNum(openCodes);
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.DICE_FULL_DICE, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快3.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成长牌的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createLongCard(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<String> winningNumList = generateLongCardNum(openCodes);
        for (String winningNum : winningNumList) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.LONG_CARD, LotteryBettingEnum.LONG_CARD, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快3.{0},生成中奖记录:{1}", LotteryPlayEnum.LONG_CARD.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成短牌的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createShortCard(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = generateShortCardNum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SHORT_CARD, LotteryBettingEnum.SHORT_CARD, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.快3.{0},生成中奖记录:{1}", LotteryPlayEnum.SHORT_CARD.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createGfwfRecord(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String opencode = StringTool.replace(lotteryResult.getOpenCode(), ",", "");
        if (isThreeSame(openCodes)) {//三同;增加三同号单选和三同号复选的中奖记录
            LotteryWinningRecord lotteryWinningRecord1 = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_SAME_NUM, LotteryBettingEnum.K3_DANXUAN_SANTONG, opencode);
            LotteryWinningRecord lotteryWinningRecord2 = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_SAME_NUM, LotteryBettingEnum.K3_FUXUAN_SANTONG, LotteryWinningNum.GENERAL);
            lotteryWinningRecordList.add(lotteryWinningRecord1);
            lotteryWinningRecordList.add(lotteryWinningRecord2);
        } else if (isThreeDifferent(openCodes)) {//三不同;增加三不同号,三连号的中奖记录
            //二不同
            LotteryWinningRecord winningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_DIFF_NUM, LotteryBettingEnum.K3_ERBUTONG, opencode);
            lotteryWinningRecordList.add(winningRecord);
            //三不同
            List<String> winNumDifferThree = getDifferThree(openCodes);
            for (String winNumThree : winNumDifferThree) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_DIFF_NUM, LotteryBettingEnum.K3_SANBUTONG, winNumThree);
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
            //三连号
            List<String> winNumLianhao = getThreeLianhao(openCodes,opencode);
            for (String winNum : winNumLianhao) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_THREE_STRAIGHT, LotteryBettingEnum.K3_TONGXUAN_SANLIAN, winNum);
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }

        } else {//二同+1;增加二不同，二同号单选，二同号复选的中奖记录
            //二不同
            LotteryWinningRecord winningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_DIFF_NUM, LotteryBettingEnum.K3_ERBUTONG, opencode);
            lotteryWinningRecordList.add(winningRecord);
            //二同号单选
            List<String> winNumtsdx = getTwoSamedx(openCodes);
            for (String winNum : winNumtsdx) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_SAME_NUM, LotteryBettingEnum.K3_DANXUAN_ERTONG, winNum);
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
            //二同号复选
            List<String> winNumtsfx = getTwoSamefx(openCodes);
            for (String winNum : winNumtsfx) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.K3_SAME_NUM, LotteryBettingEnum.K3_FUXUAN_ERTONG, winNum);
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成点数的大小的中奖结果，当三个号码相同时，通杀
     *
     * @param openCodes
     * @return
     */
    private String generatePointsBigSmallNum(String[] openCodes) {
        if (isThreeSame(openCodes)) {
            return null;
        }
        Integer threeSum = generateTotalSum(openCodes);
        if (threeSum >= 11) {
            return LotteryWinningNum.BIG;
        } else {
            return LotteryWinningNum.SMALL;
        }
    }

    /**
     * 生成点数单双的中奖结果,当三个号码相同时，通杀
     *
     * @param openCodes
     * @return
     */
    private String generatePointsSingleDoubleNum(String[] openCodes) {
        if (isThreeSame(openCodes)) {
            return null;
        }
        Integer threeSum = generateTotalSum(openCodes);
        return super.generateSingleDoubleNum(threeSum);
    }

    /**
     * 生成长牌的中奖结果
     *
     * @param openCodes
     * @return
     */
    private List<String> generateLongCardNum(String[] openCodes) {
        List<String> winningNumList = new ArrayList<>();
        if (isThreeSame(openCodes)) {//三同
            return winningNumList;
        } else if (isThreeDifferent(openCodes)) {//三不同
            winningNumList.add(Integer.valueOf(openCodes[0]) > Integer.valueOf(openCodes[1]) ? openCodes[1] + openCodes[0] : openCodes[0] + openCodes[1]);
            winningNumList.add(Integer.valueOf(openCodes[0]) > Integer.valueOf(openCodes[2]) ? openCodes[2] + openCodes[0] : openCodes[0] + openCodes[2]);
            winningNumList.add(Integer.valueOf(openCodes[1]) > Integer.valueOf(openCodes[2]) ? openCodes[2] + openCodes[1] : openCodes[1] + openCodes[2]);
        } else {//二同+1
            String result1;
            String result2;
            if (openCodes[0].equals(openCodes[1])) {
                result1 = openCodes[0];
                result2 = openCodes[2];
            } else {
                result1 = openCodes[0];
                result2 = openCodes[1];
            }
            winningNumList.add(Integer.valueOf(result1) > Integer.valueOf(result2) ? result2 + result1 : result1 + result2);
        }
        return winningNumList;
    }


    /**
     * 生成短牌的中奖结果
     *
     * @param openCodes
     * @return
     */
    private String generateShortCardNum(String[] openCodes) {
        if (isThreeDifferent(openCodes)) {
            return null;
        }
        if (openCodes[0].equals(openCodes[1])) {
            return openCodes[0] + openCodes[1];
        } else {
            return openCodes[2] + openCodes[2];
        }
    }

    /**
     * 生成围骰全骰的中奖结果
     *
     * @param openCodes
     * @return
     */
    private String generateDiceNum(String[] openCodes) {
        if (isThreeSame(openCodes)) {
            return openCodes[0] + openCodes[1] + openCodes[2];
        }

        return null;
    }


    /**
     * 生成围骰全骰的中奖结果
     *
     * @param openCodes
     * @return
     */
    private String generateFullDiceNum(String[] openCodes) {
        if (isThreeSame(openCodes)) {
            return LotteryWinningNum.FULL_DICE;
        }
        return null;
    }
    //获取二不同的中奖结果
    private List<String> getDifferTwo(String[] openCodes ,int issbt){
        List<String> winningNumList = new ArrayList<>();
        if (issbt ==0){//开奖号码三不同
            winningNumList.add(openCodes[0]+openCodes[1]);
            winningNumList.add(openCodes[0]+openCodes[2]);
            winningNumList.add(openCodes[1]+openCodes[2]);
            winningNumList.add(openCodes[2]+openCodes[0]);
            winningNumList.add(openCodes[2]+openCodes[1]);
            winningNumList.add(openCodes[1]+openCodes[0]);
        }else {//开奖号码二同+1
            if (openCodes[0].equals(openCodes[1])){
                winningNumList.add(openCodes[0]+openCodes[2]);
                winningNumList.add(openCodes[2]+openCodes[0]);
            }else{
                winningNumList.add(openCodes[0]+openCodes[1]);
                winningNumList.add(openCodes[1]+openCodes[0]);
            }
        }
        return winningNumList;
    }
    //获取三不同的中奖结果
    private List<String> getDifferThree(String[] openCodes){
        List<String> winningNumList = new ArrayList<>();
        winningNumList.add(openCodes[0] + openCodes[1] +openCodes[2] );
        winningNumList.add(openCodes[0] + openCodes[2] +openCodes[1] );
        winningNumList.add(openCodes[1] + openCodes[0] +openCodes[2] );
        winningNumList.add(openCodes[1] + openCodes[2] +openCodes[0] );
        winningNumList.add(openCodes[2] + openCodes[0] +openCodes[1] );
        winningNumList.add(openCodes[2] + openCodes[1] +openCodes[0] );
        return winningNumList;
    }
    //获取三连号的中奖结果
    private List<String> getThreeLianhao(String[] openCodes,String opencode){
        List<String> winningNumList = new ArrayList<>();
        if (Integer.valueOf(openCodes[1]) -Integer.valueOf(openCodes[0]) ==1 && Integer.valueOf(openCodes[2]) -Integer.valueOf(openCodes[1]) == 1){
            winningNumList.add(LotteryWinningNum.GENERAL);
        }
        return winningNumList;
    }
    //获取二同号单选的中奖结果
    private List<String> getTwoSamedx(String[] openCodes){
        List<String> winningNumList = new ArrayList<>();
        if (openCodes[0].equals(openCodes[1])){
            winningNumList.add(openCodes[0]+ openCodes[0] +openCodes[2]);
        }else if (openCodes[0].equals(openCodes[2])){
            winningNumList.add(openCodes[0]+ openCodes[0] +openCodes[1]);
        }else {
            winningNumList.add(openCodes[1]+ openCodes[1] +openCodes[0]);
        }

        return winningNumList;
    }

    //获取二同号复选中奖结果
    private List<String> getTwoSamefx(String[] openCodes){
        List<String> winningNumList = new ArrayList<>();
        if (openCodes[0].equals(openCodes[1])){
            winningNumList.add(openCodes[0]+openCodes[0]);
        }else {
            winningNumList.add(openCodes[2]+openCodes[2]);
        }
        return winningNumList;
    }

    private boolean isThreeDifferent(String[] openCodes) {
        return !openCodes[0].equals(openCodes[1]) && !openCodes[1].equals(openCodes[2]) && !openCodes[0].equals(openCodes[2]);
    }

    private boolean isThreeSame(String[] openCodes) {
        return openCodes[0].equals(openCodes[1]) && openCodes[1].equals(openCodes[2]);
    }
}
