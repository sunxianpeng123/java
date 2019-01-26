package multithreading;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 18:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ThreadMethod {
    /*
     5、常用方法
    public static Thread currentThread(); 获得当前执行的线程。
    public String getName() 获得线程名称。
    public final native boolean isAlive(); 判断线程是否存活（在start方法调用后，并且线程没有死亡）。
    public void join() 等待直到这个线程死亡。
    public static void sleep(long millis) 使当前线程睡眠（暂时停止执行） millis毫秒。如果当前程序存在其他等待的线程，则其他线程会获得执行机会。
    public static void yield();当前运行的线程有意让出CPU资源，由线程调度器重新选择线程调度。不过，这仅仅是一个提示而已，线程调度器可能会忽略。
    public void setDaemon(boolean on)；设置线程是否为后台线程。
    public void setPriority(int newPriority)设置线程的优先级。优先级为1-10。优先级高的线程仅意味着可能获得更多执行的机会，不表示一定会一直执行，优先级低的线程仍然有机会执行。
   */


    //执行main方法的线程名就叫main。
    public static void main(String[] args) {
        // 获取当前执行的线程。
        Thread current = Thread.currentThread();
        // 获取线程的名字。
        // System.out.println(current.getName());
        // 判断当前线程是否处于存活状态（调用start方法之后，
        // 线程死亡之前），存活返回true，否则返回false。
        // System.out.println(current.isAlive());

        ThreadA ta = new ThreadA();
        ta.start();
        try {
            // 如果在A线程中调用B线程对象的join方法（无参），则A线程
            // 会一直等待B线程执行结束，A线程才会继续执行。
            ta.join();
            // 当前线程最多等待ta线程参数指定的时间。（毫秒）
            // ta.join(500);
            // 当前线程最多等待第一个参数的时间（毫秒）加上
            // 第二个参数的时间（纳秒）。（时间的和）
            // ta.join(500, 100);
            // 令当前线程休眠参数指定的时间。
            // Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main方法输出内容");
        ThreadA ta2 = new ThreadA();
        // 设置当前线程是否为后台线程，true为后台线程，否则
        // 为前台线程。该方法需要在线程启动之前调用。
        ta2.setDaemon(true);
        // 设置线程的优先级。优先级高的线程不代表会一直执行，
        // 只是执行几率大于优先级低的线程。虽然Java提供了
        // 1-10这十个优先级，但是，操作系统未必会存在十个优先级
        // 有Java相对应。
        ta2.setPriority(Thread.NORM_PRIORITY);

    }
}
class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}