package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.VUserDetail;
import so.wwb.creditbox.model.company.lottery.so.VUserDetailSo;


/**
 * 用户管理/详细视图 - Fei  jeremy列表页值对象
 *
 * @author block
 * @time 2019-10-14 20:59:17
 */
//region your codes 1
public class VUserDetailListVo extends BaseListVo<VUserDetail, VUserDetailSo, VUserDetailListVo.VUserDetailQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -3477269163479838133L;
    //endregion your codes 5

    /**
     *  用户管理/详细视图 - Fei  jeremy列表查询逻辑
     */
    public static class VUserDetailQuery extends AbstractQuery<VUserDetailSo> {

        //region your codes 6
        private static final long serialVersionUID = 6274631919379049272L;
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