package so.wwb.creditbox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.message.po.SystemMessageReceive;
import so.wwb.creditbox.model.message.so.SystemMessageReceiveSo;

/**
 * boss->>站点 信息接收查询
 * Created by jeremy on 18-3-31.
 */
public class SystemMessageReceiveVo extends BaseObjectVo<SystemMessageReceive,SystemMessageReceiveSo,SystemMessageReceiveVo.SystemMessageReceiveQuery> {

    private static final long serialVersionUID = -228130768659856252L;

    public static class SystemMessageReceiveQuery extends AbstractQuery<SystemMessageReceiveSo> {

        private static final long serialVersionUID = 6837782961168731858L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
}
