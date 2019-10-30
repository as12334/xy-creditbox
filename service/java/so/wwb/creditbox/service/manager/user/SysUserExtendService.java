package so.wwb.creditbox.service.manager.user;

import org.apache.shiro.session.mgt.SessionManager;
import org.soul.commons.bean.Pair;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.ListTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.string.RandomStringTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.mapper.msg.notice.NoticeContactWayMapper;
import org.soul.data.mapper.security.privilege.SysUserRoleMapper;
import org.soul.data.mapper.security.privilege.VSysUserResourceMapper;
import org.soul.data.support.DataContext;
import org.soul.model.msg.notice.po.NoticeContactWay;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.po.*;
import org.soul.model.security.privilege.vo.SysDeptVo;
import org.soul.model.security.privilege.vo.SysUserStatusVo;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.data.manager.user.SysUserExtendMapper;
import so.wwb.creditbox.iservice.manager.user.ISysUserExtendService;
//import so.wwb.lotterybox.iservice.company.setting.IUserParamService;
//import so.wwb.lotterybox.iservice.company.user.IUserAssetsService;
//import so.wwb.lotterybox.iservice.company.user.IUserPlayerService;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.enums.notice.ContactWayType;
import so.wwb.creditbox.model.enums.setting.UserParamEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.so.SysUserExtendSo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.utility.UserTool;

import javax.sql.DataSource;
import java.util.*;

public class SysUserExtendService extends BaseService<SysUserExtendMapper, SysUserExtendListVo, SysUserExtendVo, SysUserExtend, Integer> implements ISysUserExtendService {

    private Log LOG = LogFactory.getLog(SysUserExtendService.class);

    @Autowired
    private VSysUserResourceMapper vSysUserResourceMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private NoticeContactWayMapper noticeContactWayMapper;
//    @Autowired
//    private IUserPlayerService userPlayerService;
//    @Autowired
//    private IUserAssetsService userAssetsService;
//    @Autowired
//    private IUserParamService userParamService;

    @Override
    public Set<String> findPermissions(PassportVo sysUserVo) {
        throwException(sysUserVo);
        Map<String, Object> map = new HashMap<>(3);
        map.put(VSysUserResource.PROP_SUBSYS_CODE, sysUserVo.getSearch().getSubsysCode());
        map.put(VSysUserResource.PROP_USERNAME, sysUserVo.getSearch().getUsername());
        map.put(VSysUserRole.PROP_SITE_ID, sysUserVo.getSearch().getSiteId());
        List<String> permissions = vSysUserResourceMapper.andSearchProperty(map, VSysUserResource.PROP_PERMISSION);
        trimList(permissions);
        return new HashSet<>(permissions);
    }

    private void throwException(PassportVo sysUserVo) {
        if (StringTool.isBlank(sysUserVo.getSearch().getSubsysCode())) {
            throw new IllegalArgumentException("子系统编号不能为空！");
        }
        if (StringTool.isBlank(sysUserVo.getSearch().getUsername())) {
            throw new IllegalArgumentException("用户名不能为空！");
        }
    }

    @Override
    public Map<String, Pair<String, Boolean>> findPermissionMapping(PassportVo sysUserVo) {
        throwException(sysUserVo);

        Map<String, Object> map = new HashMap<>(3);
        map.put(VSysUserResource.PROP_SUBSYS_CODE, sysUserVo.getSearch().getSubsysCode());
        map.put(VSysUserResource.PROP_USERNAME, sysUserVo.getSearch().getUsername());
        map.put(VSysUserResource.PROP_STATUS, YesNot.YES.getBool());
        List<VSysUserResource> resList = vSysUserResourceMapper.andSearch(map);
        Map<String, Pair<String, Boolean>> resultMap = new HashMap<>(resList.size());
        for (VSysUserResource res : resList) {
            if (StringTool.isBlank(res.getResourceUrl()))
                continue;
            resultMap.put(res.getResourceUrl(), new Pair<>(res.getPermission(), res.getPrivilege()));
        }
        return resultMap;
    }

    /**
     * 排除字符串为空的列表元素
     */
    public static void trimList(List<String> list) {
        list.removeIf(StringTool::isBlank);
    }

