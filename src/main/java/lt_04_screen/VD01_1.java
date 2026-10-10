package lt_04_screen;

import java.net.InetAddress;
import java.util.Scanner;

public class VD01_1 {

    /**
     * Xác định lớp mạng (A, B, C, D, E) từ byte đầu tiên của địa chỉ IPv4.
     * @param firstByte giá trị byte đầu tiên (0-255)
     * @return tên lớp mạng
     */
    public static String getNetworkClass(int firstByte) {
        if (firstByte >= 1 && firstByte <= 126) {
            return "A";
        } else if (firstByte == 127) {
            return "Loopback (127.x.x.x)";
        } else if (firstByte >= 128 && firstByte <= 191) {
            return "B";
        } else if (firstByte >= 192 && firstByte <= 223) {
            return "C";
        } else if (firstByte >= 224 && firstByte <= 239) {
            return "D (Multicast)";
        } else if (firstByte >= 240 && firstByte <= 255) {
            return "E (Dự phòng)";
        }
        return "Không xác định";
    }

    /**
     * Chuyển byte có dấu (Java byte: -128..127) sang giá trị không dấu 0..255.
     */
    public static int toUnsigned(byte b) {
        return b & 0xFF;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap ten mien can kiem tra: ");
            String s = sc.nextLine().trim();

            // Lấy TẤT CẢ địa chỉ IP của tên miền
            InetAddress[] hosts = InetAddress.getAllByName(s);

            System.out.println("\n=== KET QUA PHAN GIAI ===");
            System.out.println("Ten mien: " + s);
            System.out.println("So luong dia chi IP tim thay: " + hosts.length);
            System.out.println("----------------------------------------");

            for (int idx = 0; idx < hosts.length; idx++) {
                InetAddress host = hosts[idx];
                String ip = host.getHostAddress();

                System.out.println("IP #" + (idx + 1) + ":");
                System.out.println("  Host name  : " + host.getHostName());
                System.out.println("  IP address : " + ip);

                byte[] b = host.getAddress();

                if (b.length == 4) {
                    // IPv4: lấy byte đầu để xác định lớp
                    int firstByte = toUnsigned(b[0]);
                    String ipClass = getNetworkClass(firstByte);
                    System.out.println("  Lop mang   : " + ipClass);
                } else {
                    // IPv6 (16 byte) - không áp dụng khái niệm lớp A/B/C
                    System.out.println("  Lop mang   : IPv6 (khong ap dung lop A/B/C)");
                }
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Khong tim thay dia chi hoac loi phan giai: " + e.getMessage());
        }
    }
}