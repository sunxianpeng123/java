package multiThread.examples.productCustomerDemo;

/**
 * Created by XP on 2019/7/31.
 */

/**
 * 生产者类
 */
public class Producter implements Runnable {
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
//基数代表一种食物，偶数代表一种食物，即只生产两种食物
        for (int i = 0; i < 20; i++) {
            if (i %2 ==0){
                food.productFood("锅包肉","酸甜口味，爽");
            }else{
                food.productFood("佛跳墙","大补，滋阴补阳");
            }
        }
    }
}
