package lt_04_screen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class VD01_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap URL can kiem tra (vd: https://www.dantri.com.vn): ");
        String urlStr = sc.nextLine().trim();

        if (!urlStr.startsWith("http://") && !urlStr.startsWith("https://")) {
            urlStr = "https://" + urlStr;
        }

        try {
            URL u = new URL(urlStr);
            URLConnection uc = u.openConnection();
            uc.connect(); // Thực sự kết nối tới server

            System.out.println("\n========== THONG TIN URL ==========");
            System.out.println("URL        : " + u);
            System.out.println("Protocol   : " + u.getProtocol());
            System.out.println("Host       : " + u.getHost());
            System.out.println("Port       : " + u.getPort());
            System.out.println("Path       : " + u.getPath());

            if (uc instanceof java.net.HttpURLConnection) {
                java.net.HttpURLConnection http = (java.net.HttpURLConnection) uc;
                System.out.println("\n========== STATUS ==========");
                System.out.println("Response Code   : " + http.getResponseCode());
                System.out.println("Response Message: " + http.getResponseMessage());
            }

            System.out.println("\n========== HEADERS ==========");
            String key = null;
            int index = 1;

            for (int i = 1; (key = uc.getHeaderFieldKey(i)) != null; i++) {
                System.out.printf("%2d. %-25s : %s%n",
                        index++,
                        key,
                        uc.getHeaderField(key));
            }

            System.out.println("\n========== HEADER QUAN TRONG ==========");
            System.out.println("Content-Type   : " + uc.getContentType());
            System.out.println("Content-Length : " + uc.getContentLengthLong());
            System.out.println("Server         : " + uc.getHeaderField("Server"));
            System.out.println("Date           : " + uc.getHeaderField("Date"));
            System.out.println("Last-Modified  : " + uc.getHeaderField("Last-Modified"));

        } catch (MalformedURLException e) {
            System.err.println("URL khong hop le: " + urlStr);
            System.err.println("Chi tiet: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Khong the ket noi toi server: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}