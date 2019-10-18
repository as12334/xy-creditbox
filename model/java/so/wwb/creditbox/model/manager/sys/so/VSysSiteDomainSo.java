package so.wwb.creditbox.model.manager.sys.so;

import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;

import java.util.List;


/**
 * 查询对象
 *
 * @author Administrator
 * @time 2017-4-12 11:22:59
 */
//region your codes 1
public class VSysSiteDomainSo extends VSysSiteDomain {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 8216642523416469492L;
	private List<String> domainType;

	public List<String> getDomainType() {
		return domainType;
	}

	public void setDomainType(List<String> domainType) {
		this.domainType = domainType;
	}
}