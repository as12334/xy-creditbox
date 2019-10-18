package so.wwb.creditbox.schedule.service.utility;

import org.soul.data.datasource.DatasourceTool;
import so.wwb.creditbox.model.manager.sys.po.SysSite;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ScheduleJobTool {


    //判断站点是否有数据源
    public static List<SysSite> checkSysDatasource(List<SysSite> list){
        List<SysSite> sysSites = new ArrayList<SysSite>();
        if(list!=null && list.size()>0){
            for(SysSite sysSite:list){
                DataSource masterDataSource = DatasourceTool.getDruidDatasource(sysSite.getId());
                if(masterDataSource !=null){
                    sysSites.add(sysSite);
                }
            }
        }
        return sysSites;
    }

}
