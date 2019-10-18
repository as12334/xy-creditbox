package so.wwb.creditbox.context;

import org.soul.commons.init.context.ContextParam;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;

import java.util.Map;
import java.util.Set;

public class LotteryContextParam extends ContextParam {

    private static long lastFreshTime = System.currentTimeMillis();
    private long freshTime = 60000L;
    private final static String _Key_userMode="userMode";
    private final static String _Key_siteMode="siteMode";
    private final static String _Key_payUri="payUri";
    private final static String _Key_hallUri="hallUri";
    private final static String _Key_sysUser="sysUser";
    private final static String _Key_subSysCodeEnum="subSysCodeEnum";
    private final static String _Key_siteSubsysCode="siteSubsysCode";
    public final static String _Key_domainSubsysCode="domainSubsysCode";
    private final static String _Key_domain="domain";
    private final static String _Key_pcTheme="pcTheme";
    private final static String _Key_mobileTheme="mobileTheme";
    private final static String _Key_domainUserName="domainUserName";
    private final static String _Key_merchantName="ownerName";

    /**
     * 此域名的拥有者(总控、股东、商户)的账户代码
     */
    private final static String _Key_domainUserCode="domainUserCode";

    /**
     * 域名归属(商户|代理)主账号ID.
     */
    private final static String _Key_domainUserId="domainUserId";

    /**
     * 此站点的拥有者(总控、股东、商户)的账户的上级代码
     */
    private final static String _Key_siteUserOwnerCode="siteUserOwnerCode";

    /**
     * 此站点的拥有者(总控、股东、商户)的账户代码
     */
    private final static String _Key_siteUserCode="siteUserCode";
    private final static String _Key_domains="domains";

    private final static String _Key_siteName="siteName";

    public String getSiteName() {
        if(super.getExtendProperties().containsKey(_Key_siteName)) {
            return (String) super.getExtendProperties().get(_Key_siteName);
        }else{
            return null;
        }
    }
    public void setSiteName(String siteName) {
        super.getExtendProperties().put(_Key_siteName,siteName);
    }

    public Map<String, Map<String, Set<String>>> getDomains() {
        if(super.getExtendProperties().containsKey(_Key_domains)) {
            return (Map<String, Map<String, Set<String>>>) super.getExtendProperties().get(_Key_domains);
        }else{
            return null;
        }
    }
    public void setDomains(Map<String, Map<String, Set<String>>> domains) {
        super.getExtendProperties().put(_Key_domains,domains);
    }

    public String getSiteUserCode() {
        if(super.getExtendProperties().containsKey(_Key_siteUserCode)) {
            return (String) super.getExtendProperties().get(_Key_siteUserCode);
        }else{
            return null;
        }
    }
    public void setSiteUserCode(String siteUserCode) {
        super.getExtendProperties().put(_Key_siteUserCode,siteUserCode);
    }

    public String getSiteUserOwnerCode() {
        if(super.getExtendProperties().containsKey(_Key_siteUserOwnerCode)) {
            return (String) super.getExtendProperties().get(_Key_siteUserOwnerCode);
        }else{
            return null;
        }
    }
    public void setSiteUserOwnerCode(String siteUserOwnerCode) {
        super.getExtendProperties().put(_Key_siteUserOwnerCode,siteUserOwnerCode);
    }

    public String getMerchantName() {
        if(super.getExtendProperties().containsKey(_Key_merchantName)) {
            return (String) super.getExtendProperties().get(_Key_merchantName);
        }else{
            return null;
        }
    }
    public void setMerchantName(String merchantName) {
        super.getExtendProperties().put(_Key_merchantName, merchantName);
    }

    public Integer getDomainUserId() {
        if(super.getExtendProperties().containsKey(_Key_domainUserId)) {
            return (Integer) super.getExtendProperties().get(_Key_domainUserId);
        }else{
            return null;
        }
    }
    public void setDomainUserId(Integer domainUserId) {
        super.getExtendProperties().put(_Key_domainUserId,domainUserId);
    }

    public String getDomainUserName() {
        if(super.getExtendProperties().containsKey(_Key_domainUserName)) {
            return (String) super.getExtendProperties().get(_Key_domainUserName);
        }else{
            return null;
        }
    }
    public void setDomainUserName(String domainUserName) {
        super.getExtendProperties().put(_Key_domainUserName,domainUserName);
    }

    public String getDomainUserCode() {
        if(super.getExtendProperties().containsKey(_Key_domainUserCode)) {
            return (String) super.getExtendProperties().get(_Key_domainUserCode);
        }else{
            return null;
        }
    }
    public void setDomainUserCode(String domainUserCode) {
        super.getExtendProperties().put(_Key_domainUserCode,domainUserCode);
    }

    public String getPcTheme() {
        if(super.getExtendProperties().containsKey(_Key_pcTheme)) {
            return (String) super.getExtendProperties().get(_Key_pcTheme);
        }else{
            return null;
        }
    }
    public void setPcTheme(String pcTheme) {
        super.getExtendProperties().put(_Key_pcTheme,pcTheme);
    }

