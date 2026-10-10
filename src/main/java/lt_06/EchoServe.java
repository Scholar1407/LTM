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

    public EchoServe(Socket s) throws IOException {
        socket = s;
        System.out.println("Serving: " + socket);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("....Server is waiting...");
                String str = in.readLine();
                if (str == null || str.equals("exit")) {
                    break;
                }
                System.out.println("Received: " + str);
                System.out.println("From: " + socket);
                String upper = str.toUpperCase();
                out.println(upper);
            }
            System.out.println("Disconnected with.." + socket);
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
