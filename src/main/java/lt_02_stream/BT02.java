package lt_02_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BT02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten tap tin nguon: ");
        String inputPath = sc.nextLine().trim();

        File inputFile = new File(inputPath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Loi: Tap tin nguon khong ton tai hoac khong hop le!");
            sc.close();
            return;
        }

        String outputPath = "Mang.txt";

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int[] chunk = new int[100];
            int index = 0;
            int b;
            int totalChunks = 0;

            while ((b = fis.read()) != -1) {
                chunk[index] = b;
                index++;

                if (index == 100) {
                    totalChunks++;
                    for (int i = 0; i < index; i++) {
                        fos.write(chunk[i]);
                    }
                    index = 0;
                }
            }

            if (index > 0) {
                totalChunks++;
                for (int i = 0; i < index; i++) {
                    fos.write(chunk[i]);
                }
            }

            System.out.println("Da tach va ghi thanh cong vao tap tin '" + outputPath + "'!");
            System.out.println("Tong so doan (mang 100 phan tu) da xu ly: " + totalChunks);

        } catch (IOException e) {
            System.out.println("Loi khi doc/ghi tap tin: " + e.getMessage());
        }

        sc.close();
    }
}
