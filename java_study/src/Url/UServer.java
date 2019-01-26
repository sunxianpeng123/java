package Url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class UServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(8888);
            byte[] data = new byte[100];
            DatagramPacket dp = new DatagramPacket(data, data.length);
            // 接收客户端发送的数据报（数据包）。
            // 该方法在接受数据报之前会一直处于阻塞状态。
            ds.receive(dp);
            // 获得接受的数据
            // dp.getData();
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            // 获得数据的长度。
            // dp.getLength();
            // 获得发送方的IP
            // dp.getAddress();
            // 获得发送方的端口号。
            // dp.getPort();
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}