package multiThread.base.resources;

/**
 * Created by XP on 2019/7/28.
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

/**临界资源问题*/
public class SourceConfilct {

    public static void main(String[] args) {
//        案例：假设某个景点有 4个售票员在同时售票
//      实例化4个售票员， 用4个线程来模拟4个售票员
        Runnable r = ()->{
          while (TickitCenter.restCount > 0){
              System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余票数="+ --TickitCenter.restCount+"张");
          }
        };
        Thread t1 = new Thread(r,"thread-1");
        Thread t2 = new Thread(r,"thread-2");
        Thread t3 = new Thread(r,"thread-3");
        Thread t4 = new Thread(r,"thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class TickitCenter{
//     剩余的票的数量
    public static  int restCount = 100;
}