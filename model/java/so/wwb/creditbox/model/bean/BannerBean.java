package so.wwb.creditbox.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import so.wwb.creditbox.model.manager.lottery.bean.BaseBean;

/**
 * 轮播图Beans
 * Create by Fei on 2018-01-17
 */
public class BannerBean extends BaseBean {

    private String name;
    private String cover;
    private String link;
    @JsonIgnore
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
