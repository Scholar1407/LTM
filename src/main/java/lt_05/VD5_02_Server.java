package lt_05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class VD5_02_Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server listening..."); // Đổi thành listening... theo mẫu[cite: 10]

            Socket socket;
            while ((socket = server.accept()) != null) {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                if (in.hasNextLine()) {
                    String chuoi = in.nextLine().trim();

                    // Phân tách chuỗi gửi từ Client theo ký tự @
                    Scanner stringScanner = new Scanner(chuoi);
                    stringScanner.useDelimiter("@");

                    int so1 = stringScanner.nextInt();
                    String pheptoan = stringScanner.next();
                    int so2 = stringScanner.nextInt();
                    stringScanner.close();

                    // In ra log server theo đúng định dạng mở rộng[cite: 10]
                    System.out.println("Nhan so thu 1: " + so1);
                    System.out.println("Nhan so thu 2: " + so2);
                    System.out.println("Nhan phep toan: " + pheptoan);

                    String ketQua = "";

                    switch (pheptoan) {
                        case "+":
                            ketQua = String.valueOf(so1 + so2);
                            break;
                        case "-":
                            ketQua = String.valueOf(so1 - so2);
                            break;
                        case "*":
                            ketQua = String.valueOf(so1 * so2);
                            break;
                        case "/":
                            // Xử lý chia cho 0 an toàn ở phía server
                            if (so2 == 0) {
                                ketQua = "Loi chia cho 0";
                            } else {
                                // Xóa .0 nếu là số nguyên để kết quả đẹp hơn, ép kiểu float
                                float kqFloat = (float) so1 / so2;
                                if (kqFloat == (int) kqFloat) {
                                    ketQua = String.valueOf((int) kqFloat);
                                } else {
                                    ketQua = String.valueOf(kqFloat);
                                }
                            }
                            break;
                        default:
                            ketQua = "Phep toan khong hop le";
                            break;
                    }

                    System.out.println("Ket qua tinh toan: " + ketQua);
                    out.println(ketQua);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi Server: " + e.getMessage());
        }
    }
}
