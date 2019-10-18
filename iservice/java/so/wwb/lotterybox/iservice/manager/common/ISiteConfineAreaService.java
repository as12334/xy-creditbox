package so.wwb.lotterybox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineArea;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineAreaListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineAreaVo;

import java.util.List;
import java.util.Map;


/**
 * 限制访问站点的地区表服务接口
 *
 * @author loong
 * @time 2015-8-11 11:17:30
 */
public interface ISiteConfineAreaService extends IBaseService<SiteConfineAreaListVo, SiteConfineAreaVo, SiteConfineArea, Integer> {

    Map<String,Map<String, SiteConfineArea>> load(SiteConfineAreaVo siteConfineAreaVo);

    /**
     * 查询地区是否已在限制列表中
     */
    SiteConfineAreaVo isThereArea(SiteConfineAreaVo objectVo);

    List getDateList();

    SiteConfineAreaVo callInitSiteConfineArea(SiteConfineAreaVo vo);

}