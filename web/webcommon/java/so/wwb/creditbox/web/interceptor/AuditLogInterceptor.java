package so.wwb.creditbox.web.interceptor;

import org.soul.model.log.audit.annotation.IAudit;
import org.soul.model.log.audit.po.IAuditEntity;
import org.soul.web.interceptor.AbstractAuditLogWebInterceptor;
import org.springframework.web.method.HandlerMethod;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.notice.AuditAnnationSupport;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by longer on 7/8/15.
 * 审计日志拦截器
 */
public class AuditLogInterceptor extends AbstractAuditLogWebInterceptor {

    @Override
    protected IAuditEntity which(HttpServletRequest request) {
        return new IAuditEntity() {
            @Override
            public Long getEntityId() {
                //被审计实体
                return null;
            }
        };
    }

    @Override
    protected IAudit hasAuditAnnation(HandlerMethod handlerMethod) {
        final Audit audit = handlerMethod.getMethodAnnotation(Audit.class);
        return AuditAnnationSupport.annotationToInterface(audit);
    }
}
