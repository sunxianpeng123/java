package reflect;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获得系统类加载器
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        // 主动加载一个类型，需要提供类型的全限定名。
        try {
            // 加载类型后，就会创建该类型的Class对象。
            // 返回加载类型的Class对象。
            // 加载一个类型，不会初始化该类型。（静态初始化不会
            // 得到执行。
            Class<?> c = cl.loadClass("reflect.Value");
            // 获得类型的加载器。
            System.out.println(c.getClassLoader());
            // 启动类加载器负责加载API（JAVA类库提供的）类型，启动类
            // 加载时不是Java语言实现的，因此会输出null。
            System.out.println(String.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}