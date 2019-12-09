package so.wwb.creditbox.model.enums.content;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 站点公告
 * dick
 */
public enum BulletinStateEnum implements ICodeEnum {

	NORMAL("0","正常"),
	DELETE("1","删除");
	private String code;
	private String trans;
	BulletinStateEnum(String code, String trans){
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