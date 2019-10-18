package so.wwb.creditbox.model.manager.user.so;

import so.wwb.creditbox.model.manager.user.po.VUserManager;


/**
 * 用户管理/详细视图 - Fei  jeremy查询对象
 *
 * @author block
 * @time 2019-10-16 18:58:21
 */
//region your codes 1
public class VUserManagerSo extends VUserManager {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -5159546078097080421L;


    //endregion your codes 3

	//region your codes 2
    public int getHidLength() {
        return hidLength;
    }

    private int hidLength;

    public void setHidLength(int hidLength) {
        this.hidLength = hidLength;
    }
	//endregion your codes 2
}