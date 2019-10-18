package so.wwb.creditbox.iservice.manager.message;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.message.po.SystemAnnouncement;
import so.wwb.creditbox.model.message.vo.SystemAnnouncementListVo;
import so.wwb.creditbox.model.message.vo.SystemAnnouncementVo;

import java.util.List;
import java.util.Map;

/**
 * Created by jeremy on 18-3-22.
 */
public interface ISystemAnnouncementService extends IBaseService<SystemAnnouncementListVo, SystemAnnouncementVo, SystemAnnouncement, Integer> {

    SystemAnnouncementVo saveMessage(SystemAnnouncementVo vo, SysUserExtend operator);


    List<SystemAnnouncement> querySystemAnnouncementList(SystemAnnouncementListVo listVo);

    /**
     * 根据公告id和语言类型查询公告内容
     * search.id  not null
     * search.language  not null
     * @param vo
     * @return
     */
    SystemAnnouncementVo querySystemAnnouncementByIdAndLanguage(SystemAnnouncementVo vo);

    /**
     * 删除公告（修改status字段）
     * @param vo
     * @return
     */
    SystemAnnouncementVo deleteMessage(SystemAnnouncementVo vo);

    int queryAnnTotalCount(SystemAnnouncementListVo listVo);

    List<SystemAnnouncement> querySysAnnouncementById(SystemAnnouncementVo vo);

    Map<String, Map<String,SystemAnnouncement>> load(SystemAnnouncementVo systemAnnouncementVo);
}
