package lt_04_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class VD01_2 {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Host name: " + ip.getHostName());
            System.out.println("Host name: " + ip.getHostAddress());
            
            ip = InetAddress.getByName("www.hutech.edu.vn");
            System.out.println("\nHost Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
            
            System.out.println("\nAll Address of google: ");
            InetAddress sw[] = InetAddress.getAllByName("www.google.com");
            for (int i = 0; i < sw.length; i++) {
                System.out.println(sw[i]);
            }

            // Thêm chức năng nhập tên miền từ bàn phím
            Scanner sc = new Scanner(System.in);
            System.out.print("\nNhập tên miền khác cần kiểm tra: ");
            String domain = sc.nextLine();
            
            InetAddress customIp = InetAddress.getByName(domain);
            System.out.println("Host Name: " + customIp.getHostName());
            System.out.println("IP Address: " + customIp.getHostAddress());
            
            InetAddress customSw[] = InetAddress.getAllByName(domain);
            for (int i = 0; i < customSw.length; i++) {
                System.out.println(customSw[i]);
            }

        } catch (UnknownHostException e) {
            System.out.println("Không tìm thấy địa chỉ cho tên miền này!");
        }
    }
}