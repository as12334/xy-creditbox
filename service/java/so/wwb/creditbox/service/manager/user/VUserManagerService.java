package so.wwb.creditbox.service.manager.user;

import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.user.VUserManagerMapper;
import so.wwb.creditbox.iservice.manager.user.IVUserManagerService;
import so.wwb.creditbox.model.manager.sys.po.Nav;
import so.wwb.creditbox.model.manager.user.po.VUserManager;
import so.wwb.creditbox.model.manager.user.vo.VUserManagerListVo;
import so.wwb.creditbox.model.manager.user.vo.VUserManagerVo;

import java.util.List;


/**
 * 用户管理/详细视图 - Fei  jeremy服务
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public class VUserManagerService extends BaseService<VUserManagerMapper, VUserManagerListVo, VUserManagerVo, VUserManager, Integer> implements IVUserManagerService {
//endregion your codes 1

    //region your codes 2
    @Override
    public VUserManagerVo searchLevelUser(VUserManagerVo objectVo) {
        objectVo.setSuperUserList(mapper.searchLevelUser(objectVo.getSearch()));
        return objectVo;
    }
    @Override
    public List<Nav> getAllMenus(SysResourceVo o) {
        return mapper.getAllMenus(o.getSearch());
    }
    //endregion your codes 2

}