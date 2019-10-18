package so.wwb.creditbox.utility;

import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.creditbox.model.manager.lottery.po.BjlResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: steady
 * @function: 百家乐开奖结果格式工具
 */
public class BjlResultFormatTool {

    public static List<BjlResult> formatOpenCode(String openCode){
        String[] openCodes = StringTool.split(openCode, ",");
        List<BjlResult> results = new ArrayList<>(5);

        //闲
        BjlResult xianResult = new BjlResult();
        String[] xianWin = new String[5];
        System.arraycopy(openCodes, 0, xianWin, 0, 4);
        System.arraycopy(openCodes, 8, xianWin, 4, 1);
        List<String> xian = Arrays.asList(xianWin);
        List<String> xianList = new ArrayList<>(xian);
        int xianNum1 = Integer.valueOf(xianList.get(0)) + Integer.valueOf(xianList.get(1));
        int xianNum2 = Integer.valueOf(xianList.get(2)) + Integer.valueOf(xianList.get(3));

        //庄
        BjlResult zhuangResult = new BjlResult();
        String[] zhuangWin = new String[5];
        System.arraycopy(openCodes, 4, zhuangWin, 0, 4);
        System.arraycopy(openCodes, 9, zhuangWin, 4, 1);
        List<String> zhuang = Arrays.asList(zhuangWin);
        List<String> zhuangList = new ArrayList<>(zhuang);
        int zhuangNum1 = Integer.valueOf(zhuangList.get(0)) + Integer.valueOf(zhuangList.get(1));
        int zhuangNum2 = Integer.valueOf(zhuangList.get(2)) + Integer.valueOf(zhuangList.get(3));


        int xianDian = (xianNum1 + xianNum2)%10;
        int zhuangDian = (zhuangNum1 + zhuangNum2)%10;

        Integer xianNum3 = null;
        Integer zhuangNum3 = null;

        if (!(zhuangDian == 8 || zhuangDian == 9) && xianDian < 6) {
            xianNum3 = Integer.valueOf(xianList.get(4));
        }

        if (!(xianDian == 8 || xianDian == 9)) {
            if (xianDian == 6 || xianDian == 7) {
                if (zhuangDian < 6) {
                    zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                }
            } else {
                int xianList5 = Integer.valueOf(xianList.get(4));
                xianList5 = xianList5 % 10;
                if (zhuangDian < 3) {
                    zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                } else if (zhuangDian == 3) {
                    if (xianList5 != 8) {
                        zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                    }
                } else if (zhuangDian == 4) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 8 || xianList5 == 9)) {
                        zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                    }
                } else if (zhuangDian == 5) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 2 || xianList5 == 3 || xianList5 == 8 || xianList5 == 9)) {
                        zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                    }
                } else if (zhuangDian == 6) {
                    if (!(xianList5 == 0 || xianList5 == 1 || xianList5 == 2 || xianList5 == 3 || xianList5 == 4 || xianList5 == 5 || xianList5 == 8 || xianList5 == 9)) {
                        zhuangNum3 = Integer.valueOf(zhuangList.get(4));
                    }
                }
            }
        }

        String nums1 = xianNum1%10 + "," + xianNum2%10;
        if (xianNum3 != null) {
            nums1 += "," + xianNum3%10;
        }
        xianResult.setNums(nums1);
        xianResult.setBetNum(LotteryBetNumEnum.BJL_XIAN.getCode());

        String nums2 = zhuangNum1%10 + "," + zhuangNum2%10;
        if (zhuangNum3 != null) {
            nums2 += "," + zhuangNum3%10;
        }
        zhuangResult.setNums(nums2);
        zhuangResult.setBetNum(LotteryBetNumEnum.BJL_ZHUANG.getCode());

        results.add(zhuangResult);
        results.add(xianResult);
        return results;
    }
}