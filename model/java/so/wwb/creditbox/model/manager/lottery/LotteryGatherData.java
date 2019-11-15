package so.wwb.creditbox.model.manager.lottery;

import java.io.Serializable;

/**
 * Created by admin on 17-4-1.
 */
public class LotteryGatherData implements Serializable {

    private static final long serialVersionUID = 2276820539530828778L;

    //开奖期数
    private String expect;
    //开奖号码
    private String opencode;
    //开奖时间
    private String opentime;
    //开奖时间stamp
    private String opentimestamp;

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getOpencode() {
        return opencode;
    }

    public void setOpencode(String opencode) {
        this.opencode = opencode;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(String opentimestamp) {
        this.opentimestamp = opentimestamp;
    }
}
