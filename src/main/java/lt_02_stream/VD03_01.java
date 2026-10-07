package lt_02_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class VD03_01 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi tu ban phim: ");
        String str = scanner.nextLine();

        FileOutputStream fos = new FileOutputStream("D:\\ASM2-scholar\\Projects\\LTM\\output\\testout.txt");
        FilterOutputStream filter = new FilterOutputStream(fos);
        byte[] b = str.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        fos.close();
        scanner.close();
        System.out.println("Xong!!!");
    }
}

