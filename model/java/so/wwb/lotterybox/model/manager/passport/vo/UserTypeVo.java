package so.wwb.lotterybox.model.manager.passport.vo;

import so.wwb.lotterybox.model.enums.user.UserTypeEnum;

/**
 * Created by admin on 16-4-11.
 */
public class UserTypeVo {

    /**
     * 是否需要检查菜单URL
     *
     * @param userTypeEnum
     * @return
     */
    public static boolean isNeedCheckUrl(UserTypeEnum userTypeEnum) {
        switch (userTypeEnum) {
            case BOSS_SUB:
            case SHAREHOLDER_SUB:
            case COMPANY_SUB:
            case DISTRIBUTOR_SUB:
                return true;
        }
        return false;
    }

    /**
     * 是否拥有全权限(菜单,功能等)
     *
     * @param userTypeEnum
     * @return
     */
    public static boolean isWholePerimssion(UserTypeEnum userTypeEnum) {
        switch (userTypeEnum) {
            case BOSS:
            case SHAREHOLDER:
            case COMPANY:
            case DISTRIBUTOR:
            case PLAYER:
                return true;
        }
        return false;
    }
}
