<#assign className = "${table.className}">
package ${basepackage}.model.${module}.vo;

import org.soul.commons.query.Criteria;
<#if table.defaultOrderColumns?has_content>
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
</#if>
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import ${basepackage}.model.${module}.po.${className};
import ${basepackage}.model.${module}.so.${className}So;


<@generateClassComment table.remarks+"列表页值对象"/>
//region your codes 1
public class ${className}ListVo extends BaseListVo<${className}, ${className}So, ${className}ListVo.${className}Query> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = ${random.nextLong()}L;
    //endregion your codes 5

    /**
     *  ${table.remarks}列表查询逻辑
     */
    public static class ${className}Query extends AbstractQuery<${className}So> {

        //region your codes 6
        private static final long serialVersionUID = ${random.nextLong()}L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        <#if table.defaultOrderColumns?has_content>
        @Override
        public Sort getDefaultSort() {
            return Sort<#list table.defaultOrderColumns as column><#if column_index == 0>.add<#else>.addOrder</#if>(${className}.PROP_${column.constantName}, <#if column.defaultOrder == "升序">Direction.ASC<#else>Direction.DESC</#if>)</#list>;
        }
        </#if>

        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}