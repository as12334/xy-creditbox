package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteUser;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteUserSo;


/**
 * 用户站点表值对象
 *
 * @author longer
 * @time Nov 17, 2015 2:22:29 PM
 */
//region your codes 1
public class VSysSiteUserVo extends BaseObjectVo<VSysSiteUser, VSysSiteUserSo, VSysSiteUserVo.VSysUserSiteQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6818607786187326068L;
    //endregion your codes 5

    /**
     *  用户站点表查询逻辑
     */
    public static class VSysUserSiteQuery extends AbstractQuery<VSysSiteUserSo> {

        //region your codes 6
        private static final long serialVersionUID = -9022716624024814148L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
                Criteria criteria = Criteria.add(VSysSiteUser.PROP_STATUS, Operator.EQ, this.searchObject.getStatus());
                criteria.addAnd(VSysSiteUser.PROP_USERNAME, Operator.LIKE, this.searchObject.getUsername());
                criteria.addAnd(VSysSiteUser.PROP_ID, Operator.EQ, this.searchObject.getId());
                criteria.addAnd(VSysSiteUser.PROP_SUBSYS_CODE, Operator.EQ, this.searchObject.getSubsysCode());
                criteria.addAnd(VSysSiteUser.PROP_OWNER_ID, Operator.EQ, this.searchObject.getOwnerId()
            );
            return criteria;
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}