package so.wwb.gamebox.tools.durid;

import com.alibaba.druid.filter.config.ConfigTools;
import org.soul.commons.security.DigestTool;

/**
 * Created by admin on 16-3-31.
 */
public class PasswordEncrypt {

    //用户安全密码
    private static String SALT_SYS_USER_PERMISSION_PWD = "bnQElt-?a:nCYg@!|>kt42HvjdEaZ_?f.CR`MGKqDrXozKnGFo%*f;{C,|F+H`9r";

    public static void main(String[] args) throws Exception {
//        String password = args[0];
        System.out.println("加密密码："+ConfigTools.encrypt("111111"));
        System.out.println("安全密码："+md5SysUserPermission("111111"));
    }


    public static String md5SysUserPermission(String source){
        return DigestTool.getMD5(source, SALT_SYS_USER_PERMISSION_PWD);
    }
}
