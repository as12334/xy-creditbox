package so.wwb.creditbox.model.enums.schedule;

import org.soul.commons.enums.ICodeEnum;
import so.wwb.creditbox.model.enums.base.IParentEnum;

/**
 * schedule应用枚举
 * @author marz
 * @time 2018-02-28 16:18:50
 **/
public enum SchedulerAppEnum implements ICodeEnum ,IParentEnum{

    SCHEDULE("schedule", "schedule"),
    GAME_SCHEDULE("game_schedule", "game-schedule");
    SchedulerAppEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    private String code;
    private String trans;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTrans() {
        return this.trans;
    }
}