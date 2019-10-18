package so.wwb.lotterybox.common.filter;

import org.soul.commons.collections.MapTool;
import org.soul.commons.dubbo.IUserSitesCacheResolver;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.ContextParam;
import so.wwb.lotterybox.context.LotteryContextParam;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserSitesCacheResolver implements IUserSitesCacheResolver {

    @Override
    public List<Integer> getSiteIds(ContextParam contextParam) {
        Map<String, SysUserExtend> map = CacheBase.getSysUser();
        if (MapTool.isEmpty(map)) {
            return null;
        }

        List<Integer> sites = new ArrayList<>();
        SubSysCodeEnum sysCodeEnum = EnumTool.enumOf(SubSysCodeEnum.class,
                (String)contextParam.getExtendProperties().get(LotteryContextParam._Key_domainSubsysCode));
        boolean isAdd;
        for (Map.Entry<String, SysUserExtend> entry : map.entrySet()) {
            SysUserExtend sysUser = entry.getValue();
            isAdd = false;
            switch (sysCodeEnum) {
                case BOSS:
                    isAdd = true;
                    break;
                case SHAREHOLDER:
                    if (sysUser.getOwnerId() != null && sysUser.getOwnerId().intValue() == contextParam.getSiteUserId().intValue())
                        isAdd = true;
                    break;
                case COMPANY:
                    if (sysUser.getSiteId() != null && sysUser.getSiteId().intValue() == contextParam.getSiteId().intValue())
                        isAdd = true;
                    break;
                case DISTRIBUTOR:
                    if (sysUser.getSiteId() != null && sysUser.getSiteId().intValue() == contextParam.getSiteId().intValue())
                        isAdd = true;
                    break;
                default:
                    break;
            }
            if (isAdd && !sites.contains(sysUser.getSiteId()))
                sites.add(sysUser.getSiteId());
        }

        sites.add(contextParam.getSiteParentId());
        return sites;
    }

    @Override
    public List<Integer> getSiteIds4Demo() {
        return null;
    }
}
