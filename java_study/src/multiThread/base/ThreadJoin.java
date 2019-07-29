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
public class ThreadJoin {
    public static void main(String[] args) {
//        子线程
        JoinThread joinThread = new JoinThread();
        Thread thread1 = new Thread(joinThread, "thread-1");
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
//               中断线程，只是做了
                thread1.interrupt();
            }
            /** join*/
            if (i == 20) {
                try {
//                    让thread1线程执行完毕再去执行主线程
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class JoinThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
//            测试中断状态，此方法会把中断状态清除
            if (Thread.interrupted()){
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