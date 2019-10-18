package so.wwb.lotterybox.data.manager.sys;

import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteManage;


/**
 * 数据访问对象
 *
 * @author jerry
 * @time 2017-4-6 22:23:42
 */
//region your codes 1
public interface VSysSiteManageMapper extends IBaseQueryMapper<VSysSiteManage, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 查询站点code是否唯一
     */
    Integer checkCodeUnique(SysSite sysSite);
    //endregion your codes 2

}