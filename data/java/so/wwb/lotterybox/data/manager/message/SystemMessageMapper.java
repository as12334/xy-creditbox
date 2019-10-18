package so.wwb.lotterybox.data.manager.message;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.message.po.SystemMessage;
import so.wwb.lotterybox.model.message.so.SystemMessageSo;

import java.util.List;

/**
 * Created by jeremy on 18-3-30.
 */
public interface SystemMessageMapper  extends IBaseMapper<SystemMessage, Integer> {

    /**
     * 我的系统信息列表
     * @param so receiverUserId(接收者Id)  not null
     * @return
     */
    List<SystemMessage> queryMyMessageList(SystemMessageSo so);

    /**
     * 我的系统信息总条数
     * @param so
     * @return
     */
    int myMessageTotalCount(SystemMessageSo so);

}
