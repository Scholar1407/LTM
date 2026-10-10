package lt_04_screen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VD01_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten mien thu nhat: ");
        String domain1 = scanner.nextLine().trim();

        System.out.print("Nhap ten mien thu hai: ");
        String domain2 = scanner.nextLine().trim();

        try {
            InetAddress[] list1 = InetAddress.getAllByName(domain1);
            InetAddress[] list2 = InetAddress.getAllByName(domain2);

            Set<String> ipSet1 = toIpSet(list1);
            Set<String> ipSet2 = toIpSet(list2);

            Set<String> commonIps = new HashSet<>(ipSet1);
            commonIps.retainAll(ipSet2); // Giao của 2 tập hợp

            System.out.println("\n========== KET QUA ==========");

            if (!commonIps.isEmpty()) {
                System.out.println("Ten mien " + domain1 + " va ten mien " + domain2
                        + " co cung IP: " + String.join(", ", commonIps));
            } else {
                System.out.println("Ten mien " + domain1 + " - IP: "
                        + String.join(", ", ipSet1));
                System.out.println("Ten mien " + domain2 + " - IP: "
                        + String.join(", ", ipSet2));
                System.out.println("Hai ten mien khong cung IP.");
            }

        } catch (UnknownHostException e) {
            System.err.println("Loi: Khong the tim thay dia chi IP cho mot hoac ca hai ten mien.");
            System.err.println("Chi tiet: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Set<String> toIpSet(InetAddress[] arr) {
        Set<String> set = new HashSet<>();
        for (InetAddress addr : arr) {
            set.add(addr.getHostAddress());
        }
        return set;
    }
}