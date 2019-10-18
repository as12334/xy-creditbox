package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.common.utility.math.PermCombTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.utility.NnResultFormatTool;

import java.util.*;
/**
   * Created by shook on 17-4-9.
*/

/**
 * Created by shook on 17-4-9.
 */
public class SscWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> oneDigitalBettingList = new ArrayList<>(5);

    private static List<String> oneDigitalPlayList = new ArrayList<>(4);

    private static List<String> twoDigitalBettingList = new ArrayList<>(10);

    private static List<String> threeDigitalBettingList = new ArrayList<>(10);

    private static List<String> oneCombinationBettingList = new ArrayList<>(4);

    private static List<String> twoCombinationBettingList = new ArrayList<>(3);

    private static List<String> fiveSumPlayList = new ArrayList<>(2);

    private static List<String> group3BettingList = new ArrayList<>(3);

    private static List<String> group6BettingList = new ArrayList<>(3);

    private static List<String> spanBettingList = new ArrayList<>(3);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> qsMap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> hsMap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> renXuanMap = new HashMap<>(3,1f);


    static {
        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.HUNDRED.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.TEN.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.ONE.getCode());
        //一字定位的彩种玩法
        oneDigitalPlayList.add(LotteryPlayEnum.ONE_DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.ONE_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.ONE_SINGLE_DOUBLE.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.ONE_PRIME_COMBINED.getCode());
        //二字定位的投注玩法
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_THOUSAND.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_HUNDRED.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_HUNDRED.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_HUNDRED_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_HUNDRED_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_TEN_ONE.getCode());
        //三字定位的投注玩法
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_HUNDRED.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_HUNDRED_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_HUNDRED_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_TEN_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_HUNDRED_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_HUNDRED_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_TEN_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.HUNDRED_TEN_ONE.getCode());
        //一字组合
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_ALL_FIVE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_FIRST_THREE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_IN_THREE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_AFTER_THREE.getCode());
        //二字组合
        twoCombinationBettingList.add(LotteryBettingEnum.TWO_FIRST_THREE.getCode());
        twoCombinationBettingList.add(LotteryBettingEnum.TWO_IN_THREE.getCode());
        twoCombinationBettingList.add(LotteryBettingEnum.TWO_AFTER_THREE.getCode());
        //五字和数
        fiveSumPlayList.add(LotteryPlayEnum.FIVE_SUM_BIG_SMALL.getCode());
        fiveSumPlayList.add(LotteryPlayEnum.FIVE_SUM_SINGLE_DOUBLE.getCode());
        //组选三
        group3BettingList.add(LotteryBettingEnum.GROUP3_FIRST_THREE.getCode());
        group3BettingList.add(LotteryBettingEnum.GROUP3_IN_THREE.getCode());
        group3BettingList.add(LotteryBettingEnum.GROUP3_AFTER_THREE.getCode());
        //组选六
        group6BettingList.add(LotteryBettingEnum.GROUP6_FIRST_THREE.getCode());
        group6BettingList.add(LotteryBettingEnum.GROUP6_IN_THREE.getCode());
        group6BettingList.add(LotteryBettingEnum.GROUP6_AFTER_THREE.getCode());
        //跨度
        spanBettingList.add(LotteryBettingEnum.SPAN_FIRST_THREE.getCode());
        spanBettingList.add(LotteryBettingEnum.SPAN_IN_THREE.getCode());
        spanBettingList.add(LotteryBettingEnum.SPAN_AFTER_THREE.getCode());


        //官方玩法 前三
        qsMap.put(LotteryPlayEnum.SSC_SANXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_QSZXFS, LotteryBettingEnum.SSC_SANXING_QSZXDS,
                        LotteryBettingEnum.SSC_SANXING_QSZXZH, LotteryBettingEnum.SSC_SANXING_QSZXHZ, LotteryBettingEnum.SSC_SANXING_QSZXKD));
        qsMap.put(LotteryPlayEnum.SSC_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_QSZ3FS, LotteryBettingEnum.SSC_SANXING_QSZ3DS,
                        LotteryBettingEnum.SSC_SANXING_QSZ6FS, LotteryBettingEnum.SSC_SANXING_QSZ6DS, LotteryBettingEnum.SSC_SANXING_QSHHZX,
                        LotteryBettingEnum.SSC_SANXING_QSZUXHZ, LotteryBettingEnum.SSC_SANXING_QSZXBD));
        qsMap.put(LotteryPlayEnum.SSC_SANXING_TESHU,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_QSHZWS, LotteryBettingEnum.SSC_SANXING_QSTS));

        //官方玩法 后三
        hsMap.put(LotteryPlayEnum.SSC_SANXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_HSZXFS, LotteryBettingEnum.SSC_SANXING_HSZXDS,
                        LotteryBettingEnum.SSC_SANXING_HSZXZH, LotteryBettingEnum.SSC_SANXING_HSZXHZ, LotteryBettingEnum.SSC_SANXING_HSZXKD));
        hsMap.put(LotteryPlayEnum.SSC_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_HSZ3FS, LotteryBettingEnum.SSC_SANXING_HSZ3DS,
                        LotteryBettingEnum.SSC_SANXING_HSZ6FS, LotteryBettingEnum.SSC_SANXING_HSZ6DS, LotteryBettingEnum.SSC_SANXING_HSHHZX,
                        LotteryBettingEnum.SSC_SANXING_HSZUXHZ, LotteryBettingEnum.SSC_SANXING_HSZXBD));
        hsMap.put(LotteryPlayEnum.SSC_SANXING_TESHU,
                Arrays.asList(LotteryBettingEnum.SSC_SANXING_HSHZWS, LotteryBettingEnum.SSC_SANXING_HSTS));

        //官方玩法 任选
        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN4_ZHIXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN4_ZXFS, LotteryBettingEnum.SSC_RENXUAN4_ZXDS));

        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN4_ZUXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN4_ZX24, LotteryBettingEnum.SSC_RENXUAN4_ZX12,
                LotteryBettingEnum.SSC_RENXUAN4_ZX6, LotteryBettingEnum.SSC_RENXUAN4_ZX4));

        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN3_ZHIXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN3_ZXFS, LotteryBettingEnum.SSC_RENXUAN3_ZXDS,
                LotteryBettingEnum.SSC_RENXUAN3_ZXHZ));

        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN3_ZUXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN3_Z3FS, LotteryBettingEnum.SSC_RENXUAN3_Z3DS,
                LotteryBettingEnum.SSC_RENXUAN3_Z6FS, LotteryBettingEnum.SSC_RENXUAN3_Z6DS, LotteryBettingEnum.SSC_RENXUAN3_HHZX, LotteryBettingEnum.SSC_RENXUAN3_ZUXHZ));

        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN2_ZHIXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN2_ZXFS, LotteryBettingEnum.SSC_RENXUAN2_ZXDS,
                LotteryBettingEnum.SSC_RENXUAN2_ZXHZ));

        renXuanMap.put(LotteryPlayEnum.SSC_RENXUAN2_ZUXUAN,Arrays.asList(LotteryBettingEnum.SSC_RENXUAN2_ZUXFS, LotteryBettingEnum.SSC_RENXUAN2_ZUXDS,
                LotteryBettingEnum.SSC_RENXUAN2_ZUXHZ));
    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(number.getOpenCode(), ",");
        if(openCodes != null && openCodes.length == 5){
            lotteryWinningRecordList.addAll(createOneDigital(number));
            lotteryWinningRecordList.addAll(createTwoDigital(number));
            lotteryWinningRecordList.addAll(createThreeDigital(number));
            lotteryWinningRecordList.addAll(createOneCombination(number));
            lotteryWinningRecordList.addAll(createTwoCombination(number));
            lotteryWinningRecordList.addAll(createFive(number));
            lotteryWinningRecordList.addAll(createDragonTigerTie(number));
            lotteryWinningRecordList.addAll(createGroup3(number));
            lotteryWinningRecordList.addAll(createGroup6(number));
            lotteryWinningRecordList.addAll(createSpan(number));
            lotteryWinningRecordList.addAll(createSscNn(number));
            //官方玩法的中奖记录
            lotteryWinningRecordList.addAll(createOffical(number));
        }
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    /**
     * 构造官方玩法的中奖记录
     * @param lotteryResult
     * @return
     */
    public List<LotteryWinningRecord> createOffical(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        //todo 暂时只有新疆时时彩,天津时时彩,重庆时时彩有官方玩法
            lotteryWinningRecordList.addAll(createFiveStar(lotteryResult));
            lotteryWinningRecordList.addAll(createFourStar(lotteryResult));
            lotteryWinningRecordList.addAll(createThreeStar(lotteryResult));
            lotteryWinningRecordList.addAll(createTwoStar(lotteryResult));
            lotteryWinningRecordList.addAll(createOneStar(lotteryResult));
            lotteryWinningRecordList.addAll(createNoDigital(lotteryResult));
            lotteryWinningRecordList.addAll(createBigSmallSingleDouble(lotteryResult));
            lotteryWinningRecordList.addAll(createOptional(lotteryResult));
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法任选二三四的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOptional(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        for(LotteryPlayEnum lotteryPlayEnum : renXuanMap.keySet()){
            List<LotteryBettingEnum> list = renXuanMap.get(lotteryPlayEnum);
            LotteryWinningRecord lotteryWinningRecord = null;
            for (LotteryBettingEnum lotteryBettingEnum : list) {
                lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, lotteryResult.getOpenCode());
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", lotteryBettingEnum.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法大小单双的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createBigSmallSingleDouble(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        LotteryWinningRecord lotteryWinningRecord = null;
        String q3Winnum = generateBigSmallSingleDoubleWinNumList(openCodes[0],openCodes[1],openCodes[2]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_DAXIAO_DANSHUANG, LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q3, q3Winnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_DAXIAO_DANSHUANG.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String h3Winnum = generateBigSmallSingleDoubleWinNumList(openCodes[2],openCodes[3],openCodes[4]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_DAXIAO_DANSHUANG, LotteryBettingEnum.SSC_DAXIAODANSHUANG_H3, h3Winnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_DAXIAO_DANSHUANG.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String q2Winnum = generateBigSmallSingleDoubleWinNumList(openCodes[0],openCodes[1]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_DAXIAO_DANSHUANG, LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q2, q2Winnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_DAXIAO_DANSHUANG.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String h2Winnum = generateBigSmallSingleDoubleWinNumList(openCodes[3],openCodes[4]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_DAXIAO_DANSHUANG, LotteryBettingEnum.SSC_DAXIAODANSHUANG_H2, h2Winnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_DAXIAO_DANSHUANG.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }


    /**
     * 生成多个号码对应的大小单双
     * @param nums
     * @return
     */
    private String generateBigSmallSingleDoubleWinNumList(String... nums) {
        StringBuilder winnum = new StringBuilder();
        String[] result = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = generateBigSmallSingleDoubleWinNum(Integer.valueOf(nums[i]));
        }
        winnum.append(StringTool.join("|",result));
        return winnum.toString();
    }

    /**
     * 生成单个号码对应的大小单双
     * @param num
     * @return
     */
    private String generateBigSmallSingleDoubleWinNum(Integer num) {
        StringBuilder sb = new StringBuilder();
        if(num > 4){
            sb.append(LotteryWinningNum.BIG);
        }else{
            sb.append(LotteryWinningNum.SMALL);
        }
        sb.append(",");
        if(num % 2 != 0){
            sb.append(LotteryWinningNum.SINGLE);
        }else{
            sb.append(LotteryWinningNum.DOUBLE);
        }
        return sb.toString();
    }

    /**
     * 构造官方玩法不定位的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createNoDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        LotteryWinningRecord lotteryWinningRecord = null;
        String[] q3OpenCodes = new String[]{openCodes[0],openCodes[1],openCodes[2]};
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SANXING, LotteryBettingEnum.SSC_BUDINGWEI_Q3EM, StringTool.join(",",q3OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SANXING, LotteryBettingEnum.SSC_BUDINGWEI_Q3YM, StringTool.join(",",q3OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String[] h3OpenCodes = new String[]{openCodes[2],openCodes[3],openCodes[4]};
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SANXING, LotteryBettingEnum.SSC_BUDINGWEI_H3EM, StringTool.join(",",h3OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SANXING, LotteryBettingEnum.SSC_BUDINGWEI_H3YM, StringTool.join(",",h3OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String[] q4OpenCodes = new String[]{openCodes[0],openCodes[1],openCodes[2],openCodes[3]};
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SIXING, LotteryBettingEnum.SSC_BUDINGWEI_Q4EM, StringTool.join(",",q4OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SIXING, LotteryBettingEnum.SSC_BUDINGWEI_Q4YM, StringTool.join(",",q4OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String[] h4OpenCodes = new String[]{openCodes[1],openCodes[2],openCodes[3],openCodes[4]};
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SIXING, LotteryBettingEnum.SSC_BUDINGWEI_H4EM, StringTool.join(",",h4OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SIXING, LotteryBettingEnum.SSC_BUDINGWEI_H4YM, StringTool.join(",",h4OpenCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_WUXING, LotteryBettingEnum.SSC_BUDINGWEI_WXSM, StringTool.join(",",lotteryResult.getOpenCode()));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_WUXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_WUXING, LotteryBettingEnum.SSC_BUDINGWEI_WXEM, StringTool.join(",",lotteryResult.getOpenCode()));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_WUXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法定位胆的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_YIXING, LotteryBettingEnum.SSC_YIXING_DWD, lotteryResult.getOpenCode());
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_YIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法二星的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createTwoStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        lotteryWinningRecordList.addAll(generateEXZhixuanWinningRecord(lotteryResult,openCodes[0],openCodes[1]));
        lotteryWinningRecordList.addAll(generateEXZuxuanWinningRecord(lotteryResult,openCodes[0],openCodes[1]));
        return lotteryWinningRecordList;
    }

    /**
     * 生成二星直选中奖记录
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateEXZhixuanWinningRecord(LotteryResultNumber lotteryResult, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String fsWinnum = generateZhixuanFuShiWinnum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZHIXUAN, LotteryBettingEnum.SSC_ERXING_QEZXFS, fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String dsWinnum = generateZhixuanDanShiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZHIXUAN, LotteryBettingEnum.SSC_ERXING_QEZXDS, dsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String hzWinnum = generateHeZhiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZHIXUAN, LotteryBettingEnum.SSC_ERXING_QEZXHZ, hzWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String kdWinnum = generateKuaduWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZHIXUAN, LotteryBettingEnum.SSC_ERXING_QEZXKD, kdWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成二星组选中奖记录
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateEXZuxuanWinningRecord (LotteryResultNumber lotteryResult, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        //二星组选不包含对子号
        if(!openCodes[0].equals(openCodes[1])){
            String fsWinnum = StringTool.join(",",openCodes);
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZUXUAN, LotteryBettingEnum.SSC_ERXING_QEZUXFS, fsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
            List<String> dsWinnumList = PermCombTool.permutationSelect(openCodes,openCodes.length,"");
            for(String dsWinnum : dsWinnumList){
                lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZUXUAN, LotteryBettingEnum.SSC_ERXING_QEZUXDS, dsWinnum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
            String hzWinnum = generateHeZhiWinnum(openCodes);
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZUXUAN, LotteryBettingEnum.SSC_ERXING_QEZUXHZ, hzWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
            String bdWinnum = StringTool.join(",",openCodes);
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_ERXING_ZUXUAN, LotteryBettingEnum.SSC_ERXING_QEZUXBD, bdWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法三星的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createThreeStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        //前三
        String[] qsopenCodes = new String[]{openCodes[0],openCodes[1],openCodes[2]};
        lotteryWinningRecordList.addAll(generateSXZhixuanWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SSC_SANXING_ZHIXUAN),qsopenCodes));
        lotteryWinningRecordList.addAll(generateSXZuxuanWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SSC_SANXING_ZUXUAN),qsopenCodes));
        lotteryWinningRecordList.addAll(generateSXTeshuWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SSC_SANXING_TESHU),qsopenCodes));
        //后三
        String[] hsopenCodes = new String[]{openCodes[2],openCodes[3],openCodes[4]};
        lotteryWinningRecordList.addAll(generateSXZhixuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SSC_SANXING_ZHIXUAN),hsopenCodes));
        lotteryWinningRecordList.addAll(generateSXZuxuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SSC_SANXING_ZUXUAN),hsopenCodes));
        lotteryWinningRecordList.addAll(generateSXTeshuWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SSC_SANXING_TESHU),hsopenCodes));
        return lotteryWinningRecordList;
    }

    /**
     * 生成三星特殊的中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateSXTeshuWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String hwWinnum = generateHeweiWinnum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_TESHU, bettingList.get(0), hwWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_TESHU.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String tsWinnum = generateTeshuWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_TESHU, bettingList.get(1), tsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_TESHU.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 三星特殊号
     * @param openCodes
     * @return
     */
    private String generateTeshuWinnum(String... openCodes) {
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return LotteryWinningNum.THREE_SAME;
        }else if(openCodes[0].equals(openCodes[1]) || openCodes[0].equals(openCodes[2]) || openCodes[1].equals(openCodes[2])){
            return LotteryWinningNum.PAIR;
        }else if(checkStraight(openCodes)){
            return LotteryWinningNum.STRAIGHT;
        }
        return null;
    }

    /**
     * 判断是否是顺子
     * @param openCodes
     * @return
     */
    private boolean checkStraight(String... openCodes){
        List<String> list = Arrays.asList(openCodes);
        Collections.sort(list);
        if(list.contains("0") && list.contains("9") && (list.contains("1") || list.contains("8"))){
            return true;
        }
        Integer num1 = Integer.valueOf(list.get(0));
        Integer num2 = Integer.valueOf(list.get(1));
        Integer num3 = Integer.valueOf(list.get(2));
        return num2 == num1+1 && num2 == num3-1;
    }


    /**
     * 三星特殊和值尾数
     * @param openCodes
     * @return
     */
    private String generateHeweiWinnum(String... openCodes) {
        return generateMantissa(generateHeZhiWinnum(openCodes));
    }

    /**
     * 生成三星组选选中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateSXZuxuanWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        String group3fsWinnum = generateSXGroup3FsWinNum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(0), group3fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> group3dsWinnumList = generateSXGroup3DsWinNum(openCodes);
        for(String group3dsWinnum : group3dsWinnumList){
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(1), group3dsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        String group6fsWinnum = generateSXGroup6FsWinNum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(2), group6fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> group6dsWinnumList = generateSXGroup6DsWinNumList(openCodes);
        for(String group6dsWinnum : group6dsWinnumList){
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(3), group6dsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        List<String> hhWinnumList = generateHhWinnumSet(openCodes);
        for (String hhWinnum: hhWinnumList) {
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(4), hhWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        String hzWinnum = generateSXHZWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(5), hzWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String bdWinnum = generateSXBDWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZUXUAN, bettingList.get(6), bdWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }
    /**
     * 三星组选包胆
     * @param openCodes
     * @return
     */
    private String generateSXBDWinnum(String... openCodes) {
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return null;
        }
        return StringTool.join(",",openCodes);
    }

    /**
     * 三星组选和值
     * @param openCodes
     * @return
     */
    private String generateSXHZWinnum(String... openCodes) {
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return null;
        }
        return StringTool.join(",",openCodes);
    }


    /**
     * 三星组选混合
     * @param openCodes
     * @return
     */
    private List<String> generateHhWinnumSet(String... openCodes) {
        List<String> winNumList = new ArrayList<>();
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return winNumList;
        }else if(!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2])){
            winNumList.addAll(PermCombTool.permutationSelect(openCodes,3,","));
        }else{
            //有;表示组三
            String num1 = openCodes[0];
            String num2 = openCodes[1];
            String num3 = openCodes[2];
            winNumList = createZuxuanHhZu3(num1,num2,num3);
        }
        return winNumList;
    }

    /**
     * 三星组选三复式
     * @param openCodes
     * @return
     */
    private String generateSXGroup3FsWinNum(String... openCodes) {
        if((openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])) ||
                (!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2]))){
            return null;
        }
        return StringTool.join(",",openCodes);
    }

    /**
     * 三星组选六复式
     * @param openCode
     * @return
     */
    private String generateSXGroup6FsWinNum(String... openCode) {
        if (!openCode[0].equals(openCode[1]) && !openCode[0].equals(openCode[2]) && !openCode[1].equals(openCode[2]))
            return StringTool.join(",",openCode);
        return null;
    }

    /**
     * 三星组选六单式
     * @param openCode
     * @return
     */
    private List<String> generateSXGroup6DsWinNumList(String... openCode) {
        List<String> list = new ArrayList<>();
        if (openCode != null && openCode.length == 3 && !openCode[0].equals(openCode[1]) && !openCode[0].equals(openCode[2]) && !openCode[1].equals(openCode[2]))
            list.addAll(PermCombTool.permutationSelect(openCode,3,""));
        return list;
    }


    /**
     * 三星组选三单式
     * @param openCodes
     * @return
     */
    private List<String> generateSXGroup3DsWinNum(String... openCodes) {
        List<String> winNumList = new ArrayList<>();
        if ((openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2]))
                || (!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2])))
            return winNumList;
        String num1 = openCodes[0];
        String num2 = openCodes[1];
        String num3 = openCodes[2];
        winNumList = createZuxuanZu3(num1,num2,num3);
        return winNumList;
    }



    /**
     * 生成三星直选中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateSXZhixuanWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String fsWinnum = generateZhixuanFuShiWinnum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZHIXUAN, bettingList.get(0), fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }

        String dsWinnum = generateZhixuanDanShiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZHIXUAN, bettingList.get(1), dsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String zhWinnum = generateZhixuanFuShiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZHIXUAN, bettingList.get(2), zhWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String hzWinnum = generateHeZhiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZHIXUAN, bettingList.get(3), hzWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String kdWinnum = generateKuaduWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SANXING_ZHIXUAN, bettingList.get(4), kdWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法四星的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createFourStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String fsOpenCode = generateZhixuanFuShiWinnum(openCodes[1],openCodes[2],openCodes[3],openCodes[4]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SIXING_ZHIXUAN, LotteryBettingEnum.SSC_SIXING_ZXFS, fsOpenCode);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SIXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String dsOpenCode = generateZhixuanDanShiWinnum(openCodes[1],openCodes[2],openCodes[3],openCodes[4]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_SIXING_ZHIXUAN, LotteryBettingEnum.SSC_SIXING_ZXDS, dsOpenCode);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_SIXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法五星的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createFiveStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String fsOpenCode = generateZhixuanFuShiWinnum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_WUXING_ZHIXUAN, LotteryBettingEnum.SSC_WUXING_ZXFS, fsOpenCode);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_WUXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String dsOpenCode = generateZhixuanDanShiWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_WUXING_ZHIXUAN, LotteryBettingEnum.SSC_WUXING_ZXDS, dsOpenCode);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_WUXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成跨度Winnum
     * @return
     */
    private String generateKuaduWinnum(String... openCodes){
        Integer min = null;
        Integer max = null;
        if(openCodes != null && openCodes.length > 0){
            min = Integer.MAX_VALUE;
            max = 0;
            for (String openCode: openCodes) {
                if(StringTool.isNotEmpty(openCode)){
                    Integer num = Integer.valueOf(openCode);
                    if(min > num){
                        min = num;
                    }
                    if(max < num){
                        max = num;
                    }
                }
            }
        }
        return min == null || max == null?null:String.valueOf(max-min);
    }

    /**
     * 生成和值Winnum
     * @return
     */
    private String generateHeZhiWinnum(String... openCodes){
        Integer sum = null;
        if(openCodes != null && openCodes.length > 0){
            sum = 0;
            for (String openCode: openCodes) {
                if(StringTool.isNotEmpty(openCode)){
                    sum += Integer.valueOf(openCode);
                }
            }
        }
        return sum == null?null:String.valueOf(sum);
    }



    /**
     * 生成直选复式Winnum
     * @return
     */
    private String generateZhixuanFuShiWinnum(String... openCodes){
        StringBuilder winnum = new StringBuilder();
        if(openCodes != null && openCodes.length > 0){
            winnum.append("%").append(StringTool.join("%|%",openCodes)).append("%");
        }
        return winnum.toString();
    }

    /**
     * 生成直选单式Winnum
     * @return
     */
    private String generateZhixuanDanShiWinnum(String... openCodes){
        return StringTool.join("",openCodes);
    }


    private List<LotteryWinningRecord> createSpan(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : spanBettingList){
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case SPAN_FIRST_THREE:
                    winningNum = generateSpanNum(openCodes[0],openCodes[1],openCodes[2]);
                    break;
                case SPAN_IN_THREE:
                    winningNum = generateSpanNum(openCodes[1],openCodes[2],openCodes[3]);
                    break;
                case SPAN_AFTER_THREE:
                    winningNum = generateSpanNum(openCodes[2],openCodes[3],openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SPAN, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SPAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    private List<LotteryWinningRecord> createOneDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, oneDigitalBettingList.get(i));
            for (String playCode : oneDigitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case ONE_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case ONE_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case ONE_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case ONE_PRIME_COMBINED:
                        winningNum = generatePrimeCombinedNum(Integer.valueOf(openCodes[i]));
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造一字组合的中奖记录，包含全五，前三，中三，后三
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneCombination(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : oneCombinationBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            Set<String> winningNumSet = null;
            switch (lotteryBettingEnum) {
                case ONE_ALL_FIVE:
                    winningNumSet = generateOneCombinationWinningNum(openCodes);
                    break;
                case ONE_FIRST_THREE:
                    winningNumSet = generateOneCombinationWinningNum(openCodes[0], openCodes[1], openCodes[2]);
                    break;
                case ONE_IN_THREE:
                    winningNumSet = generateOneCombinationWinningNum(openCodes[1], openCodes[2], openCodes[3]);
                    break;
                case ONE_AFTER_THREE:
                    winningNumSet = generateOneCombinationWinningNum(openCodes[2], openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            for (String winningNum : winningNumSet) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.ONE_COMBINATION, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.ONE_COMBINATION.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成一字组合的中奖结果
     * @return
     */
    private Set<String> generateOneCombinationWinningNum(String... openCodes){
        Set<String> winningNumSet = new HashSet<>();
        for (String openCode : openCodes){
            winningNumSet.add(openCode);
        }
        return winningNumSet;
    }


    /**
     * 构构造二字定位的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createTwoDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : twoDigitalBettingList) {
            String winningNum = null;
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {
                case SSC_WAN_THOUSAND:
                    winningNum = generateTwoDigital(openCodes[0], openCodes[1]);
                    break;
                case SSC_WAN_HUNDRED:
                    winningNum = generateTwoDigital(openCodes[0], openCodes[2]);
                    break;
                case SSC_WAN_TEN:
                    winningNum = generateTwoDigital(openCodes[0], openCodes[3]);
                    break;
                case SSC_WAN_ONE:
                    winningNum = generateTwoDigital(openCodes[0], openCodes[4]);
                    break;
                case SSC_THOUSAND_HUNDRED:
                    winningNum = generateTwoDigital(openCodes[1], openCodes[2]);
                    break;
                case SSC_THOUSAND_TEN:
                    winningNum = generateTwoDigital(openCodes[1], openCodes[3]);
                    break;
                case SSC_THOUSAND_ONE:
                    winningNum = generateTwoDigital(openCodes[1], openCodes[4]);
                    break;
                case SSC_HUNDRED_TEN:
                    winningNum = generateTwoDigital(openCodes[2], openCodes[3]);
                    break;
                case SSC_HUNDRED_ONE:
                    winningNum = generateTwoDigital(openCodes[2], openCodes[4]);
                    break;
                case SSC_TEN_ONE:
                    winningNum = generateTwoDigital(openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.TWO_DIGITAL, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.TWO_DIGITAL.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 二字组合
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createTwoCombination(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : twoCombinationBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            List<String> winningNumList = new ArrayList<>();
            if (LotteryBettingEnum.TWO_FIRST_THREE.getCode().equals(betCode)) {
                for (int i = 0; i < 3; i++) {
                    for (int j = i + 1; j < 3; j++) {
                        if (!winningNumList.contains(openCodes[i] + openCodes[j]))
                            winningNumList.add(openCodes[i] + openCodes[j]);
                        if (!winningNumList.contains(openCodes[j] + openCodes[i]))
                            winningNumList.add(openCodes[j] + openCodes[i]);
                    }
                }
            } else if (LotteryBettingEnum.TWO_IN_THREE.getCode().equals(betCode)) {
                for (int i = 1; i < 4; i++) {
                    for (int j = i + 1; j < 4; j++) {
                        if (!winningNumList.contains(openCodes[i] + openCodes[j]))
                            winningNumList.add(openCodes[i] + openCodes[j]);
                        if (!winningNumList.contains(openCodes[j] + openCodes[i]))
                            winningNumList.add(openCodes[j] + openCodes[i]);
                    }
                }
            } else if (LotteryBettingEnum.TWO_AFTER_THREE.getCode().equals(betCode)) {
                for (int i = 2; i < 5; i++) {
                    for (int j = i + 1; j < 5; j++) {
                        if (!winningNumList.contains(openCodes[i] + openCodes[j]))
                            winningNumList.add(openCodes[i] + openCodes[j]);
                        if (!winningNumList.contains(openCodes[j] + openCodes[i]))
                            winningNumList.add(openCodes[j] + openCodes[i]);
                    }
                }
            }
            for (String winningNum : winningNumList) {
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.TWO_COMBINATION, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.TWO_COMBINATION.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }


    /**
     * 构构构造三字定位的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createThreeDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : threeDigitalBettingList) {
            String winningNum = null;
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {//01234
                case TEN_THOUSAND_THOUSAND_HUNDRED:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[1], openCodes[2]);
                    break;
                case TEN_THOUSAND_THOUSAND_TEN:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[1], openCodes[3]);
                    break;
                case TEN_THOUSAND_THOUSAND_ONE:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[1], openCodes[4]);
                    break;
                case TEN_THOUSAND_HUNDRED_TEN:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[2], openCodes[3]);
                    break;
                case TEN_THOUSAND_HUNDRED_ONE:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[2], openCodes[4]);
                    break;
                case TEN_THOUSAND_TEN_ONE:
                    winningNum = generateThreeDigital(openCodes[0], openCodes[3], openCodes[4]);
                    break;
                case THOUSAND_HUNDRED_TEN:
                    winningNum = generateThreeDigital(openCodes[1], openCodes[2], openCodes[3]);
                    break;
                case THOUSAND_HUNDRED_ONE:
                    winningNum = generateThreeDigital(openCodes[1], openCodes[2], openCodes[4]);
                    break;
                case THOUSAND_TEN_ONE:
                    winningNum = generateThreeDigital(openCodes[1], openCodes[3], openCodes[4]);
                    break;
                case HUNDRED_TEN_ONE:
                    winningNum = generateThreeDigital(openCodes[2], openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.THREE_DIGITAL, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.THREE_DIGITAL.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    /**
     * 构造五字和数大小，五字 和数单双的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createFive(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer fiveSum = generateTotalSum(openCodes);
        for (String playCode : fiveSumPlayList) {
            String winningNum = null;
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            if (LotteryPlayEnum.FIVE_SUM_BIG_SMALL.equals(lotteryPlayEnum)) {
                winningNum = generateTotalBigSmallNum(fiveSum);
            } else if (LotteryPlayEnum.FIVE_SUM_SINGLE_DOUBLE.equals(lotteryPlayEnum)) {
                winningNum = generateTotalSingleDoubleNum(fiveSum);
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.FIVE_SUM, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 23;
    }

    private List<LotteryWinningRecord> createDragonTigerTie(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : twoDigitalBettingList) {
            String winningNum = null;
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {
                case SSC_WAN_THOUSAND:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[1]));
                    break;
                case SSC_WAN_HUNDRED:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[2]));
                    break;
                case SSC_WAN_TEN:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[3]));
                    break;
                case SSC_WAN_ONE:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[4]));
                    break;
                case SSC_THOUSAND_HUNDRED:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[2]));
                    break;
                case SSC_THOUSAND_TEN:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[3]));
                    break;
                case SSC_THOUSAND_ONE:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[4]));
                    break;
                case SSC_HUNDRED_TEN:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[3]));
                    break;
                case SSC_HUNDRED_ONE:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[4]));
                    break;
                case SSC_TEN_ONE:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[3]), Integer.valueOf(openCodes[4]));
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.DRAGON_TIGER_TIE, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.DRAGON_TIGER_TIE.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造组选三的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createGroup3(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : group3BettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case GROUP3_FIRST_THREE:
                    winningNum = generateGroup3Num(openCodes[0], openCodes[1], openCodes[2]);
                    break;
                case GROUP3_IN_THREE:
                    winningNum = generateGroup3Num(openCodes[1], openCodes[2], openCodes[3]);
                    break;
                case GROUP3_AFTER_THREE:
                    winningNum = generateGroup3Num(openCodes[2], openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.GROUP_THREE, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.GROUP_THREE.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createGroup6(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : group6BettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case GROUP6_FIRST_THREE:
                    winningNum = generateGroup6Num(openCodes[0], openCodes[1], openCodes[2]);
                    break;
                case GROUP6_IN_THREE:
                    winningNum = generateGroup6Num(openCodes[1], openCodes[2], openCodes[3]);
                    break;
                case GROUP6_AFTER_THREE:
                    winningNum = generateGroup6Num(openCodes[2], openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.GROUP_SIX, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.GROUP_SIX.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createSscNn (LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<String> nums = Arrays.asList(openCodes);
        int result = NnResultFormatTool.getScroe(nums);

        //牛几
        String winningNum = null;
        switch (result) {
            case -1:
                winningNum = LotteryWinningNum.SSC_NO_NIU;
                break;
            case 1:
                winningNum = LotteryWinningNum.SSC_ONE_NIU;
                break;
            case 2:
                winningNum = LotteryWinningNum.SSC_TWO_NIU;
                break;
            case 3:
                winningNum = LotteryWinningNum.SSC_THREE_NIU;
                break;
            case 4:
                winningNum = LotteryWinningNum.SSC_FOUR_NIU;
                break;
            case 5:
                winningNum = LotteryWinningNum.SSC_FIVE_NIU;
                break;
            case 6:
                winningNum = LotteryWinningNum.SSC_SIX_NIU;
                break;
            case 7:
                winningNum = LotteryWinningNum.SSC_SEVEN_NIU;
                break;
            case 8:
                winningNum = LotteryWinningNum.SSC_EIGHT_NIU;
                break;
            case 9:
                winningNum = LotteryWinningNum.SSC_NINE_NIU;
                break;
            default:
                winningNum = LotteryWinningNum.SSC_NIU_NIU;
                break;
        }
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_NN, LotteryBettingEnum.NN_NUM, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_NN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }

        //牛双面
        //牛大小
        String winningNum1 = null;
        if (LotteryWinningNum.SSC_SIX_NIU.equals(winningNum) || LotteryWinningNum.SSC_SEVEN_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_EIGHT_NIU.equals(winningNum) || LotteryWinningNum.SSC_NINE_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_NIU_NIU.equals(winningNum)) {
            winningNum1 = LotteryWinningNum.SSC_BIG_NIU;
        } else if (LotteryWinningNum.SSC_ONE_NIU.equals(winningNum) || LotteryWinningNum.SSC_TWO_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_THREE_NIU.equals(winningNum) || LotteryWinningNum.SSC_FOUR_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_FIVE_NIU.equals(winningNum)) {
            winningNum1 = LotteryWinningNum.SSC_SMALL_NIU;
        }

        LotteryWinningRecord lotteryWinningRecord1 = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_NN, LotteryBettingEnum.NN_SIDE, winningNum1);
        if (lotteryWinningRecord1 != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_NN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord1);
        }

        //牛单双
        String winningNum2 = null;
        if (LotteryWinningNum.SSC_ONE_NIU.equals(winningNum) || LotteryWinningNum.SSC_SEVEN_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_THREE_NIU.equals(winningNum) || LotteryWinningNum.SSC_NINE_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_FIVE_NIU.equals(winningNum)) {
            winningNum2 = LotteryWinningNum.SSC_SINGLE_NIU;

        } else if (LotteryWinningNum.SSC_EIGHT_NIU.equals(winningNum) || LotteryWinningNum.SSC_TWO_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_SIX_NIU.equals(winningNum) || LotteryWinningNum.SSC_FOUR_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_NIU_NIU.equals(winningNum)) {
            winningNum2 = LotteryWinningNum.SSC_DOUBLE_NIU;
        }

        LotteryWinningRecord lotteryWinningRecord2 = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_NN, LotteryBettingEnum.NN_SIDE, winningNum2);
        if (lotteryWinningRecord2 != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_NN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord2);
        }

        //牛质合
        String winningNum3 = null;
        if (LotteryWinningNum.SSC_ONE_NIU.equals(winningNum) || LotteryWinningNum.SSC_TWO_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_THREE_NIU.equals(winningNum) || LotteryWinningNum.SSC_FIVE_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_SEVEN_NIU.equals(winningNum)) {
            winningNum3 = LotteryWinningNum.SSC_PRIME_NIU;

        } else if (LotteryWinningNum.SSC_EIGHT_NIU.equals(winningNum) || LotteryWinningNum.SSC_FOUR_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_SIX_NIU.equals(winningNum) || LotteryWinningNum.SSC_NINE_NIU.equals(winningNum) ||
                LotteryWinningNum.SSC_NIU_NIU.equals(winningNum)) {
            winningNum3 = LotteryWinningNum.SSC_COMBINED_NIU;
        }

        LotteryWinningRecord lotteryWinningRecord3 = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_NN, LotteryBettingEnum.NN_SIDE, winningNum3);
        if (lotteryWinningRecord3 != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_NN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord3);
        }


        //牛梭哈
        String winningNum4 = getFullHouseWin (nums);

        LotteryWinningRecord lotteryWinningRecord4 = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_NN, LotteryBettingEnum.NN_FULL_HOUSE, winningNum4);
        if (lotteryWinningRecord4 != null && winningNum4 != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_NN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord4);
        }
        return lotteryWinningRecordList;
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 5;
    }

    private String generateTwoDigital(String openCode1, String openCode2) {
        return openCode1 + openCode2;
    }

    private String generateThreeDigital(String openCode1, String openCode2, String openCode3) {
        return openCode1 + openCode2 + openCode3;
    }

    public String getFullHouseWin(List<String> nums) {
        Collections.sort(nums);
        return computeNum (nums);
    }

    private String computeNum (List<String> nums) {
        String winNum = null;
        int count = 1;
        int count1 = 1;
        int z1 = 10;
        int z2 = 10;

        for (int i = 0; i < 5; i++) {
            if(z1 == Integer.valueOf(nums.get(i)) || z2 == Integer.valueOf(nums.get(i)))continue;
            for (int j = i+1; j < 5; j++) {
                if (Integer.valueOf(nums.get(i)) == Integer.valueOf(nums.get(j))) {
                    if (z1==10 || z1 == Integer.valueOf(nums.get(i))) {
                        z1 = Integer.valueOf(nums.get(i));
                        count++;
                    } else {
                        z2 = Integer.valueOf(nums.get(i));
                        count1++;
                    }
                } else if (isContinuous (nums)) {
                    count = -1;
                    count1 = -1;
                }
            }
        }

        if (count == 5 && count1 == 1) {
            winNum = LotteryWinningNum.SSC_WU_TIAO;
        } else if ((count == 2 && count1 == 3) || (count == 3 && count1 == 2)) {
            winNum = LotteryWinningNum.SSC_HU_LU;
        } else if ((count == 1 && count1 == 3) || (count == 3 && count1 == 1)) {
            winNum = LotteryWinningNum.SSC_SAN_TIAO;
        }else if (count == 4 || count1 == 4) {
            winNum = LotteryWinningNum.SSC_ZHA_DAN;
        } else if (count == 2 && count1 == 2) {
            winNum = LotteryWinningNum.SSC_ER_DUI;
        } else if ((count == 2 && count1 != 2) || (count != 2 && count1 == 2)) {
            winNum = LotteryWinningNum.SSC_DAN_DUI;
        } else if (count == 1 && count1 == 1) {
            winNum = LotteryWinningNum.SSC_SAN_HAO;
        } else if (count == -1 && count1 == -1) {
            winNum = LotteryWinningNum.SSC_SHUN_ZI;
        }
        return winNum;

    }

    private boolean isContinuous(List<String> nums) {
        ArrayList<String> list = new ArrayList<String>();
        if(nums.size()!=5){
            return false;
        }
        int max = -1;
        int min = 10;
        int flg = 0;
        for(int i=0;i<nums.size();i++){
            String number = nums.get(i);
            if(Integer.valueOf(number) < 0 || Integer.valueOf(number) > 10) return false;
            //查看是否有重复的数字
            if(list.contains(number)){
                flg=1;
            }else{
                list.add(number);
            }
            if(flg==1) return false;
            if(Integer.valueOf(number) > max) max = Integer.valueOf(number);
            if(Integer.valueOf(number) < min) min = Integer.valueOf(number);
        }

        if(max-min != 4) return false;
        return true;
    }
}
