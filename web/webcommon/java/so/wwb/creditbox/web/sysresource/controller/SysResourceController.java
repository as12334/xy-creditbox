package so.wwb.creditbox.web.sysresource.controller;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.tree.JsTreeNode;
import org.soul.commons.tree.TreeNode;
import org.soul.model.security.privilege.po.VSysUserResource;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.web.init.ConfigBase;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class SysResourceController extends org.soul.web.security.privilege.controller.SysResourceController {

    @Override
    public String fetchRootMenus() {
        SysResourceVo o = new SysResourceVo();
        UserTypeEnum userType = EnumTool.enumOf(UserTypeEnum.class,SessionManagerCommon.getUser().getUserType());
        if (userType == null) {
            throw new NullPointerException(MessageFormat.format("站点ID:[{0}],用户ID:[{0}]的用户类型不能为空!",SessionManagerCommon.getSiteId(),SessionManagerCommon.getUserId()));
        }
        if (!UserTypeEnum.BOSS.equals(userType)
                && !UserTypeEnum.COMPANY.equals(userType)
                /*&& !UserTypeEnum.COMPANY.API.equals(userType)*/
                && !UserTypeEnum.DISTRIBUTOR.equals(userType)
                /*&& !UserTypeEnum.DISTRIBUTOR.API.equals(userType)*/
                && !UserTypeEnum.SHAREHOLDER.equals(userType)
                ) {
            o.getSearch().setUserId(SessionManagerCommon.getUserId());
        }
        o.getSearch().setSubsysCode(ConfigBase.get().getSubsysCode());
        List<TreeNode<VSysUserResource>> menuNodeList = getService().getRootMenus(o);
        loadLocal(menuNodeList);
        return JsonTool.toJson(menuNodeList);
    }
	/**
     * 获取所有菜單
     * @return
     */
    @RequestMapping("/fetchAllMenus")
    @ResponseBody
    public String fetchAllMenus() {
        SysResourceVo o = new SysResourceVo();
        SysUserExtend user = SessionManagerCommon.getSysUserExtend();
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class,user.getUserType());
        switch (userTypeEnum) {
            case BOSS_SUB:
            case SHAREHOLDER_SUB:
            case COMPANY_SUB:
            /*case MERCHANT_API_SUB:*/
            case DISTRIBUTOR_SUB:
            /*case DISTRIBUTOR_API_SUB:*/
                o.getSearch().setUserId(SessionManagerCommon.getUserId());
            default:
                break;
        }
        o.getSearch().setSubsysCode(user.getSubsysCode());
        List<TreeNode<VSysUserResource>> menuNodeList = getService().getAllMenus(o);
        loadLocal(menuNodeList);
        return JsonTool.toJson(menuNodeList);
    }

	/**
     * 去掉子账号
     * @param menuNodeList
     * @return
     */
    private List<TreeNode<VSysUserResource>> removeSubAccount(List<TreeNode<VSysUserResource>> menuNodeList){
        if(menuNodeList==null||menuNodeList.size()==0){
            return menuNodeList;
        }
        for(TreeNode<VSysUserResource> menu : menuNodeList){
            if(menu.getObject().getId().intValue()!=7){
                continue;
            }
            List<TreeNode<VSysUserResource>> children = menu.getChildren();
            if(children ==null||children.size()==0){
                continue;
            }
            List<TreeNode<VSysUserResource>> newChildren = new ArrayList<>();
            for(TreeNode<VSysUserResource> child : children){
                if(!"subAccount/list.html".equals(child.getObject().getResourceUrl())){
                    newChildren.add(child);
                }
            }
            menu.setChildren(newChildren);
        }
        return menuNodeList;
    }

    @Override
    protected void setSubsysCode(SysResourceVo o) {
        o.setSubsysCode(SessionManagerCommon.getUser().getSubsysCode());
    }

    @Override
    public List<JsTreeNode> listResourceTree(SysResourceVo o) {
        List<JsTreeNode> jsTreeNodes = super.listResourceTree(o);

        if (Objects.equals(UserTypeEnum.DISTRIBUTOR.getCode(), SessionManagerCommon.getUserType().getCode())) {
            for (JsTreeNode jsTreeNode : jsTreeNodes) {
                if (Objects.equals(jsTreeNode.getText(), "账户")) {
                    List<JsTreeNode> jsTreeNodeChidrens = jsTreeNode.getChildren();
                    for (int i = 0; i < jsTreeNodeChidrens.size(); i++) {
                        if (Objects.equals(jsTreeNodeChidrens.get(i).getText(), "账户管理")) {
                            jsTreeNodeChidrens.remove(i);
                            jsTreeNode.setChildren(jsTreeNodeChidrens);
                            return jsTreeNodes;
                        }
                    }
                }
            }
        }
            return jsTreeNodes;
    }
}
