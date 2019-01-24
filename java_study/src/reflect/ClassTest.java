package reflect;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 11:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ClassTest {
    /*
 * ClassLoader的loadClass方法与Class的forName方法：
 * 二者都可以加载参数的类型，不同的是：
 * loadClass方法仅加载类型，不会对类型进行初始化操作。
 * 而forName方法不仅加载类型，而且会对类型进行初始化。即类中
 * 声明的静态成员会得到初始化（执行）。
 */
    public static void main(String[] args) {
        try {
            // 加载参数指定的类型。并且会对指定的类型进行
            // 初始化。
            // Class<?> c = Class.forName("day17.Value");
            // 第二个参数可以指定是否在加载后对类进行初始化。
            // 第三个参数类型加载器。
            Class.forName("reflect.Value", false, ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}