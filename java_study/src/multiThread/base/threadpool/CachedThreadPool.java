package multiThread.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/31
 * \* Time: 12:05
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        //        有4种不同的方式创建线程池
//        1、创建一个可缓存的线程池，线程池大小超过所需则会回收线程，等需要时再生成，线程池大小依赖于操作系统。
        ExecutorService executorService =  Executors.newCachedThreadPool();
        CacheThread cacheThread = new CacheThread();
//
        executorService.execute(cacheThread);
//
        executorService.execute(cacheThread);
//
        executorService.execute(cacheThread);
        executorService.shutdown();
    }
}
class  CacheThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 12 ; i++) {
            System.out.println(Thread.currentThread().getName()+" ::"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}