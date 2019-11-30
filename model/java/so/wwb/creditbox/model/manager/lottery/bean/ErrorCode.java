package so.wwb.creditbox.model.manager.lottery.bean;

public class ErrorCode {

    public final String ERR_CODE = "code";

    /** 提交订單错误信息: 订單提交成功 */
    public final String CODE_100 = "100";
    public final String MSG_100 = "下注成功";

    /** 提交订單错误信息: 游戏余额不足 */
    public final String CODE_101 = "101";
    public final String MSG_101 = "下注失败：游戏余额不足";

    /** 提交订單错误信息: 请求参数异常（如json格式错误，未能获取提交注單数量等） */
    public final String CODE_102 = "102";
    public final String MSG_102 = "下注失败：请求参数异常";

    /** 提交订單错误信息: 投注期数已过期 */
    public final String CODE_103 = "103";
    public final String MSG_103 = "下注失败：下注期数已过期";

    /** 提交订單错误信息: 获取数据异常 */
    public final String CODE_104 = "104";
    public final String MSG_104 = "下注失败：获取数据异常";

    /** 提交订單错误信息: 超出單项限额 */
    public final String CODE_105 = "105";
    public final String MSG_105 = "下注失败：超出單项限额";

    /** 提交订單错误信息: 超出單注限额 */
    public final String CODE_106 = "106";
    public final String MSG_106 = "下注失败：超出單注限额";

    /** 提交订單错误信息: 超出單类别單项限额 */
    public final String CODE_107 = "107";
    public final String MSG_107 = "下注失败：超出單类别單项限额";

    /** 提交订單错误信息: 订單提交失败 */
    public final String CODE_109 = "109";
    public final String MSG_109 = "下注失败：服务忙！";

    /** 提交订單错误信息: 投注期数已过期 */
    public final String CODE_110 = "110";
    public final String MSG_110 = "下注失败：参数有误";


    public final String CODE_111 = "111";
    public final String MSG_DISABLE = "下注失败：彩票停售";

    /** 提交订單错误信息: 投注期数尚未开盘 */
    public final String CODE_112 = "112";
    public final String MSG_112 = "下注失败：尚未开盘";

    public final String CODE_113 = "113";
    public final String MSG_113 = "下注失败：非法下注";

    /** 黄色感叹号 */
    public final int ICON_0 = 0;
    /** 绿色勾（√） */
    public final int ICON_1 = 1;
    /** 红色叉（×） */
    public final int ICON_2 = 2;
    /** 黄色问号 */
    public final int ICON_3 = 3;
    /** 灰色锁 */
    public final int ICON_4 = 4;
    /** 红色哭脸 */
    public final int ICON_5 = 5;
    /** 绿色笑脸 */
    public final int ICON_6 = 6;

    public class Error {
        private String code;
        private String msg;
        private Integer icon;

        /** 通用成功（icon = 1) */
        public Error(String msg) {
            this.code = CODE_100;
            this.msg = msg;
            this.icon = ICON_1;
        }

        /** 通用失败（icon = 2） */
        public Error(String code, String msg) {
            this.code = code;
            this.msg = msg;
            this.icon = ICON_2;
        }

        public Error(String code, String msg, Integer icon) {
            this.code = code;
            this.msg = msg;
            this.icon = icon;
        }

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Integer getIcon() {
            return icon;
        }
        public void setIcon(Integer icon) {
            this.icon = icon;
        }

    }
}
