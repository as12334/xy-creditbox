<#assign className = "${table.className}">
package ${basepackage}.model.${module}.so;

import ${basepackage}.model.${module}.po.${className};


<@generateClassComment table.remarks+"查询对象"/>
//region your codes 1
public class ${className}So extends ${className} {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = ${random.nextLong()}L;
	//endregion your codes 3

	//region your codes 2

	//endregion your codes 2
}