package so.wwb.creditbox.model.message.po;

import org.soul.commons.bean.IEntity;

/**
 * boss->>站点 息接收表实体(新)
 * Created by jeremy on 18-3-31.
 */
public class SystemMessageReceive implements IEntity<Integer> {


    private static final long serialVersionUID = 1583238537597506480L;


    public static final String ID = "id";
    public static final String MESSAGE_ID = "messageId";
    public static final String RECEIVER_USER_ID = "receiverUserId";
    public static final String RECEIVER_USERNAME = "receiverUsername";
    public static final String STATUS = "status";
    public static final String READ_STATUS = "readStatus";

    private Integer id;
    /**信息表id*/
    private Integer messageId;
    /**接收者id*/
    private Integer receiverUserId;
    /**接收者账户名*/
    private String receiverUsername;
    /**信息状态*/
    private String status;
    /**阅读状态*/
    private String readStatus;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(Integer receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
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
