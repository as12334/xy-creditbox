package so.wwb.lotterybox.web.defense.core;

import so.wwb.lotterybox.web.defense.biz.enums.Dispose;
import so.wwb.lotterybox.web.defense.core.model.ResetColumns;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

public class DefenseRs implements IDefenseRs,Serializable{
    public static final DefenseRs OK = new DefenseRs();
    public static final DefenseRs D_CAPTCHA = new DefenseRs(Dispose.CAPTCHA,true);
    public static final DefenseRs D_DISABLED = new DefenseRs(Dispose.DISABLED,false);
    public static final DefenseRs D_IP_CONFINE = new DefenseRs(Dispose.IP_CONFINE,false);

    public DefenseRs() {
        this.dispose = Dispose.NEED_NOT;
    }

    public DefenseRs(Dispose dispose, boolean isAvaiable){
        this.isAvaiable = isAvaiable;
        setDispose(dispose);
    }

    private boolean isAvaiable = true;

    private String resetColumns = ResetColumns.all();

    private Date disposeEndTime;

    private String message;

    private Dispose dispose;

    public Dispose getDispose() {
        return dispose;
    }

    public void setDispose(Dispose dispose) {
        this.dispose = dispose;
    }

    @Override
    public boolean isAvalable() {
        return isAvaiable;
    }

    public void setIsAvaiable(boolean isAvaiable) {
        this.isAvaiable = isAvaiable;
    }

    @Override
    public DefenseRs getDefenseRs() {
        return this;
    }

    public Date getDisposeEndTime() {
        return disposeEndTime;
    }

    public void setDisposeEndTime(Date disposeEndTime) {
        this.disposeEndTime = disposeEndTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResetColumns() {
        return resetColumns;
    }

    public void addReset(String column){
        this.resetColumns = ResetColumns.addReset(resetColumns,column);
    }

    public void removeReset(String column){
        this.resetColumns = ResetColumns.removeReset(resetColumns,column);
    }

    @Override
    public String toString() {
        return  MessageFormat.format("dispose:[{0}],disposeEndTime:[{1}],isAvaiable:[{2}],message:[{3}],resetColumns:{4}",
                getDispose(),
                getDisposeEndTime(),
                isAvalable(),
                getMessage(),
                getResetColumns()
        );
    }
}

