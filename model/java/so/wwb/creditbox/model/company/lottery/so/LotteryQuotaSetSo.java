package so.wwb.creditbox.model.company.lottery.so;

import so.wwb.creditbox.model.company.lottery.po.LotteryQuotaSet;

import java.util.List;

/**
 * 彩票限额设置表查询对象
 *
 * @author diego
 * @time 2018-02-11
 */
public class LotteryQuotaSetSo extends LotteryQuotaSet {

    private static final long serialVersionUID = -615798549553756236L;

    private List<Integer> ids;

    private Integer siteId;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
