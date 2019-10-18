package so.wwb.creditbox.web.interceptor;

import org.soul.commons.support.IModuleTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.web.filter.log.AbstractFilterAuditLog;
import so.wwb.creditbox.model.enums.base.Module;

public class FilterAuditLog extends AbstractFilterAuditLog {

    @Override
    protected void getModule(SysAuditLog sysAuditLog) {
        sysAuditLog.setModuleType(String.valueOf(0));
        sysAuditLog.setModuleName(IModuleTool.getModuleRecursive(Module.Log_Request));
        sysAuditLog.setModuleObj(Module.Log_Request.getCode());
        sysAuditLog.setOperateTypeId(Integer.valueOf(OpType.AUDIT.getCode()));
        sysAuditLog.setOperateType(OpType.AUDIT.getTrans());
    }
}
