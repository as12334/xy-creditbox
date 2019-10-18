package so.wwb.creditbox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import org.soul.model.common.BaseVo;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.vo.SysDomainListVo;
import so.wwb.creditbox.model.manager.sys.vo.SysDomainVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainVo;


/**
 * 站长域名表-修改完会替换 sys_domain服务接口
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public interface ISysDomainService extends IBaseService<SysDomainListVo, SysDomainVo, SysDomain, Integer> {

    /**
     * 前台展示
     * @param sysDomainListVo
     * @return
     */
    SysDomainListVo setting(SysDomainListVo sysDomainListVo);

    /**
     * 把所有isDefault 全部置为false
     * @param sysDomainVo
     * @return
     */
    int batchUpdateStatusToFalse(SysDomainVo sysDomainVo);

    SysDomainVo batchSaveDomain(SysDomainVo sysDomainVo);

    String checkDomainExists(SysDomainVo sysDomainVo);

    /**
     * 编辑修改名称,是否是默认域名
     * @param sysDomainVo
     */
    void updateNameAndIsDefault(SysDomainVo sysDomainVo);
    /**
     * 添加代理域名
     */
    SysDomainVo saveAgentDomain(VSysDomainVo objectVo);


    BaseVo refreshSiteAvailableCache(Integer siteId, String cachePrefix, String status);

    boolean insertSysDomain(SysDomain sysDomain);

}