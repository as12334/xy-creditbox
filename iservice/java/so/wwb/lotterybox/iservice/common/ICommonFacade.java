package so.wwb.lotterybox.iservice.common;

import so.wwb.lotterybox.model.manager.sys.ip.po.IpDb;
import so.wwb.lotterybox.model.manager.sys.ip.vo.IpDbVo;

public interface ICommonFacade {
    IpDb getIpDb(IpDbVo vo);
}
