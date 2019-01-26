package multithreading;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 19:03
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DeadLock {
//     当两个或多个线程同时拥有自己的资源，而相互等待获得对 方资源，导致程序永远陷入僵持状态，这就是死锁。
//     当多线程并发访问共享数据时，使用同步操作可以避免多线 程并发修改带来的危害，但同时有可能会产生死锁。
    /*
 * 死锁
 * 死锁就是两个线程分别拥有自己的资源，而想要获得对方的资源，
 * 从而处于无限的僵持与等待之中。
 */
    public static void main(String[] args) {
        Fighter f1 = new Fighter("张三");
        Fighter f2 = new Fighter("李四");
        Thread t1 = new Thread(() -> {
            f1.hold(f2);
        });
        Thread t2 = new Thread(() -> {
            f2.hold(f1);
        });
        t1.start();
        t2.start();
    }
}
class Fighter {
    private String name;

    public Fighter(String name) {
        this.name = name;
    }

    public synchronized void hold(Fighter f) {
        System.out.println(name + "抓住了" + f.name);
        System.out.println(name + "等待" + f.name + "的放手");
        // 等待着对方先放开自己
        f.loose(this);
        // 然后自己再放开对方
        this.loose(f);
    }

    public synchronized void loose(Fighter f) {
        System.out.println(name + "放开了" + f.name);
    }
}