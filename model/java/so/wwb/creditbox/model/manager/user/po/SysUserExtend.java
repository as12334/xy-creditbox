package so.wwb.creditbox.model.manager.user.po;

import org.soul.commons.support.Nonpersistent;
import org.soul.model.security.privilege.po.SysUser;
//import so.wwb.lotterybox.model..user.才.VUserPlayer;

/**
 * 用户扩展表实体
 * 该表继承sys_user
 * Create by fei on 2018-01-14
 */
public class SysUserExtend extends SysUser {

    private static final long serialVersionUID = 4212061721572381108L;

    public static final String PROP_KEY = "key";
    public static final String PROP_UPDATE_NAME="updateName";
    public static final String PROP_SUPERIOR_OCCUPY="superiorOccupy";
    public static final String PROP_STINT_OCCUPY="stintOccupy";
    public static final String PROP_HID="hid";
    public static final String PROP_CREDITS="credits";

    /** 钥匙 */
    private String key;
    /** 修改人名称 */
    private  String  updateName;
    /** 上级信息 */
//    private VUserPlayer parent;


    /** 上级占成 */
    private Double superiorOccupy;
    /** 限制占成 */
    private Double stintOccupy;
    /** ID标示(每级8位) */
    private String hid;
    /** 信用额 */
    private Double credits;


    public Double getSuperiorOccupy() {
        return superiorOccupy;
    }

    public void setSuperiorOccupy(Double superiorOccupy) {
        this.superiorOccupy = superiorOccupy;
    }

    public Double getStintOccupy() {
        return stintOccupy;
    }

    public void setStintOccupy(Double stintOccupy) {
        this.stintOccupy = stintOccupy;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    // region 非表属性
//    public VUserPlayer getParent() {
//        return parent;
//    }
//
//    public void setParent(VUserPlayer parent) {
//        this.parent = parent;
//    }


    // endregion

}