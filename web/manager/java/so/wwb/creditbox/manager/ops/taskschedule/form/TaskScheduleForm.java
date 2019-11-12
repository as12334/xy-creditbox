package so.wwb.creditbox.manager.ops.taskschedule.form;


import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;


/**
 * 任务调度实体表单验证对象
 *
 * @author admin
 * @time 2018-3-2 15:15:57
 * */
//region your codes 1
public class TaskScheduleForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private String result_jobName;
    private String result_jobCode;
    private String result_jobClass;
    private String result_jobMethod;
    private String result_cronexpression;
    private String result_isLocal;
    private String result_isSync;
    private String result_scheduler;
    private String result_belongToIdc;

    @NotBlank(message = "任务名称不能为空")
    public String getResult_jobName() {
        return result_jobName;
    }

    public void setResult_jobName(String result_jobName) {
        this.result_jobName = result_jobName;
    }

    @NotBlank(message = "任务编码不能为空")
    public String getResult_jobCode() {
        return result_jobCode;
    }

    public void setResult_jobCode(String result_jobCode) {
        this.result_jobCode = result_jobCode;
    }

    @NotBlank(message = "CLASS全路径不能为空")
    public String getResult_jobClass() {
        return result_jobClass;
    }

    public void setResult_jobClass(String result_jobClass) {
        this.result_jobClass = result_jobClass;
    }

    @NotBlank(message = "任务方法名不能为空")
    public String getResult_jobMethod() {
        return result_jobMethod;
    }

    public void setResult_jobMethod(String result_jobMethod) {
        this.result_jobMethod = result_jobMethod;
    }

    @NotBlank(message = "调度表达式不能为空")
    public String getResult_cronexpression() {
        return result_cronexpression;
    }

    public void setResult_cronexpression(String result_cronexpression) {
        this.result_cronexpression = result_cronexpression;
    }

    @NotBlank(message = "是否本地方法不能为空")
    public String getResult_isLocal() {
        return result_isLocal;
    }

    public void setResult_isLocal(String result_isLocal) {
        this.result_isLocal = result_isLocal;
    }

    @NotBlank(message = "是否同步不能为空")
    public String getResult_isSync() {
        return result_isSync;
    }

    public void setResult_isSync(String result_isSync) {
        this.result_isSync = result_isSync;
    }

    @NotBlank(message = "Quartz调度器不能为空")
    public String getResult_scheduler() {
        return result_scheduler;
    }

    public void setResult_scheduler(String result_scheduler) {
        this.result_scheduler = result_scheduler;
    }

    @NotBlank(message = "任务机房不能为空")
    public String getResult_belongToIdc() {
        return result_belongToIdc;
    }

    public void setResult_belongToIdc(String result_belongToIdc) {
        this.result_belongToIdc = result_belongToIdc;
    }
    //endregion your codes 2

}