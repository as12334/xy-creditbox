package so.wwb.creditbox.model.manager.user.so;


import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户查询对象
 *
 * @author jerry
 * @time 2017-3-28 20:34:18
 */
//region your codes 1
public class SysUserExtendSo extends SysUserExtend {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = -7328499688408494207L;
    //endregion your codes 3

    //region your codes 2

    private  Integer hidLength;

    /*多个用户类型*/
    private String[] userTypes;
    /*创建时间开始时间*/
    private Date createTimeBegin;
    /*创建时间结束时间*/
    private Date createTimeEnd;
    /*siteId或者parentId条件是or查询*/
    private Integer orSiteId;
    private Integer orParentId;
    private String shareholderCode;
    private String merchantCode;
    private String agentCode;
    private Map<String, Object> map;

    private Integer[] owner_ids;

    private String userIds;
    private Integer rankId;
    /**
     * 玩家ids
     */
    private List<Integer> ids;

    private List<String> nameList;

    private List<String> subSysCodes;
    /**
     * 用于是否显示返回按钮
     */
    private String hasReturn;
    private Integer shareholderId;
    private Integer merchantId;
    private boolean checkBossUsb;
    private String code;



    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String[] getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(String[] userTypes) {
        this.userTypes = userTypes;
    }

    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
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

    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }


    public Integer[] getUserIds() {
        if(StringTool.isNotBlank(userIds)) {
            List<String> list = new ArrayList<>();
            String[] split = userIds.split(",");
            for (String s : split) {
                if (StringTool.isNotBlank(s)) {
                    list.add(s);
                }
            }
            Integer[] ids = new Integer[list.size()];
            for(int i=0;i<list.size();i++){
                ids[i]=Integer.valueOf(list.get(i));
            }
            return ids;
        }
        return null;
    }

    public void setUserIds(String userId) {
        this.userIds=userIds;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Integer[] getOwner_ids() {
        return owner_ids;
    }

    public void setOwner_ids(Integer[] owner_ids) {
        this.owner_ids = owner_ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public String getHasReturn() {
        return hasReturn;
    }

    public void setHasReturn(String hasReturn) {
        this.hasReturn = hasReturn;
    }

    public Integer getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(Integer shareholderId) {
        this.shareholderId = shareholderId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isCheckBossUsb() {
        return checkBossUsb;
    }

    public void setCheckBossUsb(boolean checkBossUsb) {
        this.checkBossUsb = checkBossUsb;
    }

    public List<String> getSubSysCodes() {
        return subSysCodes;
    }

    public void setSubSysCodes(List<String> subSysCodes) {
        this.subSysCodes = subSysCodes;
    }

    public Integer getHidLength() {
        return hidLength;
    }

    public void setHidLength(Integer hidLength) {
        this.hidLength = hidLength;
    }




    //endregion your codes 2
}