    @Override
    public SysUserStatusVo getStatus(PassportVo passportVo) {
        Integer masterId = passportVo._getSiteUserId();
        DataSource currentDataSource = DataContext.getDataSource();
        if (masterId != null && masterId > 0) {
            //获取父级别状态
            String parentStatus;
            SysUserStatus parentStatusEnum;
            DataContext.setDataSource(DatasourceTool.getBaseDatasource());
            try {
                SysUser parentUser = mapper.get(masterId);
                parentStatus = parentUser.getStatus();
                parentStatusEnum = getSysUserStatus(parentStatus);
            } finally {
                DataContext.setDataSource(currentDataSource);
            }

            if (!isNormal(parentStatus)) {
                return new SysUserStatusVo(parentStatusEnum);
            }
        }
        return getRecursiveUserStatus(passportVo);
    }
//
//    @Override
//    public WebJson checkStatus(SysUserExtendVo extendVo, WebJson webJson) {
//        SysUserExtend userExtend = extendVo.getResult();
//        PassportVo vo = new PassportVo();
//        vo.getSearch().setId(userExtend.getId());
//        vo._setSiteUserId(contextParam().getSiteUserId());
//        vo._setDataSourceId(contextParam().getSiteId());
//        SysUserStatusVo statusVo = this.getStatus(vo);
//        switch (statusVo.getStatus()) {
//            case INACTIVE:
//                webJson.setCodeEnum(CodeEnum.ACCOUNT_INACTIVE);
//                break;
//            case LOCKED:
//                webJson.setCodeEnum(CodeEnum.ACCOUNT_LOCKED);
//                break;
//            case DISABLED:
//                webJson.setCodeEnum(CodeEnum.ACCOUNT_DISABLED);
//                break;
//            case AUDIT_FAIL:
//                webJson.setCodeEnum(CodeEnum.ACCOUNT_AUDIT_FAIL);
//            default:
//                webJson.setError(0);
//                break;
//        }
//        return webJson;
//    }
//
    private SysUserStatus getSysUserStatus(String parentStatus) {
        return SysUserStatus.enumOf(parentStatus);
    }

    /**
     * 获取递归用户状态
     */
    private SysUserStatusVo getRecursiveUserStatus(PassportVo sysUserVo) {

        SysUserExtend loginUser = mapper.get(sysUserVo.getSearch().getId());
        boolean isBoss = StringTool.equals(UserTypeEnum.BOSS.getCode(), loginUser.getUserType());
        boolean isMerchant = StringTool.equals(UserTypeEnum.COMPANY.getCode(), loginUser.getUserType());
        boolean isShareholder = StringTool.equals(UserTypeEnum.SHAREHOLDER.getCode(), loginUser.getUserType());
        boolean isDistributor = StringTool.equals(UserTypeEnum.DISTRIBUTOR.getCode(), loginUser.getUserType());
        boolean isShareholderSub = StringTool.equals(UserTypeEnum.SHAREHOLDER_SUB.getCode(), loginUser.getUserType());
        boolean isMerchantSub = StringTool.equals(UserTypeEnum.COMPANY_SUB.getCode(), loginUser.getUserType());
        boolean isDistributorSub = StringTool.equals(UserTypeEnum.DISTRIBUTOR_SUB.getCode(), loginUser.getUserType());
        if (isBoss) {
            if (isFreeze(loginUser)) {
                return new SysUserStatusVo(SysUserStatus.LOCKED, loginUser.getFreezeCode());
            }
            return new SysUserStatusVo(getSysUserStatus(loginUser.getStatus()));
        }
        List<SysUserExtend> users = mapper.findOwner(sysUserVo.getSearch().getId());
        for (SysUser user : users) {
            //1.股东账号、子账号 不会查询boss的状态
            //2.商户账号、商户子账号、总代账号、总代子账号 不会查询boss、股东的状态
            if ((isShareholder || isShareholderSub) &&
                    (StringTool.equals(UserTypeEnum.BOSS.getCode(), user.getUserType())
                            || StringTool.equals(UserTypeEnum.BOSS_SUB.getCode(), user.getUserType()))) {
                continue;
            }else if ((isMerchant || isMerchantSub || isDistributor || isDistributorSub
            )&&(StringTool.equals(UserTypeEnum.BOSS.getCode(), user.getUserType())
                            || StringTool.equals(UserTypeEnum.BOSS_SUB.getCode(), user.getUserType())
                            || StringTool.equals(UserTypeEnum.SHAREHOLDER.getCode(), user.getUserType())
                            || StringTool.equals(UserTypeEnum.SHAREHOLDER_SUB.getCode(), user.getUserType()))) {
                continue;
            }
            if (isFreeze(user)) return new SysUserStatusVo(SysUserStatus.LOCKED, user.getFreezeCode());
            if (!isNormal(user.getStatus())) return new SysUserStatusVo(getSysUserStatus(user.getStatus()));
        }
        return new SysUserStatusVo(SysUserStatus.NORMAL);
    }

