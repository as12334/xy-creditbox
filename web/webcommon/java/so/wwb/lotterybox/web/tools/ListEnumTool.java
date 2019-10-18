package so.wwb.lotterybox.web.tools;

import org.soul.commons.collections.CollectionTool;
import so.wwb.lotterybox.model.enums.base.IChildEnum;
import so.wwb.lotterybox.model.enums.base.IParentEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资金枚举工具类
 *
 * @author marz
 * @time 2018-01-23 09:49:14
 */
public class ListEnumTool {

    /**
     * 根据parentEnums获取childEnumList
     * @param parentEnums
     * @return
     */
    public static <P extends IParentEnum, C extends IChildEnum> List<C> getChildListByParents(Class<C> enumClass, P... parentEnums) {
        List<C> result = new ArrayList<>();
        C[] enums = (C[])enumClass.getEnumConstants();
        if(enums != null && enums.length > 0 && parentEnums != null && parentEnums.length > 0){
            for (int i = 0; i < parentEnums.length; ++i) {
                P parent = parentEnums[i];
                if(parent != null){
                    for(int j = 0; j < enums.length; ++j) {
                        C e = enums[j];
                        if(e != null && e.getParent().getCode().equals(parent.getCode())){
                            result.add(e);
                        }
                    }
                }
            }
        }
        return result;
    }


    public static <P extends IParentEnum, C extends IChildEnum> Map<String,String> getChildMapByParents(Class<C> enumClass, P... parentEnums) {
        Map<String,String> result = new HashMap<>();
        List<C> childList = getChildListByParents(enumClass,parentEnums);
        if(CollectionTool.isNotEmpty(childList)){
            for (IChildEnum childEnum : childList) {
                result.put(childEnum.getCode(),childEnum.getTrans());
            }
        }
        return result;
    }

}
