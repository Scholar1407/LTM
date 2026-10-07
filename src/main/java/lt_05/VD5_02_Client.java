package lt_05_screen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class VD5_02_Client {

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        Scanner serverIn = null;
        Scanner userInput = new Scanner(System.in);

        int so1 = 0, so2 = 0;
        String pheptoan = "", chuoi, ketqua;

        try {
            // Đưa phần kết nối lên đầu để in thông báo connected trước khi nhập liệu[cite: 10]
            socket = new Socket("127.0.0.1", 1234);
            out = new PrintWriter(socket.getOutputStream(), true);
            serverIn = new Scanner(socket.getInputStream());

            System.out.println("Server connected !");

            // KIỂM SOÁT LỖI: Nhập số thứ 1[cite: 10]
            while (true) {
                System.out.print("Nhap so thu 1: ");
                try {
                    so1 = Integer.parseInt(userInput.nextLine().trim());
                    break; // Nhập đúng thì thoát vòng lặp
                } catch (NumberFormatException e) {
                    System.out.println("-> Loi: Vui long nhap mot so nguyen hop le!");
                }
            }

            // KIỂM SOÁT LỖI: Nhập số thứ 2[cite: 10]
            while (true) {
                System.out.print("Nhap so thu 2: ");
                try {
                    so2 = Integer.parseInt(userInput.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("-> Loi: Vui long nhap mot so nguyen hop le!");
                }
            }

            // KIỂM SOÁT LỖI: Nhập phép toán[cite: 10]
            while (true) {
                System.out.print("Nhap phep toan (+-*/): ");
                pheptoan = userInput.nextLine().trim();

                if (pheptoan.equals("+") || pheptoan.equals("-") || pheptoan.equals("*") || pheptoan.equals("/")) {
                    if (pheptoan.equals("/") && so2 == 0) {
                        System.out.println("-> Loi: Khong the chia cho 0! Vui long nhap phep toan khac.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("-> Loi: Phep toan chi duoc la +, -, *, /");
                }
            }

            // Gộp chuỗi và gửi đi
            chuoi = so1 + "@" + pheptoan + "@" + so2;
            out.println(chuoi);

            // Nhận kết quả từ Server và in ra theo đúng định dạng mẫu[cite: 10]
            if (serverIn.hasNextLine()) {
                ketqua = serverIn.nextLine().trim();
                System.out.println("Nhan ket qua: " + ketqua);
            }
        } catch (IOException e) {
            System.out.println("Loi ket noi: " + e.getMessage());
        } finally {
            // Đảm bảo luồng luôn được đóng an toàn
            try {
                if (socket != null) {
                    socket.close();
                }
                userInput.close();
            } catch (IOException ex) {
                System.out.println("Loi dong socket.");
            }
        }
    }
}
