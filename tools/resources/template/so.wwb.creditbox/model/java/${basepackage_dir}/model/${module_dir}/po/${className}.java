<#assign className = "${table.className}">
package ${basepackage}.model.${module}.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


<@generateClassComment table.remarks+"实体" table.tableAuthor/>
//region your codes 1
public class ${className} implements IEntity<${table.pkColumn.javaType}> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = ${random.nextLong()}L;
	//endregion your codes 3

	//region property name constants
	<#list table.columns as column>
	public static final String PROP_${column.constantName} = "${column.columnNameLower}";
	</#list>
	//endregion
	
	
	//region properties
	<#list table.noImportColumns as column>
	/** ${column.remarks} */
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	//endregion

	
	//region constuctors
	<@generateConstructor className/>
	//endregion


	//region getters and setters
	<#list table.columns as column>
	<#if column.isSortable()>
	@org.soul.model.common.Sortable
	</#if>
	<@generateGetterSetters column/>
	</#list>
	//endregion

	//region your codes 2

	//endregion your codes 2

}