    private boolean isFreeze(SysUser user) {
        Date now = new Date();
        return user.getFreezeEndTime() != null && now.getTime() < user.getFreezeEndTime().getTime();
    }

    private boolean isNormal(String status) {
        return SysUserStatus.NORMAL.getCode().equals(status);
    }

    @Override
    public Map<String, SysUserExtend> load() {
        List<SysUserExtend> list = mapper.search(Criteria.add(SysUserExtend.PROP_STATUS, Operator.EQ, SysUserStatus.NORMAL.getCode()),
                Order.asc(SysUserExtend.PROP_ID));
        return CollectionTool.toEntityMap(list, SysUserExtend.PROP_HID, String.class);
    }

    @Override
    @Transactional
    public SysUserExtendVo saveSysUser(SysUserExtendVo vo) {
        SysUserExtend user = vo.getResult();
        user.setCreateTime(new Date());
//        if(user.getCode()==null)
//            user.setCode(getCode(user));
        if (UserTypeEnum.COMPANY.getCode().equals(user.getUserType())) {
            user.setKey(getKey());
        }
        user.setPassword(AuthTool.md5SysUserPassword(user.getPassword(), user.getUsername())); //账户密码加密
        user.setPermissionPwd(AuthTool.md5SysUserPermission(user.getPermissionPwd(), user.getUsername()));//安全密码加密
        boolean isSuccess = this.mapper.insert(user);
        if (!isSuccess) {
            vo.setSuccess(false);
            return vo;
        }

        //分配角色
        String userType = user.getUserType();
        if (UserTypeEnum.BOSS_SUB.getCode().equals(userType)
                || UserTypeEnum.SHAREHOLDER_SUB.getCode().equals(userType)
                || UserTypeEnum.COMPANY_SUB.getCode().equals(userType)
                || UserTypeEnum.DISTRIBUTOR_SUB.getCode().equals(userType)
        ) {
            saveUserRoles(user.getId(), vo.getRoleIds());
        }
        vo.setResult(user);
        return vo;
    }

//    private String getCode(SysUserExtend user){
//        String userType = user.getUserType();
//        UserTypeEnum typeEnum = EnumTool.enumOf(UserTypeEnum.class,userType);
//        String code;
//        if (UserTypeEnum.COMPANY.equals(typeEnum)
//                || UserTypeEnum.COMPANY_SUB.equals(typeEnum)
//        ) {
//            code = getCode(3);
//        } else {
//            code = getCode(4);
//        }
//        return code;
//    }
//
//    private String getCode(int length) {
//        String code = null;
//        boolean flag = true;
//        while (flag) {
//            code = StringTool.upperCase(RandomStringTool.random(length, true, true));
//            long count = mapper.count(Criteria.add(SysUserExtend.PROP_CODE, Operator.EQ, code));
//            if (count == 0) {
//                flag = false;
//            }
//        }
//        return code;
//    }
//

    private String getKey() {
        String key = null;
        boolean flag = true;
        while (flag) {
            key = StringTool.upperCase(RandomStringTool.random(15, true, true));
            long count = mapper.count(Criteria.add(SysUserExtend.PROP_KEY, Operator.EQ, key));
            if (count == 0) {
                flag = false;
            }
        }
        return key;
    }

    /**
     * 删除旧的角色
     */
    private void deleteOldRoles(Integer userId, Integer[] roles) {
        if (userId == null || roles == null || roles.length == 0) {
            LOG.info("删除用户角色的用户id为空！");
            return;
        }
        //删除用户角色
        Criteria criteria = Criteria.add(SysUserRole.PROP_USER_ID, Operator.EQ, userId)
                .addAnd(SysUserRole.PROP_ROLE_ID, Operator.NOT_IN, roles);
        this.sysUserRoleMapper.batchDeleteCriteria(criteria);
    }

