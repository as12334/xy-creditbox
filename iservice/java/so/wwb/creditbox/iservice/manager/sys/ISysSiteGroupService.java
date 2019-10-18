package so.wwb.creditbox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.sys.po.SysSiteGroup;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteGroupListVo;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteGroupVo;

import java.util.List;


/**
 * 站点分组表服务接口
 *
 * @author steady
 * @time 2018-9-10 16:24:29
 */
public interface ISysSiteGroupService extends IBaseService<SysSiteGroupListVo, SysSiteGroupVo, SysSiteGroup, Integer> {

    SysSiteGroupVo getGroup(SysSiteGroupVo sysSiteGroupVo);

    SysSiteGroupVo getGroupByCode(SysSiteGroupVo groupVo);

    SysSiteGroupVo doUpdateGroup(SysSiteGroupVo sysSiteGroupVo);

    List<Integer> loadSite(String type);

}