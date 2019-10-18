package so.wwb.creditbox.model.manager.lottery;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.soul.commons.data.json.JsonTool;

import java.io.Serializable;
import java.util.List;

public class LotteryOpenResult implements Serializable {
    private static final long serialVersionUID = 1276820539530828778L;
    //记录数
    private int rows;
    //彩票类型
    private String code;
    //备注信息
    private String info;

    private String time;

    private String remain;

    @JsonProperty("open")
    private List<LotteryGatherData> lotterGatherDataList;

    @JsonProperty("next")
    private List<LotteryGatherData> nextData;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<LotteryGatherData> getLotterGatherDataList() {
        return lotterGatherDataList;
    }

    public void setLotterGatherDataList(List<LotteryGatherData> lotterGatherDataList) {
        this.lotterGatherDataList = lotterGatherDataList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public List<LotteryGatherData> getNextData() {
        return nextData;
    }

    public void setNextData(List<LotteryGatherData> nextData) {
        this.nextData = nextData;
    }

    /**
     * @function:for testing
     * @param args
     */
    public static void main(String[] args) {
        String json ="{\"rows\":5,\"code\":\"cqssc\",\"info\":\"免费接口随机延迟3-6分钟，实时接口请访问opencai.net或QQ:23081452(注明彩票或API)\",\"data\":[{\"expect\":\"20170401053\",\"opencode\":\"5,7,3,1,1\",\"opentime\":\"2017-04-01 14:50:40\",\"opentimestamp\":1491029440},{\"expect\":\"20170401052\",\"opencode\":\"8,4,8,7,6\",\"opentime\":\"2017-04-01 14:40:40\",\"opentimestamp\":1491028840},{\"expect\":\"20170401051\",\"opencode\":\"6,0,6,5,8\",\"opentime\":\"2017-04-01 14:30:40\",\"opentimestamp\":1491028240},{\"expect\":\"20170401050\",\"opencode\":\"0,4,3,5,2\",\"opentime\":\"2017-04-01 14:20:40\",\"opentimestamp\":1491027640},{\"expect\":\"20170401049\",\"opencode\":\"8,2,9,8,7\",\"opentime\":\"2017-04-01 14:10:40\",\"opentimestamp\":1491027040}]}";
        json="{\"rows\":1,\"code\":\"jsk3\",\"remain\":\"8760hrs\",\"next\":[{\"expect\":\"20170501041\",\"opentime\":\"2017-05-01 15:20:00\"}],\"open\":[{\"expect\":\"20170501040\",\"opencode\":\"2,3,5\",\"opentime\":\"2017-05-01 15:10:03\"}],\"time\":\"2017-05-01 15:17:31\"}";
        LotteryOpenResult lotterGatherResult = JsonTool.fromJson(json, LotteryOpenResult.class);
        System.out.println(JsonTool.toJson(lotterGatherResult));
    }
}
