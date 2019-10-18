package so.wwb.lotterybox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteManage;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteManageVo;


/**
 * 服务接口
 *
 * @author jerry
 * @time 2017-4-6 22:23:42
 */
//region your codes 1
public interface IVSysSiteManageService extends IBaseService<VSysSiteManageListVo, VSysSiteManageVo, VSysSiteManage, Integer> {
//endregion your codes 1

    //region your codes 2

    VSysSiteManageVo saveBuildSite(VSysSiteManageVo siteBasic);

    VSysSiteManageVo saveBuildSiteMch(VSysSiteManageVo siteBasic);

    //endregion your codes 2

}