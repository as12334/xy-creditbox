<#assign className = "${table.className}">
package ${basepackage}.service.${module};

import org.soul.service.support.BaseService;
import ${basepackage}.data.${module}.${className}Mapper;
import ${basepackage}.iservice.${module}.I${className}Service;
import ${basepackage}.model.${module}.po.${className};
import ${basepackage}.model.${module}.vo.${className}ListVo;
import ${basepackage}.model.${module}.vo.${className}Vo;


<@generateClassComment table.remarks+"服务"/>
//region your codes 1
public class ${className}Service extends BaseService<${className}Mapper, ${className}ListVo, ${className}Vo, ${className}, ${table.pkColumn.javaType}> implements I${className}Service {
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}