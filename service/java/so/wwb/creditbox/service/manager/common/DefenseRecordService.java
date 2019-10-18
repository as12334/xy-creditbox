package so.wwb.creditbox.service.manager.common;

import org.soul.service.support.BaseService;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.common.DefenseRecordMapper;
import so.wwb.creditbox.iservice.manager.common.IDefenseRecordService;
import so.wwb.creditbox.model.company.setting.po.DefenseRecord;
import so.wwb.creditbox.model.company.setting.vo.DefenseRecordListVo;
import so.wwb.creditbox.model.company.setting.vo.DefenseRecordVo;


/**
 * 防御记录表服务
 *
 * @author longer
 * @time Jan 17, 2016 4:47:58 PM
 */
//region your codes 1
public class DefenseRecordService extends BaseService<DefenseRecordMapper, DefenseRecordListVo, DefenseRecordVo, DefenseRecord, Long> implements IDefenseRecordService {
//endregion your codes 1

    //region your codes 2

    @Transactional
    @Override
    public int reset(DefenseRecordVo defenseRecordVo) {
        return mapper.reset(defenseRecordVo.getResult());
    }

    @Transactional
    @Override
    public int updateRecord(DefenseRecordVo defenseRecordVo) {
        DefenseRecord defenseRecord = defenseRecordVo.getResult();
        if (defenseRecord.isActionSuccess()) {
            mapper.incrementSuccess(defenseRecordVo.getResult());
        } else {
            mapper.incrementError(defenseRecordVo.getResult());
        }
        //TODO: 详见Dispose
        if ("IP_CONFINE".equals(defenseRecord.getDisposeCode())){
            mapper.disposeByIp(defenseRecord);
        }
        return 1;
    }

    public Integer ipOpUserCount(DefenseRecordVo defenseRecordVo) {
        return mapper.ipOpUserCount(defenseRecordVo.getSearch());
    }
    //endregion your codes 2

}