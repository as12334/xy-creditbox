package so.wwb.creditbox.common.utility.common;

import org.soul.commons.lang.ClassTool;

import java.lang.reflect.Field;

public class CommonTool {

    public static Object InstanceClazz(String className) {
        Class<?> clazz = ClassTool.getClass(className);
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Is it an abstract class[" + clazz.getName() + "]?", e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("the constructor can't access by class[" + clazz.getName() + "]", e);
        }
    }

    public static Field getField(Class clz, String property) {
        if (clz == Object.class)
            return null;
        try {
            return clz.getDeclaredField(property);
        } catch (NoSuchFieldException e) {
            return getField(clz.getSuperclass(), property);
        }
    }
}
