package ConcurrentProgram;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2018/12/28
 * \* Time: 10:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SynchronizeMethod {
    public synchronized void  method1(){
        System.out.println("method 1 start");
        try {
            System.out.println("method 1 execute");
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("method 1 end");
    }

    public synchronized void  method2(){
        System.out.println("method 2 start");
        try {
            System.out.println("method 2 execute");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("method 2 end");
    }
}