package lt_06_screen;

import java.net.ServerSocket;
import java.net.Socket;

public class VD06_02_server extends Thread {

    private ServerSocket ss;

    public static void main(String args[]) throws Exception {
        new VD06_02_server();
    }

    public VD06_02_server() throws Exception {
        ss = new ServerSocket(1234);
        System.out.println("Server running on port " + 1234);
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client...");
                Socket s = ss.accept();
                System.out.println("Accepting a connection from:" + s.getInetAddress());
                new Connect(s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}