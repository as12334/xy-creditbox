package so.wwb.lotterybox.service.manager.lottery.winning;

import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.common.utility.math.PermCombTool;
import so.wwb.lotterybox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

import java.util.*;
/**
   * Created by rambo on 18-5-25.
*/

/**
 * Created by shook on 17-4-9.
 */
public class EsfWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {
    
    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> qsMap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> hsMap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> zsMap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> qeMap = new HashMap<>(2,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> heMap = new HashMap<>(2,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> renxMap = new HashMap<>(3,1f);


    static {
        //官方玩法 前三
        qsMap.put(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_QSZXFS, LotteryBettingEnum.SYX5_SANXING_QSZXDS));
        qsMap.put(LotteryPlayEnum.SYX5_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_QSZUXFS, LotteryBettingEnum.SYX5_SANXING_QSZUXDS,
                        LotteryBettingEnum.SYX5_SANXING_QSZUXDT));
        qsMap.put(LotteryPlayEnum.SYX5_SANXING_BDW,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_QSBDW));

        //官方玩法 后三
        hsMap.put(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_HSZXFS, LotteryBettingEnum.SYX5_SANXING_HSZXDS));
        hsMap.put(LotteryPlayEnum.SYX5_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_HSZUXFS, LotteryBettingEnum.SYX5_SANXING_HSZUXDS,
                        LotteryBettingEnum.SYX5_SANXING_HSZUXDT));
        hsMap.put(LotteryPlayEnum.SYX5_SANXING_BDW,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_HSBDW));

        //官方玩法 中三
        zsMap.put(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_ZSZXFS, LotteryBettingEnum.SYX5_SANXING_ZSZXDS));
        zsMap.put(LotteryPlayEnum.SYX5_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_ZSZUXFS, LotteryBettingEnum.SYX5_SANXING_ZSZUXDS,
                        LotteryBettingEnum.SYX5_SANXING_ZSZUXDT));
        zsMap.put(LotteryPlayEnum.SYX5_SANXING_BDW,
                Arrays.asList(LotteryBettingEnum.SYX5_SANXING_ZSBDW));

        //官方玩法 前二
        qeMap.put(LotteryPlayEnum.SYX5_ERXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_ERXING_QEZXFS, LotteryBettingEnum.SYX5_ERXING_QEZXDS));
        qeMap.put(LotteryPlayEnum.SYX5_ERXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_ERXING_QEZUXFS, LotteryBettingEnum.SYX5_ERXING_QEZUXDS,
                        LotteryBettingEnum.SYX5_ERXING_QEZUXDT));

        //官方玩法 后二
        heMap.put(LotteryPlayEnum.SYX5_ERXING_ZHIXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_ERXING_HEZXFS, LotteryBettingEnum.SYX5_ERXING_HEZXDS));
        heMap.put(LotteryPlayEnum.SYX5_ERXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.SYX5_ERXING_HEZUXFS, LotteryBettingEnum.SYX5_ERXING_HEZUXDS,
                        LotteryBettingEnum.SYX5_ERXING_HEZUXDT));
        //任选
        renxMap.put(LotteryPlayEnum.SYX5_ERNXUANDS,
                Arrays.asList(LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS, LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODS,
                        LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDS, LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDS,
                        LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDS, LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDS,
                        LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDS, LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDS));
        renxMap.put(LotteryPlayEnum.SYX5_ERNXUANFS,
                Arrays.asList(LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEFS, LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWOFS,
                        LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEFS, LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURFS,
                        LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEFS, LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEFS,
                        LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEFS, LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEFS));
        renxMap.put(LotteryPlayEnum.SYX5_ERNXUANDT,
                Arrays.asList(LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODT, LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDT,
                        LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDT, LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDT,
                        LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDT, LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDT,
                        LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDT));
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
            lotteryWinningRecordList.addAll(createThreeStar(lotteryResult));
            lotteryWinningRecordList.addAll(createTwoStar(lotteryResult));
            lotteryWinningRecordList.addAll(createOneStar(lotteryResult));
            lotteryWinningRecordList.addAll(createOptional(lotteryResult));
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法任选一二三四的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOptional(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        //任选单式/复式
        lotteryWinningRecordList.addAll(renXuanWinNum(lotteryResult, openCodes));
        //任选胆拖
        lotteryWinningRecordList.addAll(renXuanDtWinNum(lotteryResult, openCodes));
        return lotteryWinningRecordList;
    }
    /**
     *任选单式/复式
     * @param lotteryResult
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> renXuanWinNum(LotteryResultNumber lotteryResult, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        String winnum = StringTool.join(",",openCodes);
        for (int i = 0; i < 8; i++) {
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERNXUANDS, renxMap.get(LotteryPlayEnum.SYX5_ERNXUANDS).get(i), winnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERNXUANDS.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }

            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERNXUANFS, renxMap.get(LotteryPlayEnum.SYX5_ERNXUANDS).get(i), winnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERNXUANFS.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     *任选胆拖
     * @param lotteryResult
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> renXuanDtWinNum(LotteryResultNumber lotteryResult, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        for (int i = 0; i < 7; i++) {
            String winnum = StringTool.join(",", openCodes);
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERNXUANDT, renxMap.get(LotteryPlayEnum.SYX5_ERNXUANDT).get(i), winnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERNXUANDT.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造官方玩法三星不定位中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> generateSXBDWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SSC_BUDINGWEI_SANXING, bettingList.get(0), StringTool.join(",",openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SSC_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
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
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_YIXING, LotteryBettingEnum.SYX5_YIXING_DWD, lotteryResult.getOpenCode());
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_YIXING.getCode(), lotteryWinningRecord.toString());
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
        //前二
        String[] qsopenCodes = new String[]{openCodes[0],openCodes[1]};
        lotteryWinningRecordList.addAll(generateEXZhixuanWinningRecord(lotteryResult,qeMap.get(LotteryPlayEnum.SYX5_ERXING_ZHIXUAN),qsopenCodes));
        lotteryWinningRecordList.addAll(generateEXZuxuanWinningRecord(lotteryResult,qeMap.get(LotteryPlayEnum.SYX5_ERXING_ZUXUAN),qsopenCodes));
        //后二
        String[] hsopenCodes = new String[]{openCodes[3],openCodes[4]};
        lotteryWinningRecordList.addAll(generateEXZhixuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SYX5_ERXING_ZHIXUAN),hsopenCodes));
        lotteryWinningRecordList.addAll(generateEXZuxuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SYX5_ERXING_ZUXUAN),hsopenCodes));
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
        lotteryWinningRecordList.addAll(generateSXZhixuanWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN),qsopenCodes));
        lotteryWinningRecordList.addAll(generateSXZuxuanWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SYX5_SANXING_ZUXUAN),qsopenCodes));
        lotteryWinningRecordList.addAll(generateSXBDWinningRecord(lotteryResult,qsMap.get(LotteryPlayEnum.SYX5_SANXING_BDW),qsopenCodes));
        //中三
        String[] zsopenCodes = new String[]{openCodes[1],openCodes[2],openCodes[3]};
        lotteryWinningRecordList.addAll(generateSXZhixuanWinningRecord(lotteryResult,zsMap.get(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN),zsopenCodes));
        lotteryWinningRecordList.addAll(generateSXZuxuanWinningRecord(lotteryResult,zsMap.get(LotteryPlayEnum.SYX5_SANXING_ZUXUAN),zsopenCodes));
        lotteryWinningRecordList.addAll(generateSXBDWinningRecord(lotteryResult,zsMap.get(LotteryPlayEnum.SYX5_SANXING_BDW),zsopenCodes));
        //后三
        String[] hsopenCodes = new String[]{openCodes[2],openCodes[3],openCodes[4]};
        lotteryWinningRecordList.addAll(generateSXZhixuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN),hsopenCodes));
        lotteryWinningRecordList.addAll(generateSXZuxuanWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SYX5_SANXING_ZUXUAN),hsopenCodes));
        lotteryWinningRecordList.addAll(generateSXBDWinningRecord(lotteryResult,hsMap.get(LotteryPlayEnum.SYX5_SANXING_BDW),hsopenCodes));
        return lotteryWinningRecordList;
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
        String groupfsWinnum = StringTool.join(",",openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_SANXING_ZUXUAN, bettingList.get(0), groupfsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> groupdsWinnumList = PermCombTool.permutationSelect(openCodes,3,"");
        for(String groupdsWinnum : groupdsWinnumList){
            //组选单式
            LotteryWinningRecord ds = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_SANXING_ZUXUAN, bettingList.get(1), groupdsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(ds);
            }
            //组选胆拖
            groupdsWinnum = generateZhixuanFuShiWinnum(groupdsWinnum.split(""));
            LotteryWinningRecord dt = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_SANXING_ZUXUAN, bettingList.get(2), groupdsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(dt);
            }
        }
        return lotteryWinningRecordList;
    }
    /**
     * 生成二星组选选中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateEXZuxuanWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        String groupfsWinnum = StringTool.join(",",openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERXING_ZUXUAN, bettingList.get(0), groupfsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> groupdsWinnumList = PermCombTool.permutationSelect(openCodes,openCodes.length,"");
        for(String groupdsWinnum : groupdsWinnumList){
            //组选单式
            LotteryWinningRecord ds = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERXING_ZUXUAN, bettingList.get(1), groupdsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(ds);
            }
            //组选胆拖
            groupdsWinnum = generateZhixuanFuShiWinnum(groupdsWinnum.split(""));
            LotteryWinningRecord dt = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERXING_ZUXUAN, bettingList.get(2), groupdsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(dt);
            }
        }
        return lotteryWinningRecordList;
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
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_SANXING_ZHIXUAN, bettingList.get(0), fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }

        String dsWinnum = StringTool.join("",openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_SANXING_ZHIXUAN, bettingList.get(1), dsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成二星直选中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateEXZhixuanWinningRecord(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String fsWinnum = generateZhixuanFuShiWinnum(openCodes);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERXING_ZHIXUAN, bettingList.get(0), fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }

        String dsWinnum = StringTool.join("",openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SYX5_ERXING_ZHIXUAN, bettingList.get(1), dsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.11选5.{0},生成中奖记录:{1}", LotteryPlayEnum.SYX5_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
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
}
