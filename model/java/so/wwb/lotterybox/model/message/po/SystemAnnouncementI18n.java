package so.wwb.lotterybox.model.message.po;

import org.soul.commons.bean.IEntity;

/**
 * 公告（新）
 * Created by jeremy on 18-3-23.
 */
public class SystemAnnouncementI18n implements IEntity<Integer> {
    private static final long serialVersionUID = -804753340086888206L;
    public static final String PROP_ID = "id";
    public static final String PROP_SYS_ANNOUNCEMENT_ID = "sysAnnouncementId";
    public static final String PROP_CONTENT = "content";
    public static final String PROP_LANGUAGE = "language";




    private Integer id;
    /**公告主键*/
    private Integer sysAnnouncementId;
    /**语言*/
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

    public Integer getSysAnnouncementId() {
        return sysAnnouncementId;
    }

    public void setSysAnnouncementId(Integer sysAnnouncementId) {
        this.sysAnnouncementId = sysAnnouncementId;
    }
}
