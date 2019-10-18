package so.wwb.lotterybox.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.common.ICommonFacade;
import so.wwb.lotterybox.iservice.manager.common.IIpDbService;
import so.wwb.lotterybox.model.manager.sys.ip.po.IpDb;
import so.wwb.lotterybox.model.manager.sys.ip.vo.IpDbVo;

public class CommonFacade implements ICommonFacade {

    @Autowired
    private IIpDbService ipDbService;

    @Override
    public IpDb getIpDb(IpDbVo vo) {
        return ipDbService.getIp(vo);
    }
}