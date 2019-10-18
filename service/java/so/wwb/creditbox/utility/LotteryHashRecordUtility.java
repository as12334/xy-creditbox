package so.wwb.creditbox.utility;

import so.wwb.creditbox.model.enums.lottery.LotteryOperationEnum;
import so.wwb.creditbox.model.company.lottery.po.LotteryHashRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

public class LotteryHashRecordUtility {

    /**
     * 根据LotteryResult转成派彩LotteryHashRecord
     * @param number
     * @return
     */
    public static LotteryHashRecord createPayoutRecord(LotteryResultNumber number){
        return createHashRecord(number, LotteryOperationEnum.PAYOUT.getCode());
    }

    /**
     * 根据LotteryResult转成撤销LotteryHashRecord
     * @param number
     * @return
     */
    public static LotteryHashRecord createRevocationRecord(LotteryResultNumber number){
        return createHashRecord(number, LotteryOperationEnum.REVOCATION.getCode());
    }

    /**
     * 根据LotteryResult转成撤单LotteryHashRecord
     * @param number
     * @return
     */
    public static LotteryHashRecord createRevokeRecord(LotteryResultNumber number){
        return createHashRecord(number, LotteryOperationEnum.REVOKE.getCode());
    }

    /**
     * 根据LotteryResult转成重结LotteryHashRecord
     * @param number
     * @return
     */
    public static LotteryHashRecord createRecalculateRecord(LotteryResultNumber number){
        return createHashRecord(number, LotteryOperationEnum.RECALCULATE.getCode());
    }

    private static LotteryHashRecord createHashRecord(LotteryResultNumber number, String operation){
        LotteryHashRecord result = new LotteryHashRecord();
        result.setCode(number.getCode());
        result.setExpect(number.getExpect());
        result.setOpenCode(number.getOpenCode());
        result.setOperation(operation);
        result.setId(null);
        return result;
    }
}