    /**
     * 保存角色
     */
    private void saveUserRoles(Integer userId, Integer[] roles) {
        List<SysUserRole> userRoles = UserTool.initUserRole(userId, roles);
        if (CollectionTool.isNotEmpty(userRoles)) {
            this.mapper.batchInsertUserRole(userRoles);
        }
    }
//
//    private LotteryContextParam contextParam() {
//        return LotteryCommonContext.get();
//    }

    @Override
    public long countUserName(String username) {
        return mapper.countUserName(username);
    }
//
//    @Override
//    public long countPlayerName(SysUserExtendVo vo) {
//        return mapper.countPlayerName(vo.getSearch());
//    }

    @Override
    @Transactional
    public SysUserExtendVo deleteSysUser(SysUserExtendVo sysUserExtendVo) {
        Integer userId = sysUserExtendVo.getSearch().getId();
        //根据useId删除sys_user_role 相对应的数据
        this.mapper.deleteSysUserRole(userId);

        //删除联系方式--邮箱
        Criteria criteria = Criteria.add(NoticeContactWay.PROP_USER_ID, Operator.EQ, userId)
                .addAnd(NoticeContactWay.PROP_CONTACT_TYPE, Operator.EQ, ContactWayType.EMAIL.getCode());
        noticeContactWayMapper.batchDeleteCriteria(criteria);

        boolean success = mapper.delete(userId);
        sysUserExtendVo.setSuccess(success);
        return sysUserExtendVo;
    }

    @Override
    public SysUserExtendVo viewSysUser(SysUserExtendVo sysUserExtendVo) {
        //账户信息
        Integer userId = sysUserExtendVo.getSearch().getId();
        String username = sysUserExtendVo.getSearch().getUsername();
        SysUserExtend sysUserExtend = new SysUserExtend();
        if (userId != null){
            sysUserExtend = mapper.get(sysUserExtendVo.getSearch().getId());
        }else if (StringTool.isNotBlank(username)){
            Criteria criteria = new Criteria();
            criteria.addAnd(SysUserExtend.PROP_USERNAME, Operator.EQ, username);
            List<SysUserExtend> search = mapper.search(criteria);
            if (CollectionTool.isNotEmpty(search) && search.size() == 1){
                sysUserExtend = search.get(0);
            }
        }
        sysUserExtendVo.setResult(sysUserExtend);
        return sysUserExtendVo;
    }

    @Override
    public SysUserExtendVo editAccount(SysUserExtendVo sysUserExtendVo) {
        SysUserExtend sysUserExtend = mapper.get(sysUserExtendVo.getSearch().getId());
        sysUserExtendVo.setResult(sysUserExtend);
        return sysUserExtendVo;
    }

