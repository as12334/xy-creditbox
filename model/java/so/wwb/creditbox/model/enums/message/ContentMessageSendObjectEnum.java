package so.wwb.creditbox.model.enums.message;

import org.soul.commons.enums.ICodeEnum;

/**
 *
 * Created by jeremy on 18-4-3.
 */
public enum ContentMessageSendObjectEnum implements ICodeEnum {
    PLAYER_ALL("playerAll","全部玩家"),
    PLAYER_NAMES("playerNames","按玩家名字"),
    PLAYER_RANKS("playerRanks","按玩家层级");
    private String code;
    private String trans;

    ContentMessageSendObjectEnum(String code, String trans){
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
