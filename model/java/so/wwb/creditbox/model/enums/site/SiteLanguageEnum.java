package so.wwb.creditbox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteLanguageEnum implements ICodeEnum {
		ZH_CN("zh_CN","中文简体"),
		ZH_TW("zh_TW","中文繁体"),
		EN_US("en_US","英语");

		private String code;
		private String trans;

		SiteLanguageEnum(String code, String trans){
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