package lt_02_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class VD02_01 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("D:\\ASM2-scholar\\Projects\\LTM\\input\\data.txt");
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
