package so.wwb.lotterybox.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * 返回所有的排列组合结果
 * rambo
 */
public class CombinationTool {

    //elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
    public static List<List<String>> combiner(List<String> elements, int num,
                                              List<List<String>> result) {
        //当num为1时，即返回结果集
        if (num == 1) {
            return result;
        }
        //result的长度是变化的，故把原始值赋给变量leng
        int leng = result.size();
        //循环遍历，将 elements每两个元素放到一起，作为result中的一个元素
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (!result.get(i).contains(elements.get(j))) {
                    List<String> list1 = new ArrayList<String>();
                    for (int j2 = 0; j2 < result.get(i).size(); j2++) {
                        list1.add(result.get(i).get(j2));
                    }
                    list1.add(elements.get(j));
                    Collections.sort(list1);
                    result.add(list1);
                }
            }
        }
        //将result中的循环遍历前的数据删除
        for (int i = 0; i < leng; i++) {
            result.remove(0);
        }
        //对result进行去重
        Iterator<List<String>> it = result.iterator();
        List<List<String>> listTemp = new ArrayList<List<String>>();
        while (it.hasNext()) {
            List<String> a = it.next();
            if (listTemp.contains(a)) {
                it.remove();
            } else {
                listTemp.add(a);
            }
        }
        //递归计算，根据num的值来确定递归次数
        combiner(elements, num - 1, result);
        return result;
    }

    //elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
    public static List<List<String>> findsort(List<String> elements, int num) {
        List<List<String>> result = new ArrayList<List<String>>();
        //将elements中的数据取出来，存到新的list中，为后续计算做准备
        for (int i = 0; i < elements.size(); i++) {
            List<String> list = new ArrayList<String>();
            list.add(elements.get(i));
            result.add(list);
        }
        return combiner(elements, num, result);
    }
}