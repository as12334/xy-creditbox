package so.wwb.creditbox.model.message.po;

import org.soul.commons.bean.IEntity;

import java.util.Date;

/**
 * boss->>站点 消息表实体（新）
 * Created by jeremy on 18-3-30.
 */
public class SystemMessage implements IEntity<Integer> {

    private static final long serialVersionUID = 1849001500570020259L;

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CREATE_TIME = "createTime";
    public static final String CREATE_USERNAME = "createUsername";

    public static final String STATUS = "status";
    public static final String READ_STATUS = "readStatus";

    private Integer id;
    private String title;
    private String content;
    private Date createTime;
    private String createUsername;

    /**信息状态(关联system_message_receive字段)*/
    private String status;
    /**阅读状态(关联system_message_receive字段)*/
    private String readStatus;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @org.soul.model.common.Sortable
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }
}
