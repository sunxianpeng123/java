package multiThread.examples.productCustomerDemo;

/**
 * Created by XP on 2019/7/31.
 */
public class Food {
    private String name;
    private String desc;
//    互斥标记，用一个中间变量来控制生产者和消费者的交替协作，true表示可以生产，false表示可以消费。
    private boolean flag = true;

    public Food() {
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * 生产者方法
     * @param name
     * @param desc
     */
    public synchronized void productFood(String name,String desc){
//        flag ==false 表示不能生产
        if (flag ==false){
            try {
//              wait方法，线程进入等待状态，释放监视器的所有权，等待其他线程执行notify方法或者notifyAll方法.
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
//            休眠500ms，模拟生产的过程
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
//      生产完成后唤醒消费者线程
        this.setFlag(false);
        this.notify();
    }

    /**
     * 消费者方法
     */
    public synchronized void  customeFood(){
//        flag ==true 表示不能消费
        if (flag == true){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
//            休眠500ms，模拟消费的过程
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费掉的信息::"+this.getName()+"--->"+this.getDesc());
//        消费完成后，唤醒生产者线程
        this.setFlag(true);
        this.notify();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
