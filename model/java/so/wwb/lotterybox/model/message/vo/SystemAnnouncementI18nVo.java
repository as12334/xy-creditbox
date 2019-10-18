package so.wwb.lotterybox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.message.po.SystemAnnouncementI18n;
import so.wwb.lotterybox.model.message.so.SystemAnnouncementI18NSo;

/**
 * Created by jeremy on 18-3-23.
 */
public class SystemAnnouncementI18nVo extends BaseObjectVo<SystemAnnouncementI18n, SystemAnnouncementI18NSo, SystemAnnouncementI18nVo.SysAnnouncementI18nQuery> {

    private static final long serialVersionUID = 6322513054352779106L;

    public static class SysAnnouncementI18nQuery extends AbstractQuery<SystemAnnouncementI18NSo> {

        private static final long serialVersionUID = 2639725300350616927L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
}
