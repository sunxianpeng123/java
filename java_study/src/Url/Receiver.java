package Url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Receiver {
    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket(8888);
            InetAddress ip = InetAddress.getByName("224.0.0.1");
            // 加入到指定的波段，就可以接收这个波段的广播。
            ms.joinGroup(ip);
            while (true) {
                byte[] data = new byte[100];
                DatagramPacket dp = new DatagramPacket(data, data.length);
                ms.receive(dp);
                System.out.println(new String(dp.getData(), 0, dp.getLength()));
            }
            // 离开指定的广播组。
            // ms.leaveGroup(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}