package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;

/**
 * Created by tom
 */
public enum AccountStatus implements ICodeEnum {
	
	NORMAL("1", "正常"),
	DISABLED("2", "账号停用"),
	LOCKED("3", "账号冻结"),
	/*INACTIVE("4", "未激活/未审核"),
	AUDIT_FAIL("5","审核失败"),*/
	BALANCE_FREEZE("6", "余额冻结");

	private final String code;
	private String desc;
	
	AccountStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getTrans() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static AccountStatus enumOf(String code) {
		return EnumTool.enumOf(AccountStatus.class, code);
	}
	
	@Override
	public String toString() {
		return desc;
	}
}
