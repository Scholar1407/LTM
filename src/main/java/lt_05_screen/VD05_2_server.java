package lt_05_screen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class VD05_2_server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server listening...");
        try {
            Socket socket;
            while ((socket = server.accept()) != null) {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                if (in.hasNextLine()) {
                    String chuoi = in.nextLine().trim();
                    Scanner scannerChuoi = new Scanner(chuoi);
                    scannerChuoi.useDelimiter("@");
                    
                    if (scannerChuoi.hasNextInt()) {
                        int so1 = scannerChuoi.nextInt();
                        String pheptoan = scannerChuoi.next().trim();
                        int so2 = scannerChuoi.nextInt();
                        
                        System.out.println("Nhan so thu 1: " + so1);
                        System.out.println("Nhan so thu 2: " + so2);
                        System.out.println("Nhan phep toan: " + pheptoan);
                        
                        int ketqua = 0;
                        float ketquaFloat = 0;
                        boolean isFloat = false;
                        
                        switch (pheptoan) {
                            case "+":
                                ketqua = so1 + so2;
                                out.println(ketqua);
                                break;
                            case "-":
                                ketqua = so1 - so2;
                                out.println(ketqua);
                                break;
                            case "*":
                                ketqua = so1 * so2;
                                out.println(ketqua);
                                break;
                            case "/":
                                if (so2 != 0) {
                                    ketquaFloat = (float) so1 / so2;
                                    isFloat = true;
                                    out.println(ketquaFloat);
                                } else {
                                    out.println("Loi chia cho 0");
                                }
                                break;
                            default:
                                out.println("Loi phep toan");
                                break;
                        }
                        
                        if (pheptoan.equals("/") && so2 != 0) {
                            System.out.println("Ket qua tinh toan: " + ketquaFloat);
                        } else if (!pheptoan.equals("/") && !pheptoan.equals("+") && !pheptoan.equals("-") && !pheptoan.equals("*")) {
                            System.out.println("Ket qua tinh toan: Loi phep toan");
                        } else {
                            System.out.println("Ket qua tinh toan: " + ketqua);
                        }
                    }
                    scannerChuoi.close();
                }
                socket.close();
            }
        } catch (IOException e) {
        }
    }
}