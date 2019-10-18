<#assign className = "${table.className}">
package ${basepackage}.data.${module};

import ${basepackage}.model.${module}.po.${className};
<#if table.type == "TABLE">
import org.soul.data.rdb.mybatis.IBaseMapper;
<#assign baseMapper = "IBaseMapper">
</#if>
<#if table.type == "VIEW">
import org.soul.data.rdb.mybatis.IBaseQueryMapper;
<#assign baseMapper = "IBaseQueryMapper">
</#if>


<@generateClassComment table.remarks+"数据访问对象"/>
//region your codes 1
public interface ${className}Mapper extends ${baseMapper}<${className}, ${table.pkColumn.javaType}> {
//endregion your codes 1

    //region your codes 2

    //endregion your codes 2

}