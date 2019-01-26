package multithreading;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 18:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class YieldTest {

    public static void main(String[] args) {
        Thread2 t = new Thread2();
        Thread3 t2 = new Thread3();
        t.start();
        t2.start();
    }
}
class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
        // 当前线程有意让出CPU资源，让其他线程得到执行。
        // 但是，操作系统可能会忽略线程的这种请求。
        Thread.yield();
        for (int i = 6; i <= 9; i++) {
            System.out.println(i);
        }
    }
}
class Thread3 extends Thread {
    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            System.out.println(i);
        }
    }
}