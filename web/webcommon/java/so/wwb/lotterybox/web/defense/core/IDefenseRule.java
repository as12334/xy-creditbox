package so.wwb.lotterybox.web.defense.core;

import so.wwb.lotterybox.web.defense.core.model.DefenseContext;

public interface IDefenseRule {
    boolean isMatch(DefenseContext defenseContext);
    IDefenseRs getResult();
    String toString();
}
