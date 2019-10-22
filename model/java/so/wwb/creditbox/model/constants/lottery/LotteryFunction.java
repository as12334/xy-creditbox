package so.wwb.creditbox.model.constants.lottery;

public interface LotteryFunction {



    /**
     * 初始化站点赔率
     * @param 站点id
     * @param 用户唯一标识
     */
    String F_INIT_SITE_LOTTERY_ODD="SELECT f_init_site_lottery_odd(?,?)";


    /**
     * 初始化开奖结果
     * @param 日期
     * @param 彩种 为空初始化全部彩种，多个用,隔开
     */
    String F_INIT_LOTTERY_RESULT="SELECT f_init_lottery_result(?,?)";

    /**
     * 派彩
     * @param 期数
     * @param 彩种代号
     * @param 运营商链接串
     */
    String CALL_LOTTERY_PAYOUT = "{call lottery_payout(?,?,?,?)}";

    /**
     * 重结
     * @param 期数
     * @param 彩种代号
     * @param 运营商链接串
     */
    String CALL_HEAVY_PAYOUT = "{call lottery_payout_heavy(?,?,?,?)}";

    /**
     * 汇总
     * @param 站点链接串
     * @param 站点id
     * @param 彩种code
     * @param 期数
     */
    String CALL_LOTTERY_ORDER_SUMMARY = "{call f_summary_lottery_order(?,?,?,?)}";

    /**
     * 撤单
     * @param 彩种代号
     * @param 期数
     */
    String CALL_LOTTERY_REVOKE = "{call lottery_revoke(?,?)}";

    /**
     * 撤销
     * @param 彩种代号
     * @param 期数
     */
    String CALL_LOTTERY_REVOCATION = "{call lottery_revocation(?,?)}";

    //data archiving
    String CALL_DATA_ARCHIRVING = "{call bk_bet_transaction(?,?)}";

    //返水
    String CALL_LB_RAKEBACK = "{call lb_rakeback(?)}";

    //工资
    String CALL_LB_SALARY = "{call lb_salary(?)}";

    //退水
    String CALL_LB_RETREAT = "{call lb_retreat(?)}";

    //游戏报表
    String CALL_LB_REPORT_GAME_MERCHANT = "{call lb_report_game_merchant(?,?)}" ;

    //运营报表
    String CALL_LB_REPORT_OPERATE = "{call lb_report_operate(?)}";

    //黑名单
    String CALL_F_INIT_SITE_CONFINE_AREA = "{call f_init_site_confine_area(?)}";

    //分红
    String CALL_LB_DIVIDEN = "{call lb_dividen(?)}";
    //玩家报表统计
    String CALL_LB_REPORT_PLAYER_TOTAL = "{call lb_report_player(?,?,?)}";

    //经营报表
    String CALL_LB_REPORT_BUSINESS = "{call lb_report_business(?)}";

    //删除试玩,代玩账号
    String CALL_LB_REMOVE_PLAYER = "{call lb_delete_player()}";
}
