package so.wwb.creditbox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.message.po.SystemMessage;
import so.wwb.creditbox.model.message.so.SystemMessageSo;

import java.util.List;
import java.util.Map;

/**
 * boss->>站点 消息查询对象（新）
 * Created by jeremy on 18-3-30.
 */
public class SystemMessageVo extends BaseObjectVo<SystemMessage,SystemMessageSo,SystemMessageVo.SystemMessageQuery> {

    private static final long serialVersionUID = 2658410413394996811L;

    public static class SystemMessageQuery extends AbstractQuery<SystemMessageSo> {

        private static final long serialVersionUID = 3023356738938961728L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }

    private List<Map<String,String>> shareholderMsg;
    private List<Map<String,String>> merchantMsg;
    //总代
    private List<Map<String,String>> agentMsg;

    private List<Map<String,String>> merchantApiMsg;
    //总代
    private List<Map<String,String>> agentApiMsg;

    public List<Map<String, String>> getShareholderMsg() {
        return shareholderMsg;
    }

    public void setShareholderMsg(List<Map<String, String>> shareholderMsg) {
        this.shareholderMsg = shareholderMsg;
    }

    public List<Map<String, String>> getMerchantMsg() {
        return merchantMsg;
    }

    public void setMerchantMsg(List<Map<String, String>> merchantMsg) {
        this.merchantMsg = merchantMsg;
    }

    public List<Map<String, String>> getAgentMsg() {
        return agentMsg;
    }

    public void setAgentMsg(List<Map<String, String>> agentMsg) {
        this.agentMsg = agentMsg;
    }

    public List<Map<String, String>> getMerchantApiMsg() {
        return merchantApiMsg;
    }

    public void setMerchantApiMsg(List<Map<String, String>> merchantApiMsg) {
        this.merchantApiMsg = merchantApiMsg;
    }

    public List<Map<String, String>> getAgentApiMsg() {
        return agentApiMsg;
    }

    public void setAgentApiMsg(List<Map<String, String>> agentApiMsg) {
        this.agentApiMsg = agentApiMsg;
    }
}
