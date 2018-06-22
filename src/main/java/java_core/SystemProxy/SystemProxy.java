package java_core.SystemProxy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/4/16.
 */
public class SystemProxy {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "9999");



        try {
            URL url = new URL("http://view.news.qq.com/original/intouchtoday/n3131.html");
            URLConnection connection = url.openConnection();
            connection.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
