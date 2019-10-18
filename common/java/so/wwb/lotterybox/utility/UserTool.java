package so.wwb.lotterybox.utility;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.security.privilege.po.SysUserRole;

import java.util.ArrayList;
import java.util.List;

public class UserTool {

    private static final Log LOG = LogFactory.getLog(UserTool.class);

    public static List<SysUserRole> initUserRole(Integer userId, Integer[] roles) {
        if (roles == null || roles.length == 0 || userId == null) {
            LOG.info("保存用户角色的用户id为空！");
            return null;
        }
        List<SysUserRole> userRoles = new ArrayList<>(roles.length);
        List<Integer> roleIds = new ArrayList<>();
        SysUserRole userRole;
        for (Integer role : roles) {
            if (!roleIds.contains(role)) {
                userRole = new SysUserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(role);
                roleIds.add(role);
                userRoles.add(userRole);
            }
        }
        return userRoles;
    }

}
