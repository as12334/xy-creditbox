package so.wwb.creditbox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.sys.po.VSysDomain;
import so.wwb.creditbox.model.manager.sys.so.VSysDomainSo;


/**
 * 域名视图值对象
 *
 * @author cherry
 * @time 2017-4-3 15:11:07
 */
//region your codes 1
public class VSysDomainVo extends BaseObjectVo<VSysDomain, VSysDomainSo, VSysDomainVo.VSysDomainQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -4657429981207833027L;

    private String sitedimainType;
    private Integer angenId;
    private String angenCode;
    //endregion your codes 5

    /**
     *  域名视图查询逻辑
     */
    public static class VSysDomainQuery extends AbstractQuery<VSysDomainSo> {

        //region your codes 6
        private static final long serialVersionUID = -1043321570162676629L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    public String getSitedimainType() {
        return sitedimainType;
    }

    public void setSitedimainType(String sitedimainType) {
        this.sitedimainType = sitedimainType;
    }

    public Integer getAngenId() {
        return angenId;
    }

    public void setAngenId(Integer angenId) {
        this.angenId = angenId;
    }

    public String getAngenCode() {
        return angenCode;
    }

    public void setAngenCode(String angenCode) {
        this.angenCode = angenCode;
    }
    //region your codes 4

    //endregion your codes 4

}