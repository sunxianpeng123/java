package multithreading.WaitingWakeUp;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 13:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Product {
    /*
     在多线程通信时，在某些特定条件下，我们需要线程做出一 定的“让步”，否则就很容易造成双方（或多方）进行僵持 状态，进而形成死锁。
    sleep方法虽然能使当前线程阻塞，但是sleep方法不会释放其  所占有的任何“锁”。而且，也不能保证线程苏醒后，条件就 一定会得到满足。
    我们可以使用以下方法实现线程的阻塞，并且令线程暂时释放 “锁”资源。以下方法都是在Object类中声明的（这意味着什
    么？）。
             wait 令当前线程等待，直到另一个线程调用为该对象调用 notify或notifyAll方法。当前线程必要拥有该对象的锁。当调 用wait方法后，线程会释放掉其占有的锁，并处于等待队列中。
             notify 唤醒等待该对象锁的一个线程，如果有多个线程处于 等待中，仅唤醒一个。具体哪一个，取决于底层的实现（这
    又意味着什么？）。
             notifyAll唤醒等待该对象锁的所有线程。
    说明： wait， notify与notifyAll方法调用时，当前线程一定要拥 有对象的锁。否则将会引发IllegalMonitorStateException异常。
    */
    public static void main(String[] args) {
        Worker w = new Worker();
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
class Worker {
    private List<String> list = new ArrayList<>();

    public synchronized void product() {
        if (list.size() == 3) {
            System.out.println("仓库已满，生产阻塞。"+list.size());

            try {
                // 释放掉当前占用的锁资源，使自身处于阻塞队里当中。
                // 调用该方法的线程必须要具有锁资源，否则就会产生异常
                // (IllegalMonitorStateException)。
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            list.add("");
            System.out.println("生产之后个数。"+list.size());
            // 通知（唤醒）之前处于阻塞队列的线程。
            notifyAll();
        }
    }

    public synchronized void consume() {
        if (list.size() == 0) {
            System.out.println("仓库已空，消费阻塞。"+list.size());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            list.remove(0);
            System.out.println("消费之后个数。"+list.size());
            notifyAll();
        }
    }
}