package so.wwb.creditbox.model.message.so;

import so.wwb.creditbox.model.message.po.SystemAnnouncement;

import java.util.Date;
import java.util.Map;

/**
 * Created by jeremy on 18-3-22.
 */
public class SystemAnnouncementSo extends SystemAnnouncement {
    private static final long serialVersionUID = -7020039011926458472L;

    /**发送方式*/
    private String sendType;

    private String type;

    private String viewType;

    private Date queryStartDate;
    private Date queryEndDate;
    /**关键字查询*/
    private String keyword;
    /**查询语言*/
    private String queryLanguage;
    /**查询状态*/
    private String queryStatus;

    //分页参数
    private Map<String,Object> searchPageMap;

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

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getQueryLanguage() {
        return queryLanguage;
    }

    public void setQueryLanguage(String queryLanguage) {
        this.queryLanguage = queryLanguage;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public Map<String, Object> getSearchPageMap() {
        return searchPageMap;
    }

    public void setSearchPageMap(Map<String, Object> searchPageMap) {
        this.searchPageMap = searchPageMap;
    }
}
