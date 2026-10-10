package lt_02_screen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VD01_3 {
    public static void main(String[] args) throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;
    try {
    in = new FileInputStream("C:\\Exam\\LTM\\input.txt");
    out = new FileOutputStream("C:\\Exam\\LTM\\out.txt");
    int c;
    while ((c = in.read()) != -1) {
        out.write(c);
        }
    } finally {
        if (in != null) {
        in.close();
        }
        if (out != null) {
            out.close();
            }
        }
    }
}