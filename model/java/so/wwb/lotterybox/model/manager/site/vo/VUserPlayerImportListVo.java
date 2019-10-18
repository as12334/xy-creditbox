package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.site.po.VUserPlayerImport;
import so.wwb.lotterybox.model.manager.site.so.VUserPlayerImportSo;


/**
 * 列表页值对象
 *
 * @author River
 * @time 2016-1-7 17:00:55
 */
//region your codes 1
public class VUserPlayerImportListVo extends BaseListVo<VUserPlayerImport, VUserPlayerImportSo, VUserPlayerImportListVo.VUserPlayerImportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1326892622421667307L;
    private String nameVerification;
    private String bankVerification;
    //endregion your codes 5

    /**
     *  列表查询逻辑
     */
    public static class VUserPlayerImportQuery extends AbstractQuery<VUserPlayerImportSo> {

        //region your codes 6
        private static final long serialVersionUID = -631073645076847061L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }


        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            return new Sort(Direction.DESC, VUserPlayerImport.PROP_IMPORT_TIME).and(new Sort(Direction.DESC, VUserPlayerImport.PROP_NOT_ACTIVE_COUNT));
        }

        //endregion your codes 3
    }

    //region your codes 4

    public String getNameVerification() {
        return nameVerification;
    }

    public void setNameVerification(String nameVerification) {
        this.nameVerification = nameVerification;
    }

    public String getBankVerification() {
        return bankVerification;
    }

    public void setBankVerification(String bankVerification) {
        this.bankVerification = bankVerification;
    }

    //endregion your codes 4

}