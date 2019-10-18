package so.wwb.creditbox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteUserVo;

import java.util.List;
import java.util.Map;

public interface IVSysSiteUserService extends IBaseService<VSysSiteUserListVo, VSysSiteUserVo, VSysSiteUser, Integer> {

    Map<String,VSysSiteUser> load(VSysSiteUserVo vSysSiteUserVo);

    VSysSiteUserListVo queryCenters(VSysSiteUserListVo var1);

    VSysSiteUser queryCenter(VSysSiteUserVo var1);

    List<VSysSiteUser> queryMerchantsBySiteId(Integer id);

}