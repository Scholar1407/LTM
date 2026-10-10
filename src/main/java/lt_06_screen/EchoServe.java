package lt_06_screen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EchoServe extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public EchoServe(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try {
            InetAddress clientAddr = socket.getInetAddress();
            String clientName = clientAddr.getHostName();
            String clientIP = clientAddr.getHostAddress();
            int clientPort = socket.getPort();
            System.out.println("Nhan yeu cau tu: client (" + clientName + " / " + clientIP + " / " + clientPort + ")");

            while (true) {
                String str = in.readLine();
                if (str == null || str.equals("exit")) {
                    break;
                }
                System.out.println("Chuoi nhan duoc: " + str);
                String upper = str.toUpperCase();
                System.out.println("KQ xu ly: " + upper);
                out.println(upper);
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