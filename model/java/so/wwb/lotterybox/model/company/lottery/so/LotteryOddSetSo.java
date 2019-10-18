package so.wwb.lotterybox.model.company.lottery.so;

import so.wwb.lotterybox.model.company.lottery.po.LotteryOddSet;

import java.util.List;

/**
 * 彩票赔率设置表查询对象
 *
 * @author diego
 * @time 18-2-11.
 */
public class LotteryOddSetSo extends LotteryOddSet {

    private static final long serialVersionUID = -4702380442141585954L;

    private List<Integer> ids;

    private String[] betcodes;

    /** 站点ID */
    private Integer siteId;

    /** 默认总代盘口id*/
    private Integer defauleProjectId;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String[] getBetcodes() {
        return betcodes;
    }

    public void setBetcodes(String[] betcodes) {
        this.betcodes = betcodes;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getDefauleProjectId() {
        return defauleProjectId;
    }

    public void setDefauleProjectId(Integer defauleProjectId) {
        this.defauleProjectId = defauleProjectId;
    }
}
