package multiThread.base;

/**
 * Created by XP on 2019/7/28.
 */
/**
 * 线程的优先级
 */
public class ThreadPriority {
    public static void main(String[] args) {
        threadPriortity();

    }
    /** 设置线程有优先级*/
    private static  void  threadPriortity(){
//        设置线程优先级 只是修改这个线程可以抢占到cpu时间片的概率，
//        并不是优先级高的线程一定能抢到cpu的时间片
//        优先级的设置，是一个整数，范围在[0-10],默认是5，数值越大，优先级越高
        Runnable r = ()->{
          for (int i =0; i<=100;i++){
              System.out.println(Thread.currentThread().getName()+":::"+i);
          }
        };
        Thread t1 = new Thread(r,"thread_1");
        Thread t2 = new Thread(r,"thread_2");
//        设置优先级
//        设置优先级必须要放在这个线程开始执行（start方法）之前
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
