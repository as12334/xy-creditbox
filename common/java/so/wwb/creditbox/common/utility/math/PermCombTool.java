package so.wwb.creditbox.common.utility.math;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列组合工具类
 * Created by marz on 17-9-25.
 */
public class PermCombTool {

    public static final String SEPARATOR = ",";

    /**
     * 排列选择（从列表中选择n个排列）
     * @param dataList 待选列表 String[]类型
     * @param n 选择个数
     */
    public static List<String> permutationSelect(String[] dataList, int n) {
        return permutationSelect(dataList,n,SEPARATOR);
    }

    /**
     * 排列选择（从列表中选择n个排列） 
     * @param dataList 待选列表 String[]类型
     * @param n 选择个数
     * @param separator 分割符
     */
    public static List<String> permutationSelect(String[] dataList, int n,String separator) {
        List<String> resultList = new ArrayList<>();
        if(dataList != null && dataList.length != 0) {
            permutationSelect(resultList,dataList, new String[n], 0,separator);
        }
        return resultList;
    }

    /**
     * 排列选择（从列表中选择n个排列）
     * @param dataList 待选列表 List类型
     * @param n 选择个数
     */
    public static List<String> permutationSelect(List<String> dataList, int n) {
        return permutationSelect(dataList,n,SEPARATOR);
    }

    /**
     * 排列选择（从列表中选择n个排列）
     * @param dataList 待选列表 List类型
     * @param n 选择个数
     * @param separator 分割符
     */
    public static List<String> permutationSelect(List<String> dataList, int n, String separator) {
        if(CollectionTool.isNotEmpty(dataList)){
            return permutationSelect(dataList.toArray(new String[dataList.size()]),n,separator);
        }
        return new ArrayList<>();
    }

    /**
     * 排列选择
     * @param resultList 全部结果列表
     * @param dataList 待选列表
     * @param resultCode 前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始 
     */
    private static void permutationSelect(List<String> resultList, String[] dataList, String[] resultCode, int resultIndex,String separator) {
        int resultLen = resultCode.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            resultList.add(StringTool.join(separator,resultCode));
            return;
        }

        // 递归选择下一个  
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中  
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultCode[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择  
                resultCode[resultIndex] = dataList[i];
                permutationSelect(resultList,dataList, resultCode, resultIndex + 1,separator);
            }
        }
    }

    /**
     * 组合选择（从列表中选择n个组合） 
     * @param dataList 待选列表     String[]类型
     * @param n 选择个数 
     */
    public static List<String> combinationSelect(String[] dataList, int n) {
        return combinationSelect(dataList,n,SEPARATOR);
    }

    /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表     String[]类型
     * @param n 选择个数
     * @param separator 分割符
     */
    public static List<String> combinationSelect(String[] dataList, int n,String separator) {
        List<String> resultList = new ArrayList<>();
        if(dataList != null && dataList.length != 0){
            combinationSelect(resultList,dataList, 0, new String[n], 0,separator);
        }
        return resultList;
    }

    /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表     List类型
     * @param n 选择个数
     */
    public static List<String> combinationSelect(List<String> dataList, int n) {
        if(CollectionTool.isNotEmpty(dataList)){
            return combinationSelect(dataList.toArray(new String[dataList.size()]),n,SEPARATOR);
        }
        return new ArrayList<>();
    }

    /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表     List类型
     * @param n 选择个数
     * @param separator 分割符
     */
    public static List<String> combinationSelect(List<String> dataList, int n,String separator) {
        if(CollectionTool.isNotEmpty(dataList)){
            return combinationSelect(dataList.toArray(new String[dataList.size()]),n,separator);
        }
        return new ArrayList<>();
    }

    /**
     * 组合选择 
     * @param resultList 全部结果列表
     * @param dataList 待选列表
     * @param dataIndex 待选开始索引
     * @param resultCode 前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     * @param separator 分割符
     */
    private static void combinationSelect(List<String> resultList, String[] dataList, int dataIndex, String[] resultCode, int resultIndex,String separator) {
        int resultLen = resultCode.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            resultList.add(StringTool.join(separator,resultCode));
            return;
        }

        // 递归选择下一个  
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultCode[resultIndex] = dataList[i];
            combinationSelect(resultList,dataList, i + 1, resultCode, resultIndex + 1,separator);
        }
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1 
     * @param n
     * @return
     */
    public static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)! 
     * @param n
     * @param m
     * @return
     */
    public static long permutationCount(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!) 
     * @param n
     * @param m
     * @return
     */
    public static long combinationCount(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }


    public static void main(String[] args) {
        List<String> result = permutationSelect(new String[] {
                "2", "2", "3", "6"
        }, 2);
        System.out.println(result);
        result = combinationSelect(new String[] {
                "1", "2", "3", "4", "5"
        }, 3);
        System.out.println(result);
    }
}
