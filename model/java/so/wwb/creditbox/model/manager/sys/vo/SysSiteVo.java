package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.msg.notice.vo.NoticeEmailInterfaceVo;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.creditbox.model.manager.site.po.SiteI18n;
import so.wwb.creditbox.model.manager.site.po.SiteLanguage;
import so.wwb.creditbox.model.manager.site.po.SiteOperateArea;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.so.SysSiteSo;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 站长站点表值对象
 *
 * Created by tom using soul-code-generator on 2015-7-21 17:37:50
 */
//region your codes 1
public class SysSiteVo extends BaseObjectVo<SysSite, SysSiteSo, SysSiteVo.SysSiteQuery> {
    private static final long serialVersionUID = 756316507022091648L;
    //log地址
//    private CttLogo cttLogo;
    private List<SiteOperateArea> siteOperateAreaList;
    private List<SiteLanguage> siteLanguageList;
    private Map<String, SiteI18n> siteI18nMap;
    Long year;
    Long month;
    Long Day;
    //用户类型，跟sys_user一致
    private String userType;
    // 站长名称
    private String username;
    // 操作用户
    private SysUser sysUser;
    // 备注
//    private Remark remark;
    //邮件接口
    private NoticeEmailInterfaceVo emailInterfaceVo;
    //加载模块
    private String index;

    private Date publishTime;

    private String announcementType;
    private String announcementSubType;

    private boolean hasReturn;

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    //endregion your codes 1


    /**
     *  站长站点表查询逻辑
     */
    public static class SysSiteQuery extends AbstractQuery<SysSiteSo> {

        private static final long serialVersionUID = 4095177184363520512L;

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SysSite.PROP_SSO_THEME, Operator.EQ,searchObject.getSsoTheme());
            criteria.addAnd(SysSite.PROP_SYS_USER_ID,Operator.EQ,searchObject.getSysUserId());
            criteria.addAnd(SysSite.PROP_ID,Operator.EQ,searchObject.getId());
            criteria.addAnd(SysSite.PROP_THEME,Operator.EQ,searchObject.getTheme());
            criteria.addAnd(SysSite.PROP_TEMPLATE_CODE,Operator.EQ,searchObject.getTheme());
            return criteria;
            //endregion your codes 2
        }

        public Criteria getCheckCode(){
            Criteria criteria = Criteria.add(SysSite.PROP_CODE, Operator.EQ, searchObject.getCode());
            return criteria;
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

//    public CttLogo getCttLogo() {
//        return cttLogo;
//    }
//
//    public void setCttLogo(CttLogo cttLogo) {
//        this.cttLogo = cttLogo;
//    }

    public List<SiteOperateArea> getSiteOperateAreaList() {
        return siteOperateAreaList;
    }

    public void setSiteOperateAreaList(List<SiteOperateArea> siteOperateAreaList) {
        this.siteOperateAreaList = siteOperateAreaList;
    }

    public List<SiteLanguage> getSiteLanguageList() {
        return siteLanguageList;
    }

    public void setSiteLanguageList(List<SiteLanguage> siteLanguageList) {
        this.siteLanguageList = siteLanguageList;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getDay() {
        return Day;
    }

    public void setDay(Long day) {
        Day = day;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, SiteI18n> getSiteI18nMap() {
        return siteI18nMap;
    }

    public void setSiteI18nMap(Map<String, SiteI18n> siteI18nMap) {
        this.siteI18nMap = siteI18nMap;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

//    public Remark getRemark() {
//        return remark;
//    }
//
//    public void setRemark(Remark remark) {
//        this.remark = remark;
//    }

    public NoticeEmailInterfaceVo getEmailInterfaceVo() {
        return emailInterfaceVo;
    }

    public void setEmailInterfaceVo(NoticeEmailInterfaceVo emailInterfaceVo) {
        this.emailInterfaceVo = emailInterfaceVo;
    }

    public String getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }

    public String getAnnouncementSubType() {
        return announcementSubType;
    }

    public void setAnnouncementSubType(String announcementSubType) {
        this.announcementSubType = announcementSubType;
    }

    public boolean isHasReturn() {
        return hasReturn;
    }

    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    //endregion your codes 4

}