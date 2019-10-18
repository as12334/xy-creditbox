package so.wwb.lotterybox.model.company.setting.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;
import so.wwb.lotterybox.model.company.setting.so.DefenseRecordSo;


/**
 * 防御记录表列表页值对象
 *
 * @author longer
 * @time Jan 17, 2016 4:47:58 PM
 */
//region your codes 1
public class DefenseRecordListVo extends BaseListVo<DefenseRecord, DefenseRecordSo, DefenseRecordListVo.DefenseRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -1136850482976061712L;
    //endregion your codes 5

    /**
     *  防御记录表列表查询逻辑
     */
    public static class DefenseRecordQuery extends AbstractQuery<DefenseRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = 6153494974426855813L;
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