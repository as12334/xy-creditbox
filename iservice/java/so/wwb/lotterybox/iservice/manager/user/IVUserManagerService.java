package so.wwb.lotterybox.iservice.manager.user;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.user.po.VUserManager;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerListVo;
import so.wwb.lotterybox.model.manager.user.vo.VUserManagerVo;


/**
 * 用户管理/详细视图 - Fei  jeremy服务接口
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public interface IVUserManagerService extends IBaseService<VUserManagerListVo, VUserManagerVo, VUserManager, Integer> {
//endregion your codes 1

    //region your codes 2
    VUserManagerVo searchLevelUser(VUserManagerVo objectVo);

    //endregion your codes 2

}