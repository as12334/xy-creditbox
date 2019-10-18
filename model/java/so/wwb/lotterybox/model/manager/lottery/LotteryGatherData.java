package so.wwb.lotterybox.model.manager.lottery;

import java.io.Serializable;

public class LotteryGatherData implements Serializable {

    private static final long serialVersionUID = 2276820539530828778L;

    private String expect;
    private String opencode;
    private String opentime;
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
