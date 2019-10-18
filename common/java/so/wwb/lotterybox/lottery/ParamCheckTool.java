package so.wwb.lotterybox.lottery;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.lotterybox.model.manager.lottery.bean.OrderBean;

/**
 * Create by Fei on 2018-02-25
 */
public class ParamCheckTool {

    private static final Log LOG = LogFactory.getLog(ParamCheckTool.class);

    public static boolean checkParam(OrderBean bean, SysUser user) {
        if (bean == null) {
            LOG.info("新增彩票投注订单异常：OrderBean 为空");
            return true;
        }
        if (user == null) {
            LOG.info("新增彩票投注订单异常：user 为空");
            return true;
        }
        return false;
    }


}
