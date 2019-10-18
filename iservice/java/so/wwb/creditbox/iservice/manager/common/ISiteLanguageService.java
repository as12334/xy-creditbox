package so.wwb.creditbox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.site.po.SiteLanguage;
import so.wwb.creditbox.model.manager.site.vo.SiteLanguageListVo;
import so.wwb.creditbox.model.manager.site.vo.SiteLanguageVo;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;

import java.util.List;
import java.util.Map;


/**
 * 站点语言表服务接口
 *
 * @author tony
 * @time 2015-11-13 16:23:49
 */
public interface ISiteLanguageService extends IBaseService<SiteLanguageListVo, SiteLanguageVo, SiteLanguage, Integer> {

    Map<String,Map<String, SiteLanguage>> load(SiteLanguageVo vo);

    /**
     * 站长开通且支持的语言
     */
    List<SiteLanguage> availableLanguage(SiteLanguageListVo languageListVo);

    /**
     * 运营商下站长使用的语言
     */
    List<String> masterIsUse(SysSiteVo sysSiteVo);

}