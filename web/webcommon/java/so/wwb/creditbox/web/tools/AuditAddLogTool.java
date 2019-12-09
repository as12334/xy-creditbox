package so.wwb.creditbox.web.tools;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.ienums.ICodeEnum;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.ClassTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.log.audit.vo.BaseLog;
import org.soul.model.log.audit.vo.LogVo;
import org.soul.model.sys.po.SysAuditLog;
import so.wwb.creditbox.model.common.AuditLogEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuditAddLogTool {

    private static final Log LOG = LogFactory.getLog(AuditAddLogTool.class);

    /**
     * 日志
     *
     * @param request
     * @param description 日志描述
     */
    public static void addLog(HttpServletRequest request, String description, List<String> paramList) {
        LogVo logVo = new LogVo();
        BaseLog baseLog = logVo.addBussLog();
        baseLog.setDescription(description);
        if (CollectionTool.isNotEmpty(paramList)) {
            for (String param : paramList) {
                baseLog.addParam(param);
            }
        }
        request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
    }

    /**
     * 审计日志
     *
     * @param request
     * @param description 国际化信息key
     * @param info        记录内容
     */
    public static void addLog(HttpServletRequest request, String description, String info) {
        LogVo logVo = new LogVo();
        BaseLog baseLog = logVo.addBussLog();
        baseLog.setDescription(description);
        baseLog.addParam(info);
        request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
    }

    /**
     * 通过 AuditLogEnum 共同管理审计日志，提高可维护性
     *
     * @param request
     * @param logEnum
     * @param paramList
     */
    public static void addLog(HttpServletRequest request, AuditLogEnum logEnum, List<String> paramList) {
        try {
            LogVo logVo = new LogVo();
            BaseLog baseLog = logVo.addBussLog();
            baseLog.setDescription(logEnum.getCode());
            String log = logEnum.getTrans();
            Matcher regex = Pattern.compile("\\{(\\d)}").matcher(log);
            while (regex.find()) {
                log = log.replace(regex.group(), paramList.get(Integer.parseInt(regex.group(1))));
            }
            baseLog.addParam(log);
            request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
        } catch (Exception e) {
            LOG.error("[" + logEnum.getTrans() + "]保存审计日志错误：{0}", e.getMessage());
        }
    }


    /**
     * 组装枚举信息
     *
     * @param enumClass 枚举类
     * @param param     组装参数key
     * @return
     */
    public static String installEnumMsg(Class<? extends ICodeEnum> enumClass, String param) {
        try {
            String simpleName = ClassTool.getSimpleName(enumClass);
            String packageName = ClassTool.getPackageName(enumClass);
            Class<? extends ICodeEnum> codeEnumClass = EnumTool.getCodeEnumClass(packageName + "." + simpleName);
            ICodeEnum[] enums = codeEnumClass.getEnumConstants();
            if (ArrayTool.isNotEmpty(enums)) {
                for (ICodeEnum codeEnum : enums) {
                    if (StringTool.equals(codeEnum.getCode(), param)) {
                        param = codeEnum.getTrans();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("保存审计日志匹配枚举信息错误：{0}", e.getMessage());
        } finally {
            return param;
        }
    }


    /**
     * 订單备注、存款、赠送优惠相关审计日志
     *
     * @param vo
     * @param request
     * @param logEnum
     */
//    public static void addBillDepositLog(BillDepositVo vo, AuditLogEnum logEnum, HttpServletRequest request) {
//        try {
//            if (vo.isSuccess()) {
//                List<String> params = new ArrayList<>();
//                params.add(SessionManagerCommon.getSiteId().toString());
//                if (AuditLogEnum.UPDATE_MANUAL_DEPOSIT_REMARK == logEnum
//                        || AuditLogEnum.UPDATE_COMPANY_DEPOSIT_REMARK == logEnum
//                        || AuditLogEnum.UPDATE_ONLINE_DEPOSIT_REMARK == logEnum) {//修改备注的日志数据
//                    params.add(vo.getResult().getBillNo());
//                    params.add(AuditAddLogTool.installEnumMsg(BillItemEnum.class, vo.getResult().getItem()));
//                    params.add(vo.getResult().getRemark());
//
//                } else {//存款、优惠
//                    params.add(vo.getResult().getPlayerName());
//                    params.add(vo.getResult().getBillNo());
//                }
//
//                if (AuditLogEnum.UPDATE_MANUAL_DEPOSIT_CHECK_FAIL == logEnum
//                        || AuditLogEnum.UPDATE_COMPANY_DEPOSIT_CHECK_FAIL == logEnum
//                        || AuditLogEnum.UPDATE_ONLINE_DEPOSIT_CHECK_FAIL == logEnum) {//失败金额
//                    params.add(vo.getResult().getMoney().toString());
//
//                } else if (AuditLogEnum.UPDATE_MANUAL_DEPOSIT_CHECK_SUCCESS == logEnum) {
//                    params.add(vo.getResult().getMoney().toString());
//                    params.add(vo.getResult().getFavorableMoney() == null ? "无" : vo.getResult().getFavorableMoney().toString());
//                    params.add(AuditAddLogTool.installEnumMsg(BillDepositFavorableStatusEnum.class, vo.getResult().getFavorableStatus()));
//                    params.add(vo.getResult().getActualMoney().toString());
//
//                } else if (AuditLogEnum.UPDATE_COMPANY_DEPOSIT_CHECK_SUCCESS == logEnum) {//公司入款
//                    //站点[{0}] 玩家[{1}] 订單号[{2}] 存款金额[{3}] 优惠金额[{4}] 优惠状态[{5}] 实际到账金额[{6}]
//                    params.add(vo.getResult().getMoney().toString());
//                    params.add(vo.getResult().getFavorableMoney() == null ? "无" : vo.getResult().getFavorableMoney().toString());
//                    params.add(AuditAddLogTool.installEnumMsg(BillDepositFavorableStatusEnum.class, vo.getResult().getFavorableStatus()));
//                    params.add(vo.getResult().getCounterFee() == null ? "无" : vo.getResult().getCounterFee().toString());
//                    params.add(vo.getResult().getActualMoney().toString());
//
//                } else if (AuditLogEnum.UPDATE_FAVORABLE_DEPOSIT_CHECK_SUCCESS == logEnum
//                        || AuditLogEnum.UPDATE_FAVORABLE_DEPOSIT_CHECK_FAIL == logEnum) {//优惠活动
//                    params.add(vo.getResult().getFavorableMoney() == null ? "无" : vo.getResult().getFavorableMoney().toString());
//
//                } else if (AuditLogEnum.UPDATE_ONLINE_DEPOSIT_CHECK_SUCCESS == logEnum) {//线上支付
//                    //站点[{0}] 玩家[{1}] 订單号[{2}] 存款金额[{3}] 手续费[{4}] 实际到账金额[{5}]
//                    params.add(vo.getResult().getMoney().toString());
//                    params.add(vo.getResult().getCounterFee() == null ? "无" : vo.getResult().getCounterFee().toString());
//                    params.add(vo.getResult().getActualMoney().toString());
//                }
//                AuditAddLogTool.addLog(request, logEnum, params);
//            }
//        } catch (Exception e) {
//            LOG.error(e, "保存审计日志出错:{0}", e.getMessage());
//        }
//    }

//    /**
//     * 取款相关审计日志
//     */
//    public static void addBillWithdrawalLog(BillWithdrawalVo vo, AuditLogEnum logEnum, HttpServletRequest request) {
//        try {
//            if (vo.isSuccess()) {
//                //站点[{0}] 玩家[{1}] 订單号[{2}]
//                List<String> params = new ArrayList<>();
//                params.add(SessionManagerCommon.getSiteId().toString());
//                if (AuditLogEnum.UPDATE_MANUAL_WITHDRAW_CHECK_LOCK == logEnum
//                        || AuditLogEnum.UPDATE_MANUAL_WITHDRAW_CHECK_UNLOCK == logEnum
//                        || AuditLogEnum.UPDATE_PLAYER_WITHDRAW_CHECK_LOCK == logEnum
//                        || AuditLogEnum.UPDATE_PLAYER_WITHDRAW_CHECK_UNLOCK == logEnum) {
//                    params.add(vo.getSearch().getPlayerName());
//                    params.add(vo.getSearch().getBillNo());
//                } else {
//                    params.add(vo.getResult().getPlayerName());
//                    params.add(vo.getResult().getBillNo());
//                }
//
//                if (AuditLogEnum.UPDATE_MANUAL_WITHDRAW_CHECK_SUCCESS == logEnum) {
//                    //[财务审核-系统取款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 取款金额[{3}] 类型[{4}] 清除稽核点[{5}]
//                    params.add(vo.getResult().getMoney().toString());
//                    params.add(installEnumMsg(BillItemEnum.class, vo.getResult().getItem()));
//                    params.add(vo.getResult().getCleared() ? "是" : "否");
//
//                } else if (AuditLogEnum.UPDATE_PLAYER_WITHDRAW_CHECK_SUCCESS == logEnum) {
//                    //[财务审核-玩家取款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 取款金额[{3}] 扣除优惠[{4}] 行政费[{5}] 实际到账金额[{6}]
//                    params.add(vo.getResult().getMoney().toString());
//                    params.add(vo.getResult().getDeductFavorable() == null ? "无" : vo.getResult().getDeductFavorable().toString());
//                    params.add(vo.getResult().getDeductAdminFee() == null ? "无" : vo.getResult().getDeductAdminFee().toString());
//                    params.add(vo.getResult().getActualMoney().toString());
//
//                } else if (AuditLogEnum.UPDATE_MANUAL_WITHDRAW_REMARK == logEnum
//                        || AuditLogEnum.UPDATE_PLAYER_WITHDRAW_REMARK == logEnum) {
//                    //站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]
//                    params.add(installEnumMsg(BillItemEnum.class, vo.getResult().getItem()));
//                    params.add(vo.getResult().getRemark());
//                }
//                addLog(request, logEnum, params);
//            }
//        } catch (Exception e) {
//            LOG.error("保存审计日志出错{0}", e.getMessage());
//        }
//    }

}
