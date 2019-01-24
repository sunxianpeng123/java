package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:28
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class FieldTest {
    /*
 * 通过反射动态获得成员变量。
 */
    public static void main(String[] args) {
        Class<Value> c = Value.class;
        try {
            Constructor<Value> con = c.getDeclaredConstructor();
            Value v = con.newInstance();
            Field f = c.getDeclaredField("x");
            f.setAccessible(true);
            // 设置Field对象所代表的成员变量的值。
            f.set(v, 99);
            // 获取Field对象所代表的成员变量的值。
            // int k = f.get(v);
            System.out.println(f.get(v));

            // 如果成员变量是基本数据类型，我们可以使用
            // 更加简便的getT或setT方法，T为相应的
            // 基本数据类型。
            f.setInt(v, 20);
            int x = f.getInt(v);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}