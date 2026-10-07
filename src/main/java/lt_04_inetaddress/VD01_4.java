package lt_04_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class VD01_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten mien thu nhat: "); 
        String domain1 = scanner.nextLine(); 
        System.out.print("Nhap ten mien thu hai: "); 
        String domain2 = scanner.nextLine();
        
        try {
            InetAddress address1 = InetAddress.getByName(domain1);
            InetAddress address2 = InetAddress.getByName(domain2);
            
            String ip1 = address1.getHostAddress();
            String ip2 = address2.getHostAddress();
            
            if (ip1.equals(ip2)) {
                // Trường hợp 2 tên miền cùng IP
                System.out.println("Tên miền " + domain1 + " và tên miền " + domain2 + " có cùng IP: " + ip1);
            } else {
                // Trường hợp 2 tên miền khác IP
                System.out.println("Tên miền " + domain1 + "-IP: " + ip1);
                System.out.println("Tên miền " + domain2 + "-IP: " + ip2);
                System.out.println("Hai tên miền không cùng IP");
            }
        } catch (UnknownHostException e) {
            System.err.println("Loi: Khong the tim thay dia chi IP cho mot hoac ca hai ten mien.");
        }
    }
}