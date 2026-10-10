package lt_05_screen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class VD05_2_client {

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        Scanner in = null;
        Scanner scanner = new Scanner(System.in);

        int so1, so2;
        String pheptoan, chuoi, ketqua;

        System.out.println("Server connected !");
        System.out.print("Nhap so thu 1: ");
        so1 = scanner.nextInt();
        
        System.out.print("Nhap so thu 2: ");
        so2 = scanner.nextInt();
        
        System.out.print("Nhap phep toan (+-*/): ");
        pheptoan = scanner.next();
        
        chuoi = so1 + "@" + pheptoan + "@" + so2;
        
        try {
            socket = new Socket("127.0.0.1", 1234);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
            
            out.println(chuoi);
            
            if (in.hasNextLine()) {
                ketqua = in.nextLine().trim();
                System.out.println("Nhan ket qua: " + ketqua);
            }
            
            socket.close();
        } catch (IOException e) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}