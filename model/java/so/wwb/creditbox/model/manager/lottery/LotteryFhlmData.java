package so.wwb.creditbox.model.manager.lottery;

import java.io.Serializable;

public class LotteryFhlmData implements Serializable {

    private static final long serialVersionUID = 4312661808452517700L;

    //开奖号码数组
    private String[] code;
    //期数
    private String issue;
    //东八区开奖时间 格式yyyy-MM-dd HH:mm:ss
    private String time;

    public String[] getCode() {
        return code;
    }

    public void setCode(String[] code) {
        this.code = code;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
