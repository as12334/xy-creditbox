package so.wwb.lotterybox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.site.po.SiteI18n;
import so.wwb.lotterybox.model.manager.site.vo.SiteI18nListVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteI18nVo;

import java.util.Map;


/**
 * 域名表服务接口
 *
 * @author tony
 * @time 2015-11-13 14:24:42
 */
public interface ISiteI18nService extends IBaseService<SiteI18nListVo, SiteI18nVo, SiteI18n, Integer> {

    Map<String, Map<String, SiteI18n>> load(SiteI18nVo siteI18nVo);

    int hideInsertI18n(SiteI18nListVo listVo);

    /**
     * 优惠活动分类-保存分类
     */
    SiteI18nListVo saveClassification(SiteI18nListVo listVo);

}