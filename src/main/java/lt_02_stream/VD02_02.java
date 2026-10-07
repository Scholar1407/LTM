package lt_02_stream;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Scanner;

public class VD02_02 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        String input = sc.nextLine();
        char[] char_array = input.toCharArray();
        
        CharArrayReader reader = new CharArrayReader(char_array);
        int code;
        while ((code = reader.read()) != -1) {
            char ch = (char) code;
            System.out.println(ch);
        }
    }
}
