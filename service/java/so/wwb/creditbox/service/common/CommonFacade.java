package so.wwb.creditbox.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.iservice.common.ICommonFacade;
import so.wwb.creditbox.iservice.manager.common.IIpDbService;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbVo;

public class CommonFacade implements ICommonFacade {

    @Autowired
    private IIpDbService ipDbService;

    @Override
    public IpDb getIpDb(IpDbVo vo) {
        return ipDbService.getIp(vo);
    }
}