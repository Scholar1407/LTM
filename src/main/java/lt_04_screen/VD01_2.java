package lt_04_screen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class VD01_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            InetAddress localIp = InetAddress.getLocalHost();
            System.out.println("=== THONG TIN MAY CUC BO ===");
            System.out.println("Host name : " + localIp.getHostName());
            System.out.println("IP address: " + localIp.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Khong lay duoc thong tin may cuc bo: " + e.getMessage());
        }

        System.out.print("\nNhap ten mien can phan giai (vd: www.hutech.edu.vn): ");
        String domain = sc.nextLine().trim();

        try {
            InetAddress ip = InetAddress.getByName(domain);
            System.out.println("\n=== KET QUA PHAN GIAI ===");
            System.out.println("Host Name : " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("\nKhong the phan giai ten mien: " + domain);
        }

        System.out.print("\nNhap ten mien can liet ke TAT CA IP (vd: www.google.com): ");
        String multiDomain = sc.nextLine().trim();

        try {
            InetAddress[] sw = InetAddress.getAllByName(multiDomain);

            System.out.println("\n=== TAT CA DIA CHI IP CUA " + multiDomain + " ===");
            System.out.println("Tong so dia chi tim thay: " + sw.length);
            System.out.println("----------------------------------------");

            for (int i = 0; i < sw.length; i++) {
                System.out.printf("[%d] %s%n", (i + 1), sw[i]);
            }

        } catch (UnknownHostException e) {
            System.out.println("\nKhong the phan giai ten mien: " + multiDomain);
        }

        sc.close();
    }
}