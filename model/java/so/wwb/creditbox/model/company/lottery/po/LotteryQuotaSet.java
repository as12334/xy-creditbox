package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.math.NumberTool;

/**
 * 彩票限额设置表
 *
 * @author diego
 * @time 2018-02-11 19:16:50
 */
public class LotteryQuotaSet implements IEntity<Integer> {

    private static final long serialVersionUID = -1902241184021448324L;

    public static final String PROP_ID = "id";
    public static final String PROP_CODE = "code";
    public static final String PROP_MODEL = "model";
    public static final String PROP_PLAY_CODE = "playCode";
    public static final String PROP_NUM_HIGH_QUOTA = "numHighQuota";
    public static final String PROP_BET_LOW_QUOTA = "betLowQuota";
    public static final String PROP_BET_HIGH_QUOTA = "betHighQuota";
    public static final String PROP_PLAY_HIGH_QUOTA = "playHighQuota";

    /** 自增主键 */
    private Integer id;
    /** 彩种代号LotteryCodeEnum */
    private String code;
    /** 彩种模式LotteryModelEnum */
    private String model;
    /** 彩种玩法LotteryPlayCodeEnum */
    private String playCode;
    /** 单号最高限额 */
    private Double numHighQuota;
    /** 单注最低限额 */
    private Double betLowQuota;
    /** 单注最高限额 */
    private Double betHighQuota;
    /** 单类别最高限额 */
    private Double playHighQuota;

    //用于数据展示,禁止科学计数法展示数据
    /** 单项限额 */
    private String numHighQuotaStr;
    /** 单注最低限额 */
    private String betLowQuotaStr;
    /** 单注最高限额 */
    private String betHighQuotaStr;
    /** 单类别单项限额 */
    private String playHighQuotaStr;


    public LotteryQuotaSet(){
    }

    @org.soul.model.common.Sortable
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlayCode() {
        return playCode;
    }

    public void setPlayCode(String playCode) {
        this.playCode = playCode;
    }

    public Double getNumHighQuota() {
        return numHighQuota;
    }

    public void setNumHighQuota(Double numHighQuota) {
        this.numHighQuota = numHighQuota;
    }

    public Double getBetLowQuota() {
        return betLowQuota;
    }

    public void setBetLowQuota(Double betLowQuota) {
        this.betLowQuota = betLowQuota;
    }

    public Double getBetHighQuota() {
        return betHighQuota;
    }

    public void setBetHighQuota(Double betHighQuota) {
        this.betHighQuota = betHighQuota;
    }

    public Double getPlayHighQuota() {
        return playHighQuota;
    }

    public void setPlayHighQuota(Double playHighQuota) {
        this.playHighQuota = playHighQuota;
    }

    public String getNumHighQuotaStr() {
        String numHighQuotaStr = NumberTool.toString(this.numHighQuota);
        return numHighQuotaStr;
    }

    public String getBetLowQuotaStr() {
        String betLowQuotaStr = NumberTool.toString(this.betLowQuota);
        return betLowQuotaStr;
    }

    public String getBetHighQuotaStr() {
        String betHighQuotaStr = NumberTool.toString(this.betHighQuota);
        return betHighQuotaStr;
    }

    public String getPlayHighQuotaStr() {
        String playHighQuotaStr = null;
        if (this.playHighQuota != null) {
            playHighQuotaStr = NumberTool.toString(this.playHighQuota);
        }
        return playHighQuotaStr;
    }
}