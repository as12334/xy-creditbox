package so.wwb.creditbox.model.manager.lottery.vo;

import java.io.Serializable;

/**
 * GameManageOrderVo
 *
 * @author River
 * @date 15-11-9 下午7:18
 */

public class GameManageOrderVo implements Serializable {

    private Integer order;

    private Integer objectId;

    private Integer siteId;

    public GameManageOrderVo() {
    }

    public GameManageOrderVo(Integer order, Integer objectId) {
        this.order = order;
        this.objectId = objectId;
    }

    public GameManageOrderVo(Integer order, Integer objectId, Integer siteId) {
        this.order = order;
        this.objectId = objectId;
        this.siteId = siteId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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
