package so.wwb.creditbox.model.manager.lottery;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "record")
public class GatherRecord implements Serializable {
    private static final long serialVersionUID = 849348000130383216L;

    public GatherRecord() {
    }

    private String expect;
    private String open_code;
    private String code;
    private String open_time;
    private String type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getExpect() {
        return expect;
    }

    @XmlAttribute(name = "expect")
    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getOpen_code() {
        return open_code;
    }

    @XmlAttribute(name = "opencode")
    public void setOpen_code(String open_code) {
        this.open_code = open_code;
    }

    public String getCode() {
        return code;
    }

    @XmlAttribute(name = "code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getOpen_time() {
        return open_time;
    }

    @XmlAttribute(name = "open_time")
    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
    }
}
