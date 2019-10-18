package so.wwb.creditbox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.site.po.VSiteMasterManage;
import so.wwb.creditbox.model.manager.site.so.VSiteMasterManageSo;


/**
 * 列表页值对象
 *
 * @author jerry
 * @time 2017-4-7 9:42:27
 */
public class VSiteMasterManageListVo extends BaseListVo<VSiteMasterManage, VSiteMasterManageSo, VSiteMasterManageListVo.VSiteMasterManageQuery> {

    private static final long serialVersionUID = 924180403307518785L;

    /**
     *  列表查询逻辑
     */
    public static class VSiteMasterManageQuery extends AbstractQuery<VSiteMasterManageSo> {

        private static final long serialVersionUID = 102079499865372949L;

        @Override
        public Criteria getCriteria() {
            return null;
        }

    }

}