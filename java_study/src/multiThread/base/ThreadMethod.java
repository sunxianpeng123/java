package multiThread.base;

/**
 * Created by XP on 2019/7/28.
 */
public class ThreadMethod {
    public static void main(String[] args) {
        //    线程的命名
//    1、实例化一个线程对象
        Thread thread = new Thread();
        thread.setName("self_name");
        System.out.println(thread.getName());
//        2、实例化一个线程对象的同时，通过构造方法对线程进行命名
        Thread thread1 = new Thread("self_thread_1");
        System.out.println(thread1.getName());
//      3、使用自定义的线程类，在实例化线程对象的同时，进行名称的赋值
//        需要给自定义的线程类添加对应的构造方法
        ExtendsThread2 extendsThread2 =new ExtendsThread2("self_thread_extendsThread2");
        System.out.println(extendsThread2.getName());

    }

}
class ExtendsThread2 extends  Thread{
    public ExtendsThread2() {
    }
    public ExtendsThread2 (String name){
//        super(name);
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("ExtendsThread子线程中的逻辑:::  "+ i);
            // 令当前线程休眠参数指定的时间（毫秒）
            // 处于休眠的线程会放弃掉当前的时间片，
            // 并且在整个休眠期间，不会获得CPU的时间片。
            // 当线程苏醒时，线程会处于就绪状态。（不是运行状态）。
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取线程的名字。
//            System.out.println(getName());
        }
    }
}
