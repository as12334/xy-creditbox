package so.wwb.creditbox.iservice.manager.user;

import org.soul.iservice.support.IBaseService;
import org.soul.model.security.privilege.vo.SysRoleVo;
import so.wwb.creditbox.model.manager.sys.po.VSysRole;
import so.wwb.creditbox.model.manager.sys.vo.SysRoleListVo;
import so.wwb.creditbox.model.manager.user.po.VSubAccount;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountListVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;

import java.util.List;


/**
 * 子账户视图服务接口
 *
 * @author jeff
 * @time 2015-10-20 10:49:12  VSubAccountListVo, VSubAccountVo, VSubAccount
 */
//region your codes 1
public interface IVSubAccountService extends IBaseService<VSubAccountListVo,VSubAccountVo,VSubAccount,Integer> {
   //endregion your codes 1

    //region your codes 2

    /**
     * 新增编辑需要的数据
     * @param vSubAccountVo
     * @return
     */
    VSubAccountVo preCreateOrEdit(VSubAccountVo vSubAccountVo);


    List<VSysRole> getAllRolesBySubsysCode(SysRoleListVo sysRoleListVo);


    List<VSysRole> getUserRoleList(SysRoleListVo sysRoleListVo);

    boolean roleNameIsExist(SysRoleVo vo);
    //endregion your codes 2

}