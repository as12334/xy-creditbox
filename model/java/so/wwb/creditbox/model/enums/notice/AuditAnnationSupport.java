package so.wwb.creditbox.model.enums.notice;


import org.soul.commons.enums.YesNot;
import org.soul.commons.support.IModule;
import org.soul.commons.support.IModuleType;
import org.soul.model.log.audit.annotation.IAudit;
import org.soul.model.log.audit.enums.OpType;
import so.wwb.creditbox.model.annotations.Audit;


/**
 * created by longer on 7/15/15.
 */
public class AuditAnnationSupport {

    /**
     * 从注解到接口的转换
     * @param audit
     * @return
     */
    public static IAudit annotationToInterface(final Audit audit) {
        if (audit != null) {
            return new IAudit() {
                @Override
                public OpType opType() {
                    return audit.opType();
                }

                @Override
                public IModule module() {
                    return audit.module();
                }

                @Override
                public IModuleType moduleType() {
                    return audit.moduleType();
                }

                @Override
                public String desc() {
                    return audit.desc();
                }

                @Override
                public YesNot ignoreForm() {
                    return audit.ignoreForm();
                }

                @Override
                public YesNot isSystem() {
                    return audit.isSystem();
                }
            };
        }
        return null;
    }
}
