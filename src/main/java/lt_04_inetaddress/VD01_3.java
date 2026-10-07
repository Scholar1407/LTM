package lt_04_inetaddress;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class VD01_3 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập URL hoặc tên miền cần kiểm tra (vd: dantri.vn hoặc https://google.com): ");
            String input = sc.nextLine().trim();

            if (!input.startsWith("http://") && !input.startsWith("https://")) {
                input = "https://" + input;
            }

            URL u = new URL(input); 
            URLConnection uc = u.openConnection();
            uc.connect(); 
            
            String key = null; 
            for (int i = 1; (key = uc.getHeaderFieldKey(i)) != null; i++) {
                System.out.println(key + " :" + uc.getHeaderField(key));
            }
            
        } catch (IOException e) { 
            System.err.println("Lỗi kết nối hoặc URL không hợp lệ: " + e.getMessage());
        }
    }
}