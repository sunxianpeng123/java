package multiThread.examples.splitBatchDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XP on 2019/7/29.
 */

/**
 * 小项目可以这么做，大项目不可以，大项目需要考虑线程次管理，使用消息中间件来保证数据一致性
 */
public class BatchHandingMain {
    //        案例：假设蚂蚁课堂有十万个会员，给每一个会员发一个短信祝福
//      实例化2个发送客户端， 用2个线程来模拟多个客户端。
    public static void main(String[] args) {
//        1、初始化数据
        List<UserEntity> userList = initUser();
//        2、定义每个线程分批发送大小
        int userCount =2;
//        3、计算每个线程需要分批处理的数据
        List<List<UserEntity>> splitList = SplitPagesUtil.splitList(userList, userCount);
//        4、进行分批发送
        for (int i = 0; i <splitList.size() ; i++) {
            List<UserEntity> list = splitList.get(i);
            UserSenderThread userSenderThread=new UserSenderThread(list);
            Thread thread =new Thread(userSenderThread,"thread-" + i);
            thread.start();
            System.out.println();
        }


    }

    public static List<UserEntity> initUser() {
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            list.add(new UserEntity("userId:"+i,"userName:"+i));
        }
        return  list;
    }
}
