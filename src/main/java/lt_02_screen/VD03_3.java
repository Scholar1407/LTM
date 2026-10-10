package lt_02_screen;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VD03_3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:/Exam/LTM/filedata.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        final int NUMBER = 5;
        dos.writeInt(NUMBER);
        for (int i = 0; i <= NUMBER; i++) {
            dos.writeInt(i);
        }
        dos.writeUTF("XIN CHÀO VIỆT NAM");
        dos.writeDouble(100.75);
        dos.flush();
        dos.close();
    }
}
