package so.wwb.creditbox.schedule.service.base;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import so.wwb.creditbox.schedule.service.utility.ServiceManager;
import so.wwb.creditbox.utility.CommonTool;

public class TaskSchedulerFactoryBean extends SchedulerFactoryBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        CommonTool.BindDataSource(0);
        super.afterPropertiesSet();
    }

    @Override
    public void setBeanName(String name) {
        String idc = ServiceManager.getServiceConf().getIdc();
        this.setSchedulerName(idc + "-" + name);
    }
}