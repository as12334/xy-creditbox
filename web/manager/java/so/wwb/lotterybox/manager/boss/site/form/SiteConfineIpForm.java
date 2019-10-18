package so.wwb.lotterybox.manager.boss.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.lotterybox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 限制/允许访问站点/管理中心的IP表表单验证对象
 *
 * @author loong
 * @time 2015-8-11 11:18:00
 */
//region your codes 1
public class SiteConfineIpForm implements IForm {
//endregion your codes 1

    //region your codes 2
    /**
     * 起始IP
     */
    private String result_startIpStr;
    /**
     * 结束IP
     */
    private String result_endIpStr;
    /**
     * 限制时间（1 永久限制；2 7天；3 15天；4 一个月；5 3个月；6 半年；7 1年；8自定义）
     */
    private String result_timeType;
    /**
     * 截止时间
     */
    private String result_endTime;
    /**
     * 类型（1限制访问站点；2允许访问站点；3允许访问管理中心）
     */
    private String type;
    /**
     * 备注
     **/
    private String result_remark;
    /** 当前时间 */
    private String result_newDate;

    private String result_id;

    @NotBlank
    @Pattern(regexp = RegexConst.IP)

    public String getResult_startIpStr() {
        return result_startIpStr;
    }

//    @Remote(message = "IP已存在", checkClass = SiteConfineIpController.class, checkMethod = "gameNameIsExist",additionalProperties = {"result_startIpStr", "result_id"})

    @Pattern(regexp = RegexConst.IP)
    public String getResult_endIpStr() {
        return result_endIpStr;
    }

    @NotBlank
    public String getResult_timeType() {
        return result_timeType;
    }

    @NotBlank
    @Compare(message = "不能小于当前时间",logic = CompareLogic.GT,anotherProperty = "result_newDate")
    public String getResult_endTime() {
        return result_endTime;
    }

    //@NotBlank
    public String getType() {
        return type;
    }

    @Length(min = 1,max = 200)
    public String getResult_remark() {
        return result_remark;
    }

    public String getResult_newDate() {
        return result_newDate;
    }

    public void setResult_timeType(String result_timeType) {
        this.result_timeType = result_timeType;
    }

    public void setResult_endTime(String result_endTime) {
        this.result_endTime = result_endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult_remark(String result_remark) {
        this.result_remark = result_remark;
    }

    public void setResult_startIpStr(String result_startIpStr) {
        this.result_startIpStr = result_startIpStr;
    }

    public void setResult_endIpStr(String result_endIpStr) {
        this.result_endIpStr = result_endIpStr;
    }

    public void setResult_newDate(String result_newDate) {
        this.result_newDate = result_newDate;
    }

    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }
    //endregion your codes 2

}