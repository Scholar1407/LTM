package lt_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServe extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private int serverPort;

    public EchoServe(Socket s, int serverPort) throws IOException {
        this.socket = s;
        this.serverPort = serverPort;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str == null || str.equalsIgnoreCase("exit")) {
                    break;
                }
                String clientHost = socket.getInetAddress().getHostName();
                String clientIP = socket.getInetAddress().getHostAddress();
                int clientPort = socket.getPort();

                System.out.println("Nhan yeu cau tu: client (" + clientHost + " / " + clientIP + " / Port " + clientPort + ")");
                System.out.println("Chuoi nhan duoc: " + str);
                String upper = str.toUpperCase();
                System.out.println("KQ xu ly: " + upper);
                out.println(upper);
                System.out.println("Server dang lang nghe tai cong " + serverPort);
            }
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}


