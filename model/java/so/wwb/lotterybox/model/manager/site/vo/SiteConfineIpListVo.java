package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.IpTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import org.soul.model.sys.po.SysParam;
import so.wwb.lotterybox.model.enums.site.SiteConfineStatusEnum;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineArea;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineIp;
import so.wwb.lotterybox.model.manager.site.so.SiteConfineIpSo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * 限制/允许访问站点/管理中心的IP表列表页值对象
 *
 * @author tony
 * @time 2015-11-13 16:25:18
 */
//region your codes 1
public class SiteConfineIpListVo extends BaseListVo<SiteConfineIp, SiteConfineIpSo, SiteConfineIpListVo.SiteConfineIpQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7407103874787208987L;
    private Map<String, Serializable> status;
    private String type;
    private SysParam sysParam;
    private long total;
    private Integer confineIpId;
    /**
     *  获取当前站点去查找这个站点属于boss、股东、商户
     */
    private  String userSubsysCode;
    //endregion your codes 5

    /**
     *  限制/允许访问站点/管理中心的IP表列表查询逻辑
     */
    public static class SiteConfineIpQuery extends AbstractQuery<SiteConfineIpSo> {

        //region your codes 6
        private static final long serialVersionUID = -2421934457178477070L;

        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = new Criteria();
            criteria.addAnd(SiteConfineIp.PROP_TYPE, Operator.EQ, searchObject.getType()).addAnd(SiteConfineIp.PROP_SITE_ID,Operator.EQ,searchObject.getSiteId());
            criteria.addAnd(SiteConfineIp.PROP_START_IP, Operator.LE, searchObject.getEndIp()).addAnd(SiteConfineIp.PROP_END_IP, Operator.GE, searchObject.getStartIp());
            if (StringTool.isNotBlank(searchObject.getSearchIp())) {
                criteria.addAnd(SiteConfineIp.PROP_START_IP, Operator.LE, IpTool.ipv4StringToLong(searchObject.getSearchIp())).addAnd(SiteConfineIp.PROP_END_IP, Operator.GE, IpTool.ipv4StringToLong(searchObject.getSearchIp()));
            }
            if (searchObject.getStatus() != null) {
                if (searchObject.getStatus().equals(SiteConfineStatusEnum.USING.getCode())) {
                    //使用中
                    criteria.addAnd(SiteConfineArea.PROP_END_TIME, Operator.GT, new Date());
                } else if (searchObject.getStatus().equals(SiteConfineStatusEnum.EXPIRED.getCode())) {
                    criteria.addAnd(SiteConfineArea.PROP_END_TIME, Operator.LT, new Date());
                }
            }
            criteria.addAnd(SiteConfineIp.PROP_CREATE_USER,Operator.EQ,searchObject.getCreateUser());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3


        @Override
        public Sort getDefaultSort() {
            return Sort.add(SiteConfineArea.PROP_CREATE_TIME, Direction.DESC);
        }
        //endregion your codes 3
    }

    //region your codes 4
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Map<String, Serializable> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Serializable> status) {
        this.status = status;
    }

    public SysParam getSysParam() {
        return sysParam;
    }

    public void setSysParam(SysParam sysParam) {
        this.sysParam = sysParam;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    //endregion your codes 4

    public Integer getConfineIpId() {
        return confineIpId;
    }

    public void setConfineIpId(Integer confineIpId) {
        this.confineIpId = confineIpId;
    }

    public String getUserSubsysCode() {
        return userSubsysCode;
    }

    public void setUserSubsysCode(String userSubsysCode) {
        this.userSubsysCode = userSubsysCode;
    }
}