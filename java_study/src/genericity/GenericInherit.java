package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/20
 * \* Time: 23:26
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenericInherit {
    /*
 * 参数化类型的“继承”
 * 存在一种类型，就会存在对应的数组类型。
 * 如果A是B的子类型，则A[]也是B[]子类型。
 *
 * 参数化类型不具有可继承性。
 * 如果A是B的子类型，则T<A>不是T<B>的子类型。
 * T是某泛型类型。
 */


    public static void main(String[] args) {
        // String是Object的子类型，因此，String[]
        // 也是Object[]的子类型。
        String[] s = new String[5];
        Object[] o = s;
        // o[0] = new Integer(5);
        // 错误，在编译时没有问题，但是，在运行时会产生
        // ArrayStoreException异常。
        o[0] = 5;

        List<String> list = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        // 错误，参数化类型不具有可继承性
        // list2 = list;
        // list2.add(new Object());
        // list2.add(new Integer(5));

        print(list2);
        // print(list);

    }

    public static void print(List<Object> list) {
        // 对任意的List进行操作
    }
}