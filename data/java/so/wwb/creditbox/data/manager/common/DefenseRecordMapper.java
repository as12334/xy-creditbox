package so.wwb.creditbox.data.manager.common;

import org.soul.data.rdb.mybatis.IBaseMapper;
import so.wwb.creditbox.model.company.setting.po.DefenseRecord;


/**
 * 防御记录表数据访问对象
 *
 * @author longer
 * @time Jan 17, 2016 4:47:58 PM
 */
//region your codes 1
public interface DefenseRecordMapper extends IBaseMapper<DefenseRecord, Long> {
//endregion your codes 1

    //region your codes 2

    /**
     * 成功次数增加
     * @param defenseRecord
     * @return
     */
    int incrementSuccess(DefenseRecord defenseRecord);

    /**
     * 失败次数增加
     * @param defenseRecord
     * @return
     */
    int incrementError(DefenseRecord defenseRecord);

    /**
     * 同个IP操作用户个数
     * @param defenseRecord
     * @return
     */
    Integer ipOpUserCount(DefenseRecord defenseRecord);

    /**
     * 重置
     * @param defenseRecord
     * @return
     */
    int reset(DefenseRecord defenseRecord);


    /**
     * 使用IP批量处置
     * @param defenseRecord
     * @return
     */
    int disposeByIp(DefenseRecord defenseRecord);

    //endregion your codes 2

}