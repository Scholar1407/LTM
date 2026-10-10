package lt_02_screen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

public class VD01_1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    String path = "C:\\Exam\\LTM\\out-data.txt";
    byte b[] = new byte[15];
    File file = new File(path);
    FileOutputStream os = new FileOutputStream(file);
    os.write(73);
    os.write((int) 'T');
    String s = "HUTECH-ILOVE";
    char c[] = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
    b[i] = (byte) c[i];
    }
    os.write(b);
    os.close();
    }
}
