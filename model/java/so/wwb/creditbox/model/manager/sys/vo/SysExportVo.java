package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.bean.IEntity;
import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.enums.common.TaskScheduleEnum;
import so.wwb.creditbox.model.manager.sys.po.SysExport;
import so.wwb.creditbox.model.manager.sys.so.SysExportSo;

import java.util.ArrayList;
import java.util.List;


/**
 * 导出数据历史表值对象
 *
 * @author River
 * @time 2016-1-5 15:10:38
 */
//region your codes 1
public class SysExportVo extends BaseObjectVo<SysExport, SysExportSo, SysExportVo.SysExportQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7141796442209201818L;
    //endregion your codes 5

    /**
     * 导出数据历史表查询逻辑
     */
    public static class SysExportQuery extends AbstractQuery<SysExportSo> {

        //region your codes 6
        private static final long serialVersionUID = -1211826600506470136L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4
    private String ids;
    public static final String EXPORT_NOT_START = "nostart";
    public static final String EXPORT_PROCESSING = "processing";
    public static final String EXPORT_FAIL = "fail";
    public static final String EXPORT_COMPLETED = "completed";
    public static final String EXPORT_UPLOAD_FAIL = "uploadFail";
    public static final String EXPORT_MAX_COUNT = "maxCount";
    public static final String EXPORT_RESULT_ZERO = "resultZero";

    /**
     * 文件上传接口返回的状态字段名
     */
    public static final String FSERVER_RETURN_STATE = "state";
    /**
     * 文件上传接口返回的状态字段名
     */
    public static final String FSERVER_RETURN_STATE_SUCCESS = "SUCCESS";
    /**
     * 文件上传接口返回的路径字段名
     */
    public static final String FSERVER_RETURN_URL = "url";
    /**
     * 文件上传接口文件分类的参数名称
     */
    public static final String FSERVER_PARAM_CATEPATH = "catePath";
    /**
     * 文件上传接口\删除接口用户名的参数名称
     */
    public static final String FSERVER_PARAM_USERNAME = "userName";
    /**
     * 文件删除接口文件相对路径的参数名称
     */
    public static final String FSERVER_PARAM_FILEPATH = "filePath";
    /**
     * 文件上传接口文件所关联的对象id的参数名称
     */
    public static final String FSERVER_PARAM_OBJID = "objId";
    /**
     * 文件上传接口上下文路径
     */
    public static final String FSERVER_UPLOAD_CONTEXT_PATH = "/upFile";
    /**
     * 文件删除接口上下文路径
     */
    public static final String FSERVER_DELETE_CONTEXT_PATH = "/delFile";
    /**
     * 文件服务器上文件的虚拟目录名
     */
    public static final String FSERVER_FILE_PATH = "/files/";
    /**
     * 导出任务编号
     */
    public static final String EXPORT_SCHEDULE_CODE = TaskScheduleEnum.EXCUTE_EXPORT.getCode();

    /**
     *导出任务执行导出后的回调方法，方法的入参为listvo,如果导出失败，则listVo里面的errMsg的值为error
     */
    /**
     * 先设置是否需要加调
     */
    public boolean needCallBack;
    public String callbackClass;
    public String callbackMethod;
    /**
     * 导出页面来源
     */
    public String exportFrom;

    private String params;

    private String configKey;
    //自定义PO类名称
    private String configPoClass;
    //系统代码
    private String subSysCode;

    private String exportType;

    private Integer siteId;

    private IEntity exportObject;

    private String queryParamsJson;

    private String exportTimestamp;

    private String templateFileName;

    private String exportFileType;
    private String exportLocale;

    public String getExportTimestamp() {
        return exportTimestamp;
    }

    public void setExportTimestamp(String exportTimestamp) {
        this.exportTimestamp = exportTimestamp;
    }

    public String getQueryParamsJson() {
        return queryParamsJson;
    }

    public void setQueryParamsJson(String queryParamsJson) {
        this.queryParamsJson = queryParamsJson;
    }

    public IEntity getExportObject() {
        return exportObject;
    }

    public void setExportObject(IEntity exportObject) {
        this.exportObject = exportObject;
    }

    public String getSubSysCode() {
        return subSysCode;
    }

    public void setSubSysCode(String subSysCode) {
        this.subSysCode = subSysCode;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public boolean isNeedCallBack() {
        return needCallBack;
    }

    public void setNeedCallBack(boolean needCallBack) {
        this.needCallBack = needCallBack;
    }

    public String getCallbackClass() {
        return callbackClass;
    }

    public void setCallbackClass(String callbackClass) {
        this.callbackClass = callbackClass;
    }

    public String getCallbackMethod() {
        return callbackMethod;
    }

    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    public String getExportFrom() {
        return exportFrom;
    }

    public void setExportFrom(String exportFrom) {
        this.exportFrom = exportFrom;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<Integer> getIdsList() {
        String[] split = this.ids.split(",");
        List<Integer> list = null;
        if (split.length > 0) {
            list = new ArrayList<>(split.length);
            for (int i = 0; i < split.length; i++) {
                Integer integer = new Integer(split[i]);
                list.add(integer);
            }
        }
        return list;
    }

    public String getExportFileType() {
        return exportFileType;
    }

    public void setExportFileType(String exportFileType) {
        this.exportFileType = exportFileType;
    }

    public String getExportLocale() {
        return exportLocale;
    }

    public void setExportLocale(String exportLocale) {
        this.exportLocale = exportLocale;
    }

    public String getConfigPoClass() {
        return configPoClass;
    }

    public void setConfigPoClass(String configPoClass) {
        this.configPoClass = configPoClass;
    }

    //endregion your codes 4

}