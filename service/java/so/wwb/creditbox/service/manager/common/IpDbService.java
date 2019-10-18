package so.wwb.creditbox.service.manager.common;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.net.IpTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.service.support.BaseService;
import so.wwb.creditbox.data.manager.common.IpDbMapper;
import so.wwb.creditbox.iservice.manager.common.IIpDbService;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbListVo;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IpDbService extends BaseService<IpDbMapper, IpDbListVo, IpDbVo, IpDb, Long> implements IIpDbService {

    @Override
    public IpDb getIp(IpDbVo vo) {
        Long ip = IpTool.ipv4StringToLong(vo.getSearch().getIpStr());
        List<IpDb> ipDbs = mapper.pagingSearch(Criteria.add(IpDb.PROP_IP_START, Operator.LE, ip), 1, 1, Order.desc(IpDb.PROP_IP_START));
        if (CollectionTool.isNotEmpty(ipDbs)){
            return ipDbs.get(0);
        }
        return IpDb.NULL;
    }

    @Override
    public Map<String,List<IpDb>> load(IpDbListVo vo){
        Criteria criteria = Criteria.add(IpDb.PROP_COUNTRY, Operator.EQ,"CN")
                .addAnd(IpDb.PROP_STATEPROV, Operator.NE,"810000")
                .addAnd(IpDb.PROP_STATEPROV, Operator.NE,"820000")
                .addAnd(IpDb.PROP_STATEPROV, Operator.NE,"710000");
        List<IpDb> list=this.mapper.search(criteria);
        Map<String,List<IpDb>> map=new HashMap<>();
        map.put("ip",list);
        return map;
    }

}