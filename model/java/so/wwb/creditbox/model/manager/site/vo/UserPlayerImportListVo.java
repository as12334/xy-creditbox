package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.site.po.UserPlayerImport;
import so.wwb.creditbox.model.manager.site.so.UserPlayerImportSo;


/**
 * 玩家导入记录表 by River列表页值对象
 *
 * @author River
 * @time 2015-12-28 16:29:59
 */
//region your codes 1
public class UserPlayerImportListVo extends BaseListVo<UserPlayerImport, UserPlayerImportSo, UserPlayerImportListVo.UserPlayerImportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7644846483410847521L;
    //endregion your codes 5

    /**
     *  玩家导入记录表 by River列表查询逻辑
     */
    public static class UserPlayerImportQuery extends AbstractQuery<UserPlayerImportSo> {

        //region your codes 6
        private static final long serialVersionUID = 4369846920861019844L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }


        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            Sort sort = new Sort(Order.desc(UserPlayerImport.PROP_IMPORT_TIME));
            return sort;
        }

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}