package so.wwb.creditbox.model.enums.setting;

/**
 * 玩家参数初始信息
 * Created by bruce on 16-11-22.
 */
public enum UserParamEnum {
    AWARD_PUSH("push", "award_push", "", "中奖推送"),
    OPEN_PUSH("push", "open_push", "", "开奖推送"),
    SHAKE("shake", "shake", "yes", "摇一摇机选"),
    VOICE("voice", "voice", "yes", "声音提醒"),
    GESTURE("lock", "gesture", "", "手势锁屏"),
    ANIMATION("award", "animation", "no", "开奖动画"),
    DEVICE("lock", "device", "no", "设备锁");

    private String type;
    private String code;
    private String preset;
    private String memo;

    UserParamEnum(String type, String code, String preset, String memo) {
        this.type = type;
        this.code = code;
        this.preset = preset;
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getMemo() {
        return memo;
    }

    public String getPreset() {
        return preset;
    }
}
