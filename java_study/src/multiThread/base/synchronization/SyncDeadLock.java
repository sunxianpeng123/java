package multiThread.base.synchronization;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/7/30
 * \* Time: 13:37
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

/**
 *
 */
public class SyncDeadLock {
    public static void main(String[] args) {
        new DeadLockThread();

    }
}
class DeadLockThread implements Runnable{
    Customer c =new Customer();
    Waiter w = new Waiter();
    public DeadLockThread(){
        new Thread(this).start();
        w.say(c);
    }
    @Override
    public void run() {
        c.say(w);

    }
}
class Customer{
    public synchronized  void  say(Waiter w){
        System.out.println("顾客说，先吃饭再买单！！");
        w.doService();
    }

    public synchronized void doService(){
        System.out.println("同意了，买完单再吃饭！！");
    }
}

class Waiter{
    public synchronized  void  say(Customer c){
        System.out.println("服务员说，先吃饭再买单！！");
        c.doService();
    }

    public synchronized void doService(){
        System.out.println("同意了，吃完饭再买单！！");
    }

}
