package so.wwb.creditbox.model.manager.sys.ip.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.so.IpDbSo;

//IP数据库值对象
//region your codes 1
public class IpDbVo extends BaseObjectVo<IpDb, IpDbSo, IpDbVo.IpDbQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6392804321494388819L;
    //endregion your codes 5

    /**
     *  IP数据库查询逻辑
     */
    public static class IpDbQuery extends AbstractQuery<IpDbSo> {

        //region your codes 6
        private static final long serialVersionUID = 3251136212163776453L;
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