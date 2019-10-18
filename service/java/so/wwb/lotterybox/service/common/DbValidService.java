package so.wwb.lotterybox.service.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.bean.IEntity;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.data.datasource.DatasourceTool;
import org.soul.data.mapper.sys.SysDatasourceMapper;
import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import org.soul.data.rdb.mybatis.service.impl.EntityMappingHolder;
import org.soul.data.support.DataContext;
import org.soul.iservice.test.IDbValidService;
import org.soul.model.sys.po.SysDatasource;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.util.*;

/**
 * Created by kevice on 15-10-12.
 * copy by marz on 18-05-07
 */
public class DbValidService implements IDbValidService, InitializingBean {

    private static final Log LOG = LogFactory.getLog(DbValidService.class);
    private DataSource bossDataSource;
    private DataSource statDataSource;
    private Map<String, DataSource> fixDataSourceMap;
    private EntityMappingHolder entityMappingHolder;
    private SysDatasourceMapper sysDatasourceMapper;


    @Override
    public boolean checkSchemaMapping() {
        boolean finalPass = true;
        for (Map.Entry<String, DataSource> entry : fixDataSourceMap.entrySet()) {
            String dataSourceName = entry.getKey();
            LOG.debug("校验数据源{0}...", dataSourceName);
            DataContext.setDataSource(entry.getValue());
            if (check(dataSourceName)) {
                LOG.debug("数据源{0}校验通过.", dataSourceName);
            } else {
                if (finalPass) {
                    finalPass = false;
                }
            }
        }

        LOG.debug("校验各站点数据源...");
        DataContext.setDataSource(bossDataSource);
        List<SysDatasource> siteDatasources = sysDatasourceMapper.allSearch();
        for (SysDatasource siteDatasource : siteDatasources) {
            if(siteDatasource.getId()==1) {
                String dataSourceName = siteDatasource.getName();
                LOG.debug("校验站点数据源{0}...", dataSourceName);
                Integer dsId = siteDatasource.getId();
                DruidDataSource ds = DatasourceTool.getDruidDatasource(dsId);
                DataContext.setDataSource(ds);
                if (check(dataSourceName)) {
                    LOG.debug("站点数据源{0}校验通过.", dataSourceName);
                } else {
                    if (finalPass) {
                        finalPass = false;
                    }
                }
            }
        }
        LOG.debug("校验各站点数据源完成.");

        return finalPass;
    }

    private boolean check(String dataSourceName) {
        boolean pass = true;
        Map<IBaseQueryMapper,Class<IEntity>> allMappers = entityMappingHolder.getAllMappers();
        for (Map.Entry<IBaseQueryMapper,Class<IEntity>> entry : allMappers.entrySet()) {
            Class<IEntity> entityClass = entry.getValue();
            String tableName = entityMappingHolder.getTableName(entityClass);
            IBaseQueryMapper mapper = entry.getKey();


            // 不是在当前库中的表不校验字段是否存在
            try {
                mapper.oneSearch("id", null);
            } catch (Exception e) {
                continue;
            }

            // 表在当前库存在，才进行字段存在与否的校验
            Map<String, String> propColumns = entityMappingHolder.getAllColumns(entityClass);
            Set<String> allColumns = entityMappingHolder.getAllColumnsInMapper(entityClass);
            Set<String> returnProps = new HashSet<>();
            for (Map.Entry<String, String> columnEntry : propColumns.entrySet()) {
                String column = columnEntry.getValue();
                if (allColumns.contains(column)) {
                    returnProps.add(columnEntry.getKey());
                }
            }
            LOG.debug("校验表{0}...", tableName);
            try {
                mapper.oneSearchProperties("id", null, returnProps);
                LOG.debug("校验表{0}通过.", tableName);
            } catch (Exception e) {
                LOG.error(e, "表{0}校验失败, 数据源为{1}!", tableName, dataSourceName);
                pass = false;
            }
        }
        return pass;
    }

    public void setBossDataSource(DataSource bossDataSource) {
        this.bossDataSource = bossDataSource;
    }

    public void setStatDataSource(DataSource statDataSource) {
        this.statDataSource = statDataSource;
    }

//    public void setHistoryDataSource(DataSource historyDataSource) {
//        this.historyDataSource = historyDataSource;
//    }

    public void setEntityMappingHolder(EntityMappingHolder entityMappingHolder) {
        this.entityMappingHolder = entityMappingHolder;
    }

    public void setSysDatasourceMapper(SysDatasourceMapper sysDatasourceMapper) {
        this.sysDatasourceMapper = sysDatasourceMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        fixDataSourceMap = new HashMap<>(4,1f);
        fixDataSourceMap.put("bossDataSource", bossDataSource);
        fixDataSourceMap.put("statDataSource", statDataSource);
    }
}
