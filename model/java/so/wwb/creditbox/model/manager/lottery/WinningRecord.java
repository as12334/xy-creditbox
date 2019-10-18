package so.wwb.creditbox.model.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.LotteryChildResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;

import java.util.ArrayList;
import java.util.List;

public class WinningRecord<R extends LotteryChildResult> {

    private List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();

    private R baseLotteryResult;

    public List<LotteryWinningRecord> getLotteryWinningRecordList() {
        return lotteryWinningRecordList;
    }

    public void setLotteryWinningRecordList(List<LotteryWinningRecord> lotteryWinningRecordList) {
        this.lotteryWinningRecordList = lotteryWinningRecordList;
    }

    public R getBaseLotteryResult() {
        return baseLotteryResult;
    }

    public void setBaseLotteryResult(R baseLotteryResult) {
        this.baseLotteryResult = baseLotteryResult;
    }
}
