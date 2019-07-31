package multiThread.examples.productCustomerDemo;

/**
 * Created by XP on 2019/7/31.
 */
/**
 * 实现了生产者和消费者交替进行的需求，即生产出来后消费者立马消费掉
 * 两个方法
 * sleep和wait的区别：
 * sleep：线程进入休眠状态，让出cpu时间片，不释放监视器的对象锁（所有权）
 * wait：线程进入等待状态，让出cpu时间片，并释放监视器的所有权（对象锁），并等待其他线程唤醒。
 * notify：随机唤醒其他wait状态的线程
 */
public class ProductCustomerMain {

    public static void main(String[] args) {
        Food food =new Food();
        Producter producter =new Producter(food);
        Consumer consumer =new Consumer(food);
        Thread producterThread = new Thread(producter);
        Thread consumerThread = new Thread(consumer);

        producterThread.start();
        consumerThread.start();

    }
}
