package so.wwb.creditbox.utility;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * 将FastJson格式化时间转成时间戳
 * Create by Fei on 2018-01-10
 */
public class DateFormatSerializer implements ObjectSerializer {

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) {
        if (object == null) {
            serializer.getWriter().writeNull();
        } else {
            Date date = (Date)object;
            serializer.write(date.getTime());
        }
    }

}
