package so.wwb.lotterybox.utility;

import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.lottery.CombinationTool;
import so.wwb.lotterybox.model.manager.lottery.po.NnResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: rambo
 * @function: 牛牛开奖结果格式工具
 */
public class NnResultFormatTool {
    /**
     * 生成牛牛Winnum
     * @return List
     */
    public static List<NnResult> formatOpenCode(String openCode){
        String[] openCodes = StringTool.split(openCode, ",");
        List<NnResult> results = new ArrayList<>(5);
        //庄
        NnResult zhuangResult = new NnResult();
        String[] zhuangWin = new String[5];
        System.arraycopy(openCodes, 0, zhuangWin, 0, 5);
        List<String> zhuang = Arrays.asList(zhuangWin);
        List<String> zhuangList = new ArrayList<>(zhuang);
        int zhuangNnm = getScroe(zhuangList);
        zhuangResult.setPlayName(getNiuBetNum (zhuangNnm));
        zhuangResult.setNums(StringTool.join(zhuang,","));
        zhuangResult.setWinOrLose(null);
        results.add(zhuangResult);
        //闲
        for (int i = 1; i <= 5; i++) {
            NnResult result = new NnResult();
            String[] winNum = new String[5];
            System.arraycopy(openCodes, i, winNum, 0, 5);
            List<String> xian = Arrays.asList(winNum);
            List<String> xianList = new ArrayList<>(xian);
            int xianResult = getScroe(xianList);
            result.setNums(StringTool.join(xian,","));
            result.setPlayName(getNiuBetNum (xianResult));
            if (xianResult == zhuangNnm) {
                if (xianResult > 6) {
                    if (Integer.valueOf(xian.get(0)) < Integer.valueOf(zhuang.get(0))) {
                        result.setWinOrLose("lose");
                    } else {
                        result.setWinOrLose("win");
                    }
                } else {
                    result.setWinOrLose("lose");
                }
            } else if (xianResult > zhuangNnm) {
                result.setWinOrLose("win");
            } else if (xianResult < zhuangNnm) {
                result.setWinOrLose("lose");
            }
            results.add(result);
        }
        return results;
    }

    public static String getNiuBetNum (int result) {
        String betNum = "";
        switch (result) {
            case -1: betNum = "无牛"; break;
            case 1: betNum = "牛一"; break;
            case 2: betNum = "牛二"; break;
            case 3: betNum = "牛三"; break;
            case 4: betNum = "牛四"; break;
            case 5: betNum = "牛五"; break;
            case 6: betNum = "牛六"; break;
            case 7: betNum = "牛七"; break;
            case 8: betNum = "牛八"; break;
            case 9: betNum = "牛九"; break;
            default: betNum = "牛牛"; break;
        }
        return betNum;
    }

    public static int getScroe (List<String> betNum) {
        int score = -1;
        List<List<String>> list = CombinationTool.findsort(betNum,3);
        for (List<String> nums : list) {
            int sum1 = 0;
            int sum2 = 0;
            for (String num : nums) {
                sum1 += Integer.valueOf(num);
            }
            List<String> list1 = new ArrayList<>(betNum);
            if (sum1 % 10 == 0) {
                List<String> nums1 = new ArrayList<>(nums);
                list1.removeAll(nums1);
                for (String num : list1) {
                    sum2 += Integer.valueOf(num);
                }
                int  total = sum2 % 10;
                if (total == 0) {
                    score = Integer.MAX_VALUE;
                    return score;
                } else {
                    score = total;
                    return score;
                }
            }
        }
        return score;
    }
}