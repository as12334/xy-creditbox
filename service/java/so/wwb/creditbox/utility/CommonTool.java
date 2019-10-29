package so.wwb.creditbox.utility;

import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.support.DataContext;

import javax.sql.DataSource;
import java.text.DecimalFormat;

/**
 * @author: wilson
 * @function: common business function implementation
 */
public class CommonTool {

    /** 官方玩法金额保留3位小数 */
    public static DecimalFormat BONUS = new DecimalFormat("#0.0000");

    public static void BindDataSource(Integer dataSourceId) {
        DataSource bossDataSource;
        if (dataSourceId.equals(0)) {
            bossDataSource = (DataSource) SpringTool.getBean("bossDataSource");
        } else {
            bossDataSource = DatasourceTool.getDruidDatasource(dataSourceId);
        }
        DataContext.setDataSource(bossDataSource);
    }

    /**
     * 獲取上級的userType
     * @param userType
     * @return
     */
    public static Integer getSuperUserType(String userType){
        return Integer.valueOf(userType) - 1;
    }


}