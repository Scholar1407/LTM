package lt_02_screen;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Scanner;

public class VD02_2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap vao mot chuoi ky tu tu ban phim: ");
        String s = scanner.nextLine();
        
        char char_array[] = s.toCharArray();
        
        CharArrayReader reader = new CharArrayReader(char_array);
        int code;
        while ((code = reader.read()) != -1) {
            char ch = (char) code;
            System.out.println(ch);
        }
        
        scanner.close();
    }
}