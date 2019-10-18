package so.wwb.creditbox.model.company.lottery.so;

import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 投注记录表查询对象
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */
//region your codes 1
public class LotteryBetOrderSo extends LotteryBetOrder {
//endregion your codescodes 1

    //region your codes 3
    private static final long serialVersionUID = -7354413253619832739L;
    //endregion your codes 3

    //region your codes 2
    private Date payoutStartDate;
    private Date payoutEndDate;
    private Date queryStartDate;
    private Date queryEndDate;
    private String[] codes;
    private Integer siteId;
    private Integer payout_year;
    private Integer payout_month;
    private String[] betCodes;
    private String[] playCodes;
    private String[] statuss;
    private Integer searchCode;
    //撤单类型:1:撤单 2:撤销
    private String revokeType;
    private Map<String, Object> searchMap;
    //搜索类型：1:只查询该玩家的注单,2:查询玩家及下级注单
    private String searchType;

    private String distributorCode;

    private Integer profitLoss;

    private List<String> nameList;

    private List<Integer> userIds;
    private Integer userId;

    //首页跳转过来 今天：today  昨天：yesToday  本周：thisWeek 上周：lastWeek 本月：thisMonth
    private String day;


    private String requestType;

    private int pageSize;

    private int pageNo;

    /**
     * 页面类型 LotteryOrderPageTypeEnum
     */
    private String pageType;

    /**
     * 当前页小计开关; true时，只统计分页数据
     */
    private String subTotal = "false";

    /**
     * 总代id
     */
    private Integer distributorId;
    /**
     * 总代名称
     */
    private String distributorName;

    /**
     * api查询 将此值设为 true 按总代附分组数据
     */
    private String apiQuery;
    /**
     * ajax 统计数据，将此值设为 true 按派彩时间查询已中奖、未中奖的数据
     */
    private String ajaxQuery;

    /**
     * 其他页面链接至今日注单专用参数
     */
    private String linkSearchUsername;
    /**
     * 将此值设为 true，将显示返回按钮
     */
    private String hasReturn;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Integer profitLoss) {
        this.profitLoss = profitLoss;
    }

    public String getDistributorCode() {
        return distributorCode;
    }

    public void setDistributorCode(String distributorCode) {
        this.distributorCode = distributorCode;
    }

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

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String[] getCodes() {
        return codes;
    }

    public void setCodes(String[] codes) {
        this.codes = codes;
    }

    public Integer getPayout_year() {
        return payout_year;
    }

    public void setPayout_year(Integer payout_year) {
        this.payout_year = payout_year;
    }

    public Integer getPayout_month() {
        return payout_month;
    }

    public void setPayout_month(Integer payout_month) {
        this.payout_month = payout_month;
    }

    public String[] getBetCodes() {
        return betCodes;
    }

    public void setBetCodes(String[] betCodes) {
        this.betCodes = betCodes;
    }

    public String[] getPlayCodes() {
        return playCodes;
    }

    public void setPlayCodes(String[] playCodes) {
        this.playCodes = playCodes;
    }

    public void setRevokeType(String revokeType) {
        this.revokeType = revokeType;
    }

    public String getRevokeType() {
        return revokeType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }

    public String[] getStatuss() {
        return statuss;
    }

    public void setStatuss(String[] statuss) {
        this.statuss = statuss;
    }

    public Integer getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(Integer searchCode) {
        this.searchCode = searchCode;
    }

    public Date getPayoutStartDate() {
        return payoutStartDate;
    }

    public void setPayoutStartDate(Date payoutStartDate) {
        this.payoutStartDate = payoutStartDate;
    }

    public Date getPayoutEndDate() {
        return payoutEndDate;
    }

    public void setPayoutEndDate(Date payoutEndDate) {
        this.payoutEndDate = payoutEndDate;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }


    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }

    public String getAjaxQuery() {
        return ajaxQuery;
    }

    public void setAjaxQuery(String ajaxQuery) {
        this.ajaxQuery = ajaxQuery;
    }

    public String getLinkSearchUsername() {
        return linkSearchUsername;
    }

    public void setLinkSearchUsername(String linkSearchUsername) {
        this.linkSearchUsername = linkSearchUsername;
    }

    public String getHasReturn() {
        return hasReturn;
    }

    public void setHasReturn(String hasReturn) {
        this.hasReturn = hasReturn;
    }
}