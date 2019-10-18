package so.wwb.creditbox.model.company.setting.po;

import org.soul.commons.bean.IEntity;

/**
 * 用户参数表实体
 * Create by Fei on 2018-01-03
 */
public class UserParam implements IEntity<Integer> {

    public static final String PROP_ID = "id";
    public static final String PROP_USER_ID = "userId";
    public static final String PROP_PARAM_TYPE = "paramType";
    public static final String PROP_PARAM_CODE ="paramCode";
    public static final String PROP_PARAM_VALUE = "paramValue";
    public static final String PROP_ACTIVE = "active";
    public static final String PROP_ORDER_NUM = "orderNum";
    public static final String PROP_REMARK = "remark";

    /** ID */
    private Integer id;
    /** 用户ID */
    private Integer userId;
    /** 参数类型 */
    private String paramType;
    /** 参数代码 */
    private String paramCode;
    /** 参数值 */
    private String paramValue;
    /** 是否可用 */
    private Boolean active;
    /** 排序 */
    private Integer orderNum;
    /** 备注 */
    private String remark;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
