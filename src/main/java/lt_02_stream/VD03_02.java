package lt_02_stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class VD03_02 {

    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        FilterInputStream filter = null;
        try {
            file = new FileInputStream(new File("D:\\ASM2-scholar\\Projects\\LTM\\output\\testout.txt"));
            filter = new BufferedInputStream(file);
            int k = 0;
            while ((k = filter.read()) != -1) {
                System.out.print((char) k);
            }
            filter.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

