package so.wwb.lotterybox.data.manager.common;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineIp;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineIpVo;


/**
 * 限制/允许访问站点/管理中心的IP表数据访问对象
 *
 * @author tony
 * @time 2015-11-13 16:25:18
 */
//region your codes 1
public interface SiteConfineIpMapper extends IBaseMapper<SiteConfineIp, Integer> {
//endregion your codes 1

    //region your codes 2
    /**
     * 判断该IP段是否已存在
     * @param siteConfineIpVo
     * @return
     */
    int ipContains(SiteConfineIpVo siteConfineIpVo);
    //endregion your codes 2

}