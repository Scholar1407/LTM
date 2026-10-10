package lt_02_screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VD01_2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    String path = "C:\\Exam\\LTM\\out-data2.txt";
    File file = new File(path);

    FileOutputStream fos = new FileOutputStream(file);
    fos.write(73);
    fos.write((int) 'T');
    String s = "HUTECH";

    byte b[] = s.getBytes();
    fos.write(b);
    fos.close();
    }
}
