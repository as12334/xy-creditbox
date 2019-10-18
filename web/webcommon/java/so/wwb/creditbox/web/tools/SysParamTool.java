package so.wwb.creditbox.web.tools;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.cache.CacheTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;
import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.ClassTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleDateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.param.IParamEnum;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysDatasourceVo;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.tag.ImageTag;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.model.common.TopMenuJson;
import so.wwb.creditbox.model.enums.base.SiteParamEnum;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.common.AuditLogPageTypeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.token.TokenHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 系统参数工具类
 * Created by jeremy on 18-10-12.
 */
public class SysParamTool {

    private static final Log LOG = LogFactory.getLog(SysParamTool.class);
    private static final Integer BOSS_SITE_ID = 0;

    /**
     * 重新生成token
     * 针对拥有表单token的操作，当前端验证通过，
     * 后台验证失败或者服务失败时，重新生成token
     *
     * @param map state 服务是否成功
     */
    public static Map generateToken(Map map) {
        if (MapTool.isNotEmpty(map) && !MapTool.getBoolean(map, KeyTool.STATE)) {
            map.put(TokenHandler.TOKEN_VALUE, TokenHandler.generateGUID());
        }
        return map;
    }

    /**
     * 获取站点CODE
     */
    public static String getSiteCode(Integer siteId) {
        String code = "";
        if (siteId != null) {
            SysSite site = Cache.getSiteById(siteId);
            if (site != null && StringTool.isNotBlank(site.getCode())) {
                code = site.getCode();
                if (StringTool.isBlank(code)) {
                    SysSiteVo siteVo = new SysSiteVo();
                    siteVo.getSearch().setId(siteId);
                    siteVo = ServiceTool.sysSiteService().get(siteVo);
                    if (siteVo.getResult() != null && StringTool.isNotBlank(siteVo.getResult().getCode())) {
                        code = siteVo.getResult().getCode();
                    }
                }
            }
        }
        return code;
    }

    /**
     * 站点-系统参数
     *
     * @param siteParamEnum 枚举
     * @param siteId        站点id
     * @return
     */
    public static SysParam getSiteParam(Integer siteId, SiteParamEnum siteParamEnum) {
        return executeQueryParam(siteId, siteParamEnum);
    }

    /**
     * BOSS-系统参数
     */
    public static SysParam getBossParam(SiteParamEnum siteParamEnum) {
        return executeQueryParam(BOSS_SITE_ID, siteParamEnum);
    }

