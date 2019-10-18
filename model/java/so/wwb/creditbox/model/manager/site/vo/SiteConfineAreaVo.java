package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.sys.po.SysParam;
import so.wwb.creditbox.model.common.FieldSort;
import so.wwb.creditbox.model.manager.site.po.SiteConfineArea;
import so.wwb.creditbox.model.manager.site.po.SiteI18n;
import so.wwb.creditbox.model.manager.site.po.SiteLanguage;
import so.wwb.creditbox.model.manager.site.so.SiteConfineAreaSo;

import java.util.List;
import java.util.Map;


/**
 * 限制访问站点的地区表值对象
 *
 * @author loong
 * @time 2015-8-11 11:17:30
 */
//region your codes 1
public class SiteConfineAreaVo extends BaseObjectVo<SiteConfineArea, SiteConfineAreaSo, SiteConfineAreaVo.SiteConfineAreaQuery> {
    //endregion your codes 1
    //ip注册间隔时间限制
    private SysParam ipRegIntervalParam;
    //同一 IP 在 24 小时允许注册的最大次数
    private SysParam ipDayMaxRegNumParam;
    //注册地址
    private SysParam regAddressParam;
    //电话验证
    private SysParam phoneParam;
    //邮箱验证
    private SysParam mailParam;
    private List<FieldSort> fieldSortList;
    private Integer paramId;
    private String fieldSortStr;
    //服务条款的国际化
    private List<SiteI18n> siteI18nList;
    //服务条款的国际化 值
    private Map<String,SiteI18n> siteI18nMap;
    private List<SiteLanguage> siteLanguageList;
    //region your codes 5
    private static final long serialVersionUID = 1564211480737913741L;
    //是否是代理注册
    private String type;
    /**
     * 限制类型对应的时间
     */
    private List<String> dateList;
    /**
     * 地区---区分是访问限制--跟--站点管理的访问显示 的  新增或者编辑
     */
    private String editOrSaveType;
    //endregion your codes 5

    /**
     * 限制访问站点的地区表查询逻辑
     */
    public static class SiteConfineAreaQuery extends AbstractQuery<SiteConfineAreaSo> {

        //region your codes 6
        private static final long serialVersionUID = -1510278680318234294L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = new Criteria();
            criteria.addAnd(SiteConfineArea.PROP_NATION, Operator.EQ,searchObject.getNation())
                    .addAnd(SiteConfineArea.PROP_PROVINCE,Operator.EQ,searchObject.getProvince())
                    .addAnd(SiteConfineArea.PROP_CITY,Operator.EQ,searchObject.getCity());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    public SysParam getRegAddressParam() {
        return regAddressParam;
    }

    public void setRegAddressParam(SysParam regAddressParam) {
        this.regAddressParam = regAddressParam;
    }

    public SysParam getIpRegIntervalParam() {
        return ipRegIntervalParam;
    }

    public void setIpRegIntervalParam(SysParam ipRegIntervalParam) {
        this.ipRegIntervalParam = ipRegIntervalParam;
    }

    public SysParam getIpDayMaxRegNumParam() {
        return ipDayMaxRegNumParam;
    }

    public void setIpDayMaxRegNumParam(SysParam ipDayMaxRegNumParam) {
        this.ipDayMaxRegNumParam = ipDayMaxRegNumParam;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public List<FieldSort> getFieldSortList() {
        return fieldSortList;
    }

    public void setFieldSortList(List<FieldSort> fieldSortList) {
        this.fieldSortList = fieldSortList;
    }

    public SysParam getMailParam() {
        return mailParam;
    }

    public void setMailParam(SysParam mailParam) {
        this.mailParam = mailParam;
    }

    public SysParam getPhoneParam() {
        return phoneParam;
    }

    public void setPhoneParam(SysParam phoneParam) {
        this.phoneParam = phoneParam;
    }

    public String getFieldSortStr() {
        return fieldSortStr;
    }

    public void setFieldSortStr(String fieldSortStr) {
        this.fieldSortStr = fieldSortStr;
    }

    public List<SiteI18n> getSiteI18nList() {
        return siteI18nList;
    }

    public void setSiteI18nList(List<SiteI18n> siteI18nList) {
        this.siteI18nList = siteI18nList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<SiteLanguage> getSiteLanguageList() {
        return siteLanguageList;
    }

    public void setSiteLanguageList(List<SiteLanguage> siteLanguageList) {
        this.siteLanguageList = siteLanguageList;
    }

    public Map<String, SiteI18n> getSiteI18nMap() {
        return siteI18nMap;
    }

    public void setSiteI18nMap(Map<String, SiteI18n> siteI18nMap) {
        this.siteI18nMap = siteI18nMap;
    }

    public String getEditOrSaveType() {
        return editOrSaveType;
    }

    public void setEditOrSaveType(String editOrSaveType) {
        this.editOrSaveType = editOrSaveType;
    }
    //endregion your codes 4

}