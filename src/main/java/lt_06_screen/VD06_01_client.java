package lt_06_screen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class VD06_01_client {
    public static void main(String[] args) throws IOException {
        InetAddress myAddr = InetAddress.getLocalHost();
        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Client <" + myAddr.getHostName() + " / " + myAddr.getHostAddress() + " / localport>");

        System.out.print("Nhap IP Server: ");
        String host = myinput.readLine();

        System.out.print("Nhap port Server: ");
        int port = Integer.parseInt(myinput.readLine());

        try {
            InetAddress addr = InetAddress.getByName(host);
            Socket socket = new Socket(addr, port);
            try {
                System.out.println("Da ket noi Server <" + addr.getHostName() + " / " + addr.getHostAddress() + " / Port " + port + " >");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                while (true) {
                    System.out.print("Gui chuoi (exit de ket thuc): ");
                    String strin = myinput.readLine();
                    if (strin == null || strin.equals("exit")) {
                        out.println("exit");
                        break;
                    }
                    out.println(strin);
                    String strout = in.readLine();
                    System.out.println("Nhan ket qua: " + strout);
                }
            } finally {
                socket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Khong tim thay host");
            System.exit(1);
        } catch (SocketException e) {
            System.err.println("Khong the mo socket");
            e.printStackTrace();
            System.exit(1);
        }
    }
}