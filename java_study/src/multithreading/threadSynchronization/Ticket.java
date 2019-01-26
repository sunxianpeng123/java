package multithreading.threadSynchronization;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 18:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Ticket implements Runnable {
    private int num = 100;
    // 任意对象都可以充当共享区域的锁。
    private Object lock = new Object();
    // 因为任意对象都可以充当锁的角色，因此，我们没有必要
    // 单独创建一个对象锁，使用当前对象this来充当锁就
    // 可以了。

    @Override
    public void run() {
        // while (num > 0) {
        // synchronized (lock) {
        // String name = Thread.currentThread().getName();
        // System.out.println(name + "抢到第" + num + "张票");
        // num--;
        // }
        // }
        // 虽然可以这样实现，但是这样做，完全退化成单线程。
        // synchronized (lock) {
        // while (num > 0) {
        // String name = Thread.currentThread().getName();
        // System.out.println(name + "抢到第" + num + "张票");
        // num--;
        // }
        // }
        while (true) {
            synchronized (this) {
                if (num > 0) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "抢到第" + num + "张票");
                    num--;
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 声明同步方法，使用synchronized修饰。同步方法的整个 方法体都是共享区域，都是互斥的进行访问的。
    * 对于实例方法，使用当前对象this充当锁。 对于静态方法，使用当前类型的Class对象充当锁。
    */
    public synchronized void f() {

    }

    public synchronized void g() {

    }

    public void k() {
        synchronized (this) {

        }
    }

    public void n() {
        synchronized (lock) {

        }
    }
}