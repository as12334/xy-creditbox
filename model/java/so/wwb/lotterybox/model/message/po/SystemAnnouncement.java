package so.wwb.lotterybox.model.message.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.lang.string.StringTool;

import java.util.Date;

import static org.soul.commons.lang.string.StringTool.replaceHtml;

/**
 * 公告（新）
 * Created by jeremy on 18-3-22.
 */
public class SystemAnnouncement implements IEntity<Integer> {

    private static final long serialVersionUID = -1042290265478177003L;
    public static final String PROP_ID = "id";
    public static final String PROP_CREATE_TIME = "createTime";
    public static final String PROP_CREATE_USERNAME = "createUsername";
    public static final String PROP_STATUS = "status";
    public static final String PROP_UPDATE_TIME = "updateTime";
    public static final String PROP_UPDATE_USERNAME = "updateUsername";
    /**主键*/
    private Integer id;
    /**发布人*/
    private String createUsername;
    /**发布时间*/
    private Date createTime;
    /**修改人*/
    private String updateUsername;
    /**修改时间*/
    private Date updateTime;
    /**状态：0正常、1删除*/
    private String status;
    /**语言版本*/
    private String language;
    /**内容*/
    private String content;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }
    @org.soul.model.common.Sortable
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回Html的文字内容
     * @return
     */
    public String getContentText(){
        return replaceHtml(this.content);
    }
    public String getShortContentText20(){
        String text= StringTool.replaceHtml(this.content);
        text = handleNull(text);
        return text.length()>20?text.substring(0,20)+"...":text;
    }
    private String handleNull(String text) {
        text = (StringTool.isNotBlank(text))?text:"";
        return text;
    }
    public String getShortContentText50(){
        String text= StringTool.replaceHtml(this.content);
        text = handleNull(text);
        return text.length()>50?text.substring(0,50)+"...":text;
    }
    public String getShortContentText100(){
        String text= StringTool.replaceHtml(this.content);
        text = handleNull(text);
        return text.length()>100?text.substring(0,100)+"...":text;
    }
    public String getShortContentText80(){
        String text= StringTool.replaceHtml(this.content);
        text = handleNull(text);
        return text.length()>80?text.substring(0,80)+"...":text;
    }
}
