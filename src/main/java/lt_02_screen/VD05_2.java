package lt_02_screen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class VD05_2 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("C:\\Exam\\LTM\\ketqua.txt");
        pw.println("Ket qua Bai 2");
        pw.print("Diem: ");
        pw.println(9.5);
        pw.println(true);
        pw.close();
        System.out.println("Da ghi xong file ketqua.txt");
    }
}
