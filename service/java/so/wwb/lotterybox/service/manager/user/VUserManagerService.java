package so.wwb.lotterybox.service.manager.user;

import org.soul.service.support.BaseService;
import so.wwb.lotterybox.data.manager.user.VUserManagerMapper;
import so.wwb.lotterybox.iservice.manager.user.IVUserManagerService;
import so.wwb.lotterybox.model.manager.user.po.VUserManager;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerListVo;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerVo;


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

    //endregion your codes 2

}