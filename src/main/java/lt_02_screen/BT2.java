package lt_02_screen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dirPath = "C:\\Exam\\LTM";

        System.out.print("Nhap ten tap tin nguon: ");
        String inputFileName = scanner.nextLine();
        scanner.close();

        File sourceFile = new File(inputFileName);
        if (!sourceFile.isAbsolute()) {
            sourceFile = new File(dirPath + "\\" + inputFileName);
        }

        File destFile = new File(dirPath + "\\Mang.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            int[] chunk = new int[100];
            int count = 0;
            int c;
            int segmentIndex = 1;

            writer.write("=== KET QUA TACH DOAN (TOI DA 100 PHAN TU) ===\n");

            while ((c = reader.read()) != -1) {
                chunk[count++] = c;

                if (count == 100) {
                    writer.write("Doan " + segmentIndex++ + ": ");
                    for (int i = 0; i < count; i++) {
                        writer.write(chunk[i] + (i == count - 1 ? "" : ", "));
                    }
                    writer.newLine();
                    count = 0;
                }
            }

            if (count > 0) {
                writer.write("Doan " + segmentIndex++ + ": ");
                for (int i = 0; i < count; i++) {
                    writer.write(chunk[i] + (i == count - 1 ? "" : ", "));
                }
                writer.newLine();
            }

            System.out.println("Da tach tap tin va ghi thanh cong vao: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Loi trong qua trinh xu ly file: " + e.getMessage());
        }
    }
}