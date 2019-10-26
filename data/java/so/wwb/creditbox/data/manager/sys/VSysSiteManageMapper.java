package so.wwb.creditbox.data.manager.sys;

import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import org.soul.model.security.privilege.so.SysResourceSo;
import so.wwb.creditbox.model.manager.sys.po.Nav;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageVo;

import java.util.List;


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
    void doInitSiteData(VSysSiteManage result);

    List<Nav> getAllMenus(SysResourceSo search);


    //endregion your codes 2

}