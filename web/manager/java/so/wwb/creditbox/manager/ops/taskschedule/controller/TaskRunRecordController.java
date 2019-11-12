package so.wwb.creditbox.manager.ops.taskschedule.controller;

import org.soul.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.lotterybox.iservice.manager.taskschedule.ITaskRunRecordService;
import so.wwb.lotterybox.manager.ops.taskschedule.form.TaskRunRecordForm;
import so.wwb.lotterybox.manager.ops.taskschedule.form.TaskRunRecordSearchForm;
import so.wwb.lotterybox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.lotterybox.model.manager.taskschedule.vo.TaskRunRecordListVo;
import so.wwb.lotterybox.model.manager.taskschedule.vo.TaskRunRecordVo;


/**
 * 任务运行结果控制器
 *
 * Created by mark using soul-code-generator on 2015-7-14 19:37:47
 */
@Controller
//region your codes 1
@RequestMapping("/taskRunRecord")
public class TaskRunRecordController extends BaseCrudController<ITaskRunRecordService, TaskRunRecordListVo, TaskRunRecordVo, TaskRunRecordSearchForm, TaskRunRecordForm, TaskRunRecord, Integer> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/ops/taskschedule/taskrunrecord/";
        //endregion your codes 2
    }
    //region your codes 3

    //endregion your codes 3

}