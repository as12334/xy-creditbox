package so.wwb.gamebox.tools;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 16-11-6.
 */
public class ApiResult implements Serializable{
    private String betType;
    private String selection;
    private String handicap;
    private List<ApiResult> apiResultList;


    /**
     * 闲家结果牌集合
     */
    private Set<List<Integer>> porkerList = new LinkedHashSet<>();

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public List<ApiResult> getApiResultList() {
        return apiResultList;
    }

    public void setApiResultList(List<ApiResult> apiResultList) {
        this.apiResultList = apiResultList;
    }

    public Set<List<Integer>> getPorkerList() {
        return porkerList;
    }

    public void setPorkerList(Set<List<Integer>> porkerList) {
        this.porkerList = porkerList;
    }
}
