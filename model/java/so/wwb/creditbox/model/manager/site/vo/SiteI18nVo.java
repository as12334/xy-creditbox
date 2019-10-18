package so.wwb.creditbox.model.manager.site.vo;


import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.sys.po.SysParam;
import so.wwb.creditbox.model.manager.site.po.SiteI18n;
import so.wwb.creditbox.model.manager.site.so.SiteI18nSo;

import java.util.Date;
import java.util.Map;


/**
 * 域名表值对象
 *
 * @author tony
 * @time 2015-11-13 14:24:42
 */
//region your codes 1
public class SiteI18nVo extends BaseObjectVo<SiteI18n, SiteI18nSo, SiteI18nVo.SiteI18nQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7516081551564556692L;
    private SiteI18n[] sv;
    private String type;
    private Date closeTime;
    private Map<String, SysParam> map;
    private String defaultKey;//默认内置key
    private SysParam sysParam;
    //endregion your codes 5

    /**
     * 域名表查询逻辑
     */
    public static class SiteI18nQuery extends AbstractQuery<SiteI18nSo> {

        //region your codes 6
        private static final long serialVersionUID = -6446530147061030064L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SiteI18n.PROP_MODULE, Operator.EQ, searchObject.getModule());
            criteria.addAnd(SiteI18n.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(SiteI18n.PROP_KEY, Operator.EQ, searchObject.getKey());
            criteria.addAnd(SiteI18n.PROP_LOCALE, Operator.EQ, searchObject.getLocale());
            criteria.addAnd(SiteI18n.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4
    public SiteI18n[] getSv() {
        return sv;
    }

    public void setSv(SiteI18n[] sv) {
        this.sv = sv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Map<String, SysParam> getMap() {
        return map;
    }

    public void setMap(Map<String, SysParam> map) {
        this.map = map;
    }

    public String getDefaultKey() {
        return defaultKey;
    }

    public void setDefaultKey(String defaultKey) {
        this.defaultKey = defaultKey;
    }

    public SysParam getSysParam() {
        return sysParam;
    }

    public void setSysParam(SysParam sysParam) {
        this.sysParam = sysParam;
    }
//endregion your codes 4

}