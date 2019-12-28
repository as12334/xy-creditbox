package so.wwb.creditbox.iservice.company.user;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.company.user.vo.CzUsersChildListVo;
import so.wwb.creditbox.model.company.user.vo.CzUsersChildVo;


/**
 * 服务接口
 *
 * @author block
 * @time 2019-12-24 23:36:50
 */
//region your codes 1
public interface ICzUsersChildService extends IBaseService<CzUsersChildListVo, CzUsersChildVo, CzUsersChild, Integer> {

//endregion your codes 1

    //region your codes 2
    CzUsersChild findByUsername(CzUsersChildVo czUsersVo);

    //endregion your codes 2

}