package Url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class URLWrite {
    public static void main(String[] args) {
        try {
            // 获得平台使用的编码
            // System.out.println(System.getProperty("file.encoding"));
            // System.out.println(Charset.defaultCharset());
            URL url = new URL("http://127.0.0.1/req");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            // 使用转换流改变编码
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"), true);
            pw.println("客户端的请求");
            // pw.println("client request");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String rtn = br.readLine();
            // System.out.println("服务端的回应：" + rtn);
            System.out.println(rtn);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}