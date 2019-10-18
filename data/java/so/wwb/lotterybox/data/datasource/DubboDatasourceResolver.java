package so.wwb.lotterybox.data.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.datasource.IDubboDatasourceResolver;
import org.soul.commons.init.context.AbstractBaseVo;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.Const;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;

import javax.sql.DataSource;

public class DubboDatasourceResolver implements IDubboDatasourceResolver {
    private static final Log LOG = LogFactory.getLog(DubboDatasourceResolver.class);

    @Override
    public DataSource determineDatasource(String typeName, String method, AbstractBaseVo vo) {
        DataSource dataSource = null;
        Integer siteId = vo._getSiteId();
        Integer dataSourceId = vo._getDataSourceId();

        if (CommonContext.get() == null) {
            CommonContext.set(new ContextParam());
            CommonContext.get().setSiteId(siteId);
            if (dataSourceId != null) {
                CommonContext.get().setSiteId(dataSourceId);
            }
        }
        if (typeName.startsWith("org.soul")) {
            if (typeName.startsWith("org.soul.iservice.sys.ISysDictService")
                    || typeName.startsWith("org.soul.service.sys.SysDictService")
                    || typeName.startsWith("org.soul.iservice.listop")
                    || typeName.startsWith("org.soul.service.listop")
                    || typeName.startsWith("org.soul.iservice.taskschedule")
                    || typeName.startsWith("org.soul.commons.mq.iservice")
                    || typeName.startsWith("org.soul.service.taskschedule")
                    || typeName.startsWith("org.soul.commons.mq.service")) {
                //列表选择、字典、任务调度、MQ 统一走BOSS库
                dataSource = getBossDatasource();
            } else if (dataSourceId != null) {
                dataSource = getDataSourceById(dataSourceId);
            } else {
                dataSource = getBossDatasource();
            }
            //增加根据siteId调整数据源配置 除了玩家中心之外，其他均是boss数据源
            if (typeName.startsWith("org.soul.iservice.sys.ISysAuditLogService")) {
                if(SubSysCodeEnum.HALL.getCode().equals(CommonContext.get().getSubsysCode())){
                    dataSource = getDataSourceById(siteId);
                }else{
                    dataSource = getBossDatasource();
                }
            }
        } else if (typeName.startsWith("so.wwb.lotterybox.iservice.") || typeName.startsWith("so.wwb.lotterybox.service.")) {
            boolean isManager = (typeName.startsWith("so.wwb.lotterybox.iservice.manager")
                    || typeName.startsWith("so.wwb.lotterybox.service.manager"))
                    && !typeName.endsWith("SysUserExtendService") && !typeName.endsWith("AuditLogService");
            // 管理库
            if (isManager) {
                dataSource = getBossDatasource();
            } else if (typeName.startsWith("so.wwb.lotterybox.iservice.company") || typeName.startsWith("so.wwb.lotterybox.service.company")) {
                // 商户库
                if (dataSourceId != null) {
                    dataSource = getDataSourceById(dataSourceId);
                } else if (siteId != null) {
                    dataSource = getDataSourceById(siteId);
                } else {
                    dataSource = getBossDatasource();
                }
            } else {
                if (dataSourceId != null) {
                    dataSource = getDataSourceById(dataSourceId);
                } else {
                    dataSource = getBossDatasource();
                }
            }
        }

        if (dataSource != null && dataSource instanceof DruidDataSource) {
            //LOG.info("选择数据源:SiteId:{0}, DataSourceID:{1}, DataSource:{3}, typeName:{2}", siteId, dataSourceId, typeName, ((DruidDataSource) dataSource).getName());
        } else {
            LOG.error("选择数据源:siteId:{0}, DataSourceID:{1}, DataSource:{2}, typeName:{3}.{4}", siteId, null, dataSourceId, typeName, method);
        }

        return dataSource;
    }

    private DataSource getDataSourceById(Integer dataSourceId) {
        DataSource dataSource = null;
        if (dataSourceId > Const.BOSS_DATASOURCE_ID) {
            dataSource = DatasourceTool.getDruidDatasource(dataSourceId);
        } else if (Const.BOSS_DATASOURCE_ID.equals(dataSourceId)) {
            dataSource = getBossDatasource();
        }
        return dataSource;
    }

    @Override
    public DataSource getDefaultDatasource() {
        return DatasourceTool.getBaseDatasource();
    }

    private DataSource getBossDatasource() {
        return (DataSource) SpringTool.getBean("bossDataSource");
    }
}
