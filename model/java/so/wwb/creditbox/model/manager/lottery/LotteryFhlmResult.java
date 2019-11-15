package so.wwb.creditbox.model.manager.lottery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class LotteryFhlmResult implements Serializable {

    private static final long serialVersionUID = -4892495353112665080L;

    //彩种code
    private String lottery;
    //彩种name
    private String title;
    //总条数
    private int total;

    //开奖结果列表
    @JsonProperty("list")
    private List<LotteryFhlmData> list;

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<LotteryFhlmData> getList() {
        return list;
    }

    public void setList(List<LotteryFhlmData> list) {
        this.list = list;
    }


    /**
     * @function:for testing
     * @param args
     */
    public static void main(String[] args) {
//        String json = "{\"list\":[{\"issue\":\"190401034\",\"code\":[\"8\",\"6\",\"6\",\"8\",\"7\"],\"time\":\"2019-04-01 15:31:00\"},{\"issue\":\"190401033\",\"code\":[\"3\",\"5\",\"7\",\"8\",\"0\"],\"time\":\"2019-04-01 15:12:00\"}],\"total\":200,\"title\":\"\\u91cd\\u5e86\\u65f6\\u65f6\\u5f69\",\"lottery\":\"cqssc\"}";
//        LotteryFhlmResult result = JsonTool.fromJson(json, LotteryFhlmResult.class);
//        System.out.println(JsonTool.toJson(result));

        String json = "19033148";
        System.out.printf("20"+json.substring(0,6)+"0"+json.substring(6,json.length()));
    }
}
