package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.UserPlayerTransfer;
import so.wwb.lotterybox.model.manager.site.so.UserPlayerTransferSo;


/**
 * 导入玩家表 by River值对象
 *
 * @author River
 * @time 2015-12-28 16:30:45
 */
//region your codes 1
public class UserPlayerTransferVo extends BaseObjectVo<UserPlayerTransfer, UserPlayerTransferSo, UserPlayerTransferVo.UserPlayerTransferQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 4426570265057397111L;

    private String tempPass;
    /*账号是否重复*/
    private boolean accountRepeat;

    /** 密码强度等级 */
    private String passLevel;
    /** 验证码 */
    private String tempCode;

    //endregion your codes 5

    /**
     *  导入玩家表 by River查询逻辑
     */
    public static class UserPlayerTransferQuery extends AbstractQuery<UserPlayerTransferSo> {

        //region your codes 6
        private static final long serialVersionUID = -1637613441676414675L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(UserPlayerTransfer.PROP_PLAYER_ACCOUNT, Operator.IEQ,searchObject.getPlayerAccount());
            criteria = criteria.addAnd(Criteria.add(UserPlayerTransfer.PROP_IS_ACTIVE, Operator.EQ,searchObject.getIsActive()));
            criteria = criteria.addAnd(Criteria.add(UserPlayerTransfer.PROP_PLAYER_ACCOUNT, Operator.EQ,searchObject.getPlayerAccount()));

            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    public String getTempPass() {
        return tempPass;
    }

    public void setTempPass(String tempPass) {
        this.tempPass = tempPass;
    }

    public boolean isAccountRepeat() {
        return accountRepeat;
    }

    public void setAccountRepeat(boolean accountRepeat) {
        this.accountRepeat = accountRepeat;
    }

    public String getPassLevel() {
        return passLevel;
    }

    public void setPassLevel(String passLevel) {
        this.passLevel = passLevel;
    }

    public String getTempCode() {
        return tempCode;
    }

    public void setTempCode(String tempCode) {
        this.tempCode = tempCode;
    }
    //endregion your codes 4

}