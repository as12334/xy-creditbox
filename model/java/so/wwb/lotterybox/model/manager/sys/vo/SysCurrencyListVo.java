package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.SysCurrency;
import so.wwb.lotterybox.model.manager.sys.so.SysCurrencySo;

import java.util.List;
import java.util.Map;


/**
 * 币种表列表页值对象
 *
 * @author catban
 * @time 2015-12-17 15:27:35
 */
//region your codes 1
public class SysCurrencyListVo extends BaseListVo<SysCurrency, SysCurrencySo, SysCurrencyListVo.SysCurrencyQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 8007878592000042518L;



    private List<SysCurrencyVo> currencies;



//    private List<CurrencyExchangeRateVo> currencyRates;
    /*最后更新汇率*/
    private Map lastUpdateRate;

    public Map getLastUpdateRate() {
        return lastUpdateRate;
    }

    public void setLastUpdateRate(Map lastUpdateRate) {
        this.lastUpdateRate = lastUpdateRate;
    }
    //endregion your codes 5

    /**
     *  币种表列表查询逻辑
     */
    public static class SysCurrencyQuery extends AbstractQuery<SysCurrencySo> {

        //region your codes 6
        private static final long serialVersionUID = -7384158700148036277L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        /**
         * 取以人民币为基准的所有货币汇率
         * @return
         */
        public Criteria getIfromEqCNY(){
            Criteria criteria = Criteria.add(SysCurrency.PROP_STATUS, Operator.EQ, true);
            return criteria;
        }


        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4
    public List<SysCurrencyVo> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<SysCurrencyVo> currencies) {
        this.currencies = currencies;
    }

//    public List<CurrencyExchangeRateVo> getCurrencyRates() {
//        return currencyRates;
//    }
//
//    public void setCurrencyRates(List<CurrencyExchangeRateVo> currencyRates) {
//        this.currencyRates = currencyRates;
//    }
    //endregion your codes 4

}