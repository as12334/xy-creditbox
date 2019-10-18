package so.wwb.creditbox.iservice.manager.message;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.message.po.SystemMessage;
import so.wwb.creditbox.model.message.vo.SystemMessageListVo;
import so.wwb.creditbox.model.message.vo.SystemMessageVo;

import java.util.List;

/**
 * Created by jeremy on 18-3-30.
 */
public interface ISystemMessageService extends IBaseService<SystemMessageListVo, SystemMessageVo, SystemMessage, Integer> {

    /**
     * 新增系统消息
     * @param systemMessageVo
     * @param userExtend
     * @return
     */
    SystemMessageVo saveSystemMessage(SystemMessageVo systemMessageVo, SysUserExtend userExtend);

    Boolean deleteMessage(SystemMessageVo messageVo);

    /**
     * 查询自己的系统信息列表
     * @param listVo  search.receiverUserId(接收者Id)  not null
     * @return
     */
    List<SystemMessage> queryMyMessageList(SystemMessageListVo listVo);


    int myMessageTotalCount(SystemMessageListVo listVo);


}
