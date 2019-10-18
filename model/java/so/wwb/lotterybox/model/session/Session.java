package so.wwb.lotterybox.model.session;

import java.io.Serializable;
import java.util.UUID;

public class Session<T> implements Serializable {
    private T e;
    private String id=UUID.randomUUID().toString().replaceAll("-","");
    private long timeOut;
    private String prefix;

    public Session() {
    }

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
