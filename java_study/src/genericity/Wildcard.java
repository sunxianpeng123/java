package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 10:26
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Wildcard {
    /*
 * 类型通配符?
 * ?表示某种类型，是一种不确定的类型。
 * 含有通配符的参数化类型就是含有具体类型参数的参数化
 * 类型的父类型。
 *
 * 类型通配符有三种：（X表示某种类型，也可以是接口类型）
 * ?  无界通配符。可以是任意的引用类型。
 * ? extends X 含有上界的通配符，可以是X类型或X类型的子类型。
 * ? super X 含有下界的通配符，可以是X类型或X类型的父类型。
 *
 */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        print(list);
        print(list2);
        print(list3);

    }

    // 通过类型通配符，就可以接收类型参数是任意类型的参数化类型。
    public static void print(List<?> list) {
        // 当使用类型通配符时，向集合中加入元素会受到一定的限制。
        // 但是可以加入null值，因为null可以赋值给任意的引用
        // 类型。
        // list.add("");
//         list.add(5);
        // list.add(new Object());
        // 可以加入null。
        list.add(null);
    }


}