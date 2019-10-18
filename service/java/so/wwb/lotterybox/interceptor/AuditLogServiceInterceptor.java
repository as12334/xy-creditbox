package so.wwb.lotterybox.interceptor;

import org.aspectj.lang.JoinPoint;
import org.soul.commons.lang.reflect.JoinPointTool;
import org.soul.model.log.audit.annotation.IAudit;
import org.soul.service.interceptor.AbstractAuditLogServiceInterceptor;
import so.wwb.lotterybox.model.annotations.Audit;
import so.wwb.lotterybox.model.enums.notice.AuditAnnationSupport;

/**
 * Created by longer on 7/15/15.
 */
public class AuditLogServiceInterceptor extends AbstractAuditLogServiceInterceptor {

    @Override
    protected IAudit getAuditAnnotation(JoinPoint jp) throws NoSuchMethodException {
        Audit annotation = JoinPointTool.getInterfacMethod(jp,Audit.class);
        if (annotation == null) {
            return null;
        }
        return AuditAnnationSupport.annotationToInterface(annotation);
    }

}
