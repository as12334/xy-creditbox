package so.wwb.creditbox.model.company.lottery.so;

import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.Date;
import java.util.List;

/**
 * 彩票开奖号码表查询对象
 *
 * @author diego
 * @time 18-2-11.
 */
public class LotteryResultNumberSo extends LotteryResultNumber {

    private static final long serialVersionUID = 5177508722554501506L;

    private Date queryStartDate;
    private Date queryEndDate;

    private Date queryDate;

    private String bossDataSourceUrl;
    private Date initDate;
    private List<String> codes;

    private Integer querySiteId;

    private String expectStart;
    private String expectEnd;
    private Integer openingTimeInterval;
    private Integer closeTimeInterval;
    private Integer openTimeInterval;
    private Boolean loadAll;

    /**
     * 是否开奖标志
     */
    private Boolean openCodeFlag = false;

    public Date getQueryStartDate() {
        return queryStartDate;
    }

    public void setQueryStartDate(Date queryStartDate) {
        this.queryStartDate = queryStartDate;
    }

    public Date getQueryEndDate() {
        return queryEndDate;
    }

    public void setQueryEndDate(Date queryEndDate) {
        this.queryEndDate = queryEndDate;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public Boolean getOpenCodeFlag() {
        return openCodeFlag;
    }

    public void setOpenCodeFlag(Boolean openCodeFlag) {
        this.openCodeFlag = openCodeFlag;
    }

    public Integer getQuerySiteId() {
        return querySiteId;
    }

    public void setQuerySiteId(Integer querySiteId) {
        this.querySiteId = querySiteId;
    }

    public String getExpectStart() {
        return expectStart;
    }

    public void setExpectStart(String expectStart) {
        this.expectStart = expectStart;
    }

    public String getExpectEnd() {
        return expectEnd;
    }

    public void setExpectEnd(String expectEnd) {
        this.expectEnd = expectEnd;
    }

    public Integer getOpeningTimeInterval() {
        return openingTimeInterval;
    }

    public void setOpeningTimeInterval(Integer openingTimeInterval) {
        this.openingTimeInterval = openingTimeInterval;
    }

    public Integer getCloseTimeInterval() {
        return closeTimeInterval;
    }

    public void setCloseTimeInterval(Integer closeTimeInterval) {
        this.closeTimeInterval = closeTimeInterval;
    }

    public Integer getOpenTimeInterval() {
        return openTimeInterval;
    }

    public void setOpenTimeInterval(Integer openTimeInterval) {
        this.openTimeInterval = openTimeInterval;
    }

    public Boolean getLoadAll() {
        return loadAll;
    }

    public void setLoadAll(Boolean loadAll) {
        this.loadAll = loadAll;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public String getBossDataSourceUrl() {
        return bossDataSourceUrl;
    }

    public void setBossDataSourceUrl(String bossDataSourceUrl) {
        this.bossDataSourceUrl = bossDataSourceUrl;
    }
}
