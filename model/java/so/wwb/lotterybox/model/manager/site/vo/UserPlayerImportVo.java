package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.UserPlayerImport;
import so.wwb.lotterybox.model.manager.site.po.UserPlayerTransfer;
import so.wwb.lotterybox.model.manager.site.so.UserPlayerImportSo;

import java.util.List;


/**
 * 玩家导入记录表 by River值对象
 *
 * @author River
 * @time 2015-12-28 16:29:59
 */
//region your codes 1
public class UserPlayerImportVo extends BaseObjectVo<UserPlayerImport, UserPlayerImportSo, UserPlayerImportVo.UserPlayerImportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -2555869485952323645L;
    //endregion your codes 5

    /**
     *  玩家导入记录表 by River查询逻辑
     */
    public static class UserPlayerImportQuery extends AbstractQuery<UserPlayerImportSo> {

        //region your codes 6
        private static final long serialVersionUID = 106755228035300439L;
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
    List<UserPlayerTransfer> playerList;

    public List<UserPlayerTransfer> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<UserPlayerTransfer> playerList) {
        this.playerList = playerList;
    }
    //endregion your codes 4

}