<#assign className = "${table.className}">
package ${basepackage}.model.${module}.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import ${basepackage}.model.${module}.po.${className};
import ${basepackage}.model.${module}.so.${className}So;


<@generateClassComment table.remarks+"值对象"/>
//region your codes 1
public class ${className}Vo extends BaseObjectVo<${className}, ${className}So, ${className}Vo.${className}Query> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = ${random.nextLong()}L;
    //endregion your codes 5

    /**
     *  ${table.remarks}查询逻辑
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

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}