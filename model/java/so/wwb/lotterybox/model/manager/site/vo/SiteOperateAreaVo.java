package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;
import so.wwb.lotterybox.model.manager.site.so.SiteOperateAreaSo;

/**
 * 经营地区表值对象
 *
 * @author tony
 * @time 2015-11-13 16:24:12
 */
//region your codes 1
public class SiteOperateAreaVo extends BaseObjectVo<SiteOperateArea, SiteOperateAreaSo, SiteOperateAreaVo.SiteOperateAreaQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 677336588763536411L;
    //endregion your codes 5

    /**
     *  经营地区表查询逻辑
     */
    public static class SiteOperateAreaQuery extends AbstractQuery<SiteOperateAreaSo> {

        //region your codes 6
        private static final long serialVersionUID = 5982684784920661740L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}