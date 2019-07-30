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
        /**
         * 同步代码注意点：
         * 1、不跟随线程变化的预处理和后护理放在同步代码的外面，是同步的代码尽量简短
         * 2、不要阻塞线程，如inputStream.read()
         * 3、在持有锁的时候，不要对其他对象调用同步方法（即不要调用别的对象的同步方法）。
         */
//      案例：假设某个景点有 4个售票员在同时售票
//      实例化2个线程， 用2个线程来模拟2个售票员
        TicketCenterThread tickitCenterThread =new TicketCenterThread();
        Thread t1 = new Thread(tickitCenterThread,"thread-1");
        Thread t2 = new Thread(tickitCenterThread,"thread-2");
        t1.start();
        t2.start();
    }
}

class TicketCenterThread implements Runnable {
    //     剩余的票的数量
    public static  int restTicketCount = 100;
    private Object object = new Object();

    @Override
    public void run() {

        while (TicketCenterThread.restTicketCount>0){
//               同步代码块，this表示锁,可以是任意对象，但是不同线程之间此处必须要使用同一个对象
            synchronized (object){
                System.out.println(Thread.currentThread().getName() + " 卖出第 "
                        +TicketCenterThread.restTicketCount+" 张票，剩余票数 = "+
                        --TicketCenterThread.restTicketCount+" 张 ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}