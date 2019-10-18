package so.wwb.creditbox.model.manager.user.vo;

import org.soul.commons.bean.Pair;
import org.soul.commons.collections.CollectionQueryTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.ListTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.msg.notice.po.NoticeContactWay;
import org.soul.model.security.privilege.po.*;
import so.wwb.creditbox.model.enums.notice.ContactWayStatus;
import so.wwb.creditbox.model.enums.notice.ContactWayType;
import so.wwb.creditbox.model.manager.user.po.VSubAccount;
import so.wwb.creditbox.model.manager.user.so.VSubAccountSo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 子账户视图值对象
 *
 * @author jeff
 * @time 2015-10-20 10:49:13
 */
//region your codes 1
public class VSubAccountVo extends BaseObjectVo<VSubAccount, VSubAccountSo, VSubAccountVo.VSubAccountQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -3936305418266315583L;
    private SysUser sysUser;

    /*角色*/
    private List<SysRole> sysRoles;
    /*联系方式*/
    private List<NoticeContactWay> noticeContactWays;

    /*安全问题*/
    private SysUserProtection sysUserProtection;

    private String confirmPassword;

    private String confirmPermissionPwd;

    /*安全问题字典*/
    private Map<String, Serializable> questions;


    private NoticeContactWay email;
    private NoticeContactWay mobilePhone;

    private List<SysUserRole> sysUserRoles;

    private List<Integer> roleIds;

    private String subSysCode;

    /*修改密码的类别*/
    private String changePassword;

    private SysUser currentLoginUser;
    private Map<String, Serializable> sex;
    private static final  String CHANGE_TYPE_PERMISSIONPWD = "_permissionPwd";
    private static final  String CHANGE_TYPE_PASSWORD = "_password";

    //endregion your codes 5

    /**
     *  子账户视图查询逻辑
     */
    public static class VSubAccountQuery extends AbstractQuery<VSubAccountSo> {

        //region your codes 6
        private static final long serialVersionUID = 4305840398264771602L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<NoticeContactWay> getNoticeContactWays() {
        return noticeContactWays;
    }

    public void setNoticeContactWays(List<NoticeContactWay> noticeContactWays) {
        if(!noticeContactWays.isEmpty()){
            List<NoticeContactWay> emails = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ,ContactWayType.EMAIL.getCode()));
            if(!emails.isEmpty()){
                this.email = emails.get(0);
            }
//            this.email = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ,ContactWayType.EMAIL.getCode())).get(0);
            List<NoticeContactWay> mobilePhones = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ,ContactWayType.CELLPHONE.getCode()));
            if(!mobilePhones.isEmpty()){
                this.mobilePhone = mobilePhones.get(0);
            }
//            this.mobilePhone = CollectionQueryTool.query(noticeContactWays, Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ,ContactWayType.CELLPHONE.getCode())).get(0);
        }
        this.noticeContactWays = noticeContactWays;
    }

    public SysUserProtection getSysUserProtection() {
//        this.sysUserProtection.setId(getSysUser().getId());
        return sysUserProtection;
    }

    public void setSysUserProtection(SysUserProtection sysUserProtection) {
        this.sysUserProtection = sysUserProtection;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPermissionPwd() {
        return confirmPermissionPwd;
    }

    public void setConfirmPermissionPwd(String confirmPermissionPwd) {
        this.confirmPermissionPwd = confirmPermissionPwd;
    }

    public NoticeContactWay getEmail() {
        if(email != null){
            email.setContactType(ContactWayType.EMAIL.getCode());
        }
        return email;
    }

    public void setEmail(NoticeContactWay email) {
        this.email = email;
    }

    public NoticeContactWay getMobilePhone() {
        if(mobilePhone != null){
            mobilePhone.setContactType(ContactWayType.CELLPHONE.getCode());
        }
        return mobilePhone;
    }

    public void setMobilePhone(NoticeContactWay mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Map<String, Serializable> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Serializable> questions) {
        this.questions = questions;
    }

    public List<SysUserRole> getSysUserRoles() {
        return sysUserRoles;
    }

    public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    public List<NoticeContactWay> getInsertNoticeContactWay(){
        List<NoticeContactWay> noticeContactWays = ListTool.newArrayList(this.email,this.mobilePhone);
        /*设置user_id 状态*/
        Map<String,Object> params = MapTool.newHashMap(new Pair<String, Object>(NoticeContactWay.PROP_USER_ID, getSysUser().getId()), new Pair<String, Object>(NoticeContactWay.PROP_STATUS, ContactWayStatus.INACTIVE.getCode()));
        CollectionTool.batchUpdate(noticeContactWays, params);
        return noticeContactWays;
    }
    public List<SysUserRole> getCurrentRole(){
        Integer userId = getSysUser().getId();
        List<SysUserRole> sysUserRoles = new ArrayList(this.roleIds.size());
        for (int i=0;i<this.roleIds.size();i++){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleIds.get(i));
            sysUserRole.setUserId(userId);
            sysUserRoles.add(sysUserRole);
        }
        return sysUserRoles;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getSubSysCode() {
        return subSysCode;
    }

    public void setSubSysCode(String subSysCode) {
        this.subSysCode = subSysCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(String changePassword) {
        this.changePassword = changePassword;
    }

    public SysUser getCurrentLoginUser() {
        return currentLoginUser;
    }

    public void setCurrentLoginUser(SysUser currentLoginUser) {
        this.currentLoginUser = currentLoginUser;
    }

    public Map<String, Serializable> getSex() {
        return sex;
    }
    public List<String> getUserStatus() {
        return ListTool.newArrayList(SysUserStatus.NORMAL.getCode(), SysUserStatus.DISABLED.getCode());
    }
    public void setSex(Map<String, Serializable> sex) {
        this.sex = sex;
    }

    public String[] getUpdateProperties(){
        String[] properties = {
                SysUser.PROP_NICKNAME,
                SysUser.PROP_MEMO,
                SysUser.PROP_SEX,
                SysUser.PROP_UPDATE_TIME,
                SysUser.PROP_UPDATE_USER,
                SysUser.PROP_STATUS
        };
        if(CHANGE_TYPE_PASSWORD.equals(changePassword)){
            properties = ArrayTool.add(properties, SysUser.PROP_PASSWORD);
            properties = ArrayTool.add(properties, SysUser.PROP_LOGIN_ERROR_TIMES);
            properties = ArrayTool.add(properties, SysUser.PROP_FREEZE_END_TIME);
        }else if(CHANGE_TYPE_PERMISSIONPWD.equals(changePassword)){
            properties = ArrayTool.add(properties, SysUser.PROP_PERMISSION_PWD);
            properties = ArrayTool.add(properties, SysUser.PROP_SECPWD_ERROR_TIMES);
            properties = ArrayTool.add(properties, SysUser.PROP_SECPWD_FREEZE_END_TIME);
        }
        return properties;
    }
    //endregion your codes 4

}