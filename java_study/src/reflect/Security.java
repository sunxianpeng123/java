package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Security {
    /*
 * 通过反射，我们可以访问到类的私有成员，这将
 * 打破类的封装性，我们可以设置安全管理器来
 * 解决这个问题。
 */
    public static void main(String[] args) {
        // 设置安全管理器
        System.setSecurityManager(new SecurityManager());
        Class<Value> c = Value.class;
        try {
            Constructor<Value> con = c.getDeclaredConstructor(String.class);
            con.setAccessible(true);
            con.newInstance("ab");
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