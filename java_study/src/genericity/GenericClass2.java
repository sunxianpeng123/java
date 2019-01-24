package genericity;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 11:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenericClass2 {
    /*
 * 泛型类的类型参数（形式类型参数）也可以指定界限。
 *
 * 类型参数与通配符：
 * 1 类型参数只能用extends指定上界，不能使用super指定下界。
 * （通配符既可以指定上界，也可以指定下界）
 * 2 类型参数可以作为一种类型而存在，但是通配符不能。
 * 3 类型参数可以指定一个以上（多个）上界，但是通配符不行。
 *
 * 多个上界：
 * 1 多个上界既可以是类类型，也可以是接口类型。
 * 2 如果两个（多个）上界同时是接口类型，顺序没有要求。
 * 3 如果两个（多个）上界有一个是类类型，则类必须放在前面。
 */


    public static void main(String[] args) {
        Box2<Shape> box;
        Box2<Rectangle> box2;
        // Box2<String> box3;
        // Box3<Shape> box4;
        // Box3<Rectangle> box3;
        Box3<Circle> box4;
    }
}

class Box2<T extends Shape> {
    // 在类中使用类型参数所代表的类型。
    T t;
    // 通配符不能作为一种类型。
    // ? t;
    //List<?>与List<? extends Object> 等价
}

interface Inter {

}

// 类型参数指定多个上界
class Box3<T extends Shape & Inter> {

}
//错误，对于多个上界，类必须声明在接口前。
//class Box3<T extends Inter & Shape> { }

class Circle extends Shape implements Inter {
    @Override
    public double per() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }
}