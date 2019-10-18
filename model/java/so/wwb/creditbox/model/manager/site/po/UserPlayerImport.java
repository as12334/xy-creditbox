package so.wwb.creditbox.model.manager.site.po;

import org.soul.commons.bean.IEntity;


/**
 * 玩家导入记录表 by River实体
 *
 * @author River
 * @time 2015-12-28 16:29:58
 */
//region your codes 1
public class UserPlayerImport implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4384369404844784967L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_FILE_NAME = "fileName";
	public static final String PROP_IMPORT_PLAYER_COUNT = "importPlayerCount";
	public static final String PROP_IMPORT_TIME = "importTime";
	public static final String PROP_IMPORT_USER_ID = "importUserId";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 文件名 */
	private String fileName;
	/** 导入玩家数 */
	private Integer importPlayerCount;
	/** 导入时间 */
	private java.util.Date importTime;
	/** 导入用户 */
	private Integer importUserId;
	//endregion

	
	//region constuctors
	public UserPlayerImport(){
	}

	public UserPlayerImport(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String value) {
		this.fileName = value;
	}
	public Integer getImportPlayerCount() {
		return this.importPlayerCount;
	}

	public void setImportPlayerCount(Integer value) {
		this.importPlayerCount = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(java.util.Date value) {
		this.importTime = value;
	}
	public Integer getImportUserId() {
		return this.importUserId;
	}

	public void setImportUserId(Integer value) {
		this.importUserId = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}