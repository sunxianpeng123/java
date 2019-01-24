package genericity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 12:02
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenericMethod {
    /*
 * 泛型方法。
 * 方法也可以声明为泛型方法。就是在方法的返回类型前
 * 声明一个或多个类型参数。泛型方法声明的类型参数在
 * 方法中是有效的。
 *
 * 对泛型方法调用时，可以在.后面显示指定实际类型参数。
 * gm.<String>g("abc");
 * 但是，通常情况下，我们不需要这样做，编译器可以自动
 * 推断泛型方法的类型参数。
 * gm.g("abc");
 * 如果需要显示指定类型参数，则引用不能丢失。
 */
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        // 泛型方法的调用
        // gm.<String>g("abc");
        // List<Integer> list = null;
        // gm.g("abc", list);
        gm.g("a", 10);
    }

    public <T> void g(T t, T t2) {
        // 方法体
        //如果需要显示指定类型参数，则引用不能丢失。
        //<Integer>k(20);  错误
        this.<Integer>k(20);
    }

    public <E> void k(E t) {

    }
}

/*
 * public class GenericMethod<T> { public static void main(String[] args) {
 *
 * }
 *
 * public void g(T t) { List<T> list; }
 *
 * public void k(T t) {
 *
 * } }
 */