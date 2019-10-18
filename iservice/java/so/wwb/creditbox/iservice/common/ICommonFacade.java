package so.wwb.creditbox.iservice.common;

import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbVo;

public interface ICommonFacade {
    IpDb getIpDb(IpDbVo vo);
}
