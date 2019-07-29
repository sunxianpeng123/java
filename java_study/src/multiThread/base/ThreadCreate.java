package multiThread.base;

/**
 * Created by XP on 2019/7/28.
 */
public class ThreadCreate {
    public static void main(String[] args) {
//        线程实例化
        /**
         * 继承Thread类的方法实现多线程
         */
//        1、继承Thread类做一个线程子类,（自定义的线程类）
        ExtendsThread extendsThread =new ExtendsThread();
//        注意：
//        需要调用start方法，使线程启动
//        start方法会开启新的线程,来执行run方法中的逻辑
//        如果直接调用run方法,则线程mythread不会进入就绪状态
        extendsThread.start();
        /**
         * 实现runnable接口的方法实现多线程
         */
//        2、通过Runnable接口
//        匿名内部类方式
        Runnable runnable =new Runnable() {
            @Override
            public void run() {

            }
        };
//        lamda 方式
        Runnable runnable1=() ->{
            for (int i = 1; i <= 2; i++) {
                System.out.println("runnable1子线程中的逻辑:::  "+ i);
            }
        };
        Thread runableThread =new Thread(runnable1);
        runableThread.start();


        System.out.println("====主线程中的逻辑,执行结束了====");
    }
}

/**
 *自定义的线程类
 */
class ExtendsThread extends Thread{
    /**
     * 需要重写run方法
     * 将需要并发执行的任务写到run方法中
     */
    @Override
    public void run() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("ExtendsThread子线程中的逻辑:::  "+ i);
            // 令当前线程休眠参数指定的时间（毫秒）
            // 处于休眠的线程会放弃掉当前的时间片，
            // 并且在整个休眠期间，不会获得CPU的时间片。
            // 当线程苏醒时，线程会处于就绪状态。（不是运行状态）。
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取线程的名字。
//            System.out.println(getName());
        }
    }


}
