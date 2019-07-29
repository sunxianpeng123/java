package multiThread.base;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 13:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ThreadSleep {
    /*
 * Thread类就表示线程。可以用来创建线程。
 * 通过继承Thread类实现多线程。
 */
    public static void main(String[] args) {
        // 创建线程
        Mission1 m = new Mission1();
        Mission2 m2 = new Mission2();
        // 创建线程后，需要启动线程，线程才能够执行。
        // 调用start方法来启动一个线程，是线程处于就绪
        // 状态。线程处于就绪状态，不代表该线程会马上得到执行，
        // 具体何时执行，要取决于操作系统的调度。线程处于就绪
        // 状态，表示该线程有机会获得CPU的时间片，即有机会
        // 得到执行。
        m.start();
        m2.start();
    }
}

// run方法就是线程要执行的任务。
// 我们重写Thread类的run方法。
// 线程从run方法开始执行。
class Mission1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            // 令当前线程休眠参数指定的时间（毫秒）
            // 处于休眠的线程会放弃掉当前的时间片，
            // 并且在整个休眠期间，不会获得CPU的时间片。
            // 当线程苏醒时，线程会处于就绪状态。（不是运行状态）。
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取线程的名字。
            System.out.println(getName());
        }
    }
}

class Mission2 extends Thread {
    @Override
    public void run() {
        for (int i = 11; i <= 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}