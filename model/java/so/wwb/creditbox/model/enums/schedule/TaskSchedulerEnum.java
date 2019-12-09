package so.wwb.creditbox.model.enums.schedule;

import org.soul.commons.ienums.ICodeEnum;
import so.wwb.creditbox.model.enums.base.IChildEnum;

public enum TaskSchedulerEnum implements ICodeEnum ,IChildEnum{

    DEFAULT(SchedulerAppEnum.SCHEDULE,"schedulerDefault", "默认任务"),
    MERCHANT(SchedulerAppEnum.SCHEDULE,"schedulerMerchant", "商户任务"),
    GAME(SchedulerAppEnum.GAME_SCHEDULE,"schedulerGame", "游戏任务");

    TaskSchedulerEnum(SchedulerAppEnum parent,String code, String trans) {
        this.parent = parent;
        this.code = code;
        this.trans = trans;
    }

    private String code;
    private String trans;
    private SchedulerAppEnum parent;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTrans() {
        return this.trans;
    }

    @Override
    public SchedulerAppEnum getParent() {
        return this.parent;
    }
}