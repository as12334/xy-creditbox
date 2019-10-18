package so.wwb.creditbox.service.manager.user;

import org.soul.commons.collections.ListTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.data.mapper.msg.notice.NoticeContactWayMapper;
import org.soul.data.mapper.security.privilege.SysRoleMapper;
import org.soul.data.mapper.security.privilege.SysUserMapper;
import org.soul.data.mapper.security.privilege.SysUserProtectionMapper;
import org.soul.data.mapper.security.privilege.SysUserRoleMapper;
import org.soul.model.msg.notice.po.NoticeContactWay;
import org.soul.model.security.privilege.po.SysRole;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.po.SysUserRole;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.security.privilege.vo.SysRoleVo;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.data.manager.permission.VSysRoleMapper;
import so.wwb.creditbox.data.manager.user.VSubAccountMapper;
import so.wwb.creditbox.iservice.manager.user.IVSubAccountService;
import so.wwb.creditbox.model.enums.notice.ContactWayType;
import so.wwb.creditbox.model.manager.sys.po.VSysRole;
import so.wwb.creditbox.model.manager.sys.vo.SysRoleListVo;
import so.wwb.creditbox.model.manager.user.po.VSubAccount;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountListVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;

import java.util.Date;
import java.util.List;


/**
 * 子账户视图服务
 *
 * @author jeff
 * @time 2015-10-20 10:49:13
 */
//region your codes 1
public class VSubAccountService extends BaseService<VSubAccountMapper, VSubAccountListVo, VSubAccountVo, VSubAccount, Integer> implements IVSubAccountService {
//endregion your codes 1

    //region your codes 2
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private NoticeContactWayMapper noticeContactWayMapper;
    @Autowired
    private SysUserProtectionMapper sysUserProtectionMapper;
    @Autowired
    private VSysRoleMapper vSysRoleMapper;


    @Override
    public VSubAccountVo get(VSubAccountVo objectVo) {
        Integer userId = objectVo.getSearch().getId();
        String subSysCode = objectVo.getSearch().getSubSysCode();
        objectVo = super.get(objectVo);
        SysUser sysUser = sysUserMapper.get(userId);
        objectVo.setSysUser(sysUser);

        /*联系方式*/
        List list = noticeContactWayMapper.search(Criteria.add(NoticeContactWay.PROP_USER_ID, Operator.EQ, userId));
        objectVo.setNoticeContactWays(list);

        /*安全问题*/
        objectVo.setSysUserProtection(sysUserProtectionMapper.get(userId));
        return preCreateOrEdit(objectVo);
    }

    @Override
    public VSubAccountVo update(VSubAccountVo objectVo) {
        preInsertOrUpdate(objectVo,true);
        SysUser sysUser = objectVo.getSysUser();
        if(StringTool.isNotBlank(sysUser.getPassword())){
            sysUser.setLoginErrorTimes(0);
            sysUser.setFreezeEndTime(new Date());
            sysUser.setPassword(AuthTool.md5SysUserPassword(sysUser.getPassword(), sysUser.getUsername()));
        }
        if(StringTool.isNotBlank(sysUser.getPermissionPwd())){
            sysUser.setSecpwdErrorTimes(0);
            sysUser.setSecpwdFreezeEndTime(new Date());
            sysUser.setPermissionPwd(AuthTool.md5SysUserPermission(sysUser.getPermissionPwd(), sysUser.getUsername()));
        }
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateUser(objectVo._getUserId());
        sysUserMapper.updateOnly(sysUser, objectVo.getUpdateProperties());
        return objectVo;
    }

    @Override
    public VSubAccountVo insert(VSubAccountVo objectVo) {
        objectVo.getSysUser().setId(objectVo.getSearch().getId());

        SysUser sysUser= objectVo.getSysUser();
        /*是否内置 false*/
        sysUser.setBuiltIn(false);
        /*创建人*/
        SysUser currentUser = objectVo.getCurrentLoginUser();
        sysUser.setSiteId(objectVo._getSiteId());
        sysUser.setCity(currentUser.getCity());
        sysUser.setCountry(currentUser.getCountry());
        sysUser.setCreateUser(currentUser.getId());
        sysUser.setRegion(currentUser.getRegion());
        sysUser.setDefaultLocale(currentUser.getDefaultLocale());
        sysUser.setDefaultCurrency(currentUser.getDefaultCurrency());
        sysUser.setDefaultTimezone(currentUser.getDefaultTimezone());
        if(StringTool.isNotBlank(sysUser.getPassword())){
            sysUser.setPassword(AuthTool.md5SysUserPassword(sysUser.getPassword(), sysUser.getUsername()));
        }
        if(StringTool.isNotBlank(sysUser.getPermissionPwd())){
            sysUser.setPermissionPwd(AuthTool.md5SysUserPermission(sysUser.getPermissionPwd(), sysUser.getUsername()));
        }
        sysUserMapper.insert(sysUser);
        objectVo = preInsertOrUpdate(objectVo,false);
        return objectVo;
    }

