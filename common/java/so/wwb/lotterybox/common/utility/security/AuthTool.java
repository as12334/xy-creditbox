package so.wwb.lotterybox.common.utility.security;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.security.CryptoTool;
import org.soul.commons.security.DigestTool;

import java.util.Arrays;

public class AuthTool {

    //用户密码
    private static String SALT_SYS_USERNAME_PWD = "?tJ163hN+v-0xyFwO3iU4R8QDVuG_Ujnhs9qAX?~VqTto^E^?98KLM#6V##mTd6K";

    //用户安全密码
    private static String SALT_SYS_USER_PERMISSION_PWD = "SANbx4SvphTxD^r!Fuu&**??3Mmv4+nAS_!PDR99LO0lREjgLabqTJNiZyg~*OCN";

    /**
     * 用户密码
     * @param source
     * @param username
     * @return
     */
    public static String md5SysUserPassword(String source,String username){
        String rs = source;
        String salt = sysUserPwdSalt(StringTool.lowerCase(username));
        for(int i = 0; i < 11; i++) {
            rs = DigestTool.getMD5(rs, salt);
        }
        return rs;
    }

    private static String sysUserPwdSalt(String username){
        if (StringTool.isNotBlank(username)) {
            return SALT_SYS_USERNAME_PWD + username;
        }
        return SALT_SYS_USERNAME_PWD;
    }

    /**
     * 安全密码
     * @param source
     * @param username
     * @return
     */
    public static String md5SysUserPermission(String source, String username){
        String salt = sysUserPermissionSalt(StringTool.lowerCase(username));
        return DigestTool.getMD5(source, salt);
    }

    private static String sysUserPermissionSalt(String username){
        if (StringTool.isNotBlank(username)) {
            return SALT_SYS_USERNAME_PWD + username;
        }
        return SALT_SYS_USER_PERMISSION_PWD;
    }

    public static void main(String[] args) {

        String[] names = {"boss@aaaa", "b_eleven@aaaa", "b_panda@aaaa"};
        String password = "123123";

        Arrays.stream(names).forEach(s -> {
            System.out.println(md5SysUserPassword(password, s));
//            System.out.println(md5SysUserPermission(password, s));
//            System.out.println(s + "---> 登陆密码：\t" + md5SysUserPassword(password, s));
//            System.out.println(s + "---> 安全密码：\t" + md5SysUserPermission(password, s));
        });

        try {
            System.out.println(CryptoTool.aesEncrypt("6", "deve"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
