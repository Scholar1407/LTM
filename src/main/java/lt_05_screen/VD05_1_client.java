package lt_05_screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class VD05_1_client {

    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        if (args.length > 0) {
            hostname = args[0];
        }
        
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            Socket s = new Socket(hostname, 2007);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(s.getOutputStream(), true);
            
            System.out.println("Server connected ! Nhap noi dung de gui (nhap 'exit' de thoat):");

            while (true) {
                String st = user.readLine();
                if (st == null || st.equals("exit")) {
                    pw.println("exit");
                    break;
                }
                pw.println(st);
                
                String response = br.readLine();
                System.out.println("Phan hoi tu Server: " + response);
            }
        } catch (IOException e) {
            System.err.println("Loi ket noi toi Server: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}