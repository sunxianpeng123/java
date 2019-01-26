package Url;

import java.io.IOException;
import java.net.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class UClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            byte[] b = "你好".getBytes();
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(b, b.length, ip, 8888);
            // 发送数据报
            ds.send(dp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}