    @Override
    @Transactional
    public SysUserExtendVo updateSysUser(SysUserExtendVo userExtendVo, SysUserExtend operator) {
        Integer userId = userExtendVo.getResult().getId();
        userExtendVo.setSuccess(false);
        if (userId == null || operator == null){
            userExtendVo.setErrMsg("参数错误，保存失败");
            return userExtendVo;
        }
        SysUserExtend user = this.mapper.get(userId);
        if (user == null){
            userExtendVo.setErrMsg("账号不存在，保存失败");
            return userExtendVo;
        }
        user.setUpdateUser(operator.getId());
        user.setUpdateName(operator.getUsername());
        user.setUpdateTime(new Date());
        user.setNickname(userExtendVo.getResult().getNickname());
        user.setRealName(userExtendVo.getResult().getRealName());
        user.setSex(userExtendVo.getResult().getSex());
        user.setBirthday(userExtendVo.getResult().getBirthday());
        boolean isSuccess = this.mapper.updateOnly(user, SysUserExtend.PROP_REAL_NAME,
                SysUserExtend.PROP_NICKNAME, SysUserExtend.PROP_BIRTHDAY, SysUserExtend.PROP_SEX,
                SysUserExtend.PROP_UPDATE_TIME, SysUserExtend.PROP_UPDATE_USER, SysUserExtend.PROP_UPDATE_NAME ,SysUserExtend.PROP_MANUAL_AUTO_SHIPMENTS);
        if (isSuccess) {
            //子账号删除旧的角色，再保存角色
            user = this.mapper.get(user.getId());
            String userType = user.getUserType();
            if (UserTypeEnum.BOSS_SUB.getCode().equals(userType)
                    || UserTypeEnum.SHAREHOLDER_SUB.getCode().equals(userType)
                    || UserTypeEnum.COMPANY_SUB.getCode().equals(userType)
                    || UserTypeEnum.DISTRIBUTOR_SUB.getCode().equals(userType)
            ) {
                deleteOldRoles(user.getId(), userExtendVo.getRoleIds());
                saveUserRoles(user.getId(), userExtendVo.getRoleIds());
            }
            userExtendVo.setSuccess(true);
            userExtendVo.setOkMsg("保存成功");
        }
        userExtendVo.setResult(user);
        return userExtendVo;
    }
//
    @Override
    public SysUserExtend findByUsername(SysUserExtendVo user) {
        if (StringTool.isBlank(user.getSearch().getUsername())) {
            throw new IllegalArgumentException("用户名不能为空！");
        }

        Criteria criteria = Criteria.add(SysUser.PROP_USERNAME, Operator.EQ, user.getSearch().getUsername())
                .addAnd(SysUser.PROP_SITE_ID, Operator.EQ, user.getSearch().getSiteId());
        if (SubSysCodeEnum.COMPANY.getCode().equalsIgnoreCase(user.getSearch().getSubsysCode())) {
            criteria.addOr(Criteria.add(SysUser.PROP_SUBSYS_CODE, Operator.EQ, user.getSearch().getSubsysCode()),
                    Criteria.add(SysUser.PROP_SUBSYS_CODE, Operator.EQ, SubSysCodeEnum.DISTRIBUTOR.getCode()));
        } else {
            criteria.addAnd(SysUser.PROP_SUBSYS_CODE, Operator.EQ, user.getSearch().getSubsysCode());
        }

        List<SysUserExtend> results = mapper.search(criteria, Order.asc(SysUser.PROP_ID));
        if (CollectionTool.isEmpty(results)) return null;

        return results.get(0);
    }
//
//    @Override
//    public void updateUserExtendByUserId(SysUserExtendVo vo) {
//        this.mapper.updateProperties(vo.getSearch().getId(),vo.getSearch().getMap());
//    }
//
//    @Override
//    public List<SysUserExtend> queryOnlinePlayer(SysUserExtendVo sysUserExtendVo) {
//        if(sysUserExtendVo==null){
//            throw new IllegalArgumentException("参数有误");
//        }
//        return mapper.queryOnlinePlayer(sysUserExtendVo.getSearch());
//    }
//
//    @Override
//    public List<SysUserExtend> queryAllPlayer(SysUserExtendVo sysUserExtendVo) {
//        if(sysUserExtendVo==null){
//            throw new IllegalArgumentException("参数有误");
//        }
//        return mapper.queryAllPlayer(sysUserExtendVo.getSearch());
//    }
//
//    @Override
//    @Transactional
//    public SysUserExtendVo addUserExtend(SysUserExtendVo vo) {
//        vo.setResult(initUserExtend(vo));
//        vo = insert(vo);
//
//        if (vo.isSuccess()) {
//            this.addUserPlayer(vo);
//            this.addUserAssets(vo);
////            this.addUserParams(vo);
//        }
//
//        return vo;
//    }
//
//    private SysUserExtend initUserExtend(SysUserExtendVo extendVo) {
//        SysUserExtend userExtend = extendVo.getResult();
//        if(StringTool.isBlank(userExtend.getNickname())){
//            userExtend.setNickname("--");
//        }
//        userExtend.setPassword(AuthTool.md5SysUserPassword(userExtend.getPassword(), userExtend.getUsername()));
//        userExtend.setCreateTime(new Date());
//        userExtend.setUpdateTime(userExtend.getCreateTime());
//        userExtend.setCreateUser(contextParam().getUserId());
//        userExtend.setSiteId(contextParam().getSiteId());
//        userExtend.setStatus(SysUserStatus.NORMAL.getCode());
//        userExtend.setUserType(UserTypeEnum.PLAYER.getCode());
//
//        // 玩家代号
////        userExtend.setCode(getCode(8));
//        // 商户ID
//        userExtend.setOwnerId(contextParam().getSiteUserId());
//
//        userExtend.setSubsysCode(SubSysCodeEnum.HALL.getCode());
//        userExtend.setDefaultTimezone(contextParam().getTimeZone().getDisplayName());
//        userExtend.setDefaultLocale(contextParam().getLocale().toString());
//        userExtend.setRegisterSite(contextParam().getDomain());
//
//        return userExtend;
//    }
//
//    @Override
//    public List<SysUserExtend> queryIgnoreCaseUserNamesExists(SysUserExtendVo userPlayerVo) {
//        return this.mapper.queryIgnoreCaseUserNamesExists(ListTool.newArrayList(userPlayerVo.getProperties()));
//    }
//
//    @Override
//    public int checkUsernameByMode(SysUserExtendVo vo) {
//        if (StringTool.isNotBlank(vo.getSearch().getUsername())){
//            return this.mapper.checkUsernameByMode(vo.getSearch());
//        }else {
//            return 0;
//        }
//    }
//
//    /** 新增玩家信息 */
//    private void addUserPlayer(SysUserExtendVo vo) {
//        UserPlayerVo userPlayerVo = new UserPlayerVo();
//        UserPlayer player = vo.getPlayer();
//        player.setId(vo.getResult().getId());
//        player.setPlayerName(vo.getResult().getUsername());
//        player.setPromoCode(getPromoCode());
//        if (player.getRankId()==null) {
//            player.setRankId(PlayerRank.DEFAULT_RANK_ID);
//        }
//
//        if (player.getSuperiorId() != null) {
////            Integer level = userPlayerService.calcLevel(player.getSuperiorId());
////            player.setLevel(level);
//
//        } else {
//            player.setLevel(1);
//        }
//        userPlayerVo.setResult(player);
////        userPlayerService.insert(userPlayerVo);
//    }
//
//    private String getPromoCode() {
//        String code = null;
//        boolean flag = true;
//        while (flag) {
//            code = RandomStringTool.random(6, false, true);
////            long count = this.userPlayerService.count(Criteria.add(UserPlayer.PROP_PROMO_CODE, Operator.EQ, code));
////            if (count == 0) {
////                flag = false;
////            }
//        }
//        return code;
//    }
//
//    /** 新增玩家资产记录 */
//    private void addUserAssets(SysUserExtendVo vo) {
//        UserAssetsVo userAssetsVo = new UserAssetsVo();
//        userAssetsVo.setResult(new UserAssets());
//        userAssetsVo.getResult().setId(vo.getResult().getId());
//        UserPlayer userPlayer = vo.getPlayer();
//        if(userPlayer != null && ModeEnum.TRYPLAY.getCode().equals(userPlayer.getMode())){
//            userAssetsVo.getResult().setBalance(10000d); //　试玩账号初始化金额
//        }else {
//            if(vo.getMoney() == null){
//                userAssetsVo.getResult().setBalance(0.0d);
//            }else{
//                userAssetsVo.getResult().setBalance(vo.getMoney());
//            }
//        }
//        userAssetsVo.getResult().setDepositCount(0);
//        userAssetsVo.getResult().setDepositTotal(0.0d);
//        userAssetsVo.getResult().setWithdrawCount(0);
//        userAssetsVo.getResult().setWithdrawTotal(0.0d);
//        userAssetsVo.getResult().setPayout(0.0d);
//        userAssetsVo.getResult().setTradeVolume(0.0d);
//        userAssetsVo.getResult().setEffectiveVolume(0.0d);
//        userAssetsVo.getResult().setBonus(0.0d);
//        userAssetsVo.getResult().setWages(0.0d);
//        userAssetsVo.getResult().setGive(0.0d);
//        userAssetsVo.getResult().setAward(0.0d);
//        userAssetsVo.getResult().setProfit(0.0d);
//        userAssetsVo.getResult().setBetTotal(0.0d);
////        userAssetsService.insert(userAssetsVo);
//    }
//
//    /** 新增玩家设置参数 */
////    private void addUserParams(SysUserExtendVo vo) {
////        Integer userId = vo.getResult().getId();
////        UserParamEnum[] enums = UserParamEnum.values();
////        List<UserParam> params = new ArrayList<>();
////        for (int i = 0; i < enums.length; i++) {
////            UserParam param = new UserParam();
////            param.setUserId(userId);
////            param.setParamType(enums[i].getType());
////            param.setParamCode(enums[i].getCode());
////            param.setParamValue(enums[i].getPreset());
////            param.setRemark(enums[i].getMemo());
////            param.setOrderNum(i+1);
////            param.setActive(true);
////            params.add(param);
////        }
////        userParamService.batchInsert(params);
////    }
//
//    @Override
//    public List<SysUserExtend> queryUserByRankId(SysUserExtendVo vo) {
//        return this.mapper.queryUserByRankId(vo.getSearch());
//    }
//
//    @Override
//    public List<SysUserExtend> findByUserplayListVo(UserPlayerListVo userPlayerListVo) {
//        return this.mapper.findByUserplayListVo(userPlayerListVo.getSearch());
//    }

