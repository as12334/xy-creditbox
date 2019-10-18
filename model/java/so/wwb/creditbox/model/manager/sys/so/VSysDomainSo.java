package so.wwb.creditbox.model.manager.sys.so;


import so.wwb.creditbox.model.manager.sys.po.VSysDomain;

import java.util.List;

/**
 * 域名视图查询对象
 *
 * @author cherry
 * @time 2017-4-3 15:11:07
 */
//region your codes 1
public class VSysDomainSo extends VSysDomain {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = 8813097869762312433L;
    private Integer userId;
    private int pageSize;
    private int pageNo;
    private List<String> typeList;

    private String[] subSysCodes;
    /*域名类型*/
    private String[] types;
    /*指向地址*/
    private String[] pageUrls;

    /**
     * 用于or条件查询的siteId或parent_id
     */
    private Integer orSiteId;

    private Integer orParentId;

   private String pageType;

    public String[] getSubSysCodes() {
        return subSysCodes;
    }

    public void setSubSysCodes(String[] subSysCodes) {
        this.subSysCodes = subSysCodes;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getPageUrls() {
        return pageUrls;
    }

    public void setPageUrls(String[] pageUrls) {
        this.pageUrls = pageUrls;
    }

    public Integer getOrSiteId() {
        return orSiteId;
    }

    public void setOrSiteId(Integer orSiteId) {
        this.orSiteId = orSiteId;
    }

    public Integer getOrParentId() {
        return orParentId;
    }

    public void setOrParentId(Integer orParentId) {
        this.orParentId = orParentId;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    //endregion your codes 2
}