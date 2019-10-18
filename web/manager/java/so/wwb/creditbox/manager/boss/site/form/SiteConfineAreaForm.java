package so.wwb.creditbox.manager.boss.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.AtLeast;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;

import javax.validation.GroupSequence;


/**
 * 限制访问站点的地区表表单验证对象
 *
 * @author loong
 * @time 2015-8-11 11:17:30
 */
//region your codes 1
@GroupSequence({SiteConfineAreaForm.ValidArea.class,SiteConfineAreaForm.class})
public class SiteConfineAreaForm implements IForm {
//endregion your codes 1

    //region your codes 2
    /** 限制时间（1 永久限制；2 7天；3 15天；4 一个月；5 3个月；6 半年；7 1年；8自定义） */
    private String result_timeType;
    /** 截止时间 */
    private String result_endTime;
    /** 国家 */
    private String result_nation;
    /** 省/州 */
    private String result_province;
    /** 市 */
    private String result_city;
    /** 当前时间 */
    private String result_newDate;


    /**
     * 备注
     * @return
     */
    private String remark;
    @NotBlank
    public String getResult_timeType() {
        return result_timeType;
    }

    @NotBlank
    @Compare(message = "不能小于当前时间",logic = CompareLogic.GT,anotherProperty = "result_newDate")
    public String getResult_endTime() {
        return result_endTime;
    }


    @AtLeast(groups =ValidArea.class,message = "setting.siteConfine.valid.area")
    public String getResult_nation() {
        return result_nation;
    }
    @AtLeast(groups =ValidArea.class,message = "setting.siteConfine.valid.area")
    public String getResult_province() {
        return result_province;
    }
    @AtLeast(groups =ValidArea.class,message = "setting.siteConfine.valid.area")
    public String getResult_city() {
        return result_city;
    }
    @Length(min = 1,max = 200)
    public String getRemark() {
        return remark;
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

    public void setResult_nation(String result_nation) {
        this.result_nation = result_nation;
    }

    public void setResult_province(String result_province) {
        this.result_province = result_province;
    }

    public void setResult_city(String result_city) {
        this.result_city = result_city;
    }

    public void setResult_newDate(String result_newDate) {
        this.result_newDate = result_newDate;
    }

    interface ValidArea{

    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    //endregion your codes 2
}