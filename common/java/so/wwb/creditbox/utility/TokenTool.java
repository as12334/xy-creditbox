package so.wwb.creditbox.utility;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.security.AesTool;
import org.soul.commons.security.DigestTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;

import java.util.UUID;

public class TokenTool {

    private static final Log LOG = LogFactory.getLog(TokenTool.class);

    public static LotteryContextParam getContext() {
        return LotteryCommonContext.get();
    }

    public static final String SEPARATOR = CacheKey.CACHE_KEY_SEPERATOR;

    /** token有效期(秒) */
    public static final Integer EXPIRE = 30 * 60;
    /** 一天秒数 */
    public static final Integer ONE_DAY = 24 * 60 * 60;
    /** 刷新token的有效期(秒) */
    public static final Integer REFRESH_EXPIRE = 15 * ONE_DAY;

    public static String createToken(Integer userId, String distCode) {
        if (userId != null) {
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replaceAll("-", "");
            return getMerchantCode() + SEPARATOR + distCode + SEPARATOR + userId + SEPARATOR + uuid;
        }
        else {
            LOG.error("生成api token的userId为空");
            return null;
        }
    }

    public static String getMerchantCode() {
        return getContext().getSiteUserCode();
    }

    //商户号3位:总代号4位
    public static String getCacheKey() {
        return getContext().getSiteUserOwnerCode() + CacheKey.CACHE_KEY_SEPERATOR + getMerchantCode();
    }
//
//    /**
//     * 创建 APP TOKEN
//     * 规则 - 商户号:序列号:账号:UUID
//     */
//    public static String createAppToken(OauthToken token) {
//        if (StringTool.isBlank(getMerchantCode())) {
//            LOG.error("缺少生成APP TOKEN的商户号");
//        } else if (StringTool.isBlank(token.getUsername())) {
//            LOG.error("缺少生成APP TOKEN的账号");
//        } else if (StringTool.isBlank(token.getSerialNo())) {
//            LOG.error("缺少生成APP TOKEN的序列号");
//        } else {
//            String merCode = getMerchantCode();
//            String serialNo = token.getSerialNo();
//            String username = token.getUsername();
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//
//            return merCode + SEPARATOR + serialNo + SEPARATOR + username + SEPARATOR + uuid;
//        }
//        return null;
//    }

//    /**
//     * 设备序列号加密
//     * @param token serialNo 序列号（未加密）, username 玩家账号
//     */
//    public static String encryptSerialNo(OauthToken token) {
//        return DigestTool.getMD5(token.getSerialNo(), token.getUsername());
//    }

    /**
     * 设备序列号加密
     * @param serialNo 序列号（未加密）, username 玩家账号
     */
    public static String encryptSerialNo(String serialNo, String username) {
        return DigestTool.getMD5(serialNo, username);
    }

    public static void main(String[] args) {
        try {
            String code = "LTG";   // 商户号
            String siteCode = "deve"; // 站点CODE

            String appKey = AesTool.encrypt(siteCode, code);
            System.out.println(fmtKey(appKey));

            String secret = DigestTool.getMD5(appKey, code);
            System.out.println(secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String fmtKey(String appKey) {
        if (StringTool.isNotBlank(appKey)) {
            appKey = appKey.replaceAll("/", "").replaceAll("\\+", "");
            appKey = StringTool.right(appKey, 16);
        }
        return appKey;
    }

}