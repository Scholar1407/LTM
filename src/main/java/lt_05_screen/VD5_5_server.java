package lt_05_screen;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class VD5_5_server { 
    public static void main(String[] args) { 
        int port = 2021; 
        try { 
            ServerSocket serverSocket = new ServerSocket(port); 
            System.out.println("Server is listening on port " + port); 
            
            while (true) { 
                Socket socket = serverSocket.accept(); 
                
                String currentTime = new Date().toString();
                
                System.out.println("Hien tai la: " + currentTime);
                System.out.println("New client connected"); 
                
                OutputStream output = socket.getOutputStream(); 
                PrintWriter writer = new PrintWriter(output, true); 
                writer.println(currentTime); 
                
                socket.close();
            } 
        } catch (IOException e) { 
            System.out.println("Server exception: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
}