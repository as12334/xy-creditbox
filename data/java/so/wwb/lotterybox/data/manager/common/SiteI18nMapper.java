package so.wwb.lotterybox.data.manager.common;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.site.po.SiteI18n;
import so.wwb.lotterybox.model.manager.site.vo.SiteI18nListVo;

import java.util.List;


/**
 * 域名表数据访问对象
 *
 * @author tony
 * @time 2015-11-13 14:24:42
 */
//region your codes 1
public interface SiteI18nMapper extends IBaseMapper<SiteI18n, Integer> {
//endregion your codes 1

    //region your codes 2
    int hideInsertI18n(SiteI18nListVo vPayAccountListVo);

    /**
     * 通过站点名称找出siteId
     * @param name
     * @return
     */
    List<Integer> getNameBySiteId(String name);


    //endregion your codes 2

}