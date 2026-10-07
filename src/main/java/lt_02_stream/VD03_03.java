package lt_02_stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VD03_03 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\ASM2-scholar\\Projects\\LTM\\output\\filedata.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        final int NUMBER = 5;
        dos.writeInt(NUMBER);
        for (int i = 1; i <= NUMBER; i++) {
            dos.writeInt(i);
        }
        
        dos.writeUTF("XIN CHAO VIET NAM");
        dos.writeDouble(100.75);
        dos.flush();
        dos.close();
    }
}
