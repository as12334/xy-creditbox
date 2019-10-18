<#assign className = "${table.className}">
package ${basepackage}.iservice.${module};

import org.soul.iservice.support.IBaseService;
import ${basepackage}.model.${module}.po.${className};
import ${basepackage}.model.${module}.vo.${className}ListVo;
import ${basepackage}.model.${module}.vo.${className}Vo;


<@generateClassComment table.remarks+"服务接口"/>
//region your codes 1
public interface I${className}Service extends IBaseService<${className}ListVo, ${className}Vo, ${className}, ${table.pkColumn.javaType}> {
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}