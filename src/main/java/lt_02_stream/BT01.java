package lt_02_stream;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class BT01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap duong dan thu muc: ");
        String path = sc.nextLine().trim();

        File dir = new File(path);

        if (!dir.exists()) {
            System.out.println("Duong dan khong ton tai!");
        } else if (!dir.isDirectory()) {
            System.out.println("Duong dan nhap vao khong phai la thu muc!");
        } else {
            FileFilter fileFilter = new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isFile();
                }
            };

            File[] files = dir.listFiles(fileFilter);

            System.out.println("\n--- DANH SACH CAC TAP TIN TRONG THU MUC ---");
            if (files != null && files.length > 0) {
                for (File f : files) {
                    System.out.println(f.getName());
                }
                System.out.println("Tong so tap tin: " + files.length);
            } else {
                System.out.println("Thu muc khong co tap tin nao!");
            }
        }

        sc.close();
    }
}
