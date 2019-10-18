package so.wwb.lotterybox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;
import so.wwb.lotterybox.model.manager.site.vo.SiteOperateAreaListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteOperateAreaVo;

import java.util.Map;


/**
 * 经营地区表服务接口
 *
 * @author tony
 * @time 2015-11-13 16:24:12
 */
public interface ISiteOperateAreaService extends IBaseService<SiteOperateAreaListVo, SiteOperateAreaVo, SiteOperateArea, Integer> {

    Map<String,Map<String, SiteOperateArea>> load(SiteOperateAreaVo siteOperateAreaVo);

}