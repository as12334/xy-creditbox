package so.wwb.lotterybox.web.defense.core.interceptor;

import org.soul.commons.lang.DateTool;
import org.soul.commons.net.IpTool;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.iservice.manager.common.IDefenseRecordService;
import so.wwb.lotterybox.model.company.setting.vo.DefenseRecordVo;
import so.wwb.lotterybox.web.defense.biz.enums.DefenseAction;
import so.wwb.lotterybox.web.defense.biz.interceptor.IDefense;
import so.wwb.lotterybox.web.defense.core.model.DefenseClientId;
import so.wwb.lotterybox.web.defense.core.model.DefensePadding;

import java.util.Date;

public class DefenseRecordPadding implements IDefenseRecordPadding {
    public static final String IP_OP_USER_COUNT = "IP_OP_USER_COUNT";

    @Override
    public DefensePadding padding(IDefense defense, DefenseClientId defenseClientId) {
        DefenseAction defenseAction = DefenseAction.enumOf(defense.action());
        switch (defenseAction) {
            case PHONE:
            case MAIL:
                return countByIp(defenseClientId);

        }

        return null;
    }

    /**
     * 通过IP统计 同一个IP操作账号错误数
     *
     * @param defenseClientId
     * @return
     */
    private DefensePadding countByIp(DefenseClientId defenseClientId) {
        Date minAgo = DateTool.addMinutes(new Date(), 30);
        DefenseRecordVo vo = new DefenseRecordVo();
        vo.getSearch().setOperateIp(IpTool.ipv4StringToLong(defenseClientId.getIp()));
        vo.getSearch().setOperateEndTime(minAgo);

        Integer ipOpUserCount = defenseRecordService().ipOpUserCount(vo);
        DefensePadding padding = new DefensePadding();
        padding.set(IP_OP_USER_COUNT, ipOpUserCount);
        return padding;
    }

    private IDefenseRecordService defenseRecordService() {
        return ServiceTool.defenseRecordService();
    }
}
