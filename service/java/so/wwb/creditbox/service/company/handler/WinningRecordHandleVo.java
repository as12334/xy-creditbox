package so.wwb.creditbox.service.company.handler;


import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shook on 17-4-13.
 */
public class WinningRecordHandleVo {


    private List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();


    public List<LotteryWinningRecord> getLotteryWinningRecordList() {
        return lotteryWinningRecordList;
    }

    public void setLotteryWinningRecordList(List<LotteryWinningRecord> lotteryWinningRecordList) {
        this.lotteryWinningRecordList = lotteryWinningRecordList;
    }

}
