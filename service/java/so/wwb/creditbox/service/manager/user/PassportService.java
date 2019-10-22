package so.wwb.creditbox.service.manager.user;

import org.soul.commons.bean.Pair;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateQuickPickerTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.sort.Order;
import org.soul.commons.security.CryptoTool;
import org.soul.data.mapper.security.privilege.SysResourceMapper;
import org.soul.iservice.passport.IPassportService;
import org.soul.iservice.passport.exception.AccountDisabledException;
import org.soul.iservice.passport.exception.AccountInActiveException;
import org.soul.iservice.passport.exception.AccountPasswordException;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.po.SysResource;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.so.SysUserSo;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.security.privilege.vo.SysUserStatusVo;
import org.soul.service.security.privilege.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.cache.TokenCache;
import so.wwb.creditbox.data.manager.sys.SysSiteMapper;
import so.wwb.creditbox.data.manager.user.SysUserExtendMapper;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.exception.TokenException;
import so.wwb.creditbox.model.manager.passport.vo.UserTypeVo;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.TokenPassportVo;
import so.wwb.creditbox.utility.TokenTool;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.LoginException;
import java.text.MessageFormat;
import java.util.*;

/**
 * 处理用户登入认证
 *
 * @author Alvin
 * @date 2017.3.8
 */
public class PassportService implements IPassportService {

    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private SysUserExtendMapper sysUserExtendMapper;

    @Autowired
    private SysUserExtendService sysUserService;

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Autowired
    private SysSiteMapper sysSiteMapper;

    @Autowired
    private TokenCache tokenCache;

//    private boolean processPassportVo(PassportVo passportVo) throws LoginException {
//        if (passportVo instanceof TokenPassportVo) {
//            TokenPassportVo vo = (TokenPassportVo) passportVo;
//            if (vo.getToken() != null) {
//                log.debug("token:{0}", vo.getToken());
//                String cacheKey = TokenTool.getCacheKey();
//                SysUserExtend userExtend = CacheBase.getSysUser().get(TokenTool.getCacheKey());
//                if (userExtend == null) {
//                    log.error("找不到商户缓存,key:{0}", cacheKey);
//                    throw new TokenException("参数有误.TOKEN.01.");
//                } else if (userExtend.getKey() == null || userExtend.getKey().trim().length() == 0) {
//                    log.error("商户秘钥为空,merchant.code:{0}", TokenTool.getMerchantCode());
//                    throw new TokenException("参数有误.TOKEN.02.");
//                }
//                String token = CryptoTool.decryptDES3(vo.getToken(), userExtend.getKey());
//                log.debug("token:decrypt:{0}", token);
////                Login login = tokenCache.getCache(token, new Login());
////                if (login == null) {
////                    log.error("token.找不到TOKEN缓存对象.");
////                    throw new TokenException("TOKEN令牌不合法或已失效.");
////                }
////                passportVo.getSearch().setUsername(login.getUserName());
//                passportVo.getSearch().setSiteId(userExtend.getSiteId());
//                //解密过的Token.
//                vo.setToken(token);
//                log.debug("token.value:{0}", userExtend);
//            }
//            return true;
//        }
//        return false;
//    }

//    private void setExtInfo(PassportVo passportVo) {
//        if (passportVo instanceof TokenPassportVo) {
//            TokenPassportVo vo = (TokenPassportVo) passportVo;
//            SysUserExtend user = (SysUserExtend) vo.getResult();
//            user.setPayUri(vo.getPayUri());
//            user.setHallUri(vo.getHallUri());
//        }
//    }

