package so.wwb.lotterybox.web.defense.core.model;

import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;

public class ResetColumns {
    private final static char OPEN = '1';
    private final static char CLOSE = '0';
    public final static String START_TIME = DefenseRecord.PROP_OPERATE_START_TIME;
    public final static String SUCCESS_TIMES = DefenseRecord.PROP_SUCCESS_TIMES;
    public final static String ERROR_TIMES = DefenseRecord.PROP_ERROR_TIMES;

    private static String[] column_mapping = {
            START_TIME,
            SUCCESS_TIMES,
            ERROR_TIMES
    };

    public static String all(){
        return StringTool.leftPad("",column_mapping.length,'1');
    }

    public static void reset(DefenseRecord defenseRecord){
        String columns = defenseRecord.getResetColumns();
        if(isCanReset(columns,START_TIME)){
            defenseRecord.setOperateStartTime(null);
        }
        if(isCanReset(columns, SUCCESS_TIMES)){
            defenseRecord.setSuccessTimes(0);
        }
        if(isCanReset(columns, ERROR_TIMES)){
            defenseRecord.setErrorTimes(0);
        }
        defenseRecord.setOperateEndTime(null);
        defenseRecord.setDisposeCode(null);
        defenseRecord.setDisposeEndTime(null);
    }

    private static boolean isCanReset(String columns, String columnName) {
        int index = ArrayTool.indexOf(column_mapping, columnName);
        if (index >= 0 ) {
            char[] chars = columns.toCharArray();
            if (index >= chars.length) {
                return true;
            }
            return index < chars.length && chars[index] == OPEN;
        }
        return false;
    }


    public static String addReset(String resetColumns, String columnName) {
        return doOp(resetColumns, columnName,OPEN);
    }

    public static String removeReset(String resetColumns, String columnName) {
        return doOp(resetColumns, columnName,CLOSE);
    }

    private static String doOp(String resetColumns, String columnName, char open) {
        int index = ArrayTool.indexOf(column_mapping, columnName);
        if (index >= 0) {
            char[] chars = resetColumns.toCharArray();
            chars[index] = open;
            return new String(chars);
        }
        return resetColumns;
    }
}
