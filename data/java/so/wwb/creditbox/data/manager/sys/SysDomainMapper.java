package so.wwb.creditbox.data.manager.sys;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.so.SysDomainSo;
import so.wwb.creditbox.model.manager.sys.vo.SysDomainListVo;

import java.util.List;


/**
 * 站长域名表-修改完会替换 sys_domain数据访问对象
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public interface SysDomainMapper extends IBaseMapper<SysDomain, Integer> {
//endregion your codes 1

    //region your codes 2
    List<SysDomain> getDomainByIds(SysDomainListVo sysDomainListVo);

    /**
     * 根据用户id查询域名
     *
     * @param sysUserId
     * @return
     */
    String queryDomainByUserId(Integer sysUserId);

    /**
     * 查找站点域名
     */
    List<String> querySiteDomain(SysDomainSo so);
    //endregion your codes 2

}