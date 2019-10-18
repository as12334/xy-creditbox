package so.wwb.creditbox.lottery;

import org.soul.model.security.privilege.po.SysUser;
import so.wwb.creditbox.model.manager.lottery.bean.OrderBean;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;

import java.util.Date;

/**
 * 投注业务工具类
 * Create by Fei on 2018-03-01
 */
public final class BetOrderTool {

    /**
     * 封装投注对象实体
     * @param order 投注对象（多批次）
     * @param status 状态
     * @param vo LotteryBetOrderVo
     * @return LotteryBetOrder
     */
    public static LotteryBetOrder packageOrder(LotteryBetOrder order, String status, LotteryBetOrderVo vo) {
        SysUser user = vo.getUser();
        if (user != null) {
            order.setUserId(user.getId());
            order.setUsername(user.getUsername());
        }
        order.setBillNo(vo.getSearch().getBillNo());
        OrderBean bean = vo.getOrderBean();
        if (bean != null) {
            order.setCode(bean.getCode());
            order.setExpect(bean.getExpect());
            order.setPlayModel(bean.getPlayModel());
        }
        order.setBetTime(new Date());
        order.setTerminal(vo.getTerminal());
        order.setStatus(status);
//        UserPlayer agent = vo.getAgent();
//        if (agent != null) {
//            order.setParentAgenterId(agent.getId());
//            order.setParentAgenterName(agent.getPlayerName());
//        }
        return order;
    }

}
