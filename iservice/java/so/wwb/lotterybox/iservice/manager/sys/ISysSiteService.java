package so.wwb.lotterybox.iservice.manager.sys;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteListVo;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;

import java.util.List;
import java.util.Map;


/**
 * 站长站点表服务接口
 * <p>
 * Created by tom using soul-code-generator on 2015-7-21 17:37:50
 */
public interface ISysSiteService extends IBaseService<SysSiteListVo, SysSiteVo, SysSite, Integer> {

    /**
     * 查询是否可转站
     */
    SysSite getSiteImport(SysSiteVo sysSiteVo);

    /**
     * 获取所有正常的站点,不包括运营商和BOSS
     */
    List<SysSite> getAllNormalSite(SysSiteListVo listVo);

    /**
     * 加载站点信息
     */
    Map<String, SysSite> load(SysSiteVo sysSiteVo);

    SysSite searchCodeToid(SysSiteListVo sysSiteListVo);

    /**
     * 查询站点属于哪个角色的subsysCode
     */
    String searchUserCode(SysSiteVo sysSiteVo);

    /**
     * 判断某站点是否为该股东站点
     */
    Boolean isShardholderSite(SysSiteVo sysSiteVo);

    List<SysSite> getAllSysSite();

    /**
     * 验证code是否存在
     */
    String checkSiteCode(SysSiteVo sysSiteVo);

    /**
     * 验证id
     */
    String checkSiteId(SysSiteVo sysSiteVo);


    boolean insertSysSite(SysSite sysSite);

    List<SysSite> getGroupSysSite(Integer[] sites);
}