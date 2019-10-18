package so.wwb.lotterybox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.sys.ip.po.IpDb;
import so.wwb.lotterybox.model.manager.sys.ip.vo.IpDbListVo;
import so.wwb.lotterybox.model.manager.sys.ip.vo.IpDbVo;

import java.util.List;
import java.util.Map;

public interface IIpDbService extends IBaseService<IpDbListVo, IpDbVo, IpDb, Long> {

    IpDb getIp(IpDbVo vo);

    Map<String,List<IpDb>> load(IpDbListVo vo);

}