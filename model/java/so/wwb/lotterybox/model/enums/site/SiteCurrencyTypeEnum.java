package so.wwb.lotterybox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteCurrencyTypeEnum implements ICodeEnum {
		CNY("CNY","人民币");


		private String code;
		private String trans;

	SiteCurrencyTypeEnum(String code, String trans){
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