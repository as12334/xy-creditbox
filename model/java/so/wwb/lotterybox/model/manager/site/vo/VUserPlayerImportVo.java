package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.VUserPlayerImport;
import so.wwb.lotterybox.model.manager.site.so.VUserPlayerImportSo;


/**
 * 值对象
 *
 * @author River
 * @time 2016-1-7 17:00:55
 */
//region your codes 1
public class VUserPlayerImportVo extends BaseObjectVo<VUserPlayerImport, VUserPlayerImportSo, VUserPlayerImportVo.VUserPlayerImportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8547625000559738051L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class VUserPlayerImportQuery extends AbstractQuery<VUserPlayerImportSo> {

        //region your codes 6
        private static final long serialVersionUID = 7254813964723326269L;
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