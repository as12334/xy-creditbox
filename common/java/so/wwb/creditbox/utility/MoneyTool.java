package so.wwb.creditbox.utility;

import org.soul.commons.currency.CurrencyTool;

/**
 * Create by Fei on 2018-03-22
 */
public final class MoneyTool {
    public static String format(Double money) {
        return CurrencyTool.formatBonus(money == null ? 0.0d : money, 3);
    }
}