    @Override
    public PassportVo login(PassportVo passportVo) throws LoginException {
//        boolean isToken = processPassportVo(passportVo);
        SysUserSo param = passportVo.getSearch();
        passportVo.getQuery().setSearch(param);
        List<SysUserExtend> users = sysUserExtendMapper.search(passportVo.getQuery().byUserNameAndSubSysCodeAndSiteId(), Order.desc(SysUserExtend.PROP_STATUS));

        if (CollectionTool.isEmpty(users)) {
            String message = MessageFormat.format("用户名:[{0}]不存在!", passportVo.getSearch().getUsername());
            throw new AccountNotFoundException(message);
        }

        SysUserExtend sysUser = users.get(0);
        if (!param.getPassword().equals(sysUser.getPassword())) {
            String message = MessageFormat.format("用户名:[{0}]或密码不对!", passportVo.getSearch().getUsername());
            AccountPasswordException accountPasswordException = new AccountPasswordException(message, sysUser.getId(), sysUser.getLoginErrorTimes());
            if (accountIsLock(sysUser)) {
                throw new AccountLockedException(StringTool.isBlank(sysUser.getFreezeContent()) ? "Locked" : sysUser.getFreezeContent());
            } else {
                throw accountPasswordException;
            }
        }

        param.setId(sysUser.getId());
        SysUserStatusVo statusVo = sysUserService.getStatus(passportVo);
        switch (statusVo.getStatus()) {
            case INACTIVE:
                throw new AccountInActiveException(statusVo.getStatus().getTrans());
            case LOCKED:
                throw new AccountLockedException(sysUser.getFreezeContent());
            case DISABLED:
                throw new AccountDisabledException(statusVo.getStatus().getTrans());
            case AUDIT_FAIL:
                throw new AccountNotFoundException(statusVo.getStatus().getTrans());
        }
        passportVo.setResult(sysUser);
//        if (isToken)
//            setExtInfo(passportVo);
        return passportVo;
    }

    private boolean accountIsLock(SysUser sysUser) {
        if (sysUser == null) {
            return false;
        }
        Date now = DateQuickPickerTool.getInstance().getNow();
        if (sysUser.getFreezeEndTime() == null) {
            return false;
        }
        if (sysUser.getFreezeStartTime() == null) {
            if (now.before(sysUser.getFreezeEndTime())) {
                return true;
            }
        } else {
            if (now.before(sysUser.getFreezeStartTime())) {
                return false;
            } else {
                if (now.before(sysUser.getFreezeEndTime())) {
                    return true;
                }
            }
        }

        if (sysUser.getFreezeStartTime() != null && sysUser.getFreezeEndTime() != null) {
            return now.before(sysUser.getFreezeEndTime()) && now.after(sysUser.getFreezeStartTime());
        }

        return false;
    }


    /**
     * 是否属于自己的站点
     *
     * @param sysUserId
     * @param siteId
     * @return
     */
    private boolean isMine(Integer sysUserId, Integer siteId) {
        SysSite sysSite = sysSiteMapper.get(siteId);
        return !(sysSite == null || !sysSite.getSysUserId().equals(sysUserId));
    }

    /**
     * 获取权限
     *
     * @param passportVo
     * @return
     */
    @Override
    public Set<String> findPermissions(PassportVo passportVo) {
        Set<String> permissions = null;
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, passportVo.getSearch().getUserType());
        if (UserTypeVo.isWholePerimssion(userTypeEnum)) {
            //全权限
            permissions = doFindPermissions(passportVo.getSearch().getSubsysCode(), passportVo.getSearch().getSiteId());
        } else {
            //个人权限(子账号类)
            permissions = sysUserService.findPermissions(passportVo);
        }
        return permissions;
    }

    @Override
    public Map<String, Pair<String, Boolean>> findPermissionMapping(PassportVo passportVo) {
        Map<String, Pair<String, Boolean>> userPermissionMapping = new HashMap<>();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, passportVo.getSearch().getUserType());
        if (UserTypeVo.isNeedCheckUrl(userTypeEnum)) { //子账号类,获取个人权限
            userPermissionMapping = sysUserService.findPermissionMapping(passportVo);
        } else { //获取所有权限
            SysResourceVo vo = new SysResourceVo();
            vo.getSearch().setSubsysCode(passportVo.getSearch().getSubsysCode());
            List<SysResource> sysResources = sysResourceMapper.search(vo.getQuery().bySubsysCode());
            for (SysResource sysResource : sysResources) {
                if (StringTool.isNotBlank(sysResource.getUrl())) {
                    userPermissionMapping.put(sysResource.getUrl(), new Pair(sysResource.getPermission(), sysResource.getPrivilege()));
                }
            }
        }
        return userPermissionMapping;
    }

    /**
     * 获取站长可拥有的资源
     *
     * @param subsysCode
     * @param siteId
     * @return
     */
    private Set<String> doFindPermissions(String subsysCode, Integer siteId) {
        SysResourceVo vo = new SysResourceVo();
        vo.getSearch().setSubsysCode(subsysCode);
        List<String> list = sysResourceMapper.searchProperty(vo.getQuery().bySubsysCode(), SysResource.PROP_PERMISSION);
        SysUserService.trimList(list);
        return new HashSet<String>(list);
    }

    @Override
    public PassportVo logout(PassportVo param) {
        return null;
    }

}