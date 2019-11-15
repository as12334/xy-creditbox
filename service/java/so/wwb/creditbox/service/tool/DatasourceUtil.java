package so.wwb.creditbox.service.tool;

import org.soul.commons.init.context.Const;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;

import javax.sql.DataSource;

/**
 * Created by shook on 17-11-21.
 */
public class DatasourceUtil {


    public static DataSource getDataSourceBySiteId(Integer siteId) {
        if (siteId <= Const.BOSS_DATASOURCE_ID)
            return null;
        DataSource dataSource = DatasourceTool.getDruidDatasource(siteId);
        return dataSource;
    }

    public static DataSource getBossDatasource() {
        return (DataSource) SpringTool.getBean("bossDataSource");
    }
}
