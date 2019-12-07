package so.wwb.creditbox.service.company.user;

import org.soul.commons.bean.BeanTool;
import org.soul.commons.lang.string.RandomStringTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.data.company.user.VSiteUserMapper;
import so.wwb.creditbox.data.manager.user.SysUserExtendMapper;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import java.util.Date;
import java.util.List;


/**
 * 服务
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class VSiteUserService extends BaseService<VSiteUserMapper, VSiteUserListVo, VSiteUserVo, VSiteUser, Integer> implements IVSiteUserService {
//endregion your codes 1

    //region your codes 2
    @Autowired
    private SysUserExtendMapper sysUserExtendMapper;

    @Override
    public VSiteUserVo sumSuperStintOccupy(VSiteUserVo objectVo) {
        SysUserExtend parentUser = objectVo.getParentUser();
        Integer sumSuperStintOccupy;
        //新增用户只查询上级占成情况
        if(objectVo.getSearch().getId() == null){
            sumSuperStintOccupy = mapper.sumSuperStintOccupy(parentUser.getId());
        }
        else {
            //编辑用户要查询上级和下级占成情况
           sumSuperStintOccupy = mapper.sumSuperStintOccupyCount(objectVo.getResult().getHid());
        }
        if(parentUser.getStintOccupy() > (100 - sumSuperStintOccupy)){
            parentUser.setSuperiorOccupy(parentUser.getStintOccupy());
        }
        else {
            parentUser.setSuperiorOccupy(100 - sumSuperStintOccupy);
        }
        objectVo.setParentUser(parentUser);
        return objectVo;
    }

    @Transactional
    @Override
    public SysUserExtendVo saveManagerUser(SysUserExtendVo objectVo) {
        SysUserExtend user = objectVo.getResult();
        user.setCreateTime(new Date());
        user.setKey(getKey());
        user.setPassword(AuthTool.md5SysUserPassword(user.getPassword(), user.getUsername())); //账户密码加密
        user.setPermissionPwd(AuthTool.md5SysUserPermission(user.getPermissionPwd(), user.getUsername()));//安全密码加密
        boolean isSuccess = sysUserExtendMapper.insert(user);

        //只有分公司並且開啟了賠率設置 才能新增賠率
        if(objectVo.getResult().getUserType().equals(UserTypeEnum.BRANCH.getCode())){
            mapper.doInitUserLotteryOdd(objectVo.getResult());
        }
        //只有新增主賬號才有返水設置
        if(objectVo.getResult().getUserType().length()==1){
            mapper.doInitUserLotteryRebate(objectVo.getResult());

        }

        if (!isSuccess) {
            objectVo.setSuccess(false);
            return objectVo;
        }
        objectVo.setResult(user);
        return objectVo;
    }
    /**
     * 生成用户的唯一标示
     * @param Thid 上级的
     * @return
     */
    @Override
    public String getHid(String Thid) {
        String hid = null;
        boolean flag = true;
        while (flag) {
            hid = StringTool.upperCase(RandomStringTool.random(8, true, true));
            long count = sysUserExtendMapper.count(Criteria.add(SysUserExtend.PROP_HID, Operator.EQ, Thid + hid));
            if (count == 0) {
                flag = false;
            }
        }
        return Thid + hid;
    }

    @Override
    public VSiteUserVo searchSuperUser(VSiteUserVo objectVo) {
        VSiteUserSo search = objectVo.getSearch();
        List<VSiteUser> parentUsers = mapper.searchLevelUser(search);
        //不能跨级新增账户
        if(parentUsers == null){
            objectVo.setSuccess(false);
            objectVo.setErrMsg("抱歉！您不能跨級新增帳戶！");
            return objectVo;
        }
        objectVo.setSuperUserList(parentUsers);
        SysUserExtend parendUser;
        //如果是新增，上级就是列表的第一个
        if(objectVo.getSearch().getId() == null){
            parendUser = new SysUserExtend();
            parendUser = BeanTool.copyProperties(parentUsers.get(0), parendUser);
        }else {
            parendUser = sysUserExtendMapper.get(search.getOwnerId());
        }
        objectVo.setParentUser(parendUser);
        return objectVo;
    }

//    @Override
//    public SysUserExtendVo sumSuperStintOccupy(SysUserExtendVo objectVo) {
//        Integer sumSuperStintOccupy = mapper.sumSuperStintOccupy(objectVo.getSearch());
//        objectVo.setSumSuperStintOccupy(sumSuperStintOccupy);
//        return objectVo;
//    }
//
//    @Override
//    public SysUserExtendVo sumSuperStintOccupyCount(SysUserExtendVo objectVo) {
//        Integer sumSuperStintOccupy = mapper.sumSuperStintOccupyCount(objectVo.getSearch());
//        objectVo.setSumSuperStintOccupy(sumSuperStintOccupy);
//        return objectVo;
//    }

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

    //endregion your codes 2

}