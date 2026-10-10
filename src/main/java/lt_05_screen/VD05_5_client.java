package lt_05_screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class VD05_5_client { 
    public static void main(String[] args) { 
        String hostname = "127.0.0.1";
        int port = 2021;  
        
        try { 
            Socket socket = new Socket(hostname, port); 
            InputStream input = socket.getInputStream(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
            
            String time = reader.readLine(); 
            
            System.out.println("Du lieu nhan duoc: " + time); 
            
            socket.close();
            
        } catch (UnknownHostException e) { 
            System.out.println("Server not found: " + e.getMessage()); 
        } catch (IOException e) { 
            System.out.println("I/O error: " + e.getMessage()); 
        } 
    } 
}