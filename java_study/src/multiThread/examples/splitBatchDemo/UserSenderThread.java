package multiThread.examples.splitBatchDemo;

import java.util.List;

/**
 * Created by XP on 2019/7/29.
 */
public class UserSenderThread implements Runnable {
    private List<UserEntity> listUser ;
    public UserSenderThread(List<UserEntity> listUser){
        this.listUser =listUser;
    }
    @Override
    public void run() {
        for (UserEntity userEntity:listUser) {
            System.out.println("线程名称"+Thread.currentThread().getName()+",,,"+userEntity.toString());

        }
    }
}
