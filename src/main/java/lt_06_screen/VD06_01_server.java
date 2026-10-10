package lt_06_screen;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class VD06_01_server {
    static int PORT = 100;

    public static void main(String[] args) throws IOException {
        InetAddress addrs = InetAddress.getLocalHost();
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server: " + addrs.getHostName() + " / " + addrs.getHostAddress());
        System.out.println("Server dang lang nghe tai cong " + PORT);
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    new EchoServe(socket);
                    System.out.println("Server dang lang nghe tai cong " + PORT);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}