package genericity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/21
 * \* Time: 20:15
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SortTest {
    public static void main(String[] args) {
        int[] x = { 5, 3, 1, 100, -2, 30 };
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        Integer[] x2 = { 5, 3, 1, 100, -2, 30 };
        Arrays.sort(x2);
        System.out.println(Arrays.toString(x2));
        Student[] stu = { new Student(1, "a"), new Student(3, "b"), new Student(20, "c"), new Student(2, "d") };
        Arrays.sort(stu);
        // System.out.println(Arrays.toString(stu));

        // 自行指定比较规则
        // Arrays.sort(stu, new MyOrder());
        // System.out.println(Arrays.toString(stu));
        // Arrays.sort(stu, new Comparator<Student>() {
        // @Override
        // public int compare(Student o1, Student o2) {
        // return o2.getNo() - o1.getNo();
        // }
        // });
        // System.out.println(Arrays.toString(stu));
        Arrays.sort(stu, (o1, o2) -> o2.getNo() - o1.getNo());
        System.out.println(Arrays.toString(stu));
    }
}

class MyOrder implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // return o1.getNo() - o2.getNo();
        return o2.getNo() - o1.getNo();
    }
}

class Student implements Comparable<Student> {
    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        // if (no > o.no) {
        // return 1;
        // } else if (no == o.no) {
        // return 0;
        // } else {
        // return -1;
        // }
        return no - o.no;
    }

    @Override
    public String toString() {
        return "Student [no=" + no + ", name=" + name + "]";
    }
}