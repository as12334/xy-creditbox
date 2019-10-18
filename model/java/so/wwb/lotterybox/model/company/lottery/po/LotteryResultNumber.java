package so.wwb.lotterybox.model.company.lottery.po;

import com.alibaba.fastjson.JSONArray;
import org.soul.commons.bean.IEntity;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.lotterybox.model.manager.lottery.po.BjlResult;
import so.wwb.lotterybox.model.manager.lottery.po.NnResult;

import java.util.Date;
import java.util.List;

/**
 * 彩票开奖号码表
 *
 * @author diego
 * @time 2018-02-11 19:16:50
 */
public class LotteryResultNumber implements IEntity<Integer> {

    private static final long serialVersionUID = 1368736814609663680L;

    public static final String PROP_ID = "id";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_CODE = "code";
    public static final String PROP_LOTTERY_NAME = "lotteryName";
    public static final String PROP_TYPE = "type";
    public static final String PROP_OPEN_CODE = "openCode";
    public static final String PROP_OPEN_CODE_MEMO = "openCodeMemo";
    public static final String PROP_OPEN_TIME = "openTime";
    public static final String PROP_CLOSE_TIME = "closeTime";
    public static final String PROP_OPENING_TIME = "openingTime";
    public static final String PROP_ASCRIPTION = "ascriptionTime";
    public static final String PROP_GATHER_ORIGIN = "gatherOrigin";
    public static final String PROP_GATHER_TIME = "gatherTime";
    public static final String PROP_GATHER = "gather";

    /** 自增主键 */
    private Integer id;
    /** 期数 */
    private String expect;
    /** 彩种代号LotteryCodeEnum */
    private String code;
    /** 彩种类型*/
    private String type;
    /** 彩种名称*/
    private String lotteryName;
    /** 彩种图标*/
    private String imageUrl;
    /** 开奖号码 */
    private String openCode;
    /** 开奖号码备注,暂存香港六合彩生肖,多个逗号隔开 */
    private String openCodeMemo;
    /** 开奖时间 */
    private Date openTime;
    /** 封盘时间 */
    private Date closeTime;
    /** 开盘时间 */
    private Date openingTime;
    /** 归属日期 */
    private Date ascriptionTime;
    /** 采集来源LotteryGatherOriginEnum */
    private String gatherOrigin;
    /** 采集时间 */
    private Date gatherTime;
    /** 采集人 */
    private String gather;
    /** 备注 */
    private String memo;
    /** 模式 */
    private String model;


    public LotteryResultNumber(){
    }

    @org.soul.model.common.Sortable
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    @org.soul.model.common.Sortable
    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }
    @org.soul.model.common.Sortable
    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getAscriptionTime() {
        return ascriptionTime;
    }

    public void setAscriptionTime(Date ascriptionTime) {
        this.ascriptionTime = ascriptionTime;
    }

    public String getGatherOrigin() {
        return gatherOrigin;
    }

    public void setGatherOrigin(String gatherOrigin) {
        this.gatherOrigin = gatherOrigin;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getGather() {
        return gather;
    }

    public void setGather(String gather) {
        this.gather = gather;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenCodeMemo() {
        return openCodeMemo;
    }

    public void setOpenCodeMemo(String openCodeMemo) {
        this.openCodeMemo = openCodeMemo;
    }
    @Nonpersistent
    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }
    @Nonpersistent
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Nonpersistent
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Nonpersistent
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<NnResult> getNnOpenCode () {
        if (LotteryTypeEnum.NN.getCode().equals(this.type) && LotteryEnum.PK10NN.getCode().equals(this.code)) {
            if (StringTool.isNotEmpty(this.openCodeMemo)) {
                JSONArray array = JSONArray.parseArray(this.openCodeMemo);
                List<NnResult> list = array.toJavaList(NnResult.class);
                return list;
            } else {
                return null;
            }
        }
        return null;
    }

    public List<BjlResult> getBjlOpenCode () {
        if (LotteryTypeEnum.BJL.getCode().equals(this.type) && LotteryEnum.PK10BJL.getCode().equals(this.code)) {
            if (StringTool.isNotEmpty(this.openCodeMemo)) {
                JSONArray array = JSONArray.parseArray(this.openCodeMemo);
                List<BjlResult> list = array.toJavaList(BjlResult.class);
                return list;
            } else {
                return null;
            }
        }
        return null;
    }
}