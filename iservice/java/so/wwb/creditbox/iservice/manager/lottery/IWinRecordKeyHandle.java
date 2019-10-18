package so.wwb.creditbox.iservice.manager.lottery;

import java.util.List;

public interface IWinRecordKeyHandle {

    //根据开奖结果生成对应彩种的所有彩种玩法的中奖记录
    List<String> handle(String code, List<String> resultList);
}
