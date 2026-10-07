package lt_02_stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VD04_01 {

    public static void main(String[] args) {
        try {
            String file_name = "D:\\ASM2-scholar\\Projects\\LTM\\output\\filedata.txt";
            long n = 50000;
            long t = System.currentTimeMillis();
            FileOutputStream fo = new FileOutputStream(file_name);
            BufferedOutputStream bo = new BufferedOutputStream(fo);
            for (int i = 0; i < n; i++) {
                bo.write(i);
            }
            bo.close();
            t = System.currentTimeMillis() - t;
            System.out.println("Ghi co vung dem: " + t + " ms");
            t = System.currentTimeMillis();
            fo = new FileOutputStream(file_name);
            for (int i = 0; i < n; i++) {
                fo.write(i);
            }
            fo.close();
            t = System.currentTimeMillis() - t;
            System.out.println("Ghi KHONG co vung dem: " + t + " ms");
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }
}
