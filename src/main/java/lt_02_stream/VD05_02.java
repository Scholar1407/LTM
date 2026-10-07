package lt_02_stream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class VD05_02 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("D:\\ASM2-scholar\\Projects\\LTM\\output\\ketqua.txt");
        pw.println("Ket qua Bai 2");
        pw.print("Diem: ");
        pw.println(9.5);
        pw.println(true);
        pw.close();
        System.out.println("Da ghi xong file ketqua.txt");
    }
}
