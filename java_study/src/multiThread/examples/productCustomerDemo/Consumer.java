package multiThread.examples.productCustomerDemo;

/**
 * Created by XP on 2019/7/31.
 */

/**
 * 消费者
 */
public class Consumer implements Runnable {
    private Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.customeFood();
        }
    }
}
