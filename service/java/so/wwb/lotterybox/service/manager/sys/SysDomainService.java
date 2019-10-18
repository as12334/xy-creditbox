package so.wwb.lotterybox.service.manager.sys;

import org.soul.commons.cache.CacheTool;
import org.soul.commons.exception.ServiceException;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.BaseVo;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.data.manager.sys.SysDomainMapper;
import so.wwb.lotterybox.iservice.manager.sys.ISysDomainService;
import so.wwb.lotterybox.iservice.manager.sys.ISysSiteService;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.enums.sys.ResolveStatusEnum;
import so.wwb.lotterybox.model.enums.sys.SysUserTypeEnum;
import so.wwb.lotterybox.model.manager.sys.po.SysDomain;
import so.wwb.lotterybox.model.manager.sys.po.VSysDomain;
import so.wwb.lotterybox.model.manager.sys.vo.SysDomainListVo;
import so.wwb.lotterybox.model.manager.sys.vo.SysDomainVo;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;
import so.wwb.lotterybox.model.manager.sys.vo.VSysDomainVo;

import java.text.MessageFormat;
import java.util.*;


/**
 * 站长域名表-修改完会替换 sys_domain服务
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public class SysDomainService extends BaseService<SysDomainMapper, SysDomainListVo, SysDomainVo, SysDomain, Integer> implements ISysDomainService {

    @Autowired
    ISysSiteService sysSiteService;
    @Override
    public SysDomainListVo setting(SysDomainListVo sysDomainListVo) {
        Criteria.add(SysDomain.PROP_SUBSYS_CODE, Operator.EQ, true);
        return null;
    }


    @Override
    public int batchUpdateStatusToFalse(SysDomainVo sysDomainVo) {
        Map map = new HashMap(1);
        map.put(SysDomain.PROP_IS_DEFAULT, false);
        return mapper.batchUpdateProperties(Criteria.add(SysDomain.PROP_IS_DEFAULT, Operator.EQ, true)
                .addAnd(SysDomain.PROP_SITE_ID, Operator.EQ, sysDomainVo.getResult().getSiteId())
                .addAnd(SysDomain.PROP_IS_DELETED, Operator.EQ, false)
                .addAnd(SysDomain.PROP_SUBSYS_CODE, Operator.EQ, sysDomainVo.getResult().getSubsysCode())
                , map);
    }


    @Transactional
    public SysDomainVo batchSaveDomain(SysDomainVo sysDomainVo) {
        if(sysDomainVo.getResult() ==null){
                throw new ServiceException(Module.DOMAIN, "域名生成参数有误!");
        }
        //默认域名
        if(sysDomainVo.getResult().getIsDefault() !=null && sysDomainVo.getResult().getIsDefault()){
            batchUpdateStatusToFalse(sysDomainVo);
        }
            SysSiteVo sysSiteVo = new SysSiteVo();
            sysSiteVo.getSearch().setId(sysDomainVo._getSiteId());
            sysSiteVo = sysSiteService.get(sysSiteVo);
        String domains = sysDomainVo.getResult().getDomain();
        String[] splitUrl = domains.split(",");
        for (String subDomain: splitUrl) {
            List<SysDomain> list = new ArrayList<>();
            sysDomainVo.getResult().setDomain(subDomain);
            list.add(sysDomainVo.getResult());
            this.mapper.batchInsert(list);
        }

        return sysDomainVo;
    }


    /**
     * 检查域名是否存在 false是存在
     *
     * @param sysDomainVo
     * @return
     */
    public String checkDomainExists(SysDomainVo sysDomainVo) {
        String domain = sysDomainVo.getSearch().getDomain();
        if (StringTool.isNotBlank(domain)) {
            String[] urls = domain.split(",");
            String result = "true";
            if (urls.length > 1){
                for (int i = 0; i < urls.length; i++) {
                    for (int j = 0; j < urls.length; j++) {
                        if (StringTool.equals(urls[i], urls[j]) && i != j) {
                            result = "false";
                            break;
                        }
                    }
                }
            }
            if (StringTool.equals(result, "false")) {
                return result;
            }

            for (int i = 0; i < urls.length; i++) {
                Criteria criteria = Criteria.add(SysDomain.PROP_DOMAIN, Operator.EQ, urls[i]);
                criteria.addAnd(SysDomain.PROP_IS_DELETED, Operator.EQ, false);
                long count = mapper.count(criteria);
                if (count > 0) {
                    result = "false";
                    break;
                }
            }
            return result;
        } else {
            return "false";
        }
    }

    @Override
    public void updateNameAndIsDefault(SysDomainVo sysDomainVo) {
        //如果是默认，去除其他默认
        if (sysDomainVo.getResult().getIsDefault() != null && sysDomainVo.getResult().getIsDefault()) {
            batchUpdateStatusToFalse(sysDomainVo);
        }
        this.mapper.updateOnly(sysDomainVo.getResult(), sysDomainVo.getProperties());
    }


    public SysDomainVo saveAgentDomain(VSysDomainVo objectVo) {
        VSysDomain vSysDomain = objectVo.getResult();
        SysDomain domain = new SysDomain();
        domain.setDomain(vSysDomain.getDomain());
        domain.setName(vSysDomain.getName());
        domain.setSysUserId(vSysDomain.getSysUserId());//代理ID
        domain.setPageUrl("?token={0}"); //代理只能添加游戏中心域名，页面Url有固定的
        domain.setCreateTime(new Date());
        domain.setIsDeleted(false);
        domain.setBuildIn(false);
        domain.setSiteId(objectVo.getResult().getSiteId());
        domain.setSubsysCode(SysUserTypeEnum.AGENT.getCode());
        domain.setCreateUser(objectVo._getUserId());
        domain.setIsEnable(false);
        domain.setResolveStatus(ResolveStatusEnum.TOBEBOUND.getCode());
        SysDomainVo domainVo = new SysDomainVo();
        domainVo.setResult(domain);
        return domainVo;
    }
    @Override
    public BaseVo refreshSiteAvailableCache(Integer siteId, String cachePrefix, String status) {
        SysDomainVo vo = new SysDomainVo();
        Map condition=new HashMap();
        condition.put(SysDomain.PROP_SITE_ID,siteId);
        condition.put(SysDomain.PROP_RESOLVE_STATUS,status);
        List<Map<String,Object>> domains = this.mapper.andSearch(condition);
        for (Map<String, Object> domainObj : domains) {
            String domain = (String) domainObj.get(SysDomain.PROP_DOMAIN);
            String key= MessageFormat.format("{0}:{1}", CacheKey.CACHE_KEY_DOMAIN,domain);
            CacheTool.load(new String[]{key});
        }
        vo.setSuccess(true);
        return vo;
    }

    @Override
    public boolean insertSysDomain(SysDomain sysDomain) {
        return this.mapper.insert(sysDomain);
    }

}