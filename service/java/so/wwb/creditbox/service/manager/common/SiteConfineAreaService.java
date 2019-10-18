package so.wwb.creditbox.service.manager.common;


import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.data.datasource.DatasourceTool;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.common.SiteConfineAreaMapper;
import so.wwb.creditbox.iservice.manager.common.ISiteConfineAreaService;
import so.wwb.creditbox.model.constants.lottery.LotteryFunction;
import so.wwb.creditbox.model.manager.site.po.SiteConfineArea;
import so.wwb.creditbox.model.manager.site.po.SiteOperateArea;
import so.wwb.creditbox.model.manager.site.vo.SiteConfineAreaListVo;
import so.wwb.creditbox.model.manager.site.vo.SiteConfineAreaVo;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * 限制访问站点的地区表服务
 *
 * @author tony
 * @time 2015-11-13 14:19:56
 */
public class SiteConfineAreaService extends BaseService<SiteConfineAreaMapper, SiteConfineAreaListVo, SiteConfineAreaVo, SiteConfineArea, Integer> implements ISiteConfineAreaService {
    private static final Log LOG = LogFactory.getLog(SiteConfineAreaService.class);
    @Override
    public Map<String, Map<String, SiteConfineArea>> load(SiteConfineAreaVo siteConfineAreaVo) {
        Integer siteId=siteConfineAreaVo.getSearch().getSiteId();
        if(siteId==null){
            siteId=siteConfineAreaVo._getSiteId();
        }
        Map<String, Map<String, SiteConfineArea>> cacheMap = new LinkedHashMap<>();
        List<SiteConfineArea> list = mapper.search(Criteria.add(SiteOperateArea.PROP_SITE_ID, Operator.EQ, siteId), Order.asc(SiteConfineArea.PROP_ID));
        if(list.size()>0) {
            cacheMap.put(siteId.toString(), CollectionTool.toEntityMap(list, SiteConfineArea.PROP_ID, String.class));
        }
        return cacheMap;
    }

    @Override
    public SiteConfineAreaVo isThereArea(SiteConfineAreaVo objectVo) {
        Integer id=objectVo.getResult().getId();
        String Msg = "该地区已在限制列表中,请重新选择！";
        SiteConfineArea result=objectVo.getResult();
        String city=result.getCity();
        String province=result.getProvince();
        String nation=result.getNation();
        boolean bo = false;
        if("HK".equals(nation) || "TW".equals(nation)){
            bo = checkHKTW(result);
        }
        Criteria criteria=new Criteria();
        criteria.addAnd(SiteConfineArea.PROP_SITE_ID, Operator.EQ,result.getSiteId());
        criteria.addAnd(SiteConfineArea.PROP_NATION, Operator.EQ, nation);
        if(StringTool.isNotBlank(province)){
            criteria.addAnd(SiteConfineArea.PROP_PROVINCE, Operator.EQ, province);
        }else{
            criteria.addAnd(SiteConfineArea.PROP_PROVINCE, Operator.IS_NULL, true);
        }
        if(StringTool.isNotBlank(city)){
            criteria.addAnd(SiteConfineArea.PROP_CITY, Operator.EQ, city);
        }else{
            criteria.addAnd(SiteConfineArea.PROP_CITY, Operator.IS_NULL, true);
        }
        if(id!=null){
            criteria.addAnd(SiteConfineArea.PROP_ID, Operator.NE,id);
        }
        criteria.addAnd(SiteConfineArea.PROP_END_TIME, Operator.GT,new Date());
        Long num= mapper.count(criteria);
        if (num > 0 || bo) {
            objectVo.setErrMsg(Msg);
            objectVo.setSuccess(false);
        }
        return objectVo;
    }

    //判断是否添加的是香港或台湾
    private boolean checkHKTW(SiteConfineArea result){
        boolean bo = false;
        Criteria criteria=new Criteria();
        criteria.addAnd(SiteConfineArea.PROP_SITE_ID, Operator.EQ,result.getSiteId());
        criteria.addAnd(SiteConfineArea.PROP_BUILT_IN, Operator.EQ,true);
        criteria.addAnd(SiteConfineArea.PROP_NATION, Operator.EQ,"CN");
        if("HK".equals(result.getNation())){
            criteria.addAnd(SiteConfineArea.PROP_PROVINCE, Operator.EQ,"810000");
        }else if("TW".equals(result.getNation())){
            criteria.addAnd(SiteConfineArea.PROP_PROVINCE, Operator.EQ,"710000");
        }
        Long num= mapper.count(criteria);
        if(num > 0){
            bo = true;
        }
        return bo;
    }

    public List getDateList(){
        List list =new ArrayList();
        Date date=new Date();
        list.add(DateTool.addMonths(date, 12000));
        date=new Date();
        list.add(DateTool.addDays(date, 7));
        date=new Date();
        list.add(DateTool.addDays(date, 15));
        date=new Date();
        list.add(DateTool.addMonths(date, 1));
        date=new Date();
        list.add(DateTool.addMonths(date, 3));
        date=new Date();
        list.add(DateTool.addMonths(date, 6));
        date=new Date();
        list.add(DateTool.addMonths(date, 12));
        return list;
    }

    @Override
    public SiteConfineAreaVo callInitSiteConfineArea(SiteConfineAreaVo vo){
        CallableStatement cs = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            DataSource masterDataSource = DatasourceTool.getBaseDatasource();
            conn = masterDataSource.getConnection();
            cs = conn.prepareCall(LotteryFunction.CALL_F_INIT_SITE_CONFINE_AREA);
            cs.setInt(1,vo.getResult().getSiteId());
            cs.execute();
            rs = cs.getResultSet();
            if (rs != null && rs.next()) {
                String reVal = rs.getString(1);
                LOG.info("SiteConfineAreaService:初始化黑名单返回结果:{0}",reVal);
            }
            return vo;
        } catch (SQLException e) {
            LOG.error(e,"SiteConfineAreaService:初始化黑名单返回结果");
            vo.setSuccess(false);
            return vo;
        } finally {
            DatasourceTool.release(conn,cs,rs);
        }
    }


}