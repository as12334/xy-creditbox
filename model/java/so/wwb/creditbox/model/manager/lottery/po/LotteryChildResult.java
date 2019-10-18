package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;

import java.util.Date;

public class LotteryChildResult implements IEntity<Integer>{
        private static final long serialVersionUID = 6276820539530828778L;
        public static final String PROP_ID = "id";
        public static final String PROP_EXPECT = "expect";
        public static final String PROP_CODE = "code";
        public static final String PROP_OPEN_TIME = "openTime";

        Integer id;
        String expect;
        String code;
        java.util.Date openTime;

        //region ctor
        public LotteryChildResult(){
        }

        public LotteryChildResult(Integer id){
            this.id = id;
        }
        //endregion

        @Override
        public Integer getId() {
                return id;
        }

        @Override
        public void setId(Integer id) {
                this.id = id;
        }

        @Sortable
        public String getExpect() {
                return expect;
        }

        public void setExpect(String expect) {
                this.expect = expect;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        @Sortable
        public Date getOpenTime() {
                return openTime;
        }

        public void setOpenTime(Date openTime) {
                this.openTime = openTime;
        }
}
