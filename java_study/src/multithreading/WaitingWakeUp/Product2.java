package multithreading.WaitingWakeUp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 14:03
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Product2 {
    public static void main(String[] args) {
        Worker2 w = new Worker2();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                w.product();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                w.consume();
            }
        });
        t1.start();
        t2.start();
    }
}

/*
 * Condition与Lock联合使用。
 */
class Worker2 {
    private List<String> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();// 锁对象
    private Condition condition = lock.newCondition();;// 生产/消费 线程条件

    public void product() {
        try {
            lock.lock();
            if (list.size() == 3) {
                System.out.println("仓库已满，生产阻塞。"+list.size());
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                list.add("");
                System.out.println("生产之后个数。"+list.size());
                // condition.signal();
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            if (list.size() == 0) {
                System.out.println("仓库已空，消费阻塞。"+list.size());
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                list.remove(0);
                System.out.println("消费之后个数。"+list.size());
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}