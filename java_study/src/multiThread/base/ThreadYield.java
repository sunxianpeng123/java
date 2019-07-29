package multiThread.base;

/**
 * Created by XP on 2019/7/28.
 */
/**
 * 线程的礼让
 */
public class ThreadYield {
    public static void main(String[] args) {
        threadYield();

    }
    /** 线程的礼让*/
    private static  void  threadYield(){
//        线程的礼让，指的是让当前运行状态的线程释放自己的cpu资源，由运行状态，回到就绪状态
//        线程礼让后并不代表马上要执行另外的线程，而是指当前线程和另外的线程重新去争抢cpu时间片
        Runnable r = new Runnable(){
            @Override
            public void run(){
                for (int i =0; i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+":::"+i);
                    if (i == 3 ){
//                        当前线程做出礼让
                        Thread.yield();
                    }

                };
            }

        };
        Thread t1 = new Thread(r,"thread-1");
        Thread t2 = new Thread(r,"thread-2");

        t1.start();
        t2.start();
    }
}
