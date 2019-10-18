package so.wwb.lotterybox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteLangStatusEnum implements ICodeEnum {
		WAIT("0","待使用"),
		USING("1","使用中"),
		STOP("2","已停用");

		private String code;
		private String trans;

		SiteLangStatusEnum(String code, String trans){
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