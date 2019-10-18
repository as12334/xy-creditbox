package so.wwb.lotterybox.model.message.so;

import so.wwb.lotterybox.model.message.po.SystemMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * boss->>站点 消息查询对象（新）
 * Created by jeremy on 18-3-30.
 */
public class SystemMessageSo extends SystemMessage {
    private static final long serialVersionUID = -2230415098928200893L;
    private String queryTitle;
    private Date queryStartDate;
    private Date queryEndDate;

    /**
     * 接收者用户的ID
     */
    private Integer receiverUserId;

    private String shareholder;
    private String merchant;
    private String agent;
    private String player;
    private String merchantApi;
    private String agentApi;

    private List<Integer> shareholderList;
    private List<Integer> merchantList;
    private List<Integer> agentList;

    private List<Integer> merchantApiList;
    private List<Integer> agentApiList;

    private String sendType;

    /**
     * 存储分页数据
     */
    private Map<String, Object> searchMap;

    public String getQueryTitle() {
        return queryTitle;
    }

    public void setQueryTitle(String queryTitle) {
        this.queryTitle = queryTitle;
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

    public List<Integer> getShareholderList() {
        return shareholderList;
    }

    public void setShareholderList(List<Integer> shareholderList) {
        this.shareholderList = shareholderList;
    }

    public List<Integer> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<Integer> merchantList) {
        this.merchantList = merchantList;
    }

    public List<Integer> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Integer> agentList) {
        this.agentList = agentList;
    }

    public String getShareholder() {
        return shareholder;
    }

    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }

    public Integer getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(Integer receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getMerchantApi() {
        return merchantApi;
    }

    public void setMerchantApi(String merchantApi) {
        this.merchantApi = merchantApi;
    }

    public String getAgentApi() {
        return agentApi;
    }

    public void setAgentApi(String agentApi) {
        this.agentApi = agentApi;
    }

    public List<Integer> getMerchantApiList() {
        return merchantApiList;
    }

    public void setMerchantApiList(List<Integer> merchantApiList) {
        this.merchantApiList = merchantApiList;
    }

    public List<Integer> getAgentApiList() {
        return agentApiList;
    }

    public void setAgentApiList(List<Integer> agentApiList) {
        this.agentApiList = agentApiList;
    }
}
