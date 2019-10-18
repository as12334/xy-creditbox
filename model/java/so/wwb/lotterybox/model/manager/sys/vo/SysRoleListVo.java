package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import org.soul.model.common.FieldProperty;
import org.soul.model.security.privilege.po.SysResource;
import so.wwb.lotterybox.model.manager.sys.po.SysRole;
import so.wwb.lotterybox.model.manager.sys.po.VSysRole;
import so.wwb.lotterybox.model.manager.sys.so.SysRoleSo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: tom
 * @date: 15-7-10
 */
public class SysRoleListVo extends BaseListVo<SysRole, SysRoleSo, SysRoleListVo.SysRoleQuery> {

    private static final long serialVersionUID = 4482558809911420928L;

    public Map<String, FieldProperty> getDefaultFields() {
        Map<String, FieldProperty> fieldPropertyMap = new HashMap<>();
        fieldPropertyMap.put(SysRole.PROP_NAME,new FieldProperty(SysRole.class, SysRole.PROP_NAME, 0, "SysRole.name", 0,true));
        // fieldPropertyMap.put(SysRole.PROP_CODE,new FieldProperty(SysRole.class, SysRole.PROP_CODE, 1, "SysRole.code", 1,true));
        fieldPropertyMap.put(SysRole.PROP_STATUS,new FieldProperty(SysRole.class, SysRole.PROP_STATUS, 2, "SysRole.status", 2,true));
        return fieldPropertyMap;
    }



    /**
     *  系统角色列表查询逻辑
     */
    public static class SysRoleQuery extends AbstractQuery<SysRoleSo> {

        private static final long serialVersionUID = -9223372036854775808L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add("builtIn", Operator.EQ,false);
            criteria.addAnd(new Criterion(SysRole.PROP_SITE_ID, Operator.EQ , this.searchObject.getSiteId()));
            if (StringTool.isNotEmpty(this.searchObject.getName())) {
                criteria.addAnd(new Criterion(SysRole.PROP_NAME, Operator.ILIKE, this.searchObject.getName()));
            }
            if(this.searchObject.getCreateUser() != null && this.searchObject.getCreateUser().intValue() > 0) {
                criteria.addAnd(SysRole.PROP_CREATE_USER, Operator.EQ, this.searchObject.getCreateUser());
            }
            return criteria;
        }

        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            return Sort.add(SysRole.PROP_CREATE_TIME, Direction.DESC);
        }

        //endregion your codes 3
    }

    //region your codes 4
    private List<SysResource> sysResources;

    private List<VSysRole> vSysRoles;

    //begin add by eagle
    private boolean readOnly;
    private Integer userId;
    //end add by eagle

    private List<Integer> roleIdList;

    public List<VSysRole> getvSysRoles() {
        return vSysRoles;
    }

    public void setvSysRoles(List<VSysRole> vSysRoles) {
        this.vSysRoles = vSysRoles;
    }

    public List<SysResource> getSysResources() {
        return sysResources;
    }

    public void setSysResources(List<SysResource> sysResources) {
        this.sysResources = sysResources;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }
//endregion your codes 4

}