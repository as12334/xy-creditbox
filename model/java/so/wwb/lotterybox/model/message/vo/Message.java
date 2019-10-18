package so.wwb.lotterybox.model.message.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import so.wwb.lotterybox.model.enums.message.SystemMessageSendObjectEnum;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message implements Serializable {
    private List<Serializable> userIdList;
    private String cometSubscribeType;
    private Map<String, Object> msgMap;
    private String messageSendTypeEnum;

    public Map<String, Object> getMsgMap() {
        return msgMap;
    }

    public void setMsgMap(Map<String, Object> msgMap) {
        this.msgMap = msgMap;
    }

    public String getMessageSendTypeEnum() {
        return messageSendTypeEnum;
    }

    public void setMessageTypeEnum(String messageSendTypeEnum) {
        this.messageSendTypeEnum = messageSendTypeEnum;
    }

    public Message() {
    }

    @JsonIgnore
    public Message(List<Serializable> userIdList, String msg, CometSubscribeType cometSubscribeType, SystemMessageSendObjectEnum systemMessageSendObjectEnum) {
        this.setUserIdList(userIdList);
        this.setSubscribeType(cometSubscribeType.getCode());
        this.setMessageTypeEnum(systemMessageSendObjectEnum.getCode());

        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(new Date(), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("message", msg);
        this.setMsgMap(map);
    }

    @JsonIgnore
    public Message(List<Serializable> userIdList, String msg, String cometSubscribeType, String messageSendTypeEnum) {
        this.setUserIdList(userIdList);
        this.setSubscribeType(cometSubscribeType);
        this.setMessageTypeEnum(messageSendTypeEnum);

        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(new Date(), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("message", msg);
        this.setMsgMap(map);
    }

    public List<Serializable> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Serializable> userIdList) {
        this.userIdList = userIdList;
    }

    public String getSubscribeType() {
        return cometSubscribeType;
    }

    public void setSubscribeType(String cometSubscribeType) {
        this.cometSubscribeType = cometSubscribeType;
    }

    @JsonIgnore
    public String getMsgDetail() {
        if (null == msgMap) return "";
        return msgMap.get("message").toString();
    }

    @JsonIgnore
    public Object getMsgBody() {
        if (msgMap != null) return JsonTool.toJson(msgMap);
        return null;
    }

    @JsonIgnore
    public String getMsgDate() {
        if (null == msgMap) return "";
        return msgMap.get("date").toString();
    }
}
