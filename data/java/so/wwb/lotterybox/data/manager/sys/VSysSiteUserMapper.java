package so.wwb.lotterybox.data.manager.sys;

import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteUser;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteUserSo;

import java.util.List;


/**
 * 用户站点表数据访问对象
 *
 * @author longer
 * @time Nov 17, 2015 2:22:29 PM
 */
//region your codes 1
public interface VSysSiteUserMapper extends IBaseQueryMapper<VSysSiteUser, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     *查询玩家某api下玩过的game
     *
     * @param so
     * @return
     */
    List<VSysSiteUser> queryMaster(VSysSiteUserSo so);

    //endregion your codes 2

}