    public String getMobileTheme() {
        if(super.getExtendProperties().containsKey(_Key_mobileTheme)) {
            return (String) super.getExtendProperties().get(_Key_mobileTheme);
        }else{
            return null;
        }
    }
    public void setMobileTheme(String mobileTheme) {
        super.getExtendProperties().put(_Key_mobileTheme,mobileTheme);
    }

    public String getDomain() {
        if(super.getExtendProperties().containsKey(_Key_domain)) {
            return (String) super.getExtendProperties().get(_Key_domain);
        }else{
            return null;
        }
    }
    public void setDomain(String domain) {
        super.getExtendProperties().put(_Key_domain,domain);
    }

    public String getDomainSubsysCode() {
        if(super.getExtendProperties().containsKey(_Key_domainSubsysCode)) {
            return (String) super.getExtendProperties().get(_Key_domainSubsysCode);
        }else{
            return null;
        }
    }
    public void setDomainSubsysCode(String domainSubsysCode) {
        super.getExtendProperties().put(_Key_domainSubsysCode,domainSubsysCode);
    }

//    public String getDomainType() {
//        if(super.getExtendProperties().containsKey(_Key_domainType)) {
//            return (String) super.getExtendProperties().get(_Key_domainType);
//        }else{
//            return null;
//        }
//    }
//    public void setDomainType(String domainType) {
//        super.getExtendProperties().put(_Key_domainType,domainType);
//    }

    public String getSiteSubsysCode() {
        if(super.getExtendProperties().containsKey(_Key_siteSubsysCode)) {
            return (String) super.getExtendProperties().get(_Key_siteSubsysCode);
        }else{
            return null;
        }
    }
    public void setSiteSubsysCode(String siteSubsysCode) {
        super.getExtendProperties().put(_Key_siteSubsysCode,siteSubsysCode);
    }

//    public DomainTypeEnum getDomainTypeEnum() {
//        if(super.getExtendProperties().containsKey(_Key_domainTypeEnum)) {
//            return (DomainTypeEnum) super.getExtendProperties().get(_Key_domainTypeEnum);
//        }else{
//            return null;
//        }
//    }
//    public void setDomainTypeEnum(DomainTypeEnum domainTypeEnum) {
//        super.getExtendProperties().put(_Key_domainTypeEnum,domainTypeEnum);
//    }


    public SubSysCodeEnum getSubSysCodeEnum() {
        if(super.getExtendProperties().containsKey(_Key_subSysCodeEnum)) {
            return (SubSysCodeEnum) super.getExtendProperties().get(_Key_subSysCodeEnum);
        }else{
            return null;
        }
    }
    public void setSubSysCodeEnum(SubSysCodeEnum subSysCodeEnum) {
        super.getExtendProperties().put(_Key_subSysCodeEnum,subSysCodeEnum);
    }

    public SysUser getSysUser() {
        if(super.getExtendProperties().containsKey(_Key_sysUser)) {
            return (SysUser) super.getExtendProperties().get(_Key_sysUser);
        }else{
            return null;
        }
    }
    public void setSysUser(SysUser sysUser) {
        super.getExtendProperties().put(_Key_sysUser,sysUser);
    }

    public String getHallUri() {
        if(super.getExtendProperties().containsKey(_Key_hallUri)) {
            return (String) super.getExtendProperties().get(_Key_hallUri);
        }else{
            return null;
        }
    }
    public void setHallUri(String hallUri) {
        super.getExtendProperties().put(_Key_hallUri,hallUri);
    }

    public String getPayUri() {
        if(super.getExtendProperties().containsKey(_Key_payUri)) {
            return (String) super.getExtendProperties().get(_Key_payUri);
        }else{
            return null;
        }
    }
    public void setPayUri(String payUri) {
        super.getExtendProperties().put(_Key_payUri,payUri);
    }

//    public ModeEnum getSiteMode() {
//        if(super.getExtendProperties().containsKey(_Key_siteMode)) {
//            return (ModeEnum) super.getExtendProperties().get(_Key_siteMode);
//        }else{
//            return null;
//        }
//    }
//    public void setSiteMode(ModeEnum siteMode) {
//        super.getExtendProperties().put(_Key_siteMode,siteMode);
//    }
//
//    public ModeEnum getUserMode() {
//        if(super.getExtendProperties().containsKey(_Key_userMode)) {
//            return (ModeEnum) super.getExtendProperties().get(_Key_userMode);
//        }else{
//            return null;
//        }
//    }
//    public void setUserMode(ModeEnum userMode) {
//        super.getExtendProperties().put(_Key_userMode,userMode);
//    }

    @Override
    public Integer getVirtualSiteId() {
        if(SubSysCodeEnum.DISTRIBUTOR.getCode().equalsIgnoreCase(getSubsysCode())) {
            if(UserTypeEnum.DISTRIBUTOR_SUB.getCode().equalsIgnoreCase(getUserType()))
                this.setVirtualSiteId(getUserOwnerId());
            else
                this.setVirtualSiteId(getUserId());
        }
        return super.getVirtualSiteId();
    }
}
