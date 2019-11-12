package so.wwb.creditbox.manager.ops.taskschedule.controller;


import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleDateTool;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.so.TaskScheduleSo;
import org.soul.model.taskschedule.vo.TaskScheduleListVo;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.soul.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleCrudServiceEx;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleServiceEx;
import so.wwb.creditbox.manager.ops.taskschedule.form.TaskScheduleForm;
import so.wwb.creditbox.manager.ops.taskschedule.form.TaskScheduleSearchForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.schedule.TaskScheduleStatusEnum;
import so.wwb.creditbox.model.enums.schedule.TaskSchedulerEnum;
import so.wwb.creditbox.web.tools.AuditAddLogTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 任务调度实体控制器
 * <p>
 * Created by Ronnie
 * 2017/11/30
 */
@Controller
//region your codes 1
@RequestMapping("/taskSchedule")
public class TaskScheduleController extends BaseCrudController<ITaskScheduleCrudServiceEx, TaskScheduleListVo, TaskScheduleVo, TaskScheduleSearchForm, TaskScheduleForm, TaskSchedule, Integer> {

    private static final org.soul.commons.log.Log LOG = LogFactory.getLog(TaskScheduleController.class);

    private static final String OPS_TASK_SCHEDULE_SERVICE_RUN = "ops.task.schedule.service.run";

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/ops/taskschedule/";
        //endregion your codes 2
    }

    //region your codes 3

    @Override
    protected TaskScheduleListVo doList(TaskScheduleListVo listVo, TaskScheduleSearchForm form, BindingResult result, Model model) {
        model.addAttribute("statusMap", EnumTool.getEnumList(TaskScheduleStatusEnum.class));
        model.addAttribute("schedulers", EnumTool.getEnumList(TaskSchedulerEnum.class));
        return super.doList(listVo, form, result, model);
    }

    /**
     * 保存
     * @param scheduleVo
     * @return
     */
    @Override
    protected TaskScheduleVo doSave(TaskScheduleVo scheduleVo) {
        return getService().createTask(scheduleVo);
    }

    /**
     * 更新
     * @param scheduleVo
     * @return
     */
    @Override
    protected TaskScheduleVo doUpdate(TaskScheduleVo scheduleVo) {
         return getService().updateTaskSchedule(scheduleVo);
    }

    /**
     * 编辑任务对象
     *
     * @param scheduleVo 任务VO对象
     * @param model      Spring Mvc model对象
     * @return 任务VO对象
     */
    @Override
    protected TaskScheduleVo doEdit(TaskScheduleVo scheduleVo, Model model) {
        model.addAttribute("taskSchedules", EnumTool.getEnumList(TaskSchedulerEnum.class));
        return super.doEdit(scheduleVo, model);
    }

    /**
     * 跳转到新增页面
     *
     * @param objectVo 任务VO对象
     * @param model      Spring Mvc model对象
     * @return 任务VO对象
     */
    @Override
    protected TaskScheduleVo doCreate(TaskScheduleVo objectVo, Model model) {
        model.addAttribute("taskSchedules", EnumTool.getEnumList(TaskSchedulerEnum.class));
        return super.doCreate(objectVo, model);
    }

    /** 上半部分调用ITaskScheduleCrudService，用于数据增改查，下半部分调用ITaskScheduleServiceEx，用于schedule各种操作 */

    /**
     * 立即运行一次
     *
     * @param scheduleVo 任务VO对象
     * @return 返回提示消息及执行状态
     */
    @RequestMapping("/runOnce")
    @ResponseBody
    @Audit(module = Module.OP, moduleType = ModuleType.OPS_TASK_SCHEDULE_SERVICE_RUN,opType = OpType.OTHER,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map runOnce(TaskScheduleVo scheduleVo, HttpServletRequest request) {
        ITaskScheduleServiceEx taskScheduleService = initTaskScheduleServiceEx(scheduleVo);
        taskScheduleService.runOnceTask(scheduleVo);
        addAuditLog(scheduleVo,request,OPS_TASK_SCHEDULE_SERVICE_RUN);
        return getVoMessage(scheduleVo);
    }

    @RequestMapping("/initTaskSchedule")
    @ResponseBody
    public Map initTaskSchedule(String scheduler) {
        TaskScheduleListVo listVo = new TaskScheduleListVo();
        listVo.setSearch(new TaskScheduleSo());
        listVo.getSearch().setScheduler(scheduler);
        listVo.getSearch().setStatus(TaskSchedule.STATUS_ENABLE);
        listVo = this.getService().search(listVo);
        if(CollectionTool.isNotEmpty(listVo.getResult())){
            Map<String,List<TaskSchedule>> map = CollectionTool.groupByProperty(listVo.getResult(), TaskSchedule.PROP_SCHEDULER,String.class);
            for (String schedulerKey : map.keySet()) {
                listVo.setResult(map.get(schedulerKey));
                if(TaskSchedulerEnum.GAME.getCode().equals(schedulerKey)){
                    listVo = ServiceTool.taskScheduleServiceExGs().initTaskSchedules(listVo);
                }else if(TaskSchedulerEnum.DEFAULT.getCode().equals(schedulerKey) || TaskSchedulerEnum.MERCHANT.getCode().equals(schedulerKey)){
                    listVo = ServiceTool.taskScheduleServiceExS().initTaskSchedules(listVo);
                }
                if(!listVo.isSuccess()){
                    return getVoMessage(listVo);
                }
            }
        }else{
            listVo.setOkMsg("暂无需初始化任务");
        }
        return getVoMessage(listVo);
    }

    /**
     * 启用任务
     *
     * @param scheduleVo 任务VO对象
     * @return 返回提示消息及执行状态
     */
    @RequestMapping("/resume")
    @ResponseBody
    public Map resume(TaskScheduleVo scheduleVo) {
        ITaskScheduleServiceEx taskScheduleService = initTaskScheduleServiceEx(scheduleVo);
        scheduleVo = taskScheduleService.resumeTask(scheduleVo);
        return getVoMessage(scheduleVo);
    }

    /**
     * 停用任务
     *
     * @param scheduleVo 任务VO对象
     * @return 返回提示消息及执行状态
     */
    @RequestMapping("/pause")
    @ResponseBody
    public Map pause(TaskScheduleVo scheduleVo) {
        ITaskScheduleServiceEx taskScheduleService = initTaskScheduleServiceEx(scheduleVo);
        taskScheduleService.pauseTask(scheduleVo);
        return getVoMessage(scheduleVo);
    }

    /**
     * 删除任务
     *
     * @param scheduleVo 任务VO对象
     */
    @Override
    protected void doDelete(TaskScheduleVo scheduleVo) {
        ITaskScheduleServiceEx taskScheduleService = initTaskScheduleServiceEx(scheduleVo);
        taskScheduleService.deleteTask(scheduleVo);
    }


    /**
     * 任务调度器的服务接口使用schedule还是game-schedule，默认使用schedule
     * @param scheduleVo
     * @return
     */
    private ITaskScheduleServiceEx initTaskScheduleServiceEx(TaskScheduleVo scheduleVo) {
        if(scheduleVo == null || scheduleVo.getSearch() == null || StringTool.isEmpty(scheduleVo.getSearch().getScheduler())){
            return ServiceTool.taskScheduleServiceExS();
        }else if (TaskSchedulerEnum.GAME.getCode().equals(scheduleVo.getSearch().getScheduler())){
            return ServiceTool.taskScheduleServiceExGs();
        }else{
            return ServiceTool.taskScheduleServiceExS();
        }
    }

    protected void addAuditLog(TaskScheduleVo scheduleVo, HttpServletRequest request, String msgKey){
        try {
            if (scheduleVo.isSuccess()){
                scheduleVo = getSystemParams(scheduleVo);
                List<String> params = new ArrayList<>();

                params.add(scheduleVo.getResult().getJobName());
                params.add(scheduleVo.getResult().getJobCode());
                params.add(scheduleVo.getResult().getScheduler());
                params.add(scheduleVo.getResult().getStatus());
                params.add(SessionManager.getSiteId().toString());
                params.add(SessionManager.getUserName());
                String runDate = LocaleDateTool.formatDate(new Date(), DateTool.yyyy_MM_dd_HH_mm_ss, SessionManagerCommon.getTimeZone());
                params.add(runDate);
                AuditAddLogTool.addLog(request,msgKey,params);
            }
        }catch (Exception e){
            LOG.error("保存审计日志出错{0}",e.getMessage());
        }
    }

    private TaskScheduleVo getSystemParams(TaskScheduleVo scheduleVo){
        scheduleVo._setDataSourceId(SessionManager.getSiteId());
        scheduleVo.getQuery().setCriterions(new Criterion[]{
                new Criterion(TaskSchedule.PROP_JOB_CODE, Operator.EQ,scheduleVo.getSearch().getJobCode()),
                new Criterion(TaskSchedule.PROP_SCHEDULER, Operator.EQ,scheduleVo.getSearch().getScheduler())
        });
        scheduleVo = this.getService().search(scheduleVo);
        return scheduleVo;
    }
}