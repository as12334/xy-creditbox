package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.site.po.UserPlayerTransfer;
import so.wwb.creditbox.model.manager.site.so.UserPlayerTransferSo;


/**
 * 导入玩家表 by River列表页值对象
 *
 * @author River
 * @time 2015-12-28 16:30:45
 */
//region your codes 1
public class UserPlayerTransferListVo extends BaseListVo<UserPlayerTransfer, UserPlayerTransferSo, UserPlayerTransferListVo.UserPlayerTransferQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -5812831837764683780L;
    //endregion your codes 5

    /**
     *  导入玩家表 by River列表查询逻辑
     */
    public static class UserPlayerTransferQuery extends AbstractQuery<UserPlayerTransferSo> {

        //region your codes 6
        private static final long serialVersionUID = -4632130240530720107L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria playerAccountEq = Criteria.add(UserPlayerTransfer.PROP_PLAYER_ACCOUNT, Operator.IEQ, searchObject.getPlayerAccount());
            Criteria isActiveEq = Criteria.add(UserPlayerTransfer.PROP_IS_ACTIVE, Operator.EQ, searchObject.getIsActive());
            Criteria importGroup = Criteria.add(UserPlayerTransfer.PROP_IMPORT_ID, Operator.EQ,searchObject.getImportId());
            Criteria and = Criteria.and(playerAccountEq, isActiveEq, importGroup);
            and.addAnd(UserPlayerTransfer.PROP_AGENT, Operator.LIKE,searchObject.getAgent());
            and.addAnd(UserPlayerTransfer.PROP_TOPAGENT, Operator.LIKE,searchObject.getTopagent());
            and.addAnd(UserPlayerTransfer.PROP_PLAYER_ACCOUNT, Operator.IN,searchObject.getUsernameList());
            and.addAnd(UserPlayerTransfer.PROP_REAL_NAME, Operator.EQ,searchObject.getRealName());
            return and;
        }

        @Override
        public Sort getDefaultSort() {
            return new Sort(Direction.DESC, UserPlayerTransfer.PROP_INSERT_TIME);
        }
    }




}