package so.wwb.creditbox.mdcenter.comet.websocket;

import org.soul.comet.websocket.BaseWebSocketHandler;
import org.soul.comet.websocket.model.SocketInfo;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;

import java.util.*;

/**
 * lb基础webSocket处理
 * @author marz
 * @time 2018-04-18 16:30:46
 */
public abstract class LbWebSocketHandler extends BaseWebSocketHandler {
    protected static final Log LOG = LogFactory.getLog(LbWebSocketHandler.class);

    /**
     * 根据股东id取当前股东下的所有商户id
     * @param shareHolderId
     * @return
     */
    protected Set<Integer> getSiteIdByShareHolderId(Integer shareHolderId) {
        SysUserExtendListVo listVo = new SysUserExtendListVo();
        listVo.setProperties(SysUserExtend.PROP_SITE_ID);
        Map<String, Object> map = new HashMap<>(3,1f);
        map.put(SysUserExtend.PROP_SUBSYS_CODE, SubSysCodeEnum.COMPANY.getCode());
        map.put(SysUserExtend.PROP_USER_TYPE, UserTypeEnum.COMPANY.getCode());
        map.put(SysUserExtend.PROP_OWNER_ID, shareHolderId);
        listVo.setConditions(map);
        List<Integer> siteIdList = ServiceTool.sysUserExtendService().oneSearchProperty(listVo);
        Set<Integer> result = new HashSet<>(siteIdList);
        //避免存在空对象
        result.remove(null);
        return result;
    }

    /**
     * 根据subSysCode,获取用户表的site_id字段值
     * @param subSysCode
     * @return
     */
    protected Set<Integer> getAllIdList(String subSysCode) {
        SysUserExtendListVo listVo = new SysUserExtendListVo();
        listVo.setProperties(SysUserExtend.PROP_SITE_ID);
        Map<String, Object> map = new HashMap<>(1,1f);
        map.put(SysUserExtend.PROP_SUBSYS_CODE, subSysCode);
        listVo.setConditions(map);
        List<Integer> siteIdList = ServiceTool.sysUserExtendService().oneSearchProperty(listVo);
        Set<Integer> result = new HashSet<>(siteIdList);
        //避免存在空对象
        result.remove(null);
        return result;
    }

    /**
     * 根据siteId,SubSysCode获取用户表的id
     * @param siteId
     * @return
     */
    protected Set<Integer> getAllIdListBySiteIdAndSubSysCode(Integer siteId,String code) {
        SysUserExtendListVo listVo = new SysUserExtendListVo();
        listVo.setProperties(SysUserExtend.PROP_ID);
        Map<String, Object> map = new HashMap<>(1,1f);
        map.put(SysUserExtend.PROP_SUBSYS_CODE, code);
        map.put(SysUserExtend.PROP_SITE_ID, siteId);
        listVo.setConditions(map);
        List<Integer> siteIdList = ServiceTool.sysUserExtendService().oneSearchProperty(listVo);
        Set<Integer> result = new HashSet<>(siteIdList);
        //避免存在空对象
        result.remove(null);
        return result;
    }

    /**
     * 默认不推送
     * @param socketInfo
     * @param messageVo
     * @return
     */
    @Override
    public boolean sessionCheck(SocketInfo socketInfo, MessageVo messageVo) {
        return false;
    }

}
