package multiThread.base.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/30
 * \* Time: 10:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SyncLock {
    public static void main(String[] args) {
        /**
         * 同步代码注意点：
         * 1、不跟随线程变化的预处理和后护理放在同步代码的外面，是同步的代码尽量简短
         * 2、不要阻塞线程，如inputStream.read()
         * 3、在持有锁的时候，不要对其他对象调用同步方法（即不要调用别的对象的同步方法）。
         */
//      案例：假设某个景点有 4个售票员在同时售票
//      实例化2个线程， 用2个线程来模拟2个售票员
        TicketCenterLock ticketCenterLock =new TicketCenterLock();
        Thread thread1 = new Thread(ticketCenterLock,"thread-1");
        Thread thread2 = new Thread(ticketCenterLock,"thread-2");
        thread1.start();
        thread2.start();
    }
}

class  TicketCenterLock implements Runnable {
    //     剩余的票的数量
    private static int restTicketCount = 100;
//    互斥锁
    ReentrantLock lock =new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i <300 ; i++) {
            saleTicketLock();
        }
    }

    //    Lock实现同步
    public  void  saleTicketLock(){
        lock.lock();//加锁
        try {//避免死锁
            if (TicketCenterLock.restTicketCount > 0){
                System.out.println(Thread.currentThread().getName() + " 卖出第 "
                        +TicketCenterLock.restTicketCount+" 张票，剩余票数 = "+
                        --TicketCenterLock.restTicketCount+" 张 ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            if (true){
                lock.unlock();//释放锁
            }
        }
    }

}