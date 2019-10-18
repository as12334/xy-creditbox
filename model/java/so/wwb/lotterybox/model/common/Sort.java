package so.wwb.lotterybox.model.common;

import java.io.Serializable;

/**
 * GameManageOrderVo
 *
 * @author River
 * @date 15-11-9 下午7:18
 */

public class Sort implements Serializable{

    private Integer order;

    private Integer objectId;

    public Sort() {
    }

    public Sort(Integer order, Integer objectId) {
        this.order = order;
        this.objectId = objectId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
}
