<#assign className = "${table.className}">
package so.wwb.creditbox.common.dubbo;
import org.soul.commons.dubbo.DubboTool;
<@generateClassComment "远程服务实例获取工具类"/>
public class ServiceTool {

    //region your codes 1

    //region append IMPARTIBLE codes 1
    /**
     * 返回${table.remarks}远程服务实例
     *
     * @return ${table.remarks}远程服务实例
     */
    public static ${basepackage}.iservice.${module}.I${className}Service ${className?uncap_first}Service() {
        return getService(${basepackage}.iservice.${module}.I${className}Service.class);
    }
    //endregion append IMPARTIBLE codes 1

    //endregion your codes 1

}
