package so.wwb.lotterybox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.message.po.SystemMessage;
import so.wwb.lotterybox.model.message.so.SystemMessageSo;

/**
 * boss->>站点 消息列表查询对象（新）
 * Created by jeremy on 18-3-30.
 */
public class SystemMessageListVo extends BaseListVo<SystemMessage, SystemMessageSo, SystemMessageListVo.SystemMessageQuery> {

    private static final long serialVersionUID = 2231409995636156740L;

    public static class SystemMessageQuery extends AbstractQuery<SystemMessageSo> {

        private static final long serialVersionUID = 1292214950539057645L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(SystemMessage.CREATE_TIME, Operator.GE,searchObject.getQueryStartDate());
            criteria.addAnd(SystemMessage.CREATE_TIME, Operator.LE,searchObject.getQueryEndDate());
            criteria.addAnd(SystemMessage.ID, Operator.EQ,searchObject.getId());
            criteria.addAnd(SystemMessage.TITLE, Operator.LIKE,searchObject.getQueryTitle());
            criteria.addAnd(SystemMessage.CREATE_USERNAME, Operator.EQ,searchObject.getCreateUsername());
            return criteria;
        }
        @Override
        public Sort getDefaultSort() {
            return new Sort(Order.desc(SystemMessage.CREATE_TIME));
        }
    }

}
