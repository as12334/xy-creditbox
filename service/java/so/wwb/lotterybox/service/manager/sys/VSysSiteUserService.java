package so.wwb.lotterybox.service.manager.sys;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.service.support.BaseService;
import so.wwb.lotterybox.data.manager.sys.VSysSiteUserMapper;
import so.wwb.lotterybox.iservice.manager.sys.IVSysSiteUserService;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteUser;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteUserListVo;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteUserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户站点表服务
 *
 * @author longer
 * @time Nov 17, 2015 2:22:29 PM
 */
public class VSysSiteUserService extends BaseService<VSysSiteUserMapper, VSysSiteUserListVo, VSysSiteUserVo, VSysSiteUser, Integer> implements IVSysSiteUserService {

    @Override
    public Map<String,VSysSiteUser> load(VSysSiteUserVo vSysSiteUserVo){
        List<VSysSiteUser> list = this.mapper.search(Criteria.add(VSysSiteUser.PROP_STATUS, Operator.EQ, SysUserStatus.NORMAL.getCode()),
                Order.asc(VSysSiteUser.PROP_CENTER_ID), Order.asc(VSysSiteUser.PROP_SYS_USER_ID));
        return CollectionTool.toEntityMap(list, VSysSiteUser.PROP_CACHE_KEY,String.class);
    }

    @Override
    public VSysSiteUserListVo queryCenters(VSysSiteUserListVo listVo) {
        Criteria criteria = Criteria.add(VSysSiteUser.PROP_SUBSYS_CODE, Operator.EQ, SubSysCodeEnum.SHAREHOLDER.getCode());
        criteria.addAnd(VSysSiteUser.PROP_ID, Operator.LT, 0);
        listVo.setResult(this.mapper.search(criteria, Order.desc(VSysSiteUser.PROP_ID)));
        return listVo;
    }

    @Override
    public VSysSiteUser queryCenter(VSysSiteUserVo vo) {
        Criteria criteria = Criteria.add(VSysSiteUser.PROP_SUBSYS_CODE, Operator.EQ, SubSysCodeEnum.SHAREHOLDER.getCode());
        criteria.addAnd(VSysSiteUser.PROP_SYS_USER_ID, Operator.EQ, vo.getSearch().getSysUserId());
        List<VSysSiteUser> users = this.mapper.pagingSearch(criteria, 1, 1);
        if (CollectionTool.isNotEmpty(users))
            return users.get(0);
        return null;
    }

    @Override
    public List<VSysSiteUser> queryMerchantsBySiteId(Integer siteId) {
        List<String> list=new ArrayList<>();
        list.add(SubSysCodeEnum.COMPANY.getCode());
        return this.mapper.search(
                Criteria.add(VSysSiteUser.PROP_ID, Operator.EQ, siteId)
                        .addAnd(VSysSiteUser.PROP_SUBSYS_CODE,Operator.IN, list)
        );
    }

}