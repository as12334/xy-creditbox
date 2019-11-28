package so.wwb.creditbox.iservice.manager.user;

import org.soul.commons.bean.Pair;
import org.soul.iservice.support.IBaseService;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.vo.SysUserStatusVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ISysUserExtendService extends IBaseService<SysUserExtendListVo, SysUserExtendVo, SysUserExtend, Integer> {

    /**
     * 根据用户名查找其权限
     * @return 权限表达式列表
     */
    Set<String> findPermissions(PassportVo passportVo);

    /**
     * 根据用户名查找url和权限对象
     *
     * @return Map<url, 权限表达式>
     */
    Map<String, Pair<String, Boolean>> findPermissionMapping(PassportVo passportVo);
//
//    /**
//     * 查询用户的状态,此状态是级联的状态,如上级非正常状态,刚使用上级的状态
//     * 1.boss主账号状态链： 全平台的管理账号
//     * 2.股东主账号状态链： 股东子账号
//     * 3.商户主账号状态链： 商户子账号、总代主账号、总代子账号
//     *
//     */
    SysUserStatusVo getStatus(PassportVo passportVo);
//
////    WebJson checkStatus(SysUserExtendVo extendVo, WebJson webJson);
//
    /**
     * 加载所有用户作缓存.
     */
    Map<String, SysUserExtend> load();

    /**
     * 保存用户账号
     */
    SysUserExtendVo saveSysUser(SysUserExtendVo vo);

    /**
     * 更新用户账号
     */
    SysUserExtendVo updateSysUser(SysUserExtendVo userExtendVo, SysUserExtend operator);

//    String getHid(String Thid);

    /**
     * 系统账号同名数
     * @param sysUserExtendVo
     * @return
     */
    long countUserName(SysUserExtendVo sysUserExtendVo);
//
//    /**
//     * 玩家账号同名数
//     * @param vo
//     * @return
//     */
//    long countPlayerName(SysUserExtendVo vo);
//
    /**
     * 删除用户,同时删除用户所拥有的角色,联系方式
     */
    SysUserExtendVo deleteSysUser(SysUserExtendVo sysUserExtendVo);

    /**
     * 详细查询
     */
     SysUserExtendVo viewSysUser(SysUserExtendVo sysUserExtendVo);

    /**
     * 编辑
     */
     SysUserExtendVo editAccount(SysUserExtendVo sysUserExtendVo);

    /**
     * 根据用户名查找用户
     */
    SysUserExtend findByUsername(SysUserExtendVo vo);
//
//    void updateUserExtendByUserId(SysUserExtendVo vo);
//
//    /**
//     * 根据数据源ID 查询在线玩家
//     */
//    List<SysUserExtend> queryOnlinePlayer(SysUserExtendVo sysUserExtendVo);
//    /**
//     * 根据数据源ID 查询所有玩家
//     */
//
//    List<SysUserExtend> queryAllPlayer(SysUserExtendVo sysUserExtendVo);
//
//    /** 新增玩家 */
//    SysUserExtendVo addUserExtend(SysUserExtendVo vo);
//
//
//    /**
//     * 查询存在的玩家账号（忽略大小写）
//     */
//    List<SysUserExtend> queryIgnoreCaseUserNamesExists(SysUserExtendVo vo);
//
//    /**
//     * 检查用户是否是已存在的正式账号
//     * @param vo
//     * @return
//     */
//    int checkUsernameByMode(SysUserExtendVo vo);
//
//
//    /**
//     * 根据层级ID，查找玩家列表(仅查询正式账号)
//     * @param vo 玩家vo
//     * @return 玩家列表<id, username>
//     */
//    List<SysUserExtend> queryUserByRankId(SysUserExtendVo vo);
//
////    List<SysUserExtend> findByUserplayListVo(UserPlayerListVo userPlayerListVo);
//
    List<Map<String,Object>> queryOwnerIdList(Integer[] array, List<String> subsysCodes);
//
//
    SysUserExtend getSysUserExtend(Integer id);
//
//
    boolean updateUserInfoOnly(SysUserExtend userExtend, String... var2);

    SysUserExtendVo updateManagerUser(SysUserExtendVo objectVo);

    List<SysUserExtend> findOwner(SysUserExtendVo sysUserExtendVo);

    Double getUsedCredit(SysUserExtendVo sysUserExtendVo);

//
//    boolean insertSysUserExtend(SysUserExtend userExtend);
//
//    List<SysUserExtend> searchSysUserExtends(Criteria criteria);
//
//    SysUserExtend searchSysUserBySiteIdAndUserType(SysUserExtendVo sysUserExtendVo);
//
//    /**
//     * 获取商户除默认总代的其他总代账号
//     * @param listVo
//     * @return
//     */
//    SysUserExtendListVo findDistributors (SysUserExtendListVo listVo);

}