package so.wwb.lotterybox.iservice.company.site;

import org.soul.iservice.sys.ISysParamService;
import org.soul.model.sys.vo.SysParamVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineAreaVo;
import so.wwb.lotterybox.model.manager.site.vo.SiteConfineIpVo;

/**
 * Created by Administrator on 2016/6/16.
 */
public interface ISiteSysParamService extends ISysParamService {



	/**
	 * 查询vip状态
	 *
	 * @param vo
	 * @return
	 */
	SysParamVo queryVipStatus(SysParamVo vo);

	void savePlayerSetting(SiteConfineAreaVo siteConfineAreaVo);
	/**
	 * 批量更新推荐设置
	 * @return
	 */
	Long batchUpdateRecommended(SiteConfineIpVo siteConfineIpVo);

	void saveServiceTrems(SiteConfineAreaVo siteConfineAreaVo);

	SysParamVo searchByModuleTypeCode(SysParamVo sysParamVo);

	/**
	 * 更新提示音
	 * @param vo
	 */
	SysParamVo uploadTone(SysParamVo vo);

	/**
	 * 更新是否启用
	 * @param vo
	 */
	SysParamVo uploadActive(SysParamVo vo);

	/**
	 * 更新客服参数
	 * vo search.id 有=更新，无=新增
	 * vo _dataSourceId not null
	 * customerName （名称）not null
	 * customerUrl （路径）not null
	 * customerCode 代号 PC/mobile
	 * @return
	 */
	SysParamVo saveCustomerServiceParams(SysParamVo vo, String customerName, String customerUrl, String customerCode);

	/**
	 * 保存验证码参数
	 * @param vo
	 * @param exclusionsValue
	 * @return
	 */
	SysParamVo saveYzmParams(SysParamVo vo, String exclusionsValue);

	SysParamVo saveRegisterModeServiceParams(SysParamVo vo, String paramValue, String paramCode);
}
