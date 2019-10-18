package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.enums.site.SiteConfineStatusEnum;
import so.wwb.creditbox.model.manager.site.po.SiteConfineArea;
import so.wwb.creditbox.model.manager.site.so.SiteConfineAreaSo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * 限制访问站点的地区表列表页值对象
 *
 * @author loong
 * @time 2015-8-11 11:17:30
 */
//region your codes 1
public class SiteConfineAreaListVo extends BaseListVo<SiteConfineArea, SiteConfineAreaSo, SiteConfineAreaListVo.SiteConfineAreaQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8314805151165701610L;
    private Map<String, Serializable> status;

    //endregion your codes 5

    /**
     * 限制访问站点的地区表列表查询逻辑
     */
    public static class SiteConfineAreaQuery extends AbstractQuery<SiteConfineAreaSo> {

        //region your codes 6
        private static final long serialVersionUID = -7664805638438328137L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = new Criteria();
            criteria.addAnd(SiteConfineArea.PROP_NATION,Operator.EQ,searchObject.getNation()).addAnd(SiteConfineArea.PROP_PROVINCE, Operator.EQ, searchObject.getProvince()).addAnd(SiteConfineArea.PROP_CITY,Operator.EQ,searchObject.getCity());
            if (searchObject.getStatus() != null) {
                if (searchObject.getStatus().equals(SiteConfineStatusEnum.USING.getCode())) {
                    //使用中
                    criteria.addAnd(SiteConfineArea.PROP_END_TIME, Operator.GT, new Date());
                } else if (searchObject.getStatus().equals(SiteConfineStatusEnum.EXPIRED.getCode())) {
                    criteria.addAnd(SiteConfineArea.PROP_END_TIME, Operator.LT, new Date());
                }
            }
            criteria.addAnd(SiteConfineArea.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3
        @Override
        public Sort getDefaultSort() {
            return Sort.add(SiteConfineArea.PROP_CREATE_TIME, Direction.DESC);
        }
        //endregion your codes 3
    }

    //region your codes 4

    public Map<String, Serializable> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Serializable> status) {
        this.status = status;
    }


//endregion your codes 4

}