package lt_02_stream;

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

public class BT07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten tap tin (vi du: data): ");
        String baseName = sc.nextLine().trim();

        System.out.print("Nhap so luong n so ngau nhien: ");
        int n = sc.nextInt();

        String binFile = baseName + ".bin";
        String txtFile = baseName + ".txt";

        Random rand = new Random();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("\n--- 1. CHE DO NHI PHAN (BINARY) ---");

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(binFile)))) {
            for (int val : numbers) {
                dos.writeInt(val);
            }
            System.out.println("Da ghi " + n + " so ngau nhien vao file nhi phan '" + binFile + "'");
        } catch (IOException e) {
            System.out.println("Loi ghi file nhi phan: " + e.getMessage());
        }

        System.out.print("Noi dung doc tu file nhi phan: ");
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(binFile)))) {
            for (int i = 0; i < n; i++) {
                int val = dis.readInt();
                System.out.print(val + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Loi doc file nhi phan: " + e.getMessage());
        }

        System.out.println("\n--- 2. CHE DO VAN BAN (TEXT) ---");

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(txtFile)))) {
            for (int val : numbers) {
                pw.println(val);
            }
            System.out.println("Da ghi " + n + " so ngau nhien vao file van ban '" + txtFile + "'");
        } catch (IOException e) {
            System.out.println("Loi ghi file van ban: " + e.getMessage());
        }

        System.out.print("Noi dung doc tu file van ban: ");
        try (BufferedReader br = new BufferedReader(
                new FileReader(txtFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Loi doc file van ban: " + e.getMessage());
        }

        sc.close();
    }
}