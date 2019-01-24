package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 10:37
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Wildcard2 {
    public static void main(String[] args) {
        List<Rectangle> list = new ArrayList<>();
        List<Shape> list2 = new ArrayList<>();
        eva(list);
        eva(list2);
    }

    public static void eva(List<? extends Shape> list) {
        // 循环取出每一个图形，然后计算周长与面积
        Shape s = list.get(0);
        System.out.println(s.per());
        System.out.println(s.area());
        // list.add(new Rectangle());
    }
}

    abstract class Shape {
        public abstract double per();

        public abstract double area();
    }

    class Rectangle extends Shape {
        @Override
        public double per() {
            return 1;
        }

        @Override
        public double area() {
            return 1;
        }
}