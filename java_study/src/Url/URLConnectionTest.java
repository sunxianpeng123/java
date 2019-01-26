package Url;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            // 获得URL连接的对象。获得连接对象不代表已经进行了
            // 真正的连接。
            URLConnection con = url.openConnection();
            // 设置是否可以进行读取资源，默认为true。
            con.setDoInput(true);
            // 设置是否可以进行写入资源。默认为false。
            // 如果我们需要想URL资源写入数据，则需要
            // 设置为true。
            con.setDoOutput(true);
            // setDoInput与setDoOutput需要在连接之间
            // 进行设置。(connect之前)
            // con.connect();

            // 连接URL指定（定位）的资源。当进行获取输入流，
            // 输出流操作时，会自动进行连接（如果该连接尚未
            // 打开）。
            con.connect();

            InputStream in = con.getInputStream();
            // url.openStream();
            // 后续的操作与之前相同

            // 获取URL连接（URLConenction）的输出流。
            OutputStream out = con.getOutputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}