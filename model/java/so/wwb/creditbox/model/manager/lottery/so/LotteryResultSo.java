package so.wwb.creditbox.model.manager.lottery.so;

import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;

import java.util.Date;
import java.util.List;


/**
 * 开奖结果主表查询对象
 *
 * @author block
 * @time 2019-11-15 9:31:52
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

	private String expectStart;
	private String expectEnd;
	private Boolean openingTimeStatus;
	private Boolean closeTimeStatus;
	private Boolean openTimeStatus;
	private Integer openingTimeInterval;
	private Integer closeTimeInterval;
	private Integer openTimeInterval;
	private Boolean expectStatus;
	private Integer expectInterval;
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

	public List<String> getExpects() {
		return expects;
	}

	public void setExpects(List<String> expects) {
		this.expects = expects;
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

	public Boolean getExpectStatus() {
		return expectStatus;
	}

	public void setExpectStatus(Boolean expectStatus) {
		this.expectStatus = expectStatus;
	}

	public Integer getExpectInterval() {
		return expectInterval;
	}

	public void setExpectInterval(Integer expectInterval) {
		this.expectInterval = expectInterval;
	}

	//endregion your codes 2

}