package multiThread.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/31
 * \* Time: 11:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SingleThreadPool {
    public static void main(String[] args) {
//        有4种不同的方式创建线程池
//        1、创建一个单线程的线程池
        ExecutorService executorService =  Executors.newSingleThreadExecutor();
        SingleThread singleThread = new SingleThread();
//
        executorService.execute(singleThread);
//
        executorService.execute(singleThread);
//
        executorService.shutdown();
    }
}
class  SingleThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"  ::"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}