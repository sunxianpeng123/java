package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MethodTest {
    /*
        * Value v = new Value(); v.f(10);
        */
    public static void main(String[] args) {
        Class<Value> c = Value.class;
        try {
            Constructor<Value> con = c.getDeclaredConstructor();
            Value v = con.newInstance();
            // 获得相关方法的对象
            Method m = c.getDeclaredMethod("f", int.class);
            // 调用方法，第一个参数为调用该方法的对象，
            // 第二个参数为方法的实际参数列表。
            m.invoke(v, 10);
            // 有返回值的方法。
            Method m2 = c.getDeclaredMethod("g", int.class);
            // 获得方法的返回值。
            Object rtnValue = m2.invoke(v, 2);
            System.out.println(rtnValue);
            // 静态方法
            Method m3 = c.getDeclaredMethod("staticF");
            // 因为静态方法调用不需要对象的引用，因此，可以传递null值。
            m3.invoke(null);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}