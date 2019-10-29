package so.wwb.creditbox.service.company.user;

import org.soul.commons.lang.string.RandomStringTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.data.mapper.security.privilege.SysUserMapper;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.data.company.user.VSiteUserMapper;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import java.util.Date;


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
    private SysUserMapper sysUserMapper;

    @Override
    public VSiteUserVo searchLevelUser(VSiteUserVo objectVo) {
        objectVo.setSuperUserList(mapper.searchLevelUser(objectVo.getSearch()));
        return objectVo;
    }

    @Override
    public SysUserExtendVo saveManagerUser(SysUserExtendVo objectVo) {
        SysUserExtend user = objectVo.getResult();
        user.setCreateTime(new Date());
        user.setKey(getKey());
        user.setPassword(AuthTool.md5SysUserPassword(user.getPassword(), user.getUsername())); //账户密码加密
        user.setPermissionPwd(AuthTool.md5SysUserPermission(user.getPermissionPwd(), user.getUsername()));//安全密码加密
        boolean isSuccess =sysUserMapper.insert(user);

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
            long count = mapper.count(Criteria.add(SysUserExtend.PROP_HID, Operator.EQ, Thid + hid));
            if (count == 0) {
                flag = false;
            }
        }
        return Thid + hid;
    }

    @Override
    public void doInitUserLotteryOdd(SysUserExtendVo objectVo) {
        mapper.doInitUserLotteryOdd(objectVo.getResult());
    }
    @Override
    public void doInitUserLotteryRebate(SysUserExtendVo objectVo) {
        mapper.doInitUserLotteryRebate(objectVo.getResult());
    }
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