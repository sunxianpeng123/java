package multiThread.base;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/29
 * \* Time: 19:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

/**
 * join方法，
 * 表示加入线程，让调用该方法的线程先执行执行时间或执行完毕。
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
//        first
//        firstInterruptThreadMethod();
//        second self make
        secondInterruptThreadMethod();

    }

    /**
     * 第一种中断线程的方法
     */
    private static void firstInterruptThreadMethod() {
        //        子线程
        InterruptThread interruptThread = new InterruptThread();
        Thread thread1 = new Thread(interruptThread, "thread-1");
        thread1.start();
//        主线程
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "::" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** interrupt*/
            if (i == 10) {
//               中断线程，只是做了一个中断标记
                thread1.interrupt();
            }
        }
    }

    /**第二种中断线程的方法*/
    private static void secondInterruptThreadMethod() {
        //        子线程
        InterruptThread1 interruptThread1 = new InterruptThread1();
        Thread thread2 = new Thread(interruptThread1, "thread-2");
        thread2.start();
//        主线程
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "::" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** interrupt*/
            if (i == 10) {
//               中断线程，只是做了
                interruptThread1.flag = false;
            }
        }
    }
}

class InterruptThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 51; i++) {
//            测试中断状态，此方法会把中断状态清除
            if (Thread.interrupted()) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "::" + i);
            try {
//                若休眠抛出异常，则会清除当前线程的中断状态，也就是中断线程方法interrupt不生效
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
//                只有在此处执行了中断方法，才回使外部打上的中断状态标记生效，即中断当前线程
                Thread.currentThread().interrupt();
            }
        }
    }


}

class InterruptThread1 implements Runnable {
    public boolean flag = true;

    public InterruptThread1() {
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "::" + i);
            i++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}