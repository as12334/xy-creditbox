package so.wwb.creditbox.data.manager.user;

import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import so.wwb.creditbox.model.company.user.po.VUserDetail;
import so.wwb.creditbox.model.manager.user.po.VUserManager;
import so.wwb.creditbox.model.manager.user.so.VUserManagerSo;

import java.util.List;


/**
 * 用户管理/详细视图 - Fei  jeremy数据访问对象
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public interface VUserManagerMapper extends IBaseQueryMapper<VUserManager, Integer> {
//endregion your codes 1

    //region your codes 2
    List<VUserDetail> searchLevelUser(VUserManagerSo search);

    //endregion your codes 2

}