package so.wwb.lotterybox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteDomainListVo;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteDomainVo;

import java.util.List;
import java.util.Map;


/**
 * 域名与站点信息服务接口
 *
 * @author longer
 * @time Sep 9, 2015 5:25:38 PM
 */
//region your codes 1
public interface IVSysSiteDomainService extends IBaseService<VSysSiteDomainListVo, VSysSiteDomainVo, VSysSiteDomain, Integer> {
//endregion your codes 1

    //region your codes 2
    /**
     * 有效的,未被删除的域名
     * @param listVo
     * @return
     */
    List<VSysSiteDomain> availables(VSysSiteDomainListVo listVo);

    /**
     * 缓存加载
     * @param sysSiteDomainVo
     * @return
     */
    Map<String,VSysSiteDomain> load(VSysSiteDomainVo sysSiteDomainVo);

    /**
     * 缓存加载
     * @param sysSiteDomainVo
     * @return <domain,site_id>
     */
    Map<String,Integer> loadDomain(VSysSiteDomainVo sysSiteDomainVo);


    List<VSysSiteDomain> getSiteDomainByDomain(VSysSiteDomainVo sysSiteDomainVo);

    VSysSiteDomainListVo queryMerchantDomain(VSysSiteDomainListVo listVo);

    /**
     * 根据站点获取UserID
     * @param siteId
     * @return
     */
    List<VSysSiteDomain> querySiteDomainUserId(Integer siteId);

    //endregion your codes 2
    List<VSysSiteDomain> loadSiteDomain(VSysSiteDomainListVo sysSiteDomainVo);

}