package so.wwb.lotterybox.model.manager.site.so;


import so.wwb.lotterybox.model.manager.site.po.UserPlayerTransfer;

import java.util.List;


/**
 * 导入玩家表 by River查询对象
 *
 * @author River
 * @time 2015-12-28 16:30:45
 */
//region your codes 1
public class UserPlayerTransferSo extends UserPlayerTransfer {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -946586837775071177L;
	//endregion your codes 3

	//region your codes 2
	private List<String> usernameList;

	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	//endregion your codes 2
}