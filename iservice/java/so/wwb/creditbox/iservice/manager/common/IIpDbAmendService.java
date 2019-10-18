package so.wwb.creditbox.iservice.manager.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDbAmend;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbAmendListVo;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbAmendVo;


/**
 * IP数据库-修正库服务接口
 *
 * @author longer
 * @time Dec 8, 2015 11:04:54 AM
 */
public interface IIpDbAmendService extends IBaseService<IpDbAmendListVo, IpDbAmendVo, IpDbAmend, Long> {

}