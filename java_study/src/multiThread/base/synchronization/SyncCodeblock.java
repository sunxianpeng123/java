package multiThread.base.synchronization;

/**
 * Created by XP on 2019/7/28.
 */

/**临界资源问题
 * 1、 多线程共享数据时，会发横线程不安全的情况
 * 2、 多线程共享数据必须使用同步
 * */
public class SyncCodeblock {
    public static void main(String[] args) {
//      案例：假设某个景点有 4个售票员在同时售票
//      实例化2个站点，不同站点有不同人数的售票员， 用2个线程来模拟2个站点，service_num表示售票员数量
        TickitCenterThread tickitCenterThread =new TickitCenterThread();
        Thread t1 = new Thread(tickitCenterThread,"thread-1");
        Thread t2 = new Thread(tickitCenterThread,"thread-2");
        t1.start();
        t2.start();
    }
}

class TickitCenterThread implements Runnable {
//     剩余的票的数量
    public static  int restTicketCount = 100;
    public static int service_num =300;
    private Object object = new Object();

    @Override
    public void run() {
        for (int i = 0; i < service_num; i++) {
            if (TickitCenterThread.restTicketCount>0){
//               同步代码块，this表示锁,可以是任意对象，但是不同线程之间此处必须要使用同一个对象
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + " 卖出第 "
                            +TickitCenterThread.restTicketCount+" 张票，剩余票数 = "+
                            --TickitCenterThread.restTicketCount+" 张 ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
       }
    }

}