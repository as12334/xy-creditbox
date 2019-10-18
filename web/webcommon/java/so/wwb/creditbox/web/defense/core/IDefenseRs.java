package so.wwb.creditbox.web.defense.core;

public interface IDefenseRs {
    String R_ACTION_RS   = "R_ACTION_RS";     //action result
    String R_DEFENSE_RS  = "R_DEFENSE_RS";   //defense result
    String R_DEFENSE_REC = "R_DEFENSE_REC"; //defense record
    String R_DEFENSE_CLI = "R_DEFENSE_CLI"; //defense client

    boolean isAvalable();
    DefenseRs getDefenseRs();
}
