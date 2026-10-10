package lt_04_screen;

import java.net.MalformedURLException;
import java.net.URL;

public class VD02_1 {

    public static void printUrlInfo(String urlStr) {
        System.out.println("==========================================");
        System.out.println("URL: " + urlStr);
        System.out.println("------------------------------------------");
        try {
            URL u = new URL(urlStr);

            System.out.println("The protocol is : " + u.getProtocol());
            System.out.println("The host is     : " + u.getHost());
            System.out.println("The port is     : " + u.getPort());
            System.out.println("The default port: " + u.getDefaultPort());
            System.out.println("The file is     : " + u.getFile());
            System.out.println("The path is     : " + u.getPath());
            System.out.println("The query is    : " + u.getQuery());
            System.out.println("The anchor is   : " + u.getRef());
            System.out.println("The authority   : " + u.getAuthority());
            System.out.println("The userInfo    : " + u.getUserInfo());
        } catch (MalformedURLException e) {
            System.err.println("URL khong hop le: " + urlStr);
            System.err.println("Chi tiet: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        printUrlInfo("http://www.hutech.edu.vn:80/quocte/tuyen-sinh");

        printUrlInfo("http://www.hutech.edu.vn:8080/quocte/tuyen-sinh?year=2026#top");

        printUrlInfo("https://www.hutech.edu.vn:443/quocte/tuyen-sinh/thong-bao-tuyen-sinh");

        System.out.println("==========================================");
    }
}