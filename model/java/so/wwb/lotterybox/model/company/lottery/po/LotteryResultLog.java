package so.wwb.lotterybox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;

import java.util.Date;

public class LotteryResultLog implements IEntity<Integer> {

    private static final long serialVersionUID = 8437828949449436866L;

    public static final String PROP_ID = "id";
    public static final String PROP_CODE = "code";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_RESULT_NUM = "resultNum";
    public static final String PROP_CREATE_TIME = "createTime";

    /** 主键 */
    private Integer id;
    /** 彩种代号 */
    private String code;
    /** 期数 */
    private String expect;
    /** 开奖号码 */
    private String resultNum;
    /** 匹配最低金额 */
    private Date createTime;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer integer) {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getResultNum() {
        return resultNum;
    }

    public void setResultNum(String resultNum) {
        this.resultNum = resultNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
