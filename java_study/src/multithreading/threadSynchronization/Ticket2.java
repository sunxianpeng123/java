package multithreading.threadSynchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/25
 * \* Time: 19:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Ticket2 implements Runnable {
    private int num = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 加锁
                lock.lock();
                if (num > 0) {
                    // 输出一大堆
                    num--;
                } else {
                    break;
                }
            } finally {
                // 解锁，在finally中调用，确保锁能够
                // 被解开。
                lock.unlock();
            }
        }
    }
}