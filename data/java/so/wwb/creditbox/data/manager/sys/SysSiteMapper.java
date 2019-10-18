package so.wwb.creditbox.data.manager.sys;


import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteListVo;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;

import java.util.List;


/**
 * 站点表数据访问对象
 *
 * @author catban
 * @time 2015-11-26 10:04:22
 */
public interface SysSiteMapper extends IBaseMapper<SysSite, Integer> {

    List<SysSite> queryLang(SysSiteListVo sysSiteListVo);

    SysSite searchCodeToid(String code);

    /**
     * 查询站点属于哪个角色的subsysCode
     */
    String searchUserCode(SysSite sysSite);

    /**
     * 判断某站点是否为该股东站点
     */
    Integer isShardholderSite(SysSiteVo sysSiteVo);
    //endregion your codes 2

}