package lt_02_screen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class BT3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dirPath = "C:\\Exam\\LTM";

        System.out.print("Nhap ten tap tin co so: ");
        String fileName = scanner.nextLine();
        
        System.out.print("Nhap so luong so ngau nhien n: ");
        int n = scanner.nextInt();
        scanner.close();

        String binaryFile = dirPath + "\\" + fileName + "_bin.dat";
        String textFile = dirPath + "\\" + fileName + "_txt.txt";

        Random rand = new Random();

        // ==========================================
        // 1. CHE DO NHI PHAN (Dung DataOutputStream + BufferedOutputStream)
        // ==========================================
        try {
            // Ghi file nhi phan
            DataOutputStream dos = new DataOutputStream(
                                    new BufferedOutputStream(
                                        new FileOutputStream(binaryFile)));
            dos.writeInt(n);
            for (int i = 0; i < n; i++) {
                dos.writeInt(rand.nextInt(1000));
            }
            dos.flush();
            dos.close();

            System.out.println("\n--- DOC TU FILE NHI PHAN ---");
            DataInputStream dis = new DataInputStream(
                                    new BufferedInputStream(
                                        new FileInputStream(binaryFile)));
            int countBin = dis.readInt();
            System.out.print("Cac so da doc: ");
            for (int i = 0; i < countBin; i++) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
            dis.close();

        } catch (IOException e) {
            System.err.println("Loi xu ly file nhi phan: " + e.getMessage());
        }

        // ==========================================
        // 2. CHE DO VAN BAN (Dung PrintWriter + BufferedWriter)
        // ==========================================
        try {
            // Ghi file van ban
            PrintWriter pw = new PrintWriter(
                                new BufferedWriter(
                                    new FileWriter(textFile)));
            pw.println(n); // Ghi so luong phan tu tren dong dau
            for (int i = 0; i < n; i++) {
                pw.print(rand.nextInt(1000) + " "); // Ghi cac so ngau nhien
            }
            pw.flush();
            pw.close();

            // Doc lai file van ban va hien thi
            System.out.println("\n--- DOC TU FILE VAN BAN ---");
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            String line = br.readLine(); // Doc so luong
            System.out.println("So luong phan tu: " + line);
            System.out.print("Cac so da doc: " + br.readLine());
            System.out.println();
            br.close();

        } catch (IOException e) {
            System.err.println("Loi xu ly file van ban: " + e.getMessage());
        }
        
        System.out.println("\nHoan tat qua trinh ghi va doc o ca 2 che do!");
    }
}