package so.wwb.creditbox.model.manager.sys.so;


import so.wwb.creditbox.model.manager.sys.po.SysExport;

/**
 * 导出数据历史表查询对象
 *
 * @author River
 * @time 2016-1-5 15:10:38
 */
//region your codes 1
public class SysExportSo extends SysExport {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 5291685713100564087L;
	//endregion your codes 3

	//region your codes 2
	private String hasReturn;

	public String getHasReturn() {
		return hasReturn;
	}

	public void setHasReturn(String hasReturn) {
		this.hasReturn = hasReturn;
	}
	//endregion your codes 2
}