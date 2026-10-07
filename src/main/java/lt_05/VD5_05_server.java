package lt_05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class VD5_05_server { 
    public static void main(String[] args) { 
        int port = 2022; 
        try { 
            ServerSocket serverSocket = new ServerSocket(port); 
            System.out.println("Server is listening on port " + port); 
            
            while (true) { 
                Socket socket = serverSocket.accept(); 
                
                // Lấy thời gian hiện tại của Server
                String currentTime = new Date().toString();
                
                // In ra màn hình Server theo định dạng mở rộng
                System.out.println("Hien tai la: " + currentTime);
                System.out.println("New client connected"); 
                
                OutputStream output = socket.getOutputStream(); 
                // true để tự động flush (đẩy dữ liệu đi ngay lập tức)
                PrintWriter writer = new PrintWriter(output, true); 
                writer.println(currentTime); 
                
                socket.close(); // Đóng kết nối sau khi gửi xong
            } 
        } catch (IOException e) { 
            System.out.println("Server exception: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
}