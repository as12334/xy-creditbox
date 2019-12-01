package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.support.Nonpersistent;

import java.util.Date;


/**
 * 中奖记录表实体
 *
 * @author shook
 * @time 2017-4-9 9:27:40
 */
//region your codes 1
public class LotteryWinningRecord implements IEntity<Integer> {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = 4177315760218244859L;
    //endregion your codes 3

    //region property name constants
    public static final String PROP_ID = "id";
    public static final String PROP_EXPECT = "expect";
    public static final String PROP_CODE = "code";
    public static final String PROP_PLAY_CODE = "playCode";
    public static final String PROP_BET_CODE = "betCode";
    public static final String PROP_WINNING_NUM = "winningNum";
    public static final String PROP_CREATE_TIME = "createTime";
    //endregion


    //region properties
    /**
     * 主键
     */
    private Integer id;
    /**
     * 开奖期数
     */
    private String expect;
    /**
     * 彩种代号
     */
    private String type;
    /**
     * 彩种代号
     */
    private String code;
    /**
     * 彩种玩法
     */
    private String playCode;
    /**
     * 投注玩法
     */
    private String betCode;
    /**
     * 中奖号码
     */
    private String winningNum;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 排行次数累计
     */
    private String rankCount;
    /**
     * 彩种玩法国际化
     */
    private String playCodeMemo;
    /**
     * 投注玩法国际化
     */
    private String betCodeMemo;
    //endregion


    //region constuctors
    public LotteryWinningRecord() {
    }

    public LotteryWinningRecord(Integer id) {
        this.id = id;
    }
    //endregion


    //region getters and setters
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public String getExpect() {
        return this.expect;
    }

    public void setExpect(String value) {
        this.expect = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //endregion

    //region your codes 2

    public String getPlayCode() {
        return playCode;
    }

    public void setPlayCode(String playCode) {
        this.playCode = playCode;
    }

    public String getBetCode() {
        return betCode;
    }

    public void setBetCode(String betCode) {
        this.betCode = betCode;
    }

    public String getWinningNum() {
        return winningNum;
    }

    public void setWinningNum(String winningNum) {
        this.winningNum = winningNum;
    }

    public String getRankCount() {
        return rankCount;
    }

    public void setRankCount(String rankCount) {
        this.rankCount = rankCount;
    }

    public String getPlayCodeMemo() {
        return playCodeMemo;
    }

    public void setPlayCodeMemo(String playCodeMemo) {
        this.playCodeMemo = playCodeMemo;
    }

    public String getBetCodeMemo() {
        return betCodeMemo;
    }

    public void setBetCodeMemo(String betCodeMemo) {
        this.betCodeMemo = betCodeMemo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //endregion your codes 2

}
