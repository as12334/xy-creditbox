package so.wwb.creditbox.model.manager.user.vo;


import org.apache.zookeeper.Op;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.so.SysUserExtendSo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 系统用户列表页值对象
 *
 * @author jerry
 * @time 2017-3-28 20:34:18
 */
//region your codes 1
public class SysUserExtendListVo extends BaseListVo<SysUserExtend, SysUserExtendSo, SysUserExtendListVo.SysUserExtendQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -9168578650361253314L;
    /*用户类型*/
    private String[] userTypes = null;
    private Integer dataSourceId;
    private Double money;
    private Boolean siteErr;
    private String lastTimeSearch;
    //endregion your codes 5

    /**
     * 系统用户列表查询逻辑
     */
    public static class SysUserExtendQuery extends AbstractQuery<SysUserExtendSo> {

        //region your codes 6
        private static final long serialVersionUID = -6323236097163129385L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(SysUserExtend.PROP_USER_TYPE, Operator.EQ, searchObject.getUserType());
            criteria.addAnd(SysUserExtend.PROP_USER_TYPE, Operator.IN, searchObject.getUserTypes());
            criteria.addAnd(SysUserExtend.PROP_CREATE_TIME, Operator.GE, searchObject.getCreateTimeBegin());
            criteria.addAnd(SysUserExtend.PROP_CREATE_TIME, Operator.LE, searchObject.getCreateTimeEnd());
            criteria.addAnd(SysUserExtend.PROP_LAST_LOGIN_IP, Operator.EQ, searchObject.getLastLoginIp());
            criteria.addAnd(SysUserExtend.PROP_OWNER_ID, Operator.EQ, searchObject.getOwnerId());
            criteria.addAnd(SysUserExtend.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId());
            criteria.addAnd(SysUserExtend.PROP_STATUS,Operator.EQ,searchObject.getStatus());
            criteria.addAnd(SysUserExtend.PROP_ID,Operator.IN,searchObject.getUserIds());
            criteria.addAnd(SysUserExtend.PROP_USER_TYPE, Operator.EQ,searchObject.getUserType());
            //api一起遍历
            if(CollectionTool.isNotEmpty(searchObject.getSubSysCodes())){
                criteria.addAnd(SysUserExtend.PROP_SUBSYS_CODE, Operator.IN, searchObject.getSubSysCodes());
            }else{
                criteria.addAnd(SysUserExtend.PROP_SUBSYS_CODE, Operator.EQ, searchObject.getSubsysCode());
            }

            //子账号
            if(searchObject.isCheckBossUsb()){
                criteria.addOr(Criteria.add(SysUserExtend.PROP_ID, Operator.EQ, this.searchObject.getId())
                        , Criteria.add(SysUserExtend.PROP_CREATE_USER, Operator.EQ, searchObject.getCreateUser()));
            }else{
                criteria.addAnd(SysUserExtend.PROP_CREATE_USER, Operator.EQ, searchObject.getCreateUser());
                criteria.addAnd(SysUserExtend.PROP_ID,Operator.EQ, searchObject.getId());
            }

            if(CollectionTool.isNotEmpty(this.searchObject.getNameList())){
                criteria.addAnd(SysUserExtend.PROP_USERNAME,Operator.IN,this.searchObject.getNameList());
            }else {
                criteria.addAnd(SysUserExtend.PROP_USERNAME,Operator.LIKE,this.searchObject.getUsername());
            }
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        @Override
        public Sort getDefaultSort() {
            return Sort.add(SysUserExtend.PROP_ID, Direction.DESC);
        }

        //endregion your codes 3
    }

    //region your codes 4
    public Integer getDataSourceId() {
        _setDataSourceId(dataSourceId);
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
        _setDataSourceId(dataSourceId);
        this.dataSourceId = dataSourceId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boolean getSiteErr() {
        return siteErr;
    }

    public void setSiteErr(Boolean siteErr) {
        this.siteErr = siteErr;
    }

    public String getLastTimeSearch() {
        return this.lastTimeSearch;
    }

    public void setLastTimeSearch(String lastTimeSearch) {
        this.lastTimeSearch=lastTimeSearch;
    }

    public String getLastTimeSearchToJson() {
        String search = JsonTool.toJson(this.getSearch());
        this.lastTimeSearch=search;
        search= "\'" + search.replace("\"", "\'") + "\'";
        Pattern pattern= compile("'\\w+?':null(,|(?=}))");
        Matcher matcher = pattern.matcher(search);
        search = matcher.replaceAll("").replace(",}","}");
        return search;
    }
    //endregion your codes 4

}