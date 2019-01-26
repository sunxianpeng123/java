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
public class BuyTicket {
    /*
 * 当多线程对共享变量并发进行修改时，就可能会出现
 * 并发修改的不一致性。
 * 对共享变量进行并发修改的区域，我们称之为共享区域。
 * 对于共享区域，我们必须要实现上锁（线程的互斥访问）。
 *
 * 对于共享变量，要完全放在同步区域当中，否则就可能会出现
 * 问题。（存在修改共享变量）
 */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 设置线程的名字
        t1.setName("张三");
        t2.setName("李四");
        t3.setName("王五");
        t1.start();
        t2.start();
        t3.start();
    }
}