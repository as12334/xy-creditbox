package so.wwb.lotterybox.model.manager.lottery.so;

import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;

import java.util.Date;
import java.util.List;


/**
 * 开奖结果表查询对象
 *
 * @author shook
 * @time 2017-4-9 9:47:30
 */
//region your codes 1
public class LotteryResultSo extends LotteryResult {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 7174658316147032467L;

	private Date queryStartDate;

	private Date queryEndDate;

	private Date queryDate;

	private List<String> expects;

	private List<String> codes;
	/**
	 * 是否开奖标志
	 */
	private Boolean openCodeFlag = false;

	private Date initDate;

	private Integer siteId;

	private String display;


	private String expectStart;
	private String expectEnd;
	private Boolean openingTimeStatus;
	private Boolean closeTimeStatus;
	private Boolean openTimeStatus;
	private Integer openingTimeInterval;
	private Integer closeTimeInterval;
	private Integer openTimeInterval;

	//endregion your codes 3

	//region your codes 2

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

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
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

	public Boolean getOpeningTimeStatus() {
		return openingTimeStatus;
	}

	public void setOpeningTimeStatus(Boolean openingTimeStatus) {
		this.openingTimeStatus = openingTimeStatus;
	}

	public Boolean getCloseTimeStatus() {
		return closeTimeStatus;
	}

	public void setCloseTimeStatus(Boolean closeTimeStatus) {
		this.closeTimeStatus = closeTimeStatus;
	}

	public Boolean getOpenTimeStatus() {
		return openTimeStatus;
	}

	public void setOpenTimeStatus(Boolean openTimeStatus) {
		this.openTimeStatus = openTimeStatus;
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

	public List<String> getExpects() {
		return expects;
	}

	public void setExpects(List<String> expects) {
		this.expects = expects;
	}

	//endregion your codes 2
}