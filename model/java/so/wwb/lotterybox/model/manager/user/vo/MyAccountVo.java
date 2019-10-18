package so.wwb.lotterybox.model.manager.user.vo;

import org.soul.commons.collections.CollectionQueryTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.msg.notice.po.NoticeContactWay;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.po.SysUserProtection;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.sys.po.SysAuditLog;
import so.wwb.lotterybox.model.enums.notice.ContactWayType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MyAccountVo extends SysUserVo {
    /*登录日志*/
    List<SysAuditLog> sysAuditLogs;
    /*登录日志记录数*/
    long countLogNumber;
    /*联系方式*/
    List<NoticeContactWay> noticeContactWays;
//    /*银行卡信息*/
//    UserBankcard userBankcard;
    /*安全问题*/
    SysUserProtection sysUserProtection;
    /**/
    /**/
    private NoticeContactWay qq;
    private NoticeContactWay msn;
    private NoticeContactWay email;
    private NoticeContactWay skype;
    private NoticeContactWay mobilePhone;
    /**
     * 是否时站长Id
     */
    private Integer isMasterId;
    /*字典*/
    private Map<String, Serializable> sexes;
    private Map<String, Serializable> constellations;
    private Map<String, Serializable> questions;

    public List<SysAuditLog> getSysAuditLogs() {
        return sysAuditLogs;
    }

    public void setSysAuditLogs(List<SysAuditLog> sysAuditLogs) {
        this.sysAuditLogs = sysAuditLogs;
    }

    public List<NoticeContactWay> getNoticeContactWays() {
        return noticeContactWays;
    }

    public void setNoticeContactWays(List<NoticeContactWay> noticeContactWays) {
        if(noticeContactWays != null && !noticeContactWays.isEmpty()) {

            List<NoticeContactWay> qqs = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.QQ.getCode()));
            this.qq = qqs.isEmpty() ? null:qqs.get(0);

            List<NoticeContactWay> msns = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.MSN.getCode()));
            this.msn= msns.isEmpty() ? null:msns.get(0);

            List<NoticeContactWay> emails = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.EMAIL.getCode()));
            this.email= emails.isEmpty() ? null:emails.get(0);

            List<NoticeContactWay> skypes = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.SKYPE.getCode()));
            this.skype= skypes.isEmpty() ? null:skypes.get(0);

            List<NoticeContactWay> mobilePhone = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.CELLPHONE.getCode()));
            this.mobilePhone= mobilePhone.isEmpty() ? null:mobilePhone.get(0);

        }

        this.noticeContactWays = noticeContactWays;
    }

    public Integer getIsMasterId() {
        return isMasterId;
    }

    public void setIsMasterId(Integer isMasterId) {
        this.isMasterId = isMasterId;
    }
//
//    public UserBankcard getUserBankcard() {
//        return userBankcard;
//    }
//
//    public void setUserBankcard(UserBankcard userBankcard) {
//        this.userBankcard = userBankcard;
//    }

    public SysUserProtection getSysUserProtection() {
        return sysUserProtection;
    }

    public void setSysUserProtection(SysUserProtection sysUserProtection) {
        this.sysUserProtection = sysUserProtection;
    }

    public NoticeContactWay getQq() {
        return qq;
    }

    public void setQq(NoticeContactWay qq) {
        this.qq = qq;
    }

    public NoticeContactWay getMsn() {
        return msn;
    }

    public void setMsn(NoticeContactWay msn) {
        this.msn = msn;
    }

    public NoticeContactWay getEmail() {
        return email;
    }

    public void setEmail(NoticeContactWay email) {
        this.email = email;
    }

    public NoticeContactWay getSkype() {
        return skype;
    }

    public void setSkype(NoticeContactWay skype) {
        this.skype = skype;
    }

    public NoticeContactWay getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(NoticeContactWay mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String[] _getSysUserUpdateProperties(){
        return new String[]{SysUser.PROP_CITY, SysUser.PROP_REAL_NAME, SysUser.PROP_SEX, SysUser.PROP_BIRTHDAY, SysUser.PROP_CONSTELLATION};
    }


    public Map<String, Serializable> getSexes() {
        return sexes;
    }

    public void setSexes(Map<String, Serializable> sexes) {
        this.sexes = sexes;
    }

    public Map<String, Serializable> getConstellations() {
        return constellations;
    }

    public void setConstellations(Map<String, Serializable> constellations) {
        this.constellations = constellations;
    }

    public Map<String, Serializable> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Serializable> questions) {
        this.questions = questions;
    }

    public long getCountLogNumber() {
        return countLogNumber;
    }

    public void setCountLogNumber(long countLogNumber) {
        this.countLogNumber = countLogNumber;
    }
}
