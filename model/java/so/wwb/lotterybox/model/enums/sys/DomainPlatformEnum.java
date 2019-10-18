package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum DomainPlatformEnum implements ICodeEnum {

	OPERATOR("operator","运营商域名"),
	SITE("site","站点域名"),
	AGENT("agent","总代域名")
	;
	private String code;
	private String trans;

	DomainPlatformEnum(String code, String trans){
		this.code = code;
		this.trans = trans;
	}

	@Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}
}