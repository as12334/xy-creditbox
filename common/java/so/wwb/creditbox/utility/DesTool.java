package so.wwb.creditbox.utility;

import com.alibaba.fastjson.JSONObject;
import org.soul.commons.security.CryptoTool;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ronnie on 18-5-28.
 */
public class DesTool {
    private final static String DES = "DES";

    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    /**
     *
     * @param password 密码
     * @param key 加密字符串
     * @return
     */
    public final static String encrypt(String password, String key) {
        try {
            return byte2String(encrypt(password.getBytes(), key.getBytes()));
        } catch (Exception e) {
        }
        return null;
    }

    public static String byte2String(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    public final static String decrypt(String data, String key) {
        try {
            return new String(decrypt(String2byte(data.getBytes()), key.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] String2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }


    public static void main(String[] args){

        Map<String, String> map = new LinkedHashMap<>();
        String username = "wjbno4gysb";
        map.put("username",username);
        //map.put("billNo","3109300133321096");
       // map.put("startDate","2018-11-07 08:50:00");
       // map.put("endDate","2018-11-07 08:57:00");
       // map.put("pageSize","100");
      //  map.put("pageNum","2");
       // map.put("distCode","21wjbn");
       // String password = "123123";
      //  map.put("password",password);
        map.put("money","10000");
       // map.put("code","hklhc");
        //map.put("pageSize","20");
        //map.put("pageNum","1");
        //EM1HCSERVRATODU 本地６
        //YVRWDMAOU97DVSR　测试201
        System.out.println(map.toString());
        String encryp = CryptoTool.encryptDES3(JSONObject.toJSON(map).toString(),"YVRWDMAOU97DVSR");
        Map<String,String> reqmap = new LinkedHashMap<>();
        reqmap.put("mode","1");
        reqmap.put("agent","0000");
        reqmap.put("merchant","LTG");
        reqmap.put("action","deposit");
        reqmap.put("params",encryp);

        System.out.println(encryp);
        String decrypt = CryptoTool.decryptDES3(encryp, "YVRWDMAOU97DVSR");
        System.out.println(decrypt);
       /* String pass="2096472A968F1089FB05C040B1250A80EB23BCCB1EC542DB";
        String key="boss@aaaa";*/

       // String randnum = RandomStringTool.randomNumeric(11);
        //String code = CommonContext.get().getSiteCode();
        // String str = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
       // String password = randnum.substring(0, 7);
        //m_hongtu@h111   3DRZKIPB5MVBXEIOPJ
        //42539505EA10A865C09863DEBF542F931040C695B3707C49
      //  System.out.println(randnum);
      //  System.out.println(password);
/*
        System.out.println(DesTool.encrypt(,key));
*/
       /* System.out.println(CryptoTool.aesEncrypt("111", "h111"));
        System.out.println(Integer.valueOf(CryptoTool.aesDecrypt("81c4a91325eebd30f2aee6bde58a3331", "ts01")));*/

/*
        String str = "SSSSSSSS";
        System.out.println(str.toLowerCase());*/

       /* System.out.println(CryptoTool.aesEncrypt(key,code));
        System.out.println(CryptoTool.aesDecrypt(CryptoTool.aesEncrypt(key,code), code));*/


       /* String siteCode = "deve";
        String merchantCode = "LTG";

        try {
            System.out.println(TokenTool.fmtKey(AesTool.encrypt(siteCode, merchantCode)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        String appKey = null;
        try {
            appKey = AesTool.encrypt(siteCode, merchantCode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        System.out.println((DigestTool.getMD5(appKey, merchantCode)));*/


    }



}