    public VSubAccountVo preInsertOrUpdate(VSubAccountVo vSubAccountVo,Boolean isUpdate){
        SysUser sysUser = vSubAccountVo.getSysUser();
        Integer userId = sysUser.getId();
        /*密码加密*/
        sysUser.setCreateTime(new Date());
        /*编辑时删除当前用户的 密保问题 联系方式 角色关系表 信息*/
        if(isUpdate){
//          sysUserProtectionMapper.delete(userId); 删除已有的安全问题
            Criteria userIdEQ = Criteria.add(NoticeContactWay.PROP_USER_ID, Operator.EQ,userId);
            Criteria contactTypeIn = Criteria.add(NoticeContactWay.PROP_CONTACT_TYPE, Operator.IN, ListTool.newArrayList(ContactWayType.EMAIL.getCode(),ContactWayType.CELLPHONE.getCode()));
            noticeContactWayMapper.batchDeleteCriteria(Criteria.and(userIdEQ,contactTypeIn));
            sysUserRoleMapper.batchDeleteCriteria(Criteria.add(SysUserRole.PROP_USER_ID, Operator.EQ,userId));
        }
        /*联系方式*/
        noticeContactWayMapper.batchInsert(vSubAccountVo.getInsertNoticeContactWay());

        /*用户角色关联*/
        sysUserRoleMapper.batchInsert(vSubAccountVo.getCurrentRole());

/*      安全问题
        vSubAccountVo.getSysUserProtection().setCreateTime(new Date());
        vSubAccountVo.getSysUserProtection().setTotalValidateCount(1);
        vSubAccountVo.getSysUserProtection().setMatchCount(1);
        if(!StringTool.isEmpty(vSubAccountVo.getSysUserProtection().getAnswer1())){
            vSubAccountVo.getSysUserProtection().setId(userId);
            sysUserProtectionMapper.insert(vSubAccountVo.getSysUserProtection());
        }
*/
        vSubAccountVo.setSysUser(sysUser);
        return  vSubAccountVo;
    }

    @Override
    public VSubAccountVo preCreateOrEdit(VSubAccountVo vSubAccountVo) {
        String subSysCode = vSubAccountVo.getSearch().getSubSysCode();
        /*角色*/
        Criteria criteria = Criteria.add(SysRole.PROP_SUBSYS_CODE, Operator.EQ, subSysCode);
        criteria = criteria.addAnd(Criteria.add(SysRole.PROP_STATUS, Operator.EQ, Integer.valueOf(SysUserStatus.NORMAL.getCode())));
        criteria.addAnd(SysRole.PROP_SITE_ID, Operator.EQ, vSubAccountVo.getSearch().getSiteId());
        List<SysRole> sysRoleList = sysRoleMapper.search(criteria);
        vSubAccountVo.setSysRoles(sysRoleList);

        return vSubAccountVo;
    }

    @Override
    public List<VSysRole> getAllRolesBySubsysCode(SysRoleListVo sysRoleListVo) {
        Criteria criteria = Criteria.add(VSysRole.PROP_SUBSYS_CODE, Operator.EQ,sysRoleListVo.getSearch().getSubsysCode());
        criteria.addOr(Criteria.add(VSysRole.PROP_BUILT_IN, Operator.EQ,true), Criteria.add(VSysRole.PROP_SITE_ID, Operator.EQ, sysRoleListVo.getSearch().getSiteId()));
        List<VSysRole> vSysRoles = vSysRoleMapper.search(criteria, Order.desc(VSysRole.PROP_ID));
        return vSysRoles;
    }

    @Override
    public List<VSysRole> getUserRoleList(SysRoleListVo sysRoleListVo) {
        List<VSysRole> vSysRoles = vSysRoleMapper.search(Criteria.add(VSysRole.PROP_ID, Operator.IN,sysRoleListVo.getRoleIdList()));
        return vSysRoles;
    }

    @Override
    public boolean roleNameIsExist(SysRoleVo vo) {
        Integer result = this.mapper.roleNameIsExist(vo.getSearch());
        return (result == null ? 0 : result) > 0;
    }
    //endregion your codes 2

}