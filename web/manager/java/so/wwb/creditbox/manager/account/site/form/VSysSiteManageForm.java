package so.wwb.creditbox.manager.account.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.web.support.IForm;
import so.wwb.creditbox.manager.account.site.controller.VSysSiteManageController;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 表单验证对象
 *
 * @author jerry
 */
//region your codes 1
public class VSysSiteManageForm implements IForm {
//endregion your codes 1

    //region your codes 2


    /**
     * 站点名称
     */
    private String result_siteName;
    /**
     * 站点名称
     */
    private String result_id;

    /**
     * 站点名称
     */
    private String result_code;

    /**
     * 时区
     */
    private String result_timezone;
    /**
     * 主语言
     */
    private String result_mainLanguage;
    /**
     * 主货币
     */
    private String result_mainCurrency;

    private String result_templateCode;

    private String result_theme;

    private String result_title;

    @NotBlank(message = "站点名称不能为空")
    //@Depends(property = {"$currentPage"}, operator = {Operator.EQ}, value = {"1"}, message = "站点名称不能为空")
    @Length(min = 3, max = 30)
    public String getResult_siteName() {
        return result_siteName;
    }
    public void setResult_siteName(String result_siteName) {
        this.result_siteName = result_siteName;
    }

    @NotBlank(message = "时区不能为空")
    public String getResult_timezone() {
        return result_timezone;
    }

    public void setResult_timezone(String result_timezone) {
        this.result_timezone = result_timezone;
    }

    @NotBlank(message = "语言不能为空")
    //@Depends(property = {"$currentPage"}, operator = {Operator.EQ}, value = {"1"}, message = "主语言不能为空")
    public String getResult_mainLanguage() {
        return result_mainLanguage;
    }

    public void setResult_mainLanguage(String result_mainLanguage) {
        this.result_mainLanguage = result_mainLanguage;
    }

    @NotBlank(message = "主货币不能为空")
    @Depends(property = {"$currentPage"}, operator = {Operator.EQ}, value = {"1"}, message = "主货币不能为空")
    public String getResult_mainCurrency() {
        return result_mainCurrency;
    }

    public void setResult_mainCurrency(String result_mainCurrency) {
        this.result_mainCurrency = result_mainCurrency;
    }

//    @Length(min = 4, max = 4)
    @NotBlank(message = "站点代码不能为空")
    @Pattern(message = "请输入4个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.SITECODE)
    @Remote(message = "站点代码已存在",checkMethod = "checkSiteCode",checkClass = VSysSiteManageController.class,additionalProperties = "result.code")
    public String getResult_code() {
        return result_code;
    }
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }


    @NotBlank
    @Remote( message = "该站点ID已存在", checkClass = VSysSiteManageController.class, checkMethod = "checkSiteId", additionalProperties = {"result.id"})
    public String getResult_id() {
        return result_id;
    }
    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_templateCode() {
        return result_templateCode;
    }

    public void setResult_templateCode(String result_templateCode) {
        this.result_templateCode = result_templateCode;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_theme() {
        return result_theme;
    }

    public void setResult_theme(String result_theme) {
        this.result_theme = result_theme;
    }

    @NotBlank(message = "标题名称不能为空")
    @Length(max=25,message = "备注最大长度25字符")
    public String getResult_title() {
        return result_title;
    }

    public void setResult_title(String result_title) {
        this.result_title = result_title;
    }

    //endregion your codes 2

}