package reflect;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ClassObject {
    /*
 * 获取Class对象
 * 1 ClassLoader类的loadClass方法，返回Class<?>
 * 2 Class类的forName方法，返回Class<?>
 * 3 通过类型T.class，返回Class<T>
 * 4 通过Object类的getClass方法，返回Class<? extends T>
 */
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
            Class<?> c = cl.loadClass("reflect.Value");
            Class<?> c2 = Class.forName("reflect.Value");
            Class<Value> c3 = Value.class;
            Value v = new Value();
            Class<? extends Value> c4 = v.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}