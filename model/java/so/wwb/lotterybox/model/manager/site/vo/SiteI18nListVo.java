package so.wwb.lotterybox.model.manager.site.vo;


import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.site.po.SiteI18n;
import so.wwb.lotterybox.model.manager.site.so.SiteI18nSo;

import java.util.List;


/**
 * 域名表列表页值对象
 *
 * @author tony
 * @time 2015-11-13 14:24:42
 */
//region your codes 1
public class SiteI18nListVo extends BaseListVo<SiteI18n, SiteI18nSo, SiteI18nListVo.SiteI18nQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 8626911656399991388L;
    //endregion your codes 5

    /**
     * 域名表列表查询逻辑
     */
    public static class SiteI18nQuery extends AbstractQuery<SiteI18nSo> {

        //region your codes 6
        private static final long serialVersionUID = 4801786290938591837L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.add(SiteI18n.PROP_MODULE, Operator.EQ,searchObject.getModule())
                    .addAnd(SiteI18n.PROP_TYPE,Operator.EQ,searchObject.getType())
                    .addAnd(SiteI18n.PROP_KEY,Operator.EQ,searchObject.getKey())
                    .addAnd(SiteI18n.PROP_LOCALE,Operator.EQ,searchObject.getLocale())
                    .addAnd(SiteI18n.PROP_VALUE,Operator.ILIKE,searchObject.getValue());
            //endregion your codes 2
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4
    private List<SiteI18n> siteI18ns;

    private Integer siteId;

    private String type;

    public List<SiteI18n> getSiteI18ns() {
        return siteI18ns;
    }

    public void setSiteI18ns(List<SiteI18n> siteI18ns) {
        this.siteI18ns = siteI18ns;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //endregion your codes 4

}