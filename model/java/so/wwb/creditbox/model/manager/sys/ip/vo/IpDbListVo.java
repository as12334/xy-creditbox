package so.wwb.creditbox.model.manager.sys.ip.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.so.IpDbSo;

/**
 * IP数据库列表页值对象
 *
 * @author longer
 * @time Dec 8, 2015 10:59:03 AM
 */
//region your codes 1
public class IpDbListVo extends BaseListVo<IpDb, IpDbSo, IpDbListVo.IpDbQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -495517117739130461L;
    //endregion your codes 5

    /**
     *  IP数据库列表查询逻辑
     */
    public static class IpDbQuery extends AbstractQuery<IpDbSo> {

        //region your codes 6
        private static final long serialVersionUID = 5187632518384295508L;
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