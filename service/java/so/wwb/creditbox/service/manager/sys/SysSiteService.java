package so.wwb.creditbox.service.manager.sys;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.sys.SysSiteMapper;
import so.wwb.creditbox.iservice.manager.sys.ISysSiteService;
import so.wwb.creditbox.model.enums.sys.SysSiteStatusEnum;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteListVo;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SysSiteService extends BaseService<SysSiteMapper, SysSiteListVo, SysSiteVo, SysSite, Integer> implements ISysSiteService {

    @Override
    public boolean insertSysSite(SysSite sysSite) {
        return this.mapper.insert(sysSite);
    }

    /**
     * 查询是否可转站
     *
     * @param sysSiteVo
     * @return
     */
    public SysSite getSiteImport(SysSiteVo sysSiteVo) {
        Criteria criteria = Criteria.add(SysSite.PROP_ID, Operator.EQ, sysSiteVo.getSearch().getId());
        List<SysSite> siteList = mapper.search(criteria);
        if (siteList != null && siteList.size() == 1) {
            SysSite site = siteList.get(0);
            if (site.getImportPlayersTime() == null) {
                return null;
            }
            Date now = new Date();
            if (now.getTime() > site.getImportPlayersTime().getTime()) {
                return null;
            }
            return site;
        } else {
            return null;
        }
    }

    /**
     * 获取所有正常的站点,不包括运营商和BOSS
     *
     * @param listVo
     * @return
     * @River
     */
    public List<SysSite> getAllNormalSite(SysSiteListVo listVo) {
        Criteria criteria = listVo.getQuery().getAllNormalSite();
        List<SysSite> list = mapper.search(criteria, Order.asc(SysSite.PROP_ID));
        return list;
    }

    @Override
    public Map<String, SysSite> load(SysSiteVo sysSiteVo) {
        List<SysSite> sysSites = mapper.allSearch();
        return CollectionTool.toEntityMap(sysSites, SysSite.PROP_ID, String.class);
    }

    @Override
    public String searchUserCode(SysSiteVo sysSiteVo) {
        String code = mapper.searchUserCode(sysSiteVo.getSearch());
        return code;
    }

    @Override
    public Boolean isShardholderSite(SysSiteVo sysSiteVo) {
        boolean isShardholderSite = false;
        Integer count = mapper.isShardholderSite(sysSiteVo);
        if(count == 1){
            isShardholderSite = true;
        }
        return isShardholderSite;
    }


    @Override
    public SysSite searchCodeToid(SysSiteListVo sysSiteListVo) {
        SysSite sysSite = mapper.searchCodeToid(sysSiteListVo.getSearch().getCode());
        return sysSite;
    }

    @Override
    public List<SysSite> getAllSysSite(){
        List<SysSite> list= this.mapper.search(new SysSiteListVo().getQuery().getCriteriaByStatus());
        return list;
    }

    @Override
    public String checkSiteCode(SysSiteVo sysSiteVo){
        List<SysSite> list= this.mapper.search(sysSiteVo.getQuery().getCheckCode());
        String isExist = "true";
        if (CollectionTool.isNotEmpty(list) && list.size() > 0) {
            isExist = "false";
        }
        return isExist;
    }

    @Override
    public String checkSiteId(SysSiteVo sysSiteVo){
        List<SysSite> list= this.mapper.search(sysSiteVo.getQuery().getCriteria());
        String isExist = "true";
        if (CollectionTool.isNotEmpty(list) && list.size() > 0) {
            isExist = "false";
        }
        return isExist;
    }

    @Override
    public List<SysSite> getGroupSysSite(Integer[] sites) {
        if (sites != null) {
            Criteria criteria = Criteria.add(SysSite.PROP_ID, Operator.NOT_IN, sites);
            criteria.addAnd(SysSite.PROP_STATUS, Operator.EQ, SysSiteStatusEnum.NORMAL.getCode());
            return this.mapper.search(criteria);
        }
        return null;
    }

    //endregion your codes 2

}