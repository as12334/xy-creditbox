package so.wwb.lotterybox.model.bean;

import java.util.Date;

/**
 * 购彩大厅Bean
 * @author fei
 * @date 17-11-13
 */
public class HandicapBean {
    /** 彩种类型 */
    private String type;
    /** 彩种代号 */
    private String code;
    /** 彩种名称 */
    private String name;
    /** 当前期数 */
    private String expect;
    /** 剩余封盘时间 */
    private Long leftTime;
    /** 最近一期期数 */
    private String lastExpect;
    /** 最近一期开奖号码 */
    private String[] openCode;
    /** 是否新彩种 */
    private Boolean isNew;
    /** 开奖时间 */
    private Date openTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String export) {
        this.expect = export;
    }

    public Long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(Long leftTime) {
        this.leftTime = leftTime;
    }

    public String getLastExpect() {
        return lastExpect;
    }

    public void setLastExpect(String lastExpect) {
        this.lastExpect = lastExpect;
    }

    public String[] getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String[] openCode) {
        this.openCode = openCode;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }
}
