package so.wwb.creditbox.model.bean;

import so.wwb.creditbox.model.manager.lottery.bean.BaseBean;

import java.util.List;
import java.util.Map;

/**
 * Created by jeremy on 18-8-27.
 */
public class VipParamsBean extends BaseBean {
    private static final long serialVersionUID = -9190243887220574747L;

    private List<Map<String, Integer>> paramsList;

    public List<Map<String, Integer>> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<Map<String, Integer>> paramsList) {
        this.paramsList = paramsList;
    }
}
