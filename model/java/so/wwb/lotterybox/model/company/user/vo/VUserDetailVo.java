package so.wwb.lotterybox.model.company.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.company.user.po.VUserDetail;
import so.wwb.lotterybox.model.company.user.so.VUserDetailSo;

import java.util.List;


/**
 * 用户管理/详细视图 - Fei  jeremy值对象
 *
 * @author block
 * @time 2019-10-14 20:59:17
 */
//region your codes 1
public class VUserDetailVo extends BaseObjectVo<VUserDetail, VUserDetailSo, VUserDetailVo.VUserDetailQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -511794699990132488L;
    //endregion your codes 5

    public static class VUserDetailQuery extends AbstractQuery<VUserDetailSo> {

        //region your codes 6
        private static final long serialVersionUID = 5093749324845911531L;
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