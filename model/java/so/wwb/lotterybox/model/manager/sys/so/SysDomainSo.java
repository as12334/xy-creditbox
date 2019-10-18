package so.wwb.lotterybox.model.manager.sys.so;

import so.wwb.lotterybox.model.manager.sys.po.SysDomain;

import java.util.List;


/**
 * 站长域名表-修改完会替换 sys_domain查询对象
 *
 * @author jeff
 * @time 2015-8-20 14:14:39
 */
//region your codes 1
public class SysDomainSo extends SysDomain {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 4182663470324227729L;
	private Integer rankId;
	private List<Integer> userIds;
	/**账号**/
	private String agentUserName;
	/*域名类型*/
	private String[] types;
	/*指向地址*/
	private String[] pageUrls;

	//endregion your codes 3

	//region your codes 2
	public Integer getRankId() {
		return rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	public String getAgentUserName() {
		return agentUserName;
	}

	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String[] getPageUrls() {
		return pageUrls;
	}

	public void setPageUrls(String[] pageUrls) {
		this.pageUrls = pageUrls;
	}

	//endregion your codes 2
}