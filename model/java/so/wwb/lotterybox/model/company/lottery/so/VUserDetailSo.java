package so.wwb.lotterybox.model.company.lottery.so;

import so.wwb.lotterybox.model.company.lottery.po.VUserDetail;


/**
 * 用户管理/详细视图 - Fei  jeremy查询对象
 *
 * @author block
 * @time 2019-10-14 20:59:17
 */
//region your codes 1
public class VUserDetailSo extends VUserDetail {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -567097344404212700L;
	private  Integer hidLength;
	//endregion your codes 3

	//region your codes 2

	public Integer getHidLength() {
		return hidLength;
	}

	public void setHidLength(Integer hidLength) {
		this.hidLength = hidLength;
	}


	//endregion your codes 2
}