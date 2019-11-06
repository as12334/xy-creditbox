package so.wwb.creditbox.data.company.user;

import so.wwb.creditbox.model.company.user.po.VSiteUser;
import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.so.SysUserExtendSo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import java.util.List;


/**
 * 数据访问对象
 *
 * @author block
 * @time 2019-10-29 20:12:42
 */
//region your codes 1
public interface VSiteUserMapper extends IBaseQueryMapper<VSiteUser, Integer> {
//endregion your codes 1

    //region your codes 2
    List<VSiteUser> searchLevelUser(VSiteUserSo search);

    void doInitUserLotteryOdd(SysUserExtend user);
    void doInitUserLotteryRebate(SysUserExtend user);

    Integer sumSuperStintOccupy(SysUserExtendSo search);

    Integer sumSuperStintOccupyCount(SysUserExtendSo search);
    //endregion your codes 2

}