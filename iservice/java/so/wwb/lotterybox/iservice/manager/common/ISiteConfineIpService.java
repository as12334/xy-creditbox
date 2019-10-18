package so.wwb.lotterybox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineIp;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineIpListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineIpVo;

import java.util.Map;


/**
 * 限制/允许访问站点/管理中心的IP表服务接口
 *
 * @author tony
 * @time 2015-11-13 16:25:18
 */
public interface ISiteConfineIpService extends IBaseService<SiteConfineIpListVo, SiteConfineIpVo, SiteConfineIp, Integer> {

    Map<String,Map<String, SiteConfineIp>> load(SiteConfineIpVo siteConfineIpVo);

    int ipContains(SiteConfineIpVo objectVo);

}