package so.wwb.lotterybox.model.manager.sys.ip.so;

import so.wwb.lotterybox.model.manager.sys.ip.po.IpDb;

//IP数据库查询对象
//region your codes 1
public class IpDbSo extends IpDb {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = -3944551452210203096L;
    //endregion your codes 3

    //region your codes 2
    private String ipStr;

    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }
    //endregion your codes 2
}