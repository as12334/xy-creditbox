package so.wwb.lotterybox.iservice.manager.common;

import org.soul.commons.query.Criteria;
import org.soul.iservice.support.IBaseService;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.model.sys.vo.SysAuditLogListVo;
import org.soul.model.sys.vo.SysAuditLogVo;

/**
 * 审计日志业务接口
 * @author fei
 * @time 2015-11-06 14:09
 */
public interface IAuditLogService extends IBaseService<SysAuditLogListVo, SysAuditLogVo, SysAuditLog, String> {

    /**
     * 日志查询
     */
    SysAuditLogListVo queryLogs(SysAuditLogListVo listVo);

    Criteria getSysAuditLogCriteria(SysAuditLogListVo listVo);
}
