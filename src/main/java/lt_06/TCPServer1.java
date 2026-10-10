package lt_06;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1 {

    static int PORT = 100;

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            PORT = Integer.parseInt(args[0]);
        }
        ServerSocket s = new ServerSocket(PORT);
        InetAddress addrs = InetAddress.getLocalHost();
        System.out.println("Server: " + addrs.getHostName() + " / " + addrs.getHostAddress());
        System.out.println("Server dang lang nghe tai cong " + s.getLocalPort());
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    new EchoServe(socket, s.getLocalPort());
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}


