package so.wwb.creditbox.model.company.setting.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.setting.po.UserParam;
import so.wwb.creditbox.model.company.setting.so.UserParamSo;

/**
 * Create by Fei on 2018-01-03
 */
public class UserParamListVo extends BaseListVo<UserParam, UserParamSo, UserParamListVo.UserParamQuery> {

    public static class UserParamQuery extends AbstractQuery<UserParamSo> {

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(UserParam.PROP_USER_ID, Operator.EQ, searchObject.getUserId());
            criteria.addAnd(UserParam.PROP_PARAM_TYPE, Operator.EQ, searchObject.getParamType());
            criteria.addAnd(UserParam.PROP_PARAM_CODE, Operator.EQ, searchObject.getParamCode());
            criteria.addAnd(UserParam.PROP_ACTIVE, Operator.EQ, searchObject.getActive());
            return criteria;
        }

    }

}
