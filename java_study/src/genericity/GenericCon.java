package genericity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 12:06
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenericCon {
    /*
 * 泛型构造器
 * 可以声明泛型构造器，就是在声明构造器名的前面
 * 指定一个或多个类型参数。
 */
    public static void main(String[] args) {
        // 显示指定构造器的实际类型参数。
        GenericCon c = new <String>GenericCon("abc");
        // 编译器也可以自动推断构造器的实际类型参数。
        GenericCon c2 = new GenericCon("abc");
        GenericC<String> gc = new GenericC<>("abc");
        //当构造器是泛型构造器，类是泛型类，当我们显式的为构造器
        //指定类型参数，则此时，菱形语法将不能使用。
        // 错误
        // GenericC<String> gc2 = new <Integer>GenericC<>(10);
        GenericC<String> gc2 = new <Integer>GenericC<String>(10);
    }

    public <T> GenericCon(T t) {

    }
}

class GenericC<T> {
    public <E> GenericC(E e) {

    }
}