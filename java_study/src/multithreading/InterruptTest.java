package multithreading;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 18:51
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class InterruptTest {
    /*
    * 8、中断线程
    * */
        public static void main(String[] args) {
            Thread4 t = new Thread4();
            t.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 中断线程。
            t.interrupt();
        }
}
    class Thread4 extends Thread {
        @Override
        public void run() {
            try {
                // 如果线程处于sleep，join等等待方法中，如果
                // 在等待期间，线程被其他线程所中断，则会产生
                // InterruptedException异常。如果没有处于
                // 以上等待方法中，则线程被其他线程所终端，不会
                // 产生InterruptedException异常。
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("产生了InterruptedException异常");
            }
        }
    }