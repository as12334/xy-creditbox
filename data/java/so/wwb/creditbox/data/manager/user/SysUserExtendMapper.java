

package so.wwb.creditbox.data.manager.user;


import org.apache.ibatis.annotations.Param;
import org.soul.data.rdb.mybatis.IBaseMapper;
import org.soul.model.security.privilege.po.SysUserRole;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.so.SysUserExtendSo;

import java.util.List;
import java.util.Map;

public interface SysUserExtendMapper extends IBaseMapper<SysUserExtend, Integer> {
    /**
     * 获取所有者列表
     */
    List<SysUserExtend> findOwner(Integer id);

    /**
     * 增加登录失败次数
     */
    int incLoginErrorTimes(Integer id);

    /**
     * 批量保存用户角色关系（不重复新增）
     */
    int batchInsertUserRole(List<SysUserRole> userRoles);

    /**
     * 根据useId删除sys_user_role 相对应的数据
     */
    void deleteSysUserRole(Integer userId);

    /**
     * 系统账号同名数
     * @param username
     * @return
     */
    long countUserName(String username);




    /**
     * 玩家账号同名数
     * @param so
     * @return
     */
    long countPlayerName(SysUserExtendSo so);

    /** 根据useId 获取 subsysCode */
    String userSubsysCode(Integer userId);

    //根据id  查子id
    List<SysUserExtend> queryOwnerList(Integer id);

    List<SysUserExtend> queryOnlinePlayer(SysUserExtendSo sysUserExtendSo);

    List<SysUserExtend> queryAllPlayer(SysUserExtendSo sysUserExtendSo);

    /**
     * 存款成功后更新玩家钱包余额、充值成功次数、充值总金额
     */
    SysUserExtend queryPlayerByRecharge(SysUserExtendSo sysUserExtendSo);
    List<SysUserExtend> queryIgnoreCaseUserNamesExists(List<String> list);

    /**
     *检查用户是否是已存在的正式账号
     * @param sysUserExtendSo
     * @return
     */
    int checkUsernameByMode(SysUserExtendSo sysUserExtendSo);

    /**
     * 根据层级ID，查找玩家列表
     * @param so 玩家so
     * @return 玩家列表<id, username>
     */
    List<SysUserExtend> queryUserByRankId(SysUserExtendSo so);

    /**
     * 根据userplay id 获取  玩家列表
     */
//    List<SysUserExtend> findByUserplayListVo(UserPlayerSo so);

    // TODO 待删 使用 userPlayerMapper 的 findParentAgent
    Integer findUserParenterId(@Param("id")Integer id);

    List<Map<String,Object>> queryAddPlayer(SysUserExtendSo search);

    List<Map<String,Object>> queryAddPlayerAndDeposit(SysUserExtendSo search);

    List<Map<String,Object>> queryOwnerIdList(SysUserExtendSo so);

    List<SysUserExtend> searchLevelUser(SysUserExtendSo search);

    //endregion your codes 2

}