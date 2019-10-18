package so.wwb.creditbox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;

import java.util.List;

/**
 * Created by block on 2019/10/14.
 */
public class Nav implements IEntity<Integer> {

    private static final long serialVersionUID = 4250920954455860009L;

    private Integer id;

    private String name;

    private String url;

    private String dialog;

    private List<Nav> ut;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Nav> getUt() {
        return ut;
    }

    public void setUt(List<Nav> ut) {
        this.ut = ut;
    }


    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
