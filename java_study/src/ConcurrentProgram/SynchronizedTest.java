package ConcurrentProgram;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2018/12/28
 * \* Time: 10:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SynchronizedTest {
    public static  void  main(String [] args){
         SynchronizeMethod test=new SynchronizeMethod();
        //同步方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
        //同步代码块


    }




}