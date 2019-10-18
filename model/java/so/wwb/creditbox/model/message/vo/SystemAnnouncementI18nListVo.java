package so.wwb.creditbox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.message.po.SystemAnnouncementI18n;
import so.wwb.creditbox.model.message.so.SystemAnnouncementI18NSo;

/**
 * Created by jeremy on 18-3-23.
 */
public class SystemAnnouncementI18nListVo extends BaseListVo<SystemAnnouncementI18n, SystemAnnouncementI18NSo, SystemAnnouncementI18nListVo.SysAnnouncementI18nQuery> {
    private static final long serialVersionUID = -8690625988519206274L;

    public static class SysAnnouncementI18nQuery extends AbstractQuery<SystemAnnouncementI18NSo> {

        private static final long serialVersionUID = 5323208969899651603L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
}
