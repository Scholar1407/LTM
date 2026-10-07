package lt_04_inetaddress;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class VD02_3 {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://intermezzo.fi/cgi-bin/");
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            
            uc.setDoOutput(true);
            uc.setRequestMethod("POST");
            
            DataOutputStream dos = new DataOutputStream(uc.getOutputStream());
            String s = "Here is some data"; 
            dos.writeBytes(s);
            dos.flush();
            dos.close();             
            int responseCode = uc.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) { 
                System.out.println("Đã gửi thành công! Server đã nhận với mã trạng thái: " + responseCode + " (OK)");
            } else {
                System.out.println("Gửi thành công nhưng server trả về mã trạng thái: " + responseCode);
            }
            
        } catch (IOException e) { 
            System.err.println("Lỗi kết nối hoặc gửi dữ liệu: " + e.getMessage());
        }
    }
}