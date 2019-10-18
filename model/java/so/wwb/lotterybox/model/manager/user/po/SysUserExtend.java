package so.wwb.lotterybox.model.manager.user.po;

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

    public static final String PROP_CODE = "code";
    public static final String PROP_OWNER_CODE = "ownerCode";
    public static final String PROP_OWNER_NAME = "ownerName";
    public static final String PROP_PARENT_IDS = "parentIds";
    public static final String PROP_PARENT_NAMES = "parentNames";
    public static final String PROP_KEY = "key";
    public static final String PROP_UPDATE_NAME="updateName";

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

    public static final String PROP_CODE_OWNER = "codeOwner";

    private String nameInfo;
    private String hallUri;
    private String payUri;

    private String codeOwner;

    @Nonpersistent
    public String getNameInfo() {
        return this.nameInfo;
    }
    public void setNameInfo(String nameInfo) {
        this.nameInfo = nameInfo;
    }

    @Nonpersistent
    public String getHallUri() {
        return hallUri;
    }
    public void setHallUri(String hallUri) {
        this.hallUri = hallUri;
    }

    @Nonpersistent
    public String getPayUri() {
        return payUri;
    }
    public void setPayUri(String payUri) {
        this.payUri = payUri;
    }

//    public VUserPlayer getParent() {
//        return parent;
//    }
//
//    public void setParent(VUserPlayer parent) {
//        this.parent = parent;
//    }


    // endregion

}