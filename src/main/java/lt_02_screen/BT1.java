package lt_02_screen;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap duong dan thu muc can kiem tra: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            FileFilter fileFilter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile();
                }
            };

            File[] files = dir.listFiles(fileFilter);

            if (files != null && files.length > 0) {
                System.out.println("--- Danh sach cac tap tin trong thu muc ---");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Thu muc nay khong chua tap tin nao!");
            }
        } else {
            System.out.println("Duong dan khong hop le hoac khong phai la thu muc!");
        }
    }
}
