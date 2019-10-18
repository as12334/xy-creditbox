package so.wwb.creditbox.model.common;


import java.io.Serializable;

/**
 * 自定义顶部菜单
 *
 * @author jeremy
 * @time 2018年11月16日
 */
public class TopMenuJson implements Serializable {
    private static final long serialVersionUID = -5153111394409763769L;

    private String pageType;
    private String url;
    private String name;
    private String permission;


    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}