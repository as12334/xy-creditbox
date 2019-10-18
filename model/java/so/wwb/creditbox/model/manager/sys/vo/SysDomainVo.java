package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.sys.po.SysParam;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.so.SysDomainSo;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * 站长域名表-修改完会替换 sys_domain值对象
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public class SysDomainVo extends BaseObjectVo<SysDomain, SysDomainSo, SysDomainVo.SysDomainQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7725369463489484696L;

    private Collection<SysParam> domainTypes;

    private List<Map<String,Object>> playerRanks;
    private List<Map<String,Object>> domainRanks;
    //表单验证需要
    private String rankType;

    private List<Integer> ids;

    private String indexName;
    private String indexPageUrl;
    private String indexDomain;
    private List<Integer> rankIds;

    private String managerName;
    private String managerPageUrl;
    private String managerDomain;
    /*前端展示设置*/
    /**
     * 系统参数 前台是否显示备用网址页面
     */
    private SysParam sysParam;
    private List<SysDomain> domains;
    private List<Integer> changeStatusFalse;
//    private List<CttDomainRank> editDomainRanks;

    private String agentUserName;
    //域名类型
    private String domainPlatform;

    private List<Integer> domainIds;

    private boolean saveManageDomain;
    //endregion your codes 5

    /**
     *  站长域名表-修改完会替换 sys_domain查询逻辑
     */
    public static class SysDomainQuery extends AbstractQuery<SysDomainSo> {

        //region your codes 6
        private static final long serialVersionUID = -7816953551566058099L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    public List<Integer> getRankIds() {
        return rankIds;
    }

    public void setRankIds(List<Integer> rankIds) {
        this.rankIds = rankIds;
    }

    public Collection<SysParam> getDomainTypes() {
        return domainTypes;
    }

    public void setDomainTypes(Collection<SysParam> domainTypes) {
        this.domainTypes = domainTypes;
    }

    public List<Map<String, Object>> getPlayerRanks() {
        return playerRanks;
    }

    public void setPlayerRanks(List<Map<String, Object>> playerRanks) {
        this.playerRanks = playerRanks;
    }

    public List<Map<String, Object>> getDomainRanks() {
        return domainRanks;
    }

    public void setDomainRanks(List<Map<String, Object>> domainRanks) {
        this.domainRanks = domainRanks;
    }

    public String getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = rankType;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public SysParam getSysParam() {
        return sysParam;
    }

    public void setSysParam(SysParam sysParam) {
        this.sysParam = sysParam;
    }

    public List<SysDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<SysDomain> domains) {
        this.domains = domains;
    }

    public List<Integer> getChangeStatusFalse() {
        return changeStatusFalse;
    }

    public void setChangeStatusFalse(List<Integer> changeStatusFalse) {
        this.changeStatusFalse = changeStatusFalse;
    }

//    public List<CttDomainRank> getEditDomainRanks() {
//        return editDomainRanks;
//    }
//
//    public void setEditDomainRanks(List<CttDomainRank> editDomainRanks) {
//        this.editDomainRanks = editDomainRanks;
//    }

    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexPageUrl() {
        return indexPageUrl;
    }

    public void setIndexPageUrl(String indexPageUrl) {
        this.indexPageUrl = indexPageUrl;
    }

    public String getIndexDomain() {
        return indexDomain;
    }

    public void setIndexDomain(String indexDomain) {
        this.indexDomain = indexDomain;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPageUrl() {
        return managerPageUrl;
    }

    public void setManagerPageUrl(String managerPageUrl) {
        this.managerPageUrl = managerPageUrl;
    }

    public String getManagerDomain() {
        return managerDomain;
    }

    public void setManagerDomain(String managerDomain) {
        this.managerDomain = managerDomain;
    }

    public String getDomainPlatform() {
        return domainPlatform;
    }

    public void setDomainPlatform(String domainPlatform) {
        this.domainPlatform = domainPlatform;
    }

    public List<Integer> getDomainIds() {
        return domainIds;
    }

    public void setDomainIds(List<Integer> domainIds) {
        this.domainIds = domainIds;
    }

    public boolean isSaveManageDomain() {
        return saveManageDomain;
    }

    public void setSaveManageDomain(boolean saveManageDomain) {
        this.saveManageDomain = saveManageDomain;
    }
    //endregion your codes 4

}