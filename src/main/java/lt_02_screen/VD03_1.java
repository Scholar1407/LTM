package lt_02_screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class VD03_1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String dirPath = "C:\\Exam\\LTM";
        File dir = new File(dirPath);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi can ghi vao file: ");
        String str = scanner.nextLine();
        scanner.close();

        FileOutputStream fos = new FileOutputStream(dirPath + "\\testout.txt");
        FilterOutputStream filter = new FilterOutputStream(fos);

        byte[] b = str.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        fos.close();
        
        System.out.println("Xong!!!");
    }
}