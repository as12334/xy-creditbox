package so.wwb.creditbox.iservice.company.user;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 服务接口
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public interface IVSiteUserService extends IBaseService<VSiteUserListVo, VSiteUserVo, VSiteUser, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 查询成数使用情况
     * @param objectVo
     * @return
     */
    VSiteUserVo sumSuperStintOccupy(VSiteUserVo objectVo);

    SysUserExtendVo saveManagerUser(SysUserExtendVo objectVo);


    String getHid(String Thid);

    VSiteUserVo searchSuperUser(VSiteUserVo objectVo);


    /**
     * 查询所有下级的管理用户
     * @param objectVo
     * @return
     */
    Map<String, List<SysUserExtend>> searchAllManagerList(VSiteUserVo objectVo);

    VSiteUserListVo searchList(VSiteUserListVo listVo);


//    SysUserExtendVo sumSuperStintOccupy(SysUserExtendVo objectVo);
//
//    SysUserExtendVo sumSuperStintOccupyCount(SysUserExtendVo vo);

    //endregion your codes 2

}