package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/20
 * \* Time: 23:22
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Generic {
    //2、泛型设计
/*
 * 泛型设计
 * 泛型就是在类型（类，接口）或方法（构造器）后加上一个<类型参数>。
 * 一个类型加上具体的类型参数，我们称之为参数化类型。
 * 泛型就是含有一个类型参数（泛型声明时，指定的类型参数
 * 称为形式类型参数），在使用类型时，传递一个具体的类型
 * （使用泛型时，传递的参数称为实际类型参数）。这类似于方法
 * 调用过程中的参数传递，只是方法参数传递，传递的是一个具体
 * 的值，而泛型中参数传递，传递的是一个具体的类型。
 *
 * 按照惯例，泛型声明处的类型参数使用一个大写字母表示。
 * E    元素element
 * T    类型Type
 * K    键key
 * V    值value
 *
 * 泛型的类型参数可以是任意的引用类型。（不能是基本数据类型。）
 */
//3、原生类型
/*
 * 在使用泛型类时，没有给出具体的实际类型参数，这种类型
 * 称为原生类型。例如：
 * List list = new ArrayList();
 * List与ArrayList就是原生类型。
 * 原生类型仅仅作为历史遗留的产物，之所以还能使用，那是因为
 * 是对以前程序的兼容与让步。我们在以后使用泛型类时，不要在
 * 使用原生类型，应该总是使用参数化类型来代替原生类型。
 */

    public static void main(String[] args) {
        // 使用泛型，表示当前集合仅能存储实际类型参数指定的类型。
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        // 无需再进行类型转换，消除了繁琐性。
        String s = list.get(0);
        // 错误，编译器会进行严格的类型检查，消除了不安全性。
        // list.add(new Integer(5));
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(new Integer(5));
        list2.add(5); // list2.add(Integer.valueOf(5));
        int x = list2.get(0).intValue();
        x = list2.get(0);
        // 错误的。
        // List<int> list3;
        // 可以是数组类型，因为数组类型也是引用类型。
        List<int[]> list3;
    }
}