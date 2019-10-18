<#assign className = "${table.className}">
package ${basepackage}.${webModule}.controller;

import org.soul.web.controller.BaseCrudController;
import ${basepackage}.iservice.${module}.I${className}Service;
import ${basepackage}.model.${module}.po.${className};
import ${basepackage}.model.${module}.vo.${className}ListVo;
import ${basepackage}.model.${module}.vo.${className}Vo;
import ${basepackage}.${webModule}.form.${className}SearchForm;
import ${basepackage}.${webModule}.form.${className}Form;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


<@generateClassComment table.remarks+"控制器"/>
@Controller
//region your codes 1
@RequestMapping("/${className?uncap_first}")
public class ${className}Controller extends BaseCrudController<I${className}Service, ${className}ListVo, ${className}Vo, ${className}SearchForm, ${className}Form, ${className}, ${table.pkColumn.javaType}> {
//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/${subModule?replace('.', '/')}/";
        //endregion your codes 2
    }

    //region your codes 3

    //endregion your codes 3

}