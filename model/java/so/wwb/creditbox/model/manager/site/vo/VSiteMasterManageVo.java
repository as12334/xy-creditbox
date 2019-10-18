package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.site.po.VSiteMasterManage;
import so.wwb.creditbox.model.manager.site.so.VSiteMasterManageSo;


/**
 * 值对象
 *
 * @author jerry
 * @time 2017-4-7 9:42:27
 */
//region your codes 1
public class VSiteMasterManageVo extends BaseObjectVo<VSiteMasterManage, VSiteMasterManageSo, VSiteMasterManageVo.VSiteMasterManageQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -3682855416145135210L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class VSiteMasterManageQuery extends AbstractQuery<VSiteMasterManageSo> {

        //region your codes 6
        private static final long serialVersionUID = -3950553112209681932L;
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