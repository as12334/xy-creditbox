package so.wwb.lotterybox.data.manager.message;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.lotterybox.model.message.po.SystemAnnouncement;
import so.wwb.lotterybox.model.message.so.SystemAnnouncementSo;

import java.util.List;

/**
 * Created by jeremy on 18-3-22.
 */
public interface SystemAnnouncementMapper extends IBaseMapper<SystemAnnouncement, Integer> {


    List<SystemAnnouncement> querySystemAnnouncementList(SystemAnnouncementSo so);

    /**
     * 根据公告id和语言类型查询公告内容
     * @param so
     * @return
     */
    SystemAnnouncement querySysAnnouncementByIdAndLanguage(SystemAnnouncementSo so);

    List<SystemAnnouncement> querySysAnnouncementById(SystemAnnouncementSo so);

    int queryAnnTotalCount(SystemAnnouncementSo so);
}
