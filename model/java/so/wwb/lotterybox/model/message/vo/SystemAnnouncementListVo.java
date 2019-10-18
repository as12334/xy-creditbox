package so.wwb.lotterybox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.message.po.SystemAnnouncement;
import so.wwb.lotterybox.model.message.so.SystemAnnouncementSo;

/**
 * Created by jeremy on 18-3-22.
 */
public class SystemAnnouncementListVo extends BaseListVo<SystemAnnouncement, SystemAnnouncementSo, SystemAnnouncementListVo.SysAnnouncementQuery> {

    private static final long serialVersionUID = -8676063145109574601L;

    public static class SysAnnouncementQuery extends AbstractQuery<SystemAnnouncementSo> {

        private static final long serialVersionUID = -7002949644181537753L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
}