    @Override
    public List<Map<String, Object>> queryOwnerIdList(Integer[] array,List<String> subsysCodes) {
        SysUserExtendSo so = new SysUserExtendSo();
        so.setOwner_ids(array);
        so.setSubSysCodes(subsysCodes);
        return this.mapper.queryOwnerIdList(so);
    }



    @Override
    public SysUserExtend getSysUserExtend(Integer id){
        return this.mapper.get(id);
    }

    public boolean updateUserInfoOnly(SysUserExtend userExtend, String... var2){
        return this.mapper.updateOnly(userExtend,var2);
    }

    @Transactional
    @Override
    public SysUserExtendVo updateManagerUser(SysUserExtendVo objectVo) {
        SysUserExtend sysUserExtend = mapper.get(objectVo.getResult().getId());
        String password = sysUserExtend.getPassword();
        if(StringTool.isNotBlank(objectVo.getResult().getPassword())){
            password = AuthTool.md5SysUserPassword(sysUserExtend.getUsername(), objectVo.getResult().getPassword());
        }
        objectVo.getResult().setPassword(password);
        boolean b = mapper.updateOnly(objectVo.getResult(), SysUserExtend.PROP_NICKNAME, SysUserExtend.PROP_CREDITS,
                SysUserExtend.PROP_MANUAL_AUTO_SHIPMENTS, SysUserExtend.PROP_BREAKPOINT,
                SysUserExtend.PROP_GENERAL, SysUserExtend.PROP_SUPERIOR_OCCUPY,
                SysUserExtend.PROP_STINT_OCCUPY, SysUserExtend.PROP_SET_ODDS,
                SysUserExtend.PROP_PASSWORD);
        objectVo.setSuccess(b);
        return objectVo;
    }


//
//    @Override
//    public boolean insertSysUserExtend(SysUserExtend userExtend) {
//        return this.mapper.insert(userExtend);
//    }
//
//    @Override
//    public List<SysUserExtend> searchSysUserExtends(Criteria criteria){
//        return this.mapper.search(criteria);
//    }
//
//    @Override
//    public SysUserExtend searchSysUserBySiteIdAndUserType(SysUserExtendVo sysUserExtendVo) {
//        Criteria criteria = Criteria.add(SysUserExtend.PROP_SITE_ID, Operator.EQ, sysUserExtendVo.getSearch().getSiteId())
//                .addAnd(SysUserExtend.PROP_USER_TYPE, Operator.EQ, sysUserExtendVo.getSearch().getUserType());
//        List<SysUserExtend> result = mapper.search(criteria);
//        return result.get(0);
//    }
//
//    @Override
//    public SysUserExtendListVo findDistributors(SysUserExtendListVo listVo) {
//        Criteria criteria = new Criteria();
//        criteria.addAnd(SysUserExtend.PROP_USER_TYPE, Operator.EQ, UserTypeEnum.DISTRIBUTOR.getCode());
//        criteria.addAnd(SysUserExtend.PROP_OWNER_ID,Operator.EQ,listVo.getSearch().getOwnerId());
//        criteria.addAnd(SysUserExtend.PROP_STATUS,Operator.EQ,listVo.getSearch().getStatus());
//        criteria.addAnd(SysUserExtend.PROP_SITE_ID,Operator.EQ,listVo.getSearch().getSiteId());
////        criteria.addAnd(SysUserExtend.PROP_USER_TYPE,Operator.EQ,listVo.getSearch().getUserType());
//        List<SysUserExtend> list = this.mapper.search(criteria);
//        listVo.setResult(list);
//        return listVo;
//    }



}