package Url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class URLMethod {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1:8800/abc/123.txt?a=1&b=2#bak");
            // 返回url的协议。
            System.out.println(url.getProtocol());
            // 返回主机。
            System.out.println(url.getHost());
            // 返回端口号。
            System.out.println(url.getPort());
            // 返回协议默认的端口号。
            System.out.println(url.getDefaultPort());
            // 返回文件（路径）
            System.out.println(url.getPath());
            // 返回查询参数
            System.out.println(url.getQuery());
            // 返回文件路径（包含查询参数）
            System.out.println(url.getFile());
            // 返回引用
            System.out.println(url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}