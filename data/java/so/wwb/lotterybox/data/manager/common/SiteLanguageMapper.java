package so.wwb.lotterybox.data.manager.common;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.site.po.SiteLanguage;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;

import java.util.List;


/**
 * 站点语言表数据访问对象
 *
 * @author tony
 * @time 2015-11-13 16:23:49
 */
//region your codes 1
public interface SiteLanguageMapper extends IBaseMapper<SiteLanguage, Integer> {
//endregion your codes 1

    //region your codes 2
    List<SiteLanguage> queryLanguage(SysSiteVo sysSiteVo);

    /**
     * 运营商下站长使用的语言
     * @return
     */
    List<String> masterIsUse(Integer siteId);
    //endregion your codes 2

}