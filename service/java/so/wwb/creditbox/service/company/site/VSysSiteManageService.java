package so.wwb.creditbox.service.company.site;

import org.soul.commons.bean.BeanTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.sys.po.SysParam;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.data.manager.sys.VSysSiteManageMapper;
import so.wwb.creditbox.iservice.manager.sys.ISysDomainService;
import so.wwb.creditbox.iservice.manager.sys.ISysSiteService;
import so.wwb.creditbox.iservice.manager.sys.IVSysSiteManageService;
import so.wwb.creditbox.iservice.manager.user.ISysUserExtendService;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.common.ModeEnum;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.enums.base.BossParamEnum;
import so.wwb.creditbox.model.enums.base.StatusEnum;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.sys.ResolveStatusEnum;
import so.wwb.creditbox.model.enums.sys.SysSiteStatusEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.Nav;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class VSysSiteManageService extends BaseService<VSysSiteManageMapper, VSysSiteManageListVo, VSysSiteManageVo, VSysSiteManage, Integer> implements IVSysSiteManageService {
    @Autowired
    private ISysSiteService sysSiteService;
    @Autowired
    private ISysDomainService sysDomainService;
    @Autowired
    private ISysUserExtendService sysUserExtendService;


    @Override
    @Transactional
    public VSysSiteManageVo saveBuildSite(VSysSiteManageVo siteBasic) {
        // 保存站点表sys_site
        SysSite sysSite = saveSysSite(siteBasic);
        Integer masterSiteId = sysSite.getId();
        //填充siteId到sys_user_extend
        this.fillSiteIdToSysUserExtend(masterSiteId, sysSite.getSysUserId(),sysSite.getCode());
        // 保存 临时站点域名信息
        this.saveSysDomain(siteBasic, masterSiteId, sysSite.getSysUserId(),siteBasic.getResult().getCode());
        siteBasic.getResult().setId(masterSiteId);
        siteBasic.setSysSite(sysSite);
        //运行站点赔率函数
        if(SubSysCodeEnum.COMPANY == EnumTool.enumOf(SubSysCodeEnum.class,siteBasic.getSubCode())) {
            //todo 暫時不執行函數
//            mapper.doInitSiteData(siteBasic.getResult());
        }
        return siteBasic;
    }

    @Override
    @Transactional
    public VSysSiteManageVo saveBuildSiteMch(VSysSiteManageVo siteBasic) {
        siteBasic = saveBuildSite(siteBasic);
        // 新增默认代理
//        createDefaultAgent(siteBasic);
        return siteBasic;
    }


    @Override
    public List<Nav> getAllMenus(SysResourceVo o) {
        return mapper.getAllMenus(o.getSearch());
    }

//    /**
//     * 创建默认代理
//     *
//     * @param siteBasic
//     */
//    private void createDefaultAgent(VSysSiteManageVo siteBasic) {
//        SysSite sysSite = siteBasic.getSysSite();
//        SysUserExtend sysUserExtend = new SysUserExtend();
//        sysUserExtend.setUsername(APIConst.DEFAULT_DISTRIBUTOR_ACCOUNT + "@" + sysSite.getCode());
//        sysUserExtend.setRealName("默认总代");
//        sysUserExtend.setPassword(AuthTool.md5SysUserPassword(APIConst.DEFAULT_DISTRIBUTOR_PWD, APIConst.DEFAULT_DISTRIBUTOR_ACCOUNT + "@" + sysSite.getCode()));
//        sysUserExtend.setStatus(StatusEnum.NORMAL.getCode());
//        sysUserExtend.setCreateUser(siteBasic._getSiteUserId());
//        sysUserExtend.setCreateTime(new Date());
//        sysUserExtend.setDefaultLocale(siteBasic._getLocale().toString());
//        sysUserExtend.setDefaultTimezone(siteBasic._getTimeZone().getID());
//        //判断是否是api默认总代
////        if(SubSysCodeEnum.COMPANY.getCode().equals(siteBasic.getSubCode())){
////            sysUserExtend.setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
////        }else if(SubSysCodeEnum.COMPANY.getCode().equals(siteBasic.getSubCode())){
////            sysUserExtend.setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
////        }
//        sysUserExtend.setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
//        sysUserExtend.setOwnerId(sysSite.getSysUserId());
//        sysUserExtend.setSiteId(sysSite.getId());
//        sysUserExtend.setBuiltIn(true);
//
//        SysUserExtend user = sysUserExtendService.getSysUserExtend(sysSite.getSysUserId());
//        StringBuffer parentIdBuffer = new StringBuffer();
//        parentIdBuffer.append(sysSite.getSysUserId());
//        if (StringTool.isNotBlank(user.getParentIds())) {
//            parentIdBuffer.append(CacheKey.CACHE_KEY_PREFIX_SEPERATOR).append(user.getParentIds());
//        }
//        String parentIds = parentIdBuffer.toString();
//        sysUserExtend.setParentIds(parentIds);
//
//        StringBuffer parentNameBuffer = new StringBuffer();
//        parentNameBuffer.append(user.getUsername());
//        if (StringTool.isNotBlank(user.getParentNames())) {
//            parentNameBuffer.append(CacheKey.CACHE_KEY_PREFIX_SEPERATOR).append(user.getParentNames());
//        }
//        String parentNames = parentNameBuffer.toString();
//        sysUserExtend.setParentNames(parentNames);
//        sysUserExtend.setOwnerName(user.getUsername());
//        sysUserExtend.setOwnerCode(user.getCode());
//        sysUserExtend.setCode(APIConst.DEFAULT_DISTRIBUTOR_CODE);
//        boolean insert = sysUserExtendService.insertSysUserExtend(sysUserExtend);
//        siteBasic.setSuccess(insert);
//    }

    /**
     * 保存站点信息
     */
    private SysSite saveSysSite(VSysSiteManageVo siteBasic) {
        SysSite sysSite = new SysSite();
        VSysSiteManage siteBasicResult = siteBasic.getResult();
        BeanTool.copyProperties(siteBasicResult, sysSite);
        sysSite.setStatus(SysSiteStatusEnum.NORMAL.getCode());
        sysSite.setIsBuildin(false);
        sysSite.setOpeningTime(new Date());
        sysSite.setStatus(SysSiteStatusEnum.NORMAL.getCode());
        sysSite.setMainCurrency(siteBasic.getResult().getMainCurrency());
        sysSite.setMainLanguage(siteBasic.getResult().getMainLanguage());
        sysSite.setTimezone(siteBasic.getResult().getTimezone());
        sysSite.setName(siteBasic.getResult().getSiteName());
        sysSite.setParentId(siteBasic.getResult().getParentId());
        sysSite.setTheme("".equals(siteBasic.getResult().getTheme())?"default":siteBasic.getResult().getTheme());
        sysSite.setTitle(siteBasic.getResult().getTitle());
        sysSite.setTemplateCode("".equals(siteBasic.getResult().getTemplateCode())?"default":siteBasic.getResult().getTemplateCode());
        if(StringTool.isEmpty(siteBasic.getResult().getLogoPath())){
            sysSite.setLogoPath("Logo/1/1459172297237.png");
        }
        sysSite.setCode(siteBasic.getResult().getCode());
        //新增站点默认开启测试模式
        sysSite.setId(siteBasic.getResult().getId());
        sysSite.setMode(ModeEnum.DEMO.getCode());
        sysSiteService.insertSysSite(sysSite);
        return sysSite;
    }

    /**
     * 回填site_id 到sys_user_extend,并修改站点用户自定义后缀
     */
    private void fillSiteIdToSysUserExtend(Integer masterSiteId, Integer userId,String code) {
        SysUserExtend sysUserExtend = new SysUserExtend();
        sysUserExtend.setId(userId);
        SysUserExtend user = sysUserExtendService.getSysUserExtend(userId);
        String userName = user.getUsername();
        String subUserName = StringTool.substringBefore(userName,"@");
        String userNames= subUserName+"@"+code;
        sysUserExtend.setUsername(userNames);
        sysUserExtend.setSiteId(masterSiteId);
        sysUserExtendService.updateUserInfoOnly(sysUserExtend, SysUserExtend.PROP_SITE_ID, SysUserExtend.PROP_USERNAME);
    }

    /**
     * 保存站点临时域名
     */
    private void saveSysDomain(VSysSiteManageVo siteBasic, Integer masterSiteId, Integer sysUserId, String siteCode) {
        SysDomain sysDomain = new SysDomain();
        sysDomain.setSiteId(masterSiteId);
        sysDomain.setSysUserId(siteBasic.getResult().getSysUserId());
        sysDomain.setIsDefault(false);
        sysDomain.setIsDeleted(false);
        sysDomain.setIsEnable(true);
        sysDomain.setCreateTime(new Date());
        sysDomain.setCreateUser(siteBasic.getCreateUser());
        sysDomain.setResolveStatus(ResolveStatusEnum.SUCCESS.getCode());

        SysUserExtend sysUserExtend = sysUserExtendService.getSysUserExtend(sysUserId);
        SysParam sysParam = null;
        if (Objects.equals(UserTypeEnum.SHAREHOLDER.getCode(), sysUserExtend.getUserType())
                || Objects.equals(UserTypeEnum.SHAREHOLDER_SUB.getCode(), sysUserExtend.getUserType())) {
            sysParam = ParamTool.getSysParam(BossParamEnum.DOMAIN_URL_SHAREHOLDER);
            sysDomain.setSubsysCode(SubSysCodeEnum.SHAREHOLDER.getCode());
        } else if (Objects.equals(UserTypeEnum.COMPANY.getCode(), sysUserExtend.getUserType())
                || Objects.equals(UserTypeEnum.COMPANY_SUB.getCode(), sysUserExtend.getUserType())) {
            sysParam = ParamTool.getSysParam(BossParamEnum.DOMAIN_URL_MERCHANT);
            sysDomain.setSubsysCode(SubSysCodeEnum.COMPANY.getCode());
        }

        if (sysParam != null) {
            String domain ="admin"+"."+siteCode + "." + sysParam.getDefaultValue();
            sysDomain.setDomain(domain);
            siteBasic.setSiteDomain(domain);
        }else{
            String domain ="admin"+"."+siteCode + "." + "longtoubet.com";//临时域名
            sysDomain.setDomain(domain);
            siteBasic.setSiteDomain(domain);
        }
        sysDomain.setName("临时域名");
        sysDomainService.insertSysDomain(sysDomain);
    }

    //endregion your codes 2

}