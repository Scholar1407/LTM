package lt_02_stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VD02_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String fileName = "input/data2.txt";
            File file = new File(fileName);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            System.out.print("Nhap chuoi tu ban phim: ");
            String s = scanner.nextLine();
            System.out.println("Du lieu ban dau: " + s);

            FileWriter fw = new FileWriter(file);
            fw.write(s);
            fw.close();

            FileReader fr = new FileReader(file);
            StringBuffer sb = new StringBuffer();
            char ca[] = new char[5]; //5 char 1 block
            int len;
            int blockIndex = 1;

            System.out.println("\n Doc theo tung khoi");
            while ((len = fr.read(ca)) != -1) {
                String block = new String(ca, 0, len);
                System.out.println("Khoi " + blockIndex + ": " + block);
                sb.append(ca, 0, len);
                blockIndex++;
            }
            fr.close();

            System.out.println("\nDu lieu duoc doc (gop cac khoi): " + sb);
        } catch (IOException e) {
            System.err.println("Loi IO: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

