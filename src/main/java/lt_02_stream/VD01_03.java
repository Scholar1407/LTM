package lt_02_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

//FileOutputInputStreamEx1.java
public class VD01_03 {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("D:\\ASM2-scholar\\Projects\\LTM\\output\\in-data.txt");
            out = new FileOutputStream("D:\\ASM2-scholar\\Projects\\LTM\\output\\out-data3.txt");
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
