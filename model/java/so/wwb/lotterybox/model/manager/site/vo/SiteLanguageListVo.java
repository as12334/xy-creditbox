package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.site.po.SiteLanguage;
import so.wwb.lotterybox.model.manager.site.so.SiteLanguageSo;


/**
 * 站点语言表列表页值对象
 *
 * @author tony
 * @time 2015-11-13 16:23:49
 */
//region your codes 1
public class SiteLanguageListVo extends BaseListVo<SiteLanguage, SiteLanguageSo, SiteLanguageListVo.SiteLanguageQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7395470353994951252L;
    //endregion your codes 5

    /**
     *  站点语言表列表查询逻辑
     */
    public static class SiteLanguageQuery extends AbstractQuery<SiteLanguageSo> {

        //region your codes 6
        private static final long serialVersionUID = -4649540558218062322L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SiteLanguage.PROP_STATUS, Operator.EQ, searchObject.getStatus());
            criteria = criteria.addAnd(Criteria.add(SiteLanguage.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId()));
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3
        @Override
        public Sort getDefaultSort() {
            return Sort.add(SiteLanguage.PROP_STATUS, Direction.ASC);
        }
        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}