    private static SysParam executeQueryParam(Integer siteId, SiteParamEnum paramEnum) {
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取SysParam缓存为空{0}, siteId{1}, 正在刷新缓存重试...", paramEnum, siteId);
            refreshParams(siteId, paramEnum);
            sysParam = raw(siteId, paramEnum);
            if (sysParam == null) {
                LOG.error("刷新缓存重试获取SysParam缓存为空{0}, siteId{1}, 正在查询源数据...", paramEnum, siteId);
                SysParamVo sysParamVo = new SysParamVo();
                sysParamVo._setDataSourceId(siteId);
                sysParamVo.getQuery().setCriterions(new Criterion[]{
                        new Criterion(SysParam.PROP_PARAM_TYPE, Operator.EQ, paramEnum.getType()),
                        new Criterion(SysParam.PROP_PARAM_CODE, Operator.EQ, paramEnum.getCode()),
                });
                sysParamVo = ServiceTool.sysParamService().search(sysParamVo);
                if (sysParamVo == null || sysParamVo.getResult() == null) {
                    LOG.error("sys_param表数据[{0}]为空, siteId{1}", paramEnum, siteId);
                } else {
                    sysParam = sysParamVo.getResult();
                }
            }
        }
        return sysParam;
    }

    public static void refreshParams(Integer siteId, SiteParamEnum paramEnum) {
        CacheTool.refresh(cacheKey(siteId, paramEnum));
    }

    /**
     * 获取某个参数原始记录
     */
    public static SysParam raw(Integer siteId, IParamEnum paramEnum) {
        Map<String, SysParam> params = CacheTool.get(cacheKey(siteId, paramEnum));
        if (MapTool.isEmpty(params)) {
            LOG.error("参数缓存为空!");
            return null;
        }
        return params.get(paramEnum.getCode());
    }

    /**
     * 完整的KEY,for CacheTool
     */
    public static String cacheKey(Integer siteId, IParamEnum paramEnum) {
        return CacheKey.getCacheKey(CacheKey.CACHE_KEY_PARAMS, String.valueOf(siteId), paramEnum.getModule().getCode(), paramEnum.getType());
    }

    /**
     * 获取带玩账号初始金额
     */
    public static Double getTakePlayMoney(SysParam siteParam) {
        Double money = 0.000;
        if (siteParam != null) {
            if (StringTool.isNotBlank(siteParam.getDefaultValue())) {
                money = Double.valueOf(siteParam.getDefaultValue());
            }
            //ParamValue 有值则覆盖 DefaultValue
            if (StringTool.isNotBlank(siteParam.getParamValue())) {
                money = Double.valueOf(siteParam.getParamValue());
            }
        }
        return money;
    }


    /**
     * 获取带玩账号剩余创建数量
     */
    public static Integer getTakePlayNumber(SysParam siteParam) {
        Integer number = 0;
        if (siteParam != null) {
            if (StringTool.isNotBlank(siteParam.getDefaultValue())) {
                number = Integer.valueOf(siteParam.getDefaultValue());
            }
            //ParamValue 有值则覆盖 DefaultValue
            if (StringTool.isNotBlank(siteParam.getParamValue())) {
                number = Integer.valueOf(siteParam.getParamValue());
            }
        }
        return number;
    }

    /**
     * 不传值 或者 值为空， 默认返回 false
     */
    private static Boolean executeStatus(SysParam param) {
        return param != null && StringTool.isNotBlank(param.getParamValue()) ?
                Boolean.valueOf(param.getParamValue()) : false;
    }


//    /**
//     * 商户站点存在检查
//     *
//     * @param siteId 站点ID
//     * @return true:存在  false:不存在
//     */
//    public static Boolean checkMerchantsSite(Integer siteId) {
//        Boolean flag = false;
//        if (siteId != null) {
//            List<VSysSiteUser> list = ServiceTool.vSysSiteUserService().queryMerchantsBySiteId(siteId);
//            if (CollectionTool.isNotEmpty(list)) {
//                SysDatasourceVo datasourceVo = new SysDatasourceVo();
//                datasourceVo.getSearch().setId(siteId);
//                datasourceVo = ServiceTool.sysDatasourceService().get(datasourceVo);
//                if (datasourceVo.getResult() != null && YesNot.YES.getCode().equals(datasourceVo.getResult().getStatus())) {
//                    flag = true;
//                }
//            }
//        }
//        return flag;
//    }

//    /**
//     * 获取默认总代
//     *
//     * @param siteId 站点ID
//     * @return SysUserExtend
//     */
//    public static SysUserExtend defaultDistributor(Integer siteId) {
//        SysUserExtendVo distributor = new SysUserExtendVo();
//        distributor.getQuery().setCriterions(new Criterion[]{
//                new Criterion(SysUserExtend.PROP_SITE_ID, Operator.EQ, siteId),
//                new Criterion(SysUserExtend.PROP_CODE, Operator.EQ, APIConst.DEFAULT_DISTRIBUTOR_CODE),
//                new Criterion(SysUserExtend.PROP_USERNAME, Operator.EQ,
//                        APIConst.DEFAULT_DISTRIBUTOR_ACCOUNT + "@" + getSiteCode(siteId))
//        });
//        return ServiceTool.sysUserExtendService().search(distributor).getResult();
//    }


//    /**
//     * 玩家详细资料
//     *
//     * @return Map
//     */
//
//    public static Map<String, Object> playerInfo(Integer siteId, Integer userId) {
//        Map<String, Object> infoMap = new HashMap<>();
//        SysUserExtendVo extendVo = new SysUserExtendVo();
//        extendVo.getSearch().setId(userId);
//        extendVo._setDataSourceId(siteId);
//        extendVo = ServiceTool.sysUserExtendService().get(extendVo);
//        if (extendVo.getResult() != null) {
//            infoMap.put(SysUserExtend.PROP_ID, extendVo.getResult().getId());
//            infoMap.put(SysUserExtend.PROP_USERNAME, extendVo.getResult().getUsername());
//            infoMap.put(SysUserExtend.PROP_REAL_NAME, extendVo.getResult().getRealName());
//            infoMap.put(SysUserExtend.PROP_NICKNAME, extendVo.getResult().getNickname());
//            infoMap.put(SysUserExtend.PROP_BIRTHDAY, extendVo.getResult().getBirthday());
//            infoMap.put(SysUserExtend.PROP_SEX, extendVo.getResult().getSex());
//        }
//        UserPlayerVo playerVo = new UserPlayerVo();
//        playerVo.getSearch().setId(userId);
//        playerVo._setDataSourceId(siteId);
//        playerVo = ServiceTool.userPlayerService().get(playerVo);
//        if (playerVo.getResult() != null) {
//            infoMap.put(UserPlayer.PROP_MAIL, playerVo.getResult().getMail());
//            infoMap.put(UserPlayer.PROP_MOBILE, playerVo.getResult().getMobile());
//            infoMap.put(UserPlayer.PROP_QQ, playerVo.getResult().getQq());
//            infoMap.put(UserPlayer.PROP_WEIXIN, playerVo.getResult().getWeixin());
//        }
//        return infoMap;
//    }

//    /**
//     * 活动时间交叉验证
//     * <p>
//     * 同时间段同类型的活动必须是唯一的
//     * 1.活动内容类型不需要验证
//     * 2.编辑活动时，不需和自己比较 (推荐送编辑时， 不允许修改开始时间)
//     *
//     * @return true 通过； false 不通过
//     */
//    public static boolean checkActivityTime(Integer siteId, OperationActivityVo vo) {
//        OperationActivity activity = vo.getResult();
//        if (activity == null) return false;
//        if (StringTool.equals(ActivityTypeEnum.CONTENT.getCode(), activity.getActivityType())) {
//            return true;
//        }
//        vo._setDataSourceId(siteId);
//        List<OperationActivity> list = ServiceTool.operationActivityService().serachByActivityType(vo);
//        if (CollectionTool.isNotEmpty(list)) {
//            long newStartTime = activity.getStartTime().getTime();
//            long newEndTime = activity.getEndTime().getTime();
//            Integer id = vo.getResult().getId();
//            if (list.size() == 1 && id != null && id.equals(list.get(0).getId())) {
//                //同个推荐送活动编辑时，不允许修改开始时间
//                return !(StringTool.equals(ActivityTypeEnum.RECOMMEND_SEND.getCode(), activity.getActivityType())
//                        && (newStartTime != list.get(0).getStartTime().getTime()));
//            }
//            for (OperationActivity one : list) {
//                long oldStartTime = one.getStartTime().getTime();
//                long oldEndTime = one.getEndTime().getTime();
//                if (id != null && id.equals(one.getId())) {
//                    //不用跟自己比较；同个推荐送活动编辑时不允许修改开始时间
//                    if (StringTool.equals(ActivityTypeEnum.RECOMMEND_SEND.getCode(), activity.getActivityType())
//                            && (newStartTime != oldStartTime)) {
//                        return false;
//                    }
//                    continue;
//                }
//                if ((newStartTime >= oldStartTime && newStartTime <= oldEndTime)
//                        || (newEndTime >= oldStartTime && newEndTime <= oldEndTime)) {
//                    //新开始时间、新结束时间不允许在范围之内
//                    return false;
//                }
//                //当新增/编辑开始时间小于旧开始时间时，说明下个时间段也有同类型活动。
//                //那么新增/编辑的结束时间不应该大于下个活动时间的开始时间
//                if (newStartTime <= oldStartTime && newEndTime >= oldStartTime) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }




    /**
     * 用户名不存在检查
     *
     * @param objectVo result.username 用户名 not null
     *                 result.userType 用户类型 not null
     *                 result.ownerId  上级ID not null
     * @return true：不存在； false：已存在
     */
    public static boolean checkManageUsername(SysUserExtendVo objectVo) {
        return Boolean.parseBoolean(null);
    }

    /**
     * 玩家账号
     * 分割玩家账号
     */
    public static List<String> splitPLayerName(String playerNames) {
        List<String> nameList = new ArrayList<>();
        if (StringTool.isNotBlank(playerNames) && playerNames.contains(",")) {
            String[] split = playerNames.split(",");
            Collections.addAll(nameList, split);
        }
        return nameList;
    }

    /**
     * 、
     * 玩家账号
     * 组装多账号字符串
     */
    public static String assemblePLayerName(List<String> nameList) {
        if (CollectionTool.isNotEmpty(nameList)) {
            String playerName = "";
            for (String oneName : nameList) {
                playerName += oneName + ",";
            }
            return playerName.substring(0, playerName.length() - 1);
        }
        return null;
    }


    /**
     * 组装用户名(后台管理账号)
     * <p>
     * 1.创建股东、商户账号时，因为没有创建所属站点，账户名用的是临时后缀，所以应做前缀匹配
     * 2.创建总代账号、所有子账号时，应做全匹配
     *
     * @param objectVo result.username 用户名 not null
     *                 result.userType 用户类型 not null
     *                 result.ownerId  上级ID not null
     * @return 组装后的用户名
     */
    public static String addManageUsernameSuffix(SysUserExtendVo objectVo) {
        if (objectVo.getResult() == null
                || objectVo.getResult().getOwnerId() == null
                || StringTool.isBlank(objectVo.getResult().getUsername())
                || StringTool.isBlank(objectVo.getResult().getUserType())) {
            LOG.info("addManageUsernameSuffix组装用户名缺少参数，参数:{1}", JsonTool.toJson(objectVo.getResult()));
            return objectVo.getResult() != null ? objectVo.getResult().getUsername() : "";
        }
        String username = objectVo.getResult().getUsername();
        String userType = objectVo.getResult().getUserType();
        Integer ownerId = objectVo.getResult().getOwnerId();
        try {
            if (StringTool.equals(UserTypeEnum.SHAREHOLDER.getCode(), userType) || StringTool.equals(UserTypeEnum.COMPANY.getCode(), userType)) {
                username += "@%";
            } else {
                SysUserExtend ownerUser = querySysUser(ownerId);
                if (ownerUser != null) username += "@" + getSiteCode(ownerUser.getSiteId());
            }
        } catch (Exception e) {
            LOG.error("addManageUsernameSuffix服务异常：{0}", e);
        }
        return username;
    }


    /**
     * 平台账号
     * 多用户名查询
     * 1.根据分隔符 半角逗号切割
     * 2.参数会转换为小写
     */
    public static List<String> executeSplitUsername(Integer siteId, String username) {
        List<String> resultList = new ArrayList<>();
        if (siteId != null && StringTool.isNotBlank(username)) {
            username = username.toLowerCase();
            List<String> nameList = new ArrayList<>();
            if (username.contains(",")) nameList = Arrays.asList(username.split(","));
            if (CollectionTool.isNotEmpty(nameList)) {
                String code = getSiteCode(siteId);
                if (StringTool.isNotBlank(code)) {
                    for (String one : nameList) {
                        resultList.add(one + "@" + code.toLowerCase());
                    }
                }
            }
        }
        return resultList;
    }

//    public static VUserPlayer queryPlayer(Integer siteId, Integer userId) {
//        VUserPlayerVo vUserPlayerVo = new VUserPlayerVo();
//        if (siteId != null) vUserPlayerVo._setDataSourceId(siteId);
//        vUserPlayerVo.getSearch().setId(userId);
//        vUserPlayerVo = ServiceTool.vUserPlayerService().get(vUserPlayerVo);
//        return vUserPlayerVo.getResult();
//    }

    /**
     * 查询站点玩家 sys_user_extend
     * <p>
     *
     * @param siteId 站点ID
     * @param userId 玩家ID
     * @return SysUserExtend
     */
    public static SysUserExtend querySysUser(Integer siteId, Integer userId) {
        return baseQueryUser(siteId, userId);
    }

    /**
     * 查询 后台管理账户
     *
     * @param userId 账户ID
     * @return SysUserExtend
     */
    public static SysUserExtend querySysUser(Integer userId) {
        return baseQueryUser(null, userId);
    }

    public static SysUserExtend baseQueryUser(Integer siteId, Integer userId) {
        SysUserExtendVo sysUserVo = new SysUserExtendVo();
        if (siteId != null) sysUserVo._setDataSourceId(siteId);
        sysUserVo.getSearch().setId(userId);
        sysUserVo = ServiceTool.sysUserExtendService().get(sysUserVo);
        return sysUserVo.getResult();
    }

    public static boolean checkPasswordParam(String password) {
        if (StringTool.isBlank(password)) {
            return false;
        }
        SysUserExtendVo userExtendVo = new SysUserExtendVo();
        userExtendVo.getSearch().setId(SessionManagerCommon.getUserId());
        userExtendVo = ServiceTool.sysUserExtendService().get(userExtendVo);
        String newPwd = AuthTool.md5SysUserPassword(password, userExtendVo.getResult().getUsername());
        String oldPwd = userExtendVo.getResult().getPassword();
        return StringTool.equals(oldPwd, newPwd);
    }

    public static boolean checkPrivilegePasswordParam(String password) {
        if (StringTool.isBlank(password)) {
            return false;
        }
        SysUserExtend sysUserExtend = SessionManagerCommon.getSysUserExtend();
        String inputPassword = AuthTool.md5SysUserPermission(password, sysUserExtend.getUsername());
        String privilegeCode = SessionManagerCommon.getPrivilegeCode();
        return StringTool.equals(inputPassword, privilegeCode);
    }


