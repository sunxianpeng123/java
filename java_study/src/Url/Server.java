package Url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:38
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 监听指定的端口号
            ServerSocket server = new ServerSocket(8888);
            // 用来接收客户端的请求。该方法在客户端请求到来前
            // 会处于阻塞状态。
            Socket socket = server.accept();
            new Read(socket).start();
            new Write(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class Read extends Thread {
    private Socket socket;

    public Read(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Write extends Thread {
    private Socket socket;

    public Write(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                pw.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}