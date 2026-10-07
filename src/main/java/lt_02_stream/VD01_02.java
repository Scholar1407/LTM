package lt_02_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//OutputStreamWriteEx11.java
public class VD01_02 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "D:\\ASM2-scholar\\Projects\\LTM\\output\\out-data2.txt";
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
