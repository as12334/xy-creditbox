package so.wwb.creditbox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.message.po.SystemMessageReceive;
import so.wwb.creditbox.model.message.so.SystemMessageReceiveSo;

/**
 * boss->>站点 信息接收列表查询
 * Created by jeremy on 18-3-31.
 */
public class SystemMessageReceiveListVo extends BaseListVo<SystemMessageReceive, SystemMessageReceiveSo, SystemMessageReceiveListVo.SystemMessageReceiveQuery> {

    private static final long serialVersionUID = -4115457897909090888L;

    public static class SystemMessageReceiveQuery extends AbstractQuery<SystemMessageReceiveSo> {

        private static final long serialVersionUID = 2624653708327722847L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
}
