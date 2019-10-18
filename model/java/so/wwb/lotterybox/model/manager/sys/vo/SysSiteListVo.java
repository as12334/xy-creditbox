package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.enums.sys.SysSiteStatusEnum;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.so.SysSiteSo;


/**
 * 站长站点表列表页值对象
 * <p>
 * Created by tom using soul-code-generator on 2015-7-21 17:37:50
 */
//region your codes 1
public class SysSiteListVo extends BaseListVo<SysSite, SysSiteSo, SysSiteListVo.SysSiteQuery> {
    private String defaultLanguage;
    private String logo;
    private String billNo;
//endregion your codes 1

    private static final long serialVersionUID = -1291272085159668736L;

    /**
     * 站长站点表列表查询逻辑
     */
    public static class SysSiteQuery extends AbstractQuery<SysSiteSo> {

        private static final long serialVersionUID = 1863121151444664832L;

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.add(SysSite.PROP_ID,Operator.EQ, searchObject.getId());
            //endregion your codes 2
        }


        //region your codes 3

        /**
         * 查询某站长下的所有站点信息
         *
         * @return
         * @author Longer
         */
        public Criteria bySysUserId() {
            return Criteria.add(SysSite.PROP_SYS_USER_ID, Operator.EQ, searchObject.getSysUserId());
        }

        public Criteria getSiteCriteria() {
            Criteria criteria = Criteria.add(SysSite.PROP_PARENT_ID, Operator.LT, searchObject.getParentId());
            criteria.addAnd(SysSite.PROP_STATUS, Operator.NE, searchObject.getStatus());
            return criteria;
        }

        //获取所有站点不包括运营商和BOSS
        public Criteria getAllNormalSite() {
            Criteria criteria = Criteria.add(SysSite.PROP_STATUS, Operator.EQ, searchObject.getStatus());
            criteria = criteria.addAnd(Criteria.add(SysSite.PROP_ID, Operator.GT, 0));
            return criteria;
        }

        /**
         * 获取指定站长下的所有站点
         *
         * @return
         */
        public Criteria getCriteriaByMasterId() {
            Criteria criteria = Criteria.add(SysSite.PROP_SYS_USER_ID, Operator.EQ, searchObject.getSysUserId());
            criteria.addAnd(SysSite.PROP_STATUS, Operator.EQ, searchObject.getStatus());
            return criteria;
        }

        public Criteria getCriteriaByStatus(){
            Criteria criteria = Criteria.add(SysSite.PROP_STATUS, Operator.EQ, SysSiteStatusEnum.NORMAL.getCode());
            return criteria;
        }
        //endregion your codes 3
    }

    //region your codes 4

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    //endregion your codes 4

}