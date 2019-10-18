package so.wwb.lotterybox.model.manager.user.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.company.user.po.VUserDetail;
import so.wwb.lotterybox.model.manager.user.po.VUserManager;
import so.wwb.lotterybox.model.manager.user.so.VUserManagerSo;

import java.util.List;


/**
 * 用户管理/详细视图 - Fei  jeremy值对象
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public class VUserManagerVo extends BaseObjectVo<VUserManager, VUserManagerSo, VUserManagerVo.VUserManagerQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -2442165531493597034L;

    /**
     *  用户管理/详细视图 - Fei  jeremy查询逻辑
     */
    /**
     * 上级用户
     */
    private List<VUserDetail> superUserList;

    //endregion your codes 5

    /**
     *  用户管理/详细视图 - Fei  jeremy查询逻辑
     */
    public static class VUserManagerQuery extends AbstractQuery<VUserManagerSo> {

        //region your codes 6
        private static final long serialVersionUID = -5890515278156217641L;
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
    public List<VUserDetail> getSuperUserList() {
        return superUserList;
    }

    public void setSuperUserList(List<VUserDetail> superUserList) {
        this.superUserList = superUserList;
    }


    //endregion your codes 4

}