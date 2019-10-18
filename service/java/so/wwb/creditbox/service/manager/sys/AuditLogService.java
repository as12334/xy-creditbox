package so.wwb.creditbox.service.manager.sys;


import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.IpTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.data.mapper.sys.SysAuditLogMapper;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.model.sys.so.SysAuditLogSo;
import org.soul.model.sys.vo.SysAuditLogListVo;
import org.soul.model.sys.vo.SysAuditLogVo;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.iservice.manager.common.IAuditLogService;
import so.wwb.creditbox.model.enums.sys.SysUserTypeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;


/**
 * @author fly
 * @time 2015-11-06 16:02
 */
public class AuditLogService extends BaseService<SysAuditLogMapper, SysAuditLogListVo, SysAuditLogVo, SysAuditLog, String> implements IAuditLogService {

    public SysAuditLogListVo queryLogs(SysAuditLogListVo listVo) {
        Criteria criteria = getSysAuditLogCriteria(listVo);
        SysAuditLogListVo search = search(criteria, listVo, this.mapper);
        listVo.setResult(search.getResult());
        return listVo;
    }

    public Criteria getSysAuditLogCriteria(SysAuditLogListVo listVo) {
        SysAuditLogSo logSo = listVo.getSearch();
        Criteria criteria = Criteria.add(SysAuditLog.PROP_OPERATE_TIME, Operator.GE, logSo.getOperatorBegin());
        criteria.addAnd(SysAuditLog.PROP_OPERATE_TIME, Operator.LT, logSo.getOperatorEnd());
        criteria.addAnd(SysAuditLog.PROP_MODULE_TYPE, Operator.EQ, logSo.getModuleType());
        criteria.addAnd(SysAuditLog.PROP_OPERATE_TYPE, Operator.EQ, logSo.getOperateType());
        criteria.addAnd(SysAuditLog.PROP_ENTITY_USER_ID, Operator.EQ, logSo.getEntityUserId());
        criteria.addAnd(SysAuditLog.PROP_OPERATOR_ID, Operator.EQ, logSo.getOperatorId());
        criteria.addAnd(SysAuditLog.PROP_OPERATOR, Operator.LIKE, logSo.getOperator());
        criteria.addAnd(SysAuditLog.PROP_MODULE_TYPE,Operator.IN,logSo.getModuleTypes());
        criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE,Operator.EQ,logSo.getOperatorUserType());
        criteria.addAnd(SysAuditLog.PROP_SITE_ID,Operator.EQ,logSo.getSiteId());

        if (StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), SysUserTypeEnum.AGENT.getCode())) {
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.IN, new String[]{UserTypeEnum.DISTRIBUTOR.getCode(), UserTypeEnum.DISTRIBUTOR_SUB.getCode()});
        }
        else if (StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), SysUserTypeEnum.COMPANY.getCode())) {
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.IN, new String[]{UserTypeEnum.COMPANY.getCode(), UserTypeEnum.COMPANY_SUB.getCode(), UserTypeEnum.DISTRIBUTOR.getCode(), UserTypeEnum.DISTRIBUTOR_SUB.getCode()});
        }
        else if (StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), SysUserTypeEnum.PLAYER.getCode())) {
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.EQ, UserTypeEnum.PLAYER.getCode());
        }
        else if(StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), SysUserTypeEnum.SHAREHOLDER.getCode())){
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.IN, new String[]{UserTypeEnum.SHAREHOLDER.getCode(), UserTypeEnum.SHAREHOLDER_SUB.getCode()});
        }
        else if(StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), SysUserTypeEnum.BOSS.getCode())){
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.IN, new String[]{UserTypeEnum.BOSS.getCode(), UserTypeEnum.BOSS_SUB.getCode()});
        }
        else if (StringTool.isBlank(logSo.getOperatorUserType()) && StringTool.equals(logSo.getRoleType(), "bossMerchant")) {//boss查商户没有总代
            criteria.addAnd(SysAuditLog.PROP_OPERATOR_USER_TYPE, Operator.IN, new String[]{UserTypeEnum.COMPANY.getCode(), UserTypeEnum.COMPANY_SUB.getCode()});
        }
        long ip = IpTool.ipv4StringToLong(logSo.getIp());
        criteria.addAnd(SysAuditLog.PROP_OPERATE_IP, Operator.EQ, ip == -1 ? null : ip);
        listVo.getQuery().addOrder(SysAuditLog.PROP_OPERATE_TIME, Direction.DESC);
        return criteria;
    }
}
