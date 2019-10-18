package so.wwb.lotterybox.model.manager.taskschedule.po;

import org.soul.commons.bean.IEntity;

public class TaskRunRecord implements IEntity<Integer> {

    private static final long serialVersionUID = 202914184810805056L;
    public static final String PROP_ID = "id";
    public static final String PROP_TASK_SCHEDULE_ID = "taskScheduleId";
    public static final String PROP_JOB_NAME = "jobName";
    public static final String PROP_TRIGGER_KEY_NAME = "triggerKeyName";
    public static final String PROP_STATUS = "status";
    public static final String PROP_BEGIN_TIME = "beginTime";
    public static final String PROP_END_TIME = "endTime";
    public static final String PROP_RESULT = "result";
    public static final String PROP_REMARK = "remark";

    /**
     * 主键
     */
    private Integer id;
    /**
     * 任务id
     */
    private Integer taskScheduleId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 触发器KeyName
     */
    private String triggerKeyName;
    /**
     * 任务实例状态 1、运行中 2、已结束
     */
    private String status;
    /**
     * 任务实例开始时间
     */
    private java.util.Date beginTime;
    /**
     * 任务实例结束时间
     */
    private java.util.Date endTime;
    /**
     * 任务实例运行结果 1、成功 2、失败
     */
    private String result;
    /**
     * 备注
     */
    private String remark;
    //endregion


    //region constuctors
    public TaskRunRecord() {
    }

    public TaskRunRecord(Integer id) {
        this.id = id;
    }
    //endregion

    //region getters and setters
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getTaskScheduleId() {
        return this.taskScheduleId;
    }

    public void setTaskScheduleId(Integer value) {
        this.taskScheduleId = value;
    }

    @org.soul.model.common.Sortable
    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String value) {
        this.jobName = value;
    }

    @org.soul.model.common.Sortable
    public String getTriggerKeyName() {
        return this.triggerKeyName;
    }

    public void setTriggerKeyName(String value) {
        this.triggerKeyName = value;
    }

    @org.soul.model.common.Sortable
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    @org.soul.model.common.Sortable
    public java.util.Date getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(java.util.Date value) {
        this.beginTime = value;
    }

    @org.soul.model.common.Sortable
    public java.util.Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(java.util.Date value) {
        this.endTime = value;
    }

    @org.soul.model.common.Sortable
    public String getResult() {
        return this.result;
    }

    public void setResult(String value) {
        this.result = value;
    }

    @org.soul.model.common.Sortable
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String value) {
        this.remark = value;
    }

    //endregion

    //region your codes 2
    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_FINISH = "2";

    public static final String RESULT_SUCCESS = "1";
    public static final String RESULT_FAIL = "2";
    //endregion your codes 2
}