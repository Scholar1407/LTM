package lt_02_screen;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VD02_3 {
    public static void main(String[] args) {
        try {
            String dirPath = "C:\\Exam\\LTM";
            File dir = new File(dirPath);
            String file_name = dirPath + "\\data2.txt";

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap chuoi can ghi vo file: ");
            String s = scanner.nextLine();
            scanner.close();

            System.out.println("Du lieu ban dau: " + s);

            FileWriter fw = new FileWriter(file_name);
            fw.write(s);
            fw.close();

            FileReader fr = new FileReader(file_name);
            StringBuffer sb = new StringBuffer();
            char ca[] = new char[5];

            System.out.println("--- Qua trinh doc tung khoi ---");
            while (fr.ready()) {
                int len = fr.read(ca);
                if (len != -1) {
                    String block = new String(ca, 0, len);
                    System.out.println("Khoi doc: [" + block + "]");
                    
                    sb.append(ca, 0, len);
                }
            }
            fr.close();

            System.out.println("Du lieu duoc doc: " + sb.toString());

        } catch (IOException e) {
            System.err.print("Error!");
        }
    }
}