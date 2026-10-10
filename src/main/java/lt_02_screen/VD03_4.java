package lt_02_screen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class VD03_4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String text = sc.next();
        double val = sc.nextDouble();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Exam\\2380600063\\filedata.txt"));
        dos.writeInt(num);
        for (int i = 0; i <= num; i++) dos.writeInt(i);
        dos.writeUTF(text);
        dos.writeDouble(val);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Exam\\2380600063\\filedata.txt"));
        int item = dis.readInt();
        for (int i = 0; i <= item; i++) {
            System.out.print(dis.readInt() + (i == item ? "" : " "));
        }
        System.out.println("\n" + dis.readUTF() + "\n" + dis.readDouble());
        dis.close();
    }
}