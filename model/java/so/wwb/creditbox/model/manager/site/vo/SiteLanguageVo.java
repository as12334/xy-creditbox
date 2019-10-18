package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.site.po.SiteLanguage;
import so.wwb.creditbox.model.manager.site.so.SiteLanguageSo;


/**
 * 站点语言表值对象
 *
 * @author tony
 * @time 2015-11-13 16:23:49
 */
//region your codes 1
public class SiteLanguageVo extends BaseObjectVo<SiteLanguage, SiteLanguageSo, SiteLanguageVo.SiteLanguageQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6128748269636924208L;
    //endregion your codes 5

    /**
     *  站点语言表查询逻辑
     */
    public static class SiteLanguageQuery extends AbstractQuery<SiteLanguageSo> {

        //region your codes 6
        private static final long serialVersionUID = 3437146519351485073L;
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