package Url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: sunxianpeng
 * \* Date: 2019/1/26
 * \* Time: 15:27
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class LocalFile {
    public static void main(String[] args) {
        OutputStream out = null;
        try {
            URL url = new URL("http://new.xiaohulu.com/uploads/allimg/c181018/153b53X360-334N.jpg");
            InputStream in = url.openStream();
            out = new FileOutputStream("data/153b53X360-334N.jpg");
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}