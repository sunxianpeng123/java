package multithreading;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/22
 * \* Time: 13:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class RunnableTest {
    /*
 * 通过实现Runnable接口实现多线程
 */
    public static void main(String[] args) {
        Mission m = new Mission();
        // 使用实现Runnable接口的对象，作为
        // 线程的目标执行体。
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.start();
        t2.start();
    }
}

class Mission implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            Thread current = Thread.currentThread();
            String name =current.getName();
            System.out.println(name+"__"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 无法直接调用getName()，因为当前类没有继承Thread，
        // 不是Thread类的子类。
        // getName();
        // 获取当前的执行的线程。


    }
}