package so.wwb.creditbox.model.constants.common;

public interface RegexConst {
    /** 手机号码 */
    String CELL_PHONE = "^1(3[0-9]|4[579]|5[0-35-9]|7[0-9]|8[0-9])\\d{8}$";
    /** QQ号码 */
    String QQ = "^\\d{5,11}$";
    /** 手机或电话号码，1-20位数字 */
    String NUMBER_PHONE = "^\\d{1,20}$";
    /** url地址 */
    String URL = "^(https?|s?ftp):\\/\\/(((([A-Za-z]|\\d|-|\\.|_|~|" + "[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|" + "[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|"
            + "2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([A-Za-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|" + "(([A-Za-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*"
            + "([A-Za-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([A-Za-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|" + "(([A-Za-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*"
            + "([A-Za-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|"
            + "(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|"
            + "[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:"
            + "|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(#((([A-Za-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$";
    /** 电话或手机号 */
    String TEL_OR_CELL = "^0\\d{2,3}-?\\d{7,8}$|^(0\\d{2,3})-?(\\d{7,8})-?(\\d{1,4})$|^1(3[0-9]|4[57]|5[0-35-9]|7[0-9]|8[0-35-9])\\d{8}$";
    /** 姓名（汉字、英文和·） */
    String NAME = "^[a-z\\u4E00-\\u9FA5\\\\A-Z\\·]{2,30}$";
    /** 真实姓名 英文名：字母、空格、分隔圆点；中文名：中文、分隔圆点 不能纯数字 */
    String REALNAME = "(?!\\d+$)^[a-zA-Z0-9\\u4E00-\\u9FA5\\·]{2,30}$";
    /** 有些线上账号真实姓名有数字，所以加了这个正则 */
    String NAME_D = "^[a-z\\u4E00-\\u9FA5\\\\A-Z0-9]{2,30}$";
    /** 昵称（只能是大小写英文字母或数字） */
    String NICKNAME = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,15}$";
    /** 站点Ｃｏｄｅ（只能是大小写英文字母或数字） */
    String SITECODE = "^[a-zA-Z0-9]{4}$";
    /** 模板Ｃｏｄｅ（只能是大小写英文字母或数字） */
    String TEMPLATECODE = "^[a-zA-Z0-9]{2,32}$";
    /** 不包含特殊字符 */
    String SPECIAL = "^[^&*=|{}<>/\\…—]*$";
    /**  账号 */
    String ACCOUNT = "^[a-zA-Z0-9_]{4,16}$";
    /** 玩家账号 */
    String PLAYER_ACCOUNT ="^[a-zA-Z0-9_]{1,16}$";
    /** 邮箱 */
    String EMAIL = "^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
    /** 邮箱或手机号 */
    String MAIL_OR_CELL = "^([a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+)|(1(3[0-9]|5[0-35-9]|7[0-9]|8[0-35-9])\\d{8})$";
    /** 电话号码 */
    String TELPHONE = "^(((0\\d{2})[-](\\d{8})$)|(^(0\\d{3})[-](\\d{7,8})$)|(^(0\\d{2})[-](\\d{8})-(\\d+)$)|(^(0\\d{3})[-](\\d{7,8})-(\\d+)))$";
    /** 登录密码 */
    String LOGIN_PWD = "^[A-Za-z0-9~!@#$%^&*()_+=\\{\\}\\[\\]|\\:;'\"<>,./?]{6,16}$";
    /** 安全密码 */
    String SECURITY_PWD = "^[0-9]{6}$";
    /** 正整数 */
    String POSITIVE_INTEGER = "^[1-9]\\d*$";
    /** IPv4地址 */
    String IPV4 = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    /** IPv6 标准 */
    String IPV6_STD = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
    /** IPv6 十六进制压缩 */
    String IPV6_HEX = "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$";
    /** 字符重复 */
    String CHAR_REPEAT = "^(.)\\1+$";
    /** 纯数值 */
    String DIGIT = "^\\d+$";
    /** 纯字母 */
    String CHARACTOR = "^[a-zA-Z]+$";
    /** 纯小写字母 */
    String LOWCASECHARACTOR = "^[a-z]+$";
    /** 纯大写字母 */
    String LoCHARACTOR = "^[A-Z]{1,10}$";
    String NICK_NAME = "^[a-zA-Z0-9\\u4E00-\\u9FA5]{2,15}$";
    String ANSWER = "^(.){1,30}$";
    /** 修改为和邮箱相同的规则 */
    String MSN = EMAIL;
    /* 密码强度 */
    String PASSWORD_LEVEL_1 = "^[a-zA-Z]+$";
    String PASSWORD_LEVEL_2 = "^[0-9]+$";
    String PASSWORD_LEVEL_3 = "^[0-9a-zA-Z]+$";
    String PASSWORD_LEVEL_4 = "^[A-Za-z0-9~!@#$%^&*()_+\\\\{\\\\}\\\\[\\\\]|\\\\:;\\'\\\"<>,./?]+$";

    String CONCEDE_POINTS = "^(\\-?)((?:[0-9]{1,4})(?:\\.\\d{1,2})?)(\\/?|\\-?)((?:[0-9]{1,4}|0)(?:\\.\\d{1,2})?)?$";
    /** 正数 */
    String PLUS_QUANTITY = "^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$";

    String ALL_NUMBER = "^(-|\\+)?\\d+$";
    /** 銀行卡 */
    String BANK = "^[0-9]{10,25}$";
    /** 推荐码 */
    String REC_CODE = "^[a-zA-Z0-9]{8,15}$";
    /** 只能输入1-3位数字 */
    String NUMBER_NUM = "^[0-9]{1,3}$";
    /** 只能输入1-3位数字 */
    String SITEID = "^[0-9]{1,3}$";
    /** 只能输入1-15位数字 */
    String NUMBER_CON = "^[0-9]{1,15}$";
    /** 只能输入字符1-50位 */
    String NUMBER_ZIFU= "^(.){1,50}$";
    /** 只能输入字符1-16位 */
    String NUMBER_ZIFUS= "^(.){1,16}$";
    /** 只能输入字符1-300位 */
    String NUMBER_MS= "^(.){1,300}$";
    /** 只能输入字符1-16位字母 */
    String NUMBER_ZIMU= "^[a-zA-Z]{1,16}$";
    /** 只能输入字符1-100位 */
    String NUMBER_ZIFUSITE= "^(.){1,100}$";
    /** 只能输入数字，后面俩位小数 */
    String NUMBER_DECIMAL ="^[0-9]+([.]{1}[0-9]+){0,1}$";

    /** 含0和正整数 */
    String  ZERO_POSITIVE_INTEGER="^[0-9]\\d*$";
    /** 含0和正数 */
    String ZERO_POSITIVE="^[0-9].*$";
    /** 验证电话（验证只带数字和-） */
    String TEL = "^[0-9\\-]*$";
    /** 验证手机（验证只带数字） */
    String MOBILE = "^[0-9]*$";
    /** 验证正数，含小数 */
    String POSITIVE =  "^(?!0+(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,2})?$";
    /** 验证IP */
    String IP = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    /** 验证数字，只能是数字（0-9） */
    String DIGITS = "^[0-9]*$";
    String NUMBER = "^(-)?[1-9][0-9]*$";
    /** 中文或英文大小写 */
    String CNANDEN = "^[\\u4e00-\\u9fa5a-zA-Z]+$";
    /** 中文或英文大小写和数字 */
    String CNANDEN_NUMBER = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";

    /** 中文、字符或英文大小写 */
    String CNANDEN_CHAR = "^[!@#$^&*~%\\u4E00-\\u9FA5\\u0800-\\u4e00\\\\u9fa5a-zA-Z]+$";

    /** 验证金额 */
    String MONEY = "^(?!0+(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,2})?$";
    /** 验证新的金额*/
    String MONEY_NEW = "^(?!0+(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,3})?$";
    /** 验证链接地址http:/** 后面的部分 */
    String URL_LASTPART = "^(((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(#((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&\'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$";
    String EN_ONLY = "^.[A-Za-z]+$";

    /** 包含正数,0,小数 */
    String DECIMAL = "^(?!(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,2})?$";
    /** 包含正数,0,小数 ,可以输3位小数*/
    String DECIMAL_THREE = "^(?!(?:\\.0+)?$)(?:[1-9]\\d*|0)(?:\\.\\d{1,3})?$";

    String SKYPE = "^[a-zA-Z][a-zA-Z0-9]{5,31}$";
    /** 中文或英文大小写和数字或空格 */
    String CNANDEN_NUMBER_SAPCING = "^[0-9 a-zA-Z\u4e00-\u9fa5]+$";
    /** 英文数字或半角逗号 */
    String ENGLISH_NUMBER_COMMA="^[a-zA-Z0-9_\\,\\r\\n\\s+]+$";

    /** 玩家多账号半角逗号隔开 */
    String ACCOUNT_COMMA="^[a-zA-Z0-9_]*(\\,[a-zA-Z0-9_]*)*$";

    /** 生日 */
    String BIRTHDAY = "^\\d{1,4}.\\d{1,2}.\\d{1,2}$";

    String ENGLISH_NUMBER = "^[a-zA-Z1-9]+$";

    /** ｕrl链接验证含前缀验证或只验证域名 */
    String PREFIX_LINK = "^((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";

    /**彩种代号：大小写英文或数字*/
    String LOTTERY_TYPE_CODE = "^[a-zA-Z0-9]{3,15}$";
    /**彩种名称：大小写英文或数字*/
    String LOTTERY_TYPE_NAME = "^[0-9a-zA-Z\\u4e00-\\u9fa5]{3,15}$";


    //TODO 新增支付JAR 相关正则，暂时简單验证，待完善规则 by jeremy 2018年05月16日11:26:08
    /**API简称  2-20位英文大小写字母、数字、下划线*/
    String JAR_CHANNEL_CODE = "^[a-zA-Z0-9_\u4e00-\u9fa5()]{2,20}$";
    /**API全称  2-16位英文大小写字母、数字、下划线*/
    String JAR_REMARKS = "^[a-zA-Z0-9_\u4e00-\u9fa5()]{2,16}$";
    /**版本号*/
    String JAR_VERSION = "^[a-zA-Z0-9_\\.]{2,16}$";
    /**API地址*/
    String JAR_URL = "^[a-zA-Z0-9:_\\-\\.\\/]{2,}.jar$";
    /**API_Class  6位以上英文大小写字母、圆点、下划线*/
    String JAR_CLASS = "^[a-zA-Z_0-9\\.]{6,}$";

    /**json*/
    String JSON = "^\\{.*?\\}$";
    /**可以输入负数，二位小数*/
    String NUM = "^([\\+ \\-]?(([1-9]\\d*)|(0)))([.]\\d{0,2})?$";

}
