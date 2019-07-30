package multiThread.base.synchronization;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/30
 * \* Time: 10:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SyncMethod {
    public static void main(String[] args) {
        /**
         * 同步代码注意点：
         * 1、不跟随线程变化的预处理和后护理放在同步代码的外面，是同步的代码尽量简短
         * 2、不要阻塞线程，如inputStream.read()
         * 3、在持有锁的时候，不要对其他对象调用同步方法（即不要调用别的对象的同步方法）。
         */
//      案例：假设某个景点有 4个售票员在同时售票
//      实例化2个线程， 用2个线程来模拟2个售票员
        TicketCenterMethod ticketCenterMethod =new TicketCenterMethod();
        Thread thread1 = new Thread(ticketCenterMethod,"thread-1");
        Thread thread2 = new Thread(ticketCenterMethod,"thread-2");
        thread1.start();
        thread2.start();
    }
}
class  TicketCenterMethod implements Runnable {
    //     剩余的票的数量
    private static int restTicketCount = 100;
    @Override
    public void run() {
        for (int i = 0; i <300 ; i++) {
            saleTicketMethod();
        }
    }

    //    同步方法，this表示锁,可以是任意对象，但是不同线程之间此处必须要使用同一个对象
    public synchronized void  saleTicketMethod(){
        if (TicketCenterMethod.restTicketCount > 0){
            System.out.println(Thread.currentThread().getName() + " 卖出第 "
                    +TicketCenterMethod.restTicketCount+" 张票，剩余票数 = "+
                    --TicketCenterMethod.restTicketCount+" 张 ");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}