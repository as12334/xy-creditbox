package so.wwb.creditbox.web.remote.controller;

import org.soul.commons.collections.MapTool;
import org.soul.commons.lang.string.StringTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 远程验证控制器
 * <p>
 * Created by jeremy on 18-9-27.
 */

@Controller
@RequestMapping("/remote")
public class CheckToolController {




    /**
     * 玩家账号-检查用户名是否已存在
     *
     * @param username 输入的用户名
     * @return true-可修改 false-不可修改
     */
    @RequestMapping("/checkPlayerName")
    @ResponseBody
    public Boolean checkPlayerName(@RequestParam("username") String username) {
        SysUserExtendVo userExtendVo = new SysUserExtendVo();
        userExtendVo.getSearch().setUsername(username);
        userExtendVo._setDataSourceId(SessionManagerCommon.getSiteId());
//        long count = ServiceTool.sysUserExtendService().countPlayerName(userExtendVo);
        return null;
    }


    /**
     * 平台账号-检查用户名是否已存在
     * 不同站点的子账号、总代账号、玩家账号可以一样，根据站点code区分
     * <p>
     * 组装用户名进行查询
     * 1.创建股东、商户账号时，因为没有创建所属站点，账户名用的是临时后缀，所以应做前缀匹配
     * 2.创建总代账号、所有子账号时，应做全匹配
     *
     * @param username 用户名 not null
//     * @param userType 用户类型 not null
//     * @param ownerId  上级ID not null
     * @return
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Boolean checkUsername(@RequestParam("result.username") String username,@RequestParam("result.userType") String userType) {
        SysUserExtendVo objectVo = new SysUserExtendVo();
        objectVo.setResult(new SysUserExtend());
        objectVo.getResult().setUsername(username +"@%");
//        objectVo.getResult().setUserType(userType);
//        objectVo.getResult().setOwnerId(ownerId);
        //除了查找分公司的上級要用管理庫，其他的要切到相應的站點庫
        if( UserTypeEnum.BRANCH.getCode().equals(userType)
                || UserTypeEnum.DISTRIBUTOR.getCode().equals(userType)
                || UserTypeEnum.AGENT.getCode().equals(userType)
                || UserTypeEnum.PLAYER.getCode().equals(userType)){
            objectVo.setDataSourceId(SessionManagerCommon.getSiteId());
        }
        return SysParamTool.checkManageUsername(objectVo);
    }


    /**
     * 持卡人姓名与用户的真实姓名对比检查
     * 必须保持一致, 参数为空默认通过
     *
     * @param userId     玩家ID
     * @param masterName 持卡人姓名
     * @return Boolean true: 通过  false: 不通过
     */
    @RequestMapping("/checkMasterName")
    @ResponseBody
    public Boolean checkMasterName(@RequestParam("result.userId") Integer userId, @RequestParam("result.masterName") String masterName) {
        String realName = SysParamTool.querySysUser(SessionManagerCommon.getSiteId(), userId).getRealName();
        return StringTool.isBlank(realName) ||
                (userId != null && StringTool.isNotBlank(masterName) && StringTool.isNotBlank(realName) && StringTool.equals(masterName, realName));
    }

    /**
     * 平台账号
     * 修改登录密码检查
     * 新密码不能与旧密码相同
     *
     * @param password 用户输入的密码
     * @return true-可修改 false-不可修改
     */
    @RequestMapping("/checkPassword")
    @ResponseBody
    public Boolean checkPassword(@RequestParam("password") String password) {
        return SysParamTool.checkPasswordParam(password);
    }

    /**
     * 平台账号
     * 修改权限密码检查
     * 新权限密码不能与原权限密码相同
     *
     * @param password 用户输入的权限密码
     * @return true-可修改 false-不可修改
     */
    @RequestMapping("/checkPrivilegePassword")
    @ResponseBody
    public Boolean checkPrivilegePassword(@RequestParam("password") String password) {
        return SysParamTool.checkPrivilegePasswordParam(password);
    }

    /**
     * 商户站点检查
     *
     * @param siteId 站点ID
     * @return true-存在 false-不存在
     */
    @RequestMapping("/checkSite")
    @ResponseBody
    public Boolean checkSite(Integer siteId) {
        return SysParamTool.checkCompanySite(siteId);
    }


    /**
     * 远程校验登录ip
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/checkLoginIp")
    @ResponseBody
    public boolean checkLoginIp(@RequestParam("search.lastLoginIpStr") String ip) {
        Map map = SysParamTool.fetchStartEndIp(ip);
        return MapTool.getBoolean(map, "state");
    }

    /**
     * 远程校验登录ip
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/checkIp")
    @ResponseBody
    public boolean checkIp(@RequestParam("search.ip") String ip) {
        Map map = SysParamTool.fetchStartEndIp(ip);
        return MapTool.getBoolean(map, "state");
    }

    /**
     * 远程校验注册ip
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/checkRegisterIp")
    @ResponseBody
    public boolean checkRegisterIp(@RequestParam("search.registerIpStr") String ip) {
        Map map = SysParamTool.fetchStartEndIp(ip);
        return MapTool.getBoolean(map, "state");
    }


}
