package so.wwb.creditbox.model.manager.sys.ip.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDbAmend;
import so.wwb.creditbox.model.manager.sys.ip.so.IpDbAmendSo;

/**
 * IP数据库-修正库列表页值对象
 *
 * @author longer
 * @time Dec 8, 2015 11:04:54 AM
 */
//region your codes 1
public class IpDbAmendListVo extends BaseListVo<IpDbAmend, IpDbAmendSo, IpDbAmendListVo.IpDbAmendQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -4534554265933971291L;
    //endregion your codes 5

    /**
     *  IP数据库-修正库列表查询逻辑
     */
    public static class IpDbAmendQuery extends AbstractQuery<IpDbAmendSo> {

        //region your codes 6
        private static final long serialVersionUID = 3059611517311103916L;
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