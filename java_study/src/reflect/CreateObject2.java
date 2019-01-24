package reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CreateObject2 {
    public static void main(String[] args) {
        /*
         * Value v = new Value(100); System.out.println(v.getX());
         */

        Class<Value> c = Value.class;
        // 获取声明为public访问权限的构造器
        // c.getConstructor(parameterTypes)
        try {
            // 获得任意访问权限的构造器，参数为相应构造器参数对应的
            // Class类型。
            Constructor<Value> con = c.getDeclaredConstructor(int.class);
            Value v = con.newInstance(100);
            System.out.println(v.getX());

            // 获得私有的构造器
            con = c.getDeclaredConstructor(String.class);
            // 设置为可访问的，这样可以访问私有成员（构造器）。
            con.setAccessible(true);
            v = con.newInstance("abcs");
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