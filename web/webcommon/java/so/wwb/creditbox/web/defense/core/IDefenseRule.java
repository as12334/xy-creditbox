package so.wwb.creditbox.web.defense.core;

import so.wwb.creditbox.web.defense.core.model.DefenseContext;

public interface IDefenseRule {
    boolean isMatch(DefenseContext defenseContext);
    IDefenseRs getResult();
    String toString();
}
