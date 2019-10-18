package so.wwb.lotterybox.data.manager.common;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;

import java.util.List;


/**
 * 经营地区表数据访问对象
 *
 * @author tony
 * @time 2015-11-13 16:24:12
 */
//region your codes 1
public interface SiteOperateAreaMapper extends IBaseMapper<SiteOperateArea, Integer> {
//endregion your codes 1

    //region your codes 2
    List<SiteOperateArea> queryArea(Integer siteId);
    //endregion your codes 2

}