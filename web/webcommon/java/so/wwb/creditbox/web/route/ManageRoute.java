package so.wwb.creditbox.web.route;

/**
 * 后台路由
 *
 * @author jeremy
 * @date 2018年11月21日
 */
public class ManageRoute {

    public class Common {

    }

    /**
     * 商户后台
     */
    public class Me {

        /**
         * 账号
         */
        public class Account {

            /**
             * 股东账号
             */
            public class Shareholder {

            }

            /**
             * 股东子账号
             */
            public class ShareholderSub {

            }

            /**
             * 商户账号
             */
            public class Merchant {

            }

            /**
             * 商户子账号
             */
            public class MerchantSub {

            }

            /**
             * 总代账号
             */
            public class Distributor {

            }

            /**
             * 总代子账号
             */
            public class DistributorSub {

            }

            /**
             * 玩家账号
             */
            public class Player {

                public static final String ROOT = "/merchant/account/membercenter";
                public static final String API_ROOT = "/api/merchant/account/membercenter";

                public static final String LIST = "/list";
                public static final String VIEW = "/view";
                public static final String QUERY_TOTAL_MONEY = "/queryTotalMoney";
                public static final String ADD_BANK_UI = "/addBankCardUI";
                public static final String UPDATE_USER_BANKCARD_UI = "/updateUserBankCardUI";
                public static final String ADD_ALIPAY_UI = "/addAlipayUI";
                public static final String UPDATE_ALIPAY_UI = "/updateAlipayUI";
                public static final String ADD_WEIXIN_UI = "/addWeixinUI";
                public static final String UPDATE_WEIXIN_UI = "/updateWeixinUI";
                public static final String UPDATE_USER_INFO_UI = "/updateUserInfoUI";
                public static final String FREEZE_EDIT = "/freezeEdit";
                public static final String QUERY_FREEZE_INFO_BY_ID = "/queryFreezeInfoById";
                public static final String UPDATE_USER_STATUS = "/updateUserStatus";
                public static final String SAVE_RANK_BY_IDS = "/saveRankByIds";
                public static final String SAVE_PLAYER_AGENT = "/savePlayerAgent";
                public static final String SAVE_RAKEBACK_BY_IDS = "/saveRakebackByIds";
                public static final String QUERY_USER_PLAYER_INFO = "/queryUserPlayerInfo";
                public static final String UPDATE_USER_REAL_NAME = "/updateUserRealName";
                public static final String UPDATE_USER_MEMO = "/updateUserMemo";
                public static final String PLAYER_AGENT_SUCCESS = "/playAgentSuccess";
                public static final String UPDATE_USER_INFO = "/updateUserInfo";
                public static final String SAVE_USER_BANKCARD = "/saveUserBankCard";
                public static final String DELETE_ALIPAY = "/deleteAlipay";
                public static final String DELETE_WEIXIN = "/deleteWeixin";
                public static final String DELETE_BANKCARD = "/deleteBankcard";
                public static final String QUERY_MY_BANKCARDS = "/queryMyBankCards";
                public static final String QUERY_DEFAULT_BANK = "/queryDefaultBank";
                public static final String QUERY_BANKCARD_LIST = "/queryBankcardList";
                public static final String QUERY_USER_ALL_RANK = "/queryUserAllRank";
                public static final String QUERY_ALL_PLAYER_STATUS = "/queryAllPlayerStatus";
                public static final String GET_ALL_USER_STATUS = "/getAllUserStatus";
                public static final String GET_ALL_USER_RANK = "/getAllUserRank";
                public static final String GET_ALL_RAKEBACK = "/getAllRakeback";
                public static final String QUERY_USER_REALNAME = "/queryUserRealName";
                public static final String RESET_PWD = "/resetPwd";
                public static final String RESET_SECRET = "/resetSecret";
                public static final String RESET_PRIVILEGE_PASSWORD = "/resetPrivilegePassword";
                public static final String RESET_SECURITY_PWD = "/resetSecurityPwd";
                public static final String QUERY_RAKEBACK = "/queryRakeback";
                public static final String QUERY_ALL_RAKEBACK = "/queryAllRakeback";
                public static final String CREATE_PLAYER_ACCOUNT = "/createPlayerAccount";
                public static final String SAVE_PLAYER_ACCOUNT = "/savePlayerAccount";
                public static final String QUERY_ALL_PLAYER_LEVEL = "/queryAllPlayerLevel";
                public static final String QUERY_AGENT_BY_LEVEL = "/queryAgentByLevel";
                public static final String QUERY_AGENT_LEVEL = "/queryAgentLevel";
                public static final String QUERY_REMARK_LIST = "/queryRemarkList";
            }


            public class team {

            }


        }



    }


    public class API_MERCHANT {
        /**
         * 根路径
         */
        private static final String ROOT = "/api/merchant";

    }

}
