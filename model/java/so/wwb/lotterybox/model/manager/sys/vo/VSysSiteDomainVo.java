package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteDomainSo;

import java.util.Locale;
import java.util.TimeZone;

public class VSysSiteDomainVo extends BaseObjectVo<VSysSiteDomain, VSysSiteDomainSo, VSysSiteDomainVo.VSysSiteDomainQuery> {
    private static final long serialVersionUID = 1055061476920797067L;

    public static class VSysSiteDomainQuery extends AbstractQuery<VSysSiteDomainSo> {

        private static final long serialVersionUID = -14579209038004492L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = new Criteria();
            if (searchObject.getDomain() != null) {
                criteria.addAnd(VSysSiteDomain.PROP_DOMAIN, Operator.EQ, searchObject.getDomain());
            }
            return criteria;
        }

    }

    public static BaseObjectVo toVo(VSysSiteDomain domain) {
        BaseObjectVo vo = new VSysSiteDomainVo();
        if (domain != null) {
            Integer id = domain.getSiteUserId();
            vo._setSiteUserId(id);
            vo._setSiteId(domain.getSiteId());
            vo._setSiteCode(domain.getSiteCode());
            vo._setSiteTimeZone(TimeZone.getTimeZone(domain.getTimeZone()));
            vo._setSiteParentId(domain.getSiteParentId());
            if (StringTool.isNotBlank(domain.getSiteLocale())) {
                String[] mainLocale = domain.getSiteLocale().split("_");
                if (mainLocale.length == 2) {
                    vo._setSiteLocale(new Locale(mainLocale[0], mainLocale[1].toUpperCase()));
                }
            }
            vo.setResult(domain);
        }
        return vo;
    }

}