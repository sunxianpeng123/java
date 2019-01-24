package genericity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 11:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenericClass {
    /*
 * 自定义泛型类
 *
 * 在声明类后，再声明一个（或多个）形式类型参数，
 * 这样的类就是泛型类。多个形式类型参数使用","进行分隔。
 * 按照惯例，形式类型参数使用一个大写字母表示。
 *
 * 在使用泛型类（参数化类型）时，泛型类的类体可以看成是
 * 实际类型参数替换掉形式类型参数后的结果。（但实际上，
 * 泛型类只有一个，不会因为实际类型参数的不同而不同。）
 */


    public static void main(String[] args) {
        Box<String> box = new Box<>();
        Box<Integer> box2 = new Box<>();
        box.setT("abc");
        // box.setT(5);
        String s = box.getT();
        box2.setT(10);
        //box2.setT("23");
        int x = box2.getT();
    }

}

class Box<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
