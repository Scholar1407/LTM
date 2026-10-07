package lt_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VD05_1_server {

    public static void main(String[] args) {
        int port = 2007;
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server dang chay tai cong " + port + "...");
            Socket s = null;
            
            while (true) {
                try {
                    s = ss.accept();
                    System.out.println("Da ket noi voi Client tu: " + s.getInetAddress());
                    
                    PrintWriter pw;
                    BufferedReader br;
                    pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    
                    while (true) {
                        String line = br.readLine();
                        if (line == null || line.equals("exit")) {
                            break;
                        }
                        System.out.println("Nhan tu client: " + line);
                        
                        String upper = line.toUpperCase();
                        pw.println(upper);
                        pw.flush();
                    }
                } catch (IOException e) {
                    System.err.println("Loi ket noi client: " + e.getMessage());
                } finally {
                    try {
                        if (s != null) {
                            s.close();
                            System.out.println("Da ngat ket noi voi Client.");
                        }
                    } catch (IOException e) {
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Khong the mo Server tai cong " + port);
        }
    }
}