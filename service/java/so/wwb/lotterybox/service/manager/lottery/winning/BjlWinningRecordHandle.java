package so.wwb.lotterybox.service.manager.lottery.winning;

import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.lotterybox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BjlWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createBjlDigital(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }


    private List<LotteryWinningRecord> createBjlDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");

        List<String> betNumList = generateBjlNum(openCodes);
        for (String betNum : betNumList) {
            LotteryPlayEnum lotteryPlayEnum = null;
            LotteryBettingEnum lotteryBettingEnum = null;
            if (LotteryBetNumEnum.BJL_ZHUANG.getCode().equals(betNum) || LotteryBetNumEnum.BJL_XIAN.getCode().equals(betNum) || LotteryBetNumEnum.BJL_HE.getCode().equals(betNum)) {
                lotteryPlayEnum = LotteryPlayEnum.BJL_ZHUANG_XIAN_HE;
                lotteryBettingEnum = LotteryBettingEnum.BJL_ZHUANG_XIAN;
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, betNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.PK10百家乐.{0},生成中奖记录:{1}", lotteryPlayEnum.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            } else if (LotteryBetNumEnum.BJL_DA.getCode().equals(betNum) || LotteryBetNumEnum.BJL_XIAO.getCode().equals(betNum)) {
                lotteryPlayEnum = LotteryPlayEnum.BJL_DA_XIAO;
                lotteryBettingEnum = LotteryBettingEnum.BJL_PAI_SHU;
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, betNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.PK10百家乐.{0},生成中奖记录:{1}", lotteryPlayEnum.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            } else if (LotteryBetNumEnum.BJL_ZHUANG_DUI.getCode().equals(betNum) || LotteryBetNumEnum.BJL_XIAN_DUI.getCode().equals(betNum)) {
                lotteryPlayEnum = LotteryPlayEnum.BJL_DUI_ZI;
                lotteryBettingEnum = LotteryBettingEnum.BJL_ZHUANG_XIAN_DUI;
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, betNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.PK10百家乐.{0},生成中奖记录:{1}", lotteryPlayEnum.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }

        return lotteryWinningRecordList;
    }

    private List<String> generateBjlNum(String[] openCodes){
        List<String> betNumList = new ArrayList<>();
        String daXiao = LotteryBetNumEnum.BJL_XIAO.getCode();
        String zhuangXianHe = "";

        //闲
        String[] xianWin = new String[5];
        System.arraycopy(openCodes, 0, xianWin, 0, 4);
        System.arraycopy(openCodes, 8, xianWin, 4, 1);
        List<String> xian = Arrays.asList(xianWin);
        List<String> xianList = new ArrayList<>(xian);
        int sum1 = 0;
        int xianDian = 0;
        int xianNum1 = (Integer.valueOf(xianList.get(0)) + Integer.valueOf(xianList.get(1)))%10;
        int xianNum2 = (Integer.valueOf(xianList.get(2)) + Integer.valueOf(xianList.get(3)))%10;
        if (xianNum1 == xianNum2) {
            betNumList.add(LotteryBetNumEnum.BJL_XIAN_DUI.getCode());
        }

        //庄
        String[] zhuangWin = new String[5];
        System.arraycopy(openCodes, 4, zhuangWin, 0, 4);
        System.arraycopy(openCodes, 9, zhuangWin, 4, 1);
        List<String> zhuang = Arrays.asList(zhuangWin);
        List<String> zhuangList = new ArrayList<>(zhuang);
        int sum2 = 0;
        int zhuangDian = 0;
        int zhuangNum1 = (Integer.valueOf(zhuangList.get(0)) + Integer.valueOf(zhuangList.get(1)))%10;
        int zhuangNum2 = (Integer.valueOf(zhuangList.get(2)) + Integer.valueOf(zhuangList.get(3)))%10;
        if (zhuangNum1 == zhuangNum2) {
            betNumList.add(LotteryBetNumEnum.BJL_ZHUANG_DUI.getCode());
        }

        sum1 = xianNum1 + xianNum2;
        xianDian = sum1%10;
        sum2 = zhuangNum1 + zhuangNum2;
        zhuangDian = sum2%10;

        if (!(zhuangDian == 8 || zhuangDian == 9) && xianDian <6) {
            sum1 += Integer.valueOf(xianList.get(4));
            daXiao = LotteryBetNumEnum.BJL_DA.getCode();
        }

        if (!(xianDian == 8 || xianDian == 9)) {
            if (xianDian == 6 || xianDian == 7) {
                if (zhuangDian < 6) {
                    sum2 += Integer.valueOf(zhuangList.get(4));
                    daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                }
            } else {
                int xianList5 = Integer.valueOf(xianList.get(4));
                xianList5 = xianList5%10;

                if (zhuangDian < 3) {
                    sum2 += Integer.valueOf(zhuangList.get(4));
                    daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                } else if (zhuangDian == 3) {
                    if (xianList5 != 8) {
                        sum2 += Integer.valueOf(zhuangList.get(4));
                        daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                    }
                } else if (zhuangDian == 4) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 8 || xianList5 == 9)) {
                        sum2 += Integer.valueOf(zhuangList.get(4));
                        daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                    }
                } else if (zhuangDian == 5) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 2 || xianList5 == 3 || xianList5 == 8 || xianList5 == 9)) {
                        sum2 += Integer.valueOf(zhuangList.get(4));
                        daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                    }
                } else if (zhuangDian == 6) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 2 || xianList5 == 3 || xianList5 == 4 || xianList5 == 5 || xianList5 == 8 || xianList5 == 9)) {
                        sum2 += Integer.valueOf(zhuangList.get(4));
                        daXiao = LotteryBetNumEnum.BJL_DA.getCode();
                    }
                }
            }
        }

        xianDian = sum1%10;
        zhuangDian = sum2%10;

        if (xianDian > zhuangDian) {
            zhuangXianHe =  LotteryBetNumEnum.BJL_XIAN.getCode();
        } else if (zhuangDian > xianDian) {
            zhuangXianHe =  LotteryBetNumEnum.BJL_ZHUANG.getCode();
        } else if (xianDian == zhuangDian) {
            zhuangXianHe =  LotteryBetNumEnum.BJL_HE.getCode();
        }

        if (StringTool.isNotEmpty(daXiao)) {
            betNumList.add(daXiao);
        }
        if (StringTool.isNotEmpty(zhuangXianHe)) {
            betNumList.add(zhuangXianHe);
        }
        return betNumList;
    }

}
