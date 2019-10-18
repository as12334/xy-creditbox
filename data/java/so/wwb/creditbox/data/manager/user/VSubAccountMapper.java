package so.wwb.creditbox.data.manager.user;

import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import org.soul.model.security.privilege.so.SysRoleSo;
import so.wwb.creditbox.model.manager.user.po.VSubAccount;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountListVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;

import java.util.List;
import java.util.Map;


/**
 * 子账户视图数据访问对象
 *
 * @author jeff
 * @time 2015-10-20 10:49:12
 */
//region your codes 1
public interface VSubAccountMapper extends IBaseQueryMapper<VSubAccount, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 根据subsystem_code获取角色
     * @param vSubAccountListVo
     * @return
     */
    List<Map<String,Object>> getRoles(VSubAccountListVo vSubAccountListVo);

    /**
     * 插入数据如果不存在
     * @param params
     * @return
     */
    int insertRoleNotExist(Map<String, Object> params);

    /**
     * 改变状态 根据ids
     * @param vSubAccountVo
     * @return
     */
    int changeStatusByIds(VSubAccountVo vSubAccountVo);

    Integer roleNameIsExist(SysRoleSo so);
    //endregion your codes 2

}