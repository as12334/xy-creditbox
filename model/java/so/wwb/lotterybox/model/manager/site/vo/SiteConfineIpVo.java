package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.sys.po.SysParam;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineIp;
import so.wwb.lotterybox.model.manager.site.po.SiteI18n;
import so.wwb.lotterybox.model.manager.site.po.SiteLanguage;
import so.wwb.lotterybox.model.manager.site.so.SiteConfineIpSo;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 限制/允许访问站点/管理中心的IP表值对象
 *
 * @author tony
 * @time 2015-11-13 16:25:18
 */
//region your codes 1
public class SiteConfineIpVo extends BaseObjectVo<SiteConfineIp, SiteConfineIpSo, SiteConfineIpVo.SiteConfineIpQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8939856441035495484L;
    private String type;
    /**
     * 限制类型对应的时间
     */
    private List<String> dateList;

    /**
     * 推荐设置：优惠稽核
     */
    private SysParam audit;

    /**
     * 推荐设置：红利-优惠稽核
     */
    private SysParam bonusAudit;


    /**
     * 是否启用单次奖励
     */
    private SysParam isReward;
    /**
     * 推荐设置：推荐奖励方式：存款金额满
     */
    private SysParam rewardTheWay;
    /**
     * 推荐设置：奖励金额
     */
    private SysParam rewardMoney;
    /**
     * 推荐设置：红利
     */
    private SysParam bonus;
    /**
     * 推荐设置：有效玩家交易量
     */
    private SysParam bonusTrading;
    /**
     *推荐设置：红利上限
     */
    private SysParam bonusBonusMax;
    //推荐内容国际化
    private Map<String,SiteI18n> siteI18nContentMap;
    //推荐规则国际化
    private Map<String,SiteI18n> siteI18nRuleMap;

    //推荐内容国际化
    private List<SiteI18n> siteI18nContentList;
    //推荐规则国际化
    private List<SiteI18n> siteI18nRuleList;
//    /**
//     * 梯度集合
//     */
//    private List<GradientTemp> gradientTempList;
    /**
     * 访问状态
     */
    private String VisitState;
    /**
     * Ip  ---区分是访问限制--跟--站点管理的访问显示 的  新增或者编辑
     */
    private String editOrSaveType;

    /**
     * 梯度ID
     */
    private Integer bonusJsonId;

    private List<SiteLanguage> languageList;
    //endregion your codes 5

    /**
     *  限制/允许访问站点/管理中心的IP表查询逻辑
     */
    public static class SiteConfineIpQuery extends AbstractQuery<SiteConfineIpSo> {

        //region your codes 6
        private static final long serialVersionUID = -3363026351243133443L;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public SysParam getAudit() {
        return audit;
    }

    public void setAudit(SysParam audit) {
        this.audit = audit;
    }

    public SysParam getIsReward() {
        return isReward;
    }

    public void setIsReward(SysParam isReward) {
        this.isReward = isReward;
    }

    public SysParam getRewardTheWay() {
        return rewardTheWay;
    }

    public void setRewardTheWay(SysParam rewardTheWay) {
        this.rewardTheWay = rewardTheWay;
    }

    public SysParam getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(SysParam rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public SysParam getBonus() {
        return bonus;
    }

    public void setBonus(SysParam bonus) {
        this.bonus = bonus;
    }

    public SysParam getBonusTrading() {
        return bonusTrading;
    }

    public void setBonusTrading(SysParam bonusTrading) {
        this.bonusTrading = bonusTrading;
    }

    public SysParam getBonusBonusMax() {
        return bonusBonusMax;
    }

    public void setBonusBonusMax(SysParam bonusBonusMax) {
        this.bonusBonusMax = bonusBonusMax;
    }

    public String getVisitState() {
        return VisitState;
    }

    public void setVisitState(String visitState) {
        VisitState = visitState;
    }

//    public List<GradientTemp> getGradientTempList() {
//        return gradientTempList;
//    }
//
//    public void setGradientTempList(List<GradientTemp> gradientTempList) {
//        this.gradientTempList = gradientTempList;
//    }
//


    public SysParam getBonusAudit() {
        return bonusAudit;
    }

    public void setBonusAudit(SysParam bonusAudit) {
        this.bonusAudit = bonusAudit;

  }

    public Integer getBonusJsonId() {
        return bonusJsonId;
    }

    public void setBonusJsonId(Integer bonusJsonId) {
        this.bonusJsonId = bonusJsonId;
    }

    public List<SiteLanguage> getLanguageList() {
        return languageList;
    }

    public Map<String, SiteI18n> getSiteI18nRuleMap() {
        return siteI18nRuleMap;
    }

    public void setSiteI18nRuleMap(Map<String, SiteI18n> siteI18nRuleMap) {
        this.siteI18nRuleMap = siteI18nRuleMap;
    }

    public Map<String, SiteI18n> getSiteI18nContentMap() {
        return siteI18nContentMap;
    }

    public void setSiteI18nContentMap(Map<String, SiteI18n> siteI18nContentMap) {
        this.siteI18nContentMap = siteI18nContentMap;
    }

    public void setLanguageList(List<SiteLanguage> languageList) {
        this.languageList = languageList;
    }

    public List<SiteI18n> getSiteI18nContentList() {
        return siteI18nContentList;
    }

    public void setSiteI18nContentList(List<SiteI18n> siteI18nContentList) {
        this.siteI18nContentList = siteI18nContentList;
    }

    public List<SiteI18n> getSiteI18nRuleList() {
        return siteI18nRuleList;
    }

    public void setSiteI18nRuleList(List<SiteI18n> siteI18nRuleList) {
        this.siteI18nRuleList = siteI18nRuleList;
    }

    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEditOrSaveType() {
        return editOrSaveType;
    }

    public void setEditOrSaveType(String editOrSaveType) {
        this.editOrSaveType = editOrSaveType;
    }
//endregion your codes 4

}