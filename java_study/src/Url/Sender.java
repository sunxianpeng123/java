package Url;

import java.io.IOException;
import java.net.*;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:48
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Sender {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            // 广播的波段，范围限制为224.0.0.0到239.255.255.255，
            // 其中224.0.0.0被保留，不能使用。
            InetAddress ip = InetAddress.getByName("224.0.0.1");
            while (true) {
                byte[] data = getData();
                DatagramPacket dp = new DatagramPacket(data, data.length, ip, 8888);
                ds.send(dp);
                Thread.sleep(1000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getData() {
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = 65 + r.nextInt(26);
            b.append((char) x);
        }
        System.out.println(b);
        return b.toString().getBytes();
    }
}