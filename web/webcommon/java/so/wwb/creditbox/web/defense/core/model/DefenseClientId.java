package so.wwb.creditbox.web.defense.core.model;

import org.soul.commons.lang.string.StringTool;

import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

public class DefenseClientId implements Serializable {

    public String id;

    public Integer sysUserId;

    public Locale locale;

    public TimeZone timeZone;

    public String ip;

    public String getId() {

        if (StringTool.isNotBlank(id)) {
            return id;
        }

        if (sysUserId != null) {
            return String.valueOf(sysUserId.hashCode());
        }

        id = String.valueOf(ip.hashCode());
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
