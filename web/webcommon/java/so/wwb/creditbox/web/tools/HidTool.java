package so.wwb.creditbox.web.tools;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;


/**
 * 字符串操作工具类
 *
 * @author Kevice
 * @time 2013-4-8 下午9:23:31
 * @since 1.0.0
 */
public class HidTool {

    private static final Log LOG = LogFactory.getLog(org.soul.commons.lang.string.HidTool.class);

    public static final Integer FLAG = 8;
    private HidTool() {
    }

    public static String getBranchHid(String HID){
        return  getHid(HID,Integer.valueOf(UserTypeEnum.BRANCH.getCode()));
    }

    public static String getHid(String HID,Integer index){
        if(HID.length() < index * FLAG){
            return HID;
        }
        return getSubstring(HID,index);
    }

    /**
     * 获取上级的hid
     * @param HID 该用户的hid
     * @return
     */
    public static String getSuperHid(String HID){
        return HID.substring(0,HID.length() - FLAG);
    }

    public static String getSubstring(String HID,Integer index){
        return HID.substring(0,index * FLAG);
    }

}
