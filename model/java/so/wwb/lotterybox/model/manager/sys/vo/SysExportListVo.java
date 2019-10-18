package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.SysExport;
import so.wwb.lotterybox.model.manager.sys.so.SysExportSo;


/**
 * 导出数据历史表列表页值对象
 *
 * @author River
 * @time 2016-1-5 15:10:38
 */
//region your codes 1
public class SysExportListVo extends BaseListVo<SysExport, SysExportSo, SysExportListVo.SysExportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 101594211275219738L;
    //endregion your codes 5

    /**
     *  导出数据历史表列表查询逻辑
     */
    public static class SysExportQuery extends AbstractQuery<SysExportSo> {

        //region your codes 6
        private static final long serialVersionUID = -1297584657367666632L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SysExport.PROP_USERNAME, Operator.EQ, this.searchObject.getUsername());
            criteria = criteria.addAnd(SysExport.PROP_EXPORT_USER_SITE_ID, Operator.EQ,searchObject.getExportUserSiteId());
            criteria = criteria.addAnd(SysExport.PROP_EXPORT_USER_ID, Operator.EQ,searchObject.getExportUserId());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3
        @Override
        public Sort getDefaultSort() {
            return Sort.add("createTime", Direction.DESC);
        }
        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}