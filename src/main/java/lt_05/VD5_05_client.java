package lt_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class VD5_05_client { 
    public static void main(String[] args) { 
        String hostname = "127.0.0.1"; // 127.0.0.1 là địa chỉ localhost (máy cục bộ)
        int port = 2022;  
        
        try { 
            Socket socket = new Socket(hostname, port); 
            InputStream input = socket.getInputStream(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
            
            String time = reader.readLine(); 
            
            // In ra màn hình Client theo định dạng mở rộng
            System.out.println("Du lieu nhan duoc: " + time); 
            
            socket.close(); // Đóng kết nối sau khi đọc xong
            
        } catch (UnknownHostException e) { 
            System.out.println("Server not found: " + e.getMessage()); 
        } catch (IOException e) { 
            System.out.println("I/O error: " + e.getMessage()); 
        } 
    } 
}