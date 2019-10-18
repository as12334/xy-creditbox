package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;
import so.wwb.lotterybox.model.manager.site.so.SiteOperateAreaSo;


/**
 * 经营地区表列表页值对象
 *
 * @author tony
 * @time 2015-11-13 16:24:12
 */
//region your codes 1
public class SiteOperateAreaListVo extends BaseListVo<SiteOperateArea, SiteOperateAreaSo, SiteOperateAreaListVo.SiteOperateAreaQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 8601899866379161343L;
    //endregion your codes 5

    /**
     *  经营地区表列表查询逻辑
     */
    public static class SiteOperateAreaQuery extends AbstractQuery<SiteOperateAreaSo> {

        //region your codes 6
        private static final long serialVersionUID = 5075277553256033312L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.add(SiteOperateArea.PROP_STATUS, Operator.NE,searchObject.getStatus())
                    .addAnd(SiteOperateArea.PROP_CODE, Operator.EQ, searchObject.getCode())
                    .addAnd(SiteOperateArea.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId());
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}