package so.wwb.creditbox.model.message.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.message.po.SystemAnnouncement;
import so.wwb.creditbox.model.message.so.SystemAnnouncementSo;

/**
 * Created by jeremy on 18-3-22.
 */
public class SystemAnnouncementVo extends BaseObjectVo<SystemAnnouncement, SystemAnnouncementSo, SystemAnnouncementVo.SysAnnouncementQuery> {

    private static final long serialVersionUID = -5922631371588015103L;

    public static class SysAnnouncementQuery extends AbstractQuery<SystemAnnouncementSo> {

        private static final long serialVersionUID = -1751627080994924393L;

        @Override
        public Criteria getCriteria() {
            return null;
        }
    }
    private String[] languages;//语言版本
    private String[] contents;//按语言版本顺序保存对应的内容
    /**
     *仅用于显示标题
     */
    private String editType;
    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getContents() {
        return contents;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }
}