//    /**
//     * 获取盘口的基础退水比例
//     *
//     * @param siteId    站点ID
//     * @param projectId 盘口ID
//     * @return BillRetreatRatio集合
//     */
//    public static List<BillRetreatRatio> queryBasicsRetreatRatio(Integer siteId, Integer projectId) {
//        BillRetreatRatioListVo ratioListVo = new BillRetreatRatioListVo();
//        ratioListVo.setPaging(null);
//        ratioListVo._setDataSourceId(siteId);
//        ratioListVo.getSearch().setLotteryProjectId(projectId);
//        ratioListVo.getSearch().setPlayerName(BillRetreatRatioListVo.BASICS_RETREAT_RATIO);
//        ratioListVo = ServiceTool.billRetreatRatioService().search(ratioListVo);
//        return ratioListVo.getResult();
//    }


    public static String toJsonString(Map<String, Object> map) {
        Map<String, String> result = new HashMap<>();
        if (MapTool.isNotEmpty(map)) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                result.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return JsonTool.toJson(result);
    }

    /**
     * 获取模糊查询IP的开始和结束IP
     *
     * @param ip
     * @return
     */
    public static Map fetchStartEndIp(String ip) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("state", false);
        if (StringTool.isNotBlank(ip)) {
            String[] ips = ip.split("[.]");
            if (ips.length != 4) {
                return maps;
            }
            String minIp = "";
            String maxIp = "";
            for (String s : ips) {
                Map map = testIp(s);
                String min = MapTool.getString(map, "min");
                String max = MapTool.getString(map, "max");
                minIp += min + ".";
                maxIp += max + ".";
            }
            if (minIp.endsWith(".")) {
                minIp = minIp.substring(0, minIp.length() - 1);
            }
            if (maxIp.endsWith(".")) {
                maxIp = maxIp.substring(0, maxIp.length() - 1);
            }
            if (IpTool.isValidIpv4(maxIp)) {
                maps.put("max", maxIp);
                maps.put("min", minIp);
                maps.put("state", true);
            } else {
                maps.put("state", false);
            }
        }
        return maps;
    }

    public static Map testIp(String ip) {
        Map ipMap = new HashMap();
        if (StringTool.isBlank(ip)) {
            return ipMap;
        }
        if (ip.indexOf("*") > -1) {
            ipMap.put("min", "0");
            ipMap.put("max", "255");
        } else if (ip.indexOf("?") > -1) {
            if (ip.length() == 3) {
                //IP小段为3位
                dealIp3(ip, ipMap);
            } else {
                ipMap.put("min", ip.replaceAll("[?]", "0"));
                ipMap.put("max", ip.replaceAll("[?]", "9"));
            }


        } else {
            ipMap.put("min", ip);
            ipMap.put("max", ip);
        }
        return ipMap;
    }

    /**
     * 模糊查询ip小段为3位数
     *
     * @param ip
     * @param ipMap
     */
    public static void dealIp3(String ip, Map ipMap) {
        if ("???".equals(ip)) {
            ipMap.put("min", "0");
            ipMap.put("max", "255");
        } else if (ip.endsWith("??")) {
            ipMap.put("min", ip.replaceAll("[?]", "0"));
            String firstIp = ip.substring(0, 1);
            if ("2".equals(firstIp)) {
                ipMap.put("max", ip.replaceAll("[?]", "5"));
            } else {
                ipMap.put("max", ip.replaceAll("[?]", "9"));
            }

        } else if (ip.endsWith("?")) {
            ipMap.put("min", ip.replaceAll("[?]", "0"));
            String firstIp = ip.substring(0, 1);
            String secondIp = ip.substring(1, 2);
            if (firstIp.equals("2") && secondIp.equals("5")) {
                ipMap.put("max", ip.replaceAll("[?]", "5"));
            } else {
                ipMap.put("max", ip.replaceAll("[?]", "9"));
            }
        } else if (ip.startsWith("?", 1)) {
            String firstIp = ip.substring(0, 1);
            ipMap.put("min", ip.replaceAll("[?]", "0"));
            if ("2".equals(firstIp)) {
                ipMap.put("max", ip.replaceAll("[?]", "2"));
            } else {
                ipMap.put("max", ip.replaceAll("[?]", "9"));
            }
        }
    }


    private static void addPage(List<TopMenuJson> menuList, String code, String trans, String url, String permission) {
        TopMenuJson oneMenu = new TopMenuJson();
        oneMenu.setPageType(code);
        oneMenu.setName(trans);
        oneMenu.setUrl(url);
        oneMenu.setPermission(permission);
        menuList.add(oneMenu);
    }


    /**
     * 审计日志 页面菜单
     * 区分不同后台的自定义菜单
     */
    private static List<TopMenuJson> setAuditLogPage(List<TopMenuJson> menuList, String subsysCode, String basePath, String suffix) {
        List<AuditLogPageTypeEnum> enumList = new ArrayList<>();
        if (StringTool.isNotBlank(subsysCode)) {
            if (StringTool.equals(SubSysCodeEnum.BOSS.getCode(), subsysCode)) {
                enumList.add(AuditLogPageTypeEnum.BOSS);
                enumList.add(AuditLogPageTypeEnum.SHAREHOLDER);
                enumList.add(AuditLogPageTypeEnum.COMPANY);
                enumList.add(AuditLogPageTypeEnum.DISTRIBUTOR);
            } else if (StringTool.equals(SubSysCodeEnum.SHAREHOLDER.getCode(), subsysCode)) {

            } else if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)) {
                enumList.add(AuditLogPageTypeEnum.COMPANY);
                enumList.add(AuditLogPageTypeEnum.PLAYER);
            } else if (StringTool.equals(SubSysCodeEnum.COMPANY.getCode(), subsysCode)) {
                enumList.add(AuditLogPageTypeEnum.COMPANY);
                enumList.add(AuditLogPageTypeEnum.PLAYER);
            } else if (StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), subsysCode)) {

            } else if (StringTool.equals(SubSysCodeEnum.DISTRIBUTOR.getCode(), subsysCode)) {

            }
            if (CollectionTool.isNotEmpty(enumList)) {
                for (AuditLogPageTypeEnum page : enumList) {
                    addPage(menuList, page.getCode(), page.getTrans(), basePath + page.getCode() + suffix, page.getPermission());
                }
            }
        }
        return menuList;
    }

    public static String splitLotteryCode(String[] codes) {
        if (ArrayTool.isNotEmpty(codes)) {
            String searchCodes = "";
            for (String code : codes) {
                searchCodes += code + ",";
            }
            return searchCodes.substring(0, searchCodes.length() - 1);
        }
        return "";
    }

    public static String splitLotteryCode(List<String> codes) {
        if (CollectionTool.isNotEmpty(codes)) {
            String searchCodes = "";
            for (String code : codes) {
                searchCodes += code + ",";
            }
            return searchCodes.substring(0, searchCodes.length() - 1);
        }
        return "";
    }

    /**
     * 获取属性名集合
     */
    public static List<String> getFiledName(Object o) {
        List<String> names = new ArrayList<>();
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (Field field : fields) {
            names.add(field.getName());
        }
        return names;
    }

    public static Map<String, String> getRequestMapping(Object o) {
        try {
            Field[] fields;
            if (o instanceof Class) {
                fields = ((Class) o).getFields();
            } else {
                fields = o.getClass().getFields();
            }
            Map<String, String> resultMap = new HashMap<>(fields.length);
            if (ArrayTool.isNotEmpty(fields)) {
                for (Field field : fields) {
                    if (null != field.get(null)) {
                        resultMap.put(field.getName(), field.get(null).toString());
                    }
                }
            }
            return resultMap;
        } catch (Exception e) {
            LOG.error("获取资源映射错误：", e);
        }
        return null;
    }

    /**
     * 获取自定义菜单源路径
     * 1.现根据 RequestMapping 获取
     * 2.没有则获取 getViewBasePath 的路径
     *
     * @param controller 方法中必须提供 getViewBasePath 方法
     * @return path
     */
    public static String getBasePath(Class<?> controller) {
        String path = null;
        try {
            RequestMapping annotation = controller.getAnnotation(RequestMapping.class);
            if (annotation != null) {
                String[] values = annotation.value();
                if (ArrayTool.isNotEmpty(values)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String ele : values) {
                        stringBuilder.append(ele);
                    }
                    path = stringBuilder.toString();
                }
            } else {
                Method[] methods = controller.getDeclaredMethods();
                if (ArrayTool.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (StringTool.equals("getViewBasePath", method.getName())) {
                            method.setAccessible(true);
                            path = method.invoke(controller.newInstance()) != null
                                    ? method.invoke(controller.newInstance()).toString() : null;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("获取自定义菜单URI错误：", e);
        }
        return path;
    }

    public static ICodeEnum[] getEnumClass(Class<? extends ICodeEnum> enumClass) {
        try {
            String simpleName = ClassTool.getSimpleName(enumClass);
            String packageName = ClassTool.getPackageName(enumClass);
            if (StringTool.isNotBlank(simpleName) && StringTool.isNotBlank(packageName)) {
                return EnumTool.getCodeEnumClass(packageName + "." + simpleName).getEnumConstants();
            } else {
                return null;
            }
        } catch (Exception e) {
            LOG.error("获取枚举类错误：{0}", e.getMessage());
            return null;
        }
    }

    public static Boolean checkCompanySite(Integer siteId) {
        Boolean flag = false;
        if (siteId != null) {
            List<VSysSiteUser> list = ServiceTool.vSysSiteUserService().queryMerchantsBySiteId(siteId);
            if (CollectionTool.isNotEmpty(list)) {
                SysDatasourceVo datasourceVo = new SysDatasourceVo();
                datasourceVo.getSearch().setId(siteId);
                datasourceVo = ServiceTool.sysDatasourceService().get(datasourceVo);
                if (datasourceVo.getResult() != null && YesNot.YES.getCode().equals(datasourceVo.getResult().getStatus())) {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
