package lt_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class VD05_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten mien can ket noi (cong 80): ");
        String host = sc.nextLine();

        try (Socket socket = new Socket(host, 80)) {
            System.out.println("--- Thong tin Socket tai may cuc bo ---");
            InetAddress diachiCucBo = socket.getLocalAddress();
            int congCucBo = socket.getLocalPort();
            System.out.println("Dia chi cuc bo: " + diachiCucBo.getHostAddress());
            System.out.println("Cong cuc bo: " + congCucBo);

            // Mở rộng: Lấy và hiển thị địa chỉ IP WAN (Public IP) của máy
            printWanIp();

            System.out.println("--- Thong tin Socket cua may ket noi (cong 80) ---");
            InetAddress diachiMayDich = socket.getInetAddress();
            int congMayDich = socket.getPort();
            System.out.println("Dia chi may dich: " + diachiMayDich.getHostAddress());
            System.out.println("Cong may dich: " + congMayDich);

        } catch (UnknownHostException e) {
            System.out.println("Khong tim thay may chu!");
        } catch (IOException e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void printWanIp() {
        try {
            URL url = new URL("https://api.ipify.org");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String wanIp = reader.readLine();
                System.out.println("Dia chi IP WAN: " + wanIp);
            }
        } catch (IOException e) {
            System.out.println("Khong thể lay dia chi IP WAN: " + e.getMessage());
        }
    }
}