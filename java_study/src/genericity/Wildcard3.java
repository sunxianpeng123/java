package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 11:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Wildcard3 {
    public static void main(String[] args) {
        List<Rectangle> list = new ArrayList<>();
        List<Shape> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        Rectangle r = new Rectangle();
        add(list, r);
        add(list2, r);
        add(list3, r);

    }

    public static void add(List<? super Rectangle> list, Rectangle s) {
        // 加入的操作
        list.add(null);
        list.add(s);
    }
    static abstract class Shape {
        public abstract double per();

        public abstract double area();
    }

    static class  Rectangle extends Shape {
        @Override
        public double per() {
            return 1;
        }

        @Override
        public double area() {
            return 1;
        }
    }
}