package so.wwb.lotterybox.model.company.setting.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;
import so.wwb.lotterybox.model.company.setting.so.DefenseRecordSo;


/**
 * 防御记录表值对象
 *
 * @author longer
 * @time Jan 17, 2016 4:47:58 PM
 */
//region your codes 1
public class DefenseRecordVo extends BaseObjectVo<DefenseRecord, DefenseRecordSo, DefenseRecordVo.DefenseRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 3068125570108211116L;

    //endregion your codes 5

    /**
     *  防御记录表查询逻辑
     */
    public static class DefenseRecordQuery extends AbstractQuery<DefenseRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = 4738761627356280232L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return Criteria.and(
                    Criteria.add(DefenseRecord.PROP_CLIENT_ID, Operator.EQ,searchObject.getClientId()),
                    Criteria.add(DefenseRecord.PROP_ACTION_CODE, Operator.EQ,searchObject.getActionCode())
            );
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}