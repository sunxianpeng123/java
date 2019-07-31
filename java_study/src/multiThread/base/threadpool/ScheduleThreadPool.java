package multiThread.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/31
 * \* Time: 12:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ScheduleThreadPool {
    public static void main(String[] args) {
        //        有4种不同的方式创建线程池
//        1、创建一个不限制大小的schedule线程池，线程池大小超过所需则会回收线程，等需要时再生成，线程池大小依赖于操作系统。
//        ExecutorService executorService =  Executors.newScheduledThreadPool(3);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        ScheduleThread scheduleThread = new ScheduleThread();
//
//        executorService.execute(scheduleThread);
////
//        executorService.execute(scheduleThread);
////
//        executorService.execute(scheduleThread);
//        延迟三秒进行执行
        executorService.schedule(scheduleThread,3, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
class  ScheduleThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 9 ; i++) {
            System.out.println(Thread.currentThread().getName()+" ::"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}