package so.wwb.lotterybox.data.manager.message;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.message.po.SystemAnnouncementI18n;
import so.wwb.lotterybox.model.message.vo.SystemAnnouncementI18nVo;
import so.wwb.lotterybox.model.message.vo.SystemAnnouncementVo;

/**
 * Created by jeremy on 18-3-23.
 */
public interface SystemAnnouncementI18nMapper extends IBaseMapper<SystemAnnouncementI18n, Integer> {
    Boolean deleteI18nMsgByAnnouncementId(SystemAnnouncementVo vo);
    SystemAnnouncementI18n querySysI18nByAnnouncementIdAndLanguage(SystemAnnouncementI18nVo vo);
}
