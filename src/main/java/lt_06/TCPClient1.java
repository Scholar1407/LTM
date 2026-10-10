package lt_06;

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

public class TCPClient1 {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 2008;
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        try {
            InetAddress addr = InetAddress.getByName(host);
            Socket socket = new Socket(addr, port);
            try {
                System.out.println("socket = " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    System.out.println("Nhap chuoi (exit de ket thuc):");
                    String strin = myinput.readLine();
                    if (strin == null || strin.equals("exit")) {
                        out.println("exit");
                        break;
                    }
                    out.println(strin);
                    String strout = in.readLine();
                    if (strout != null && strin.length() == strout.length()) {
                        System.out.println("Received: " + strout);
                    } else {
                        System.out.println("Echo bad -- string unequal " + strout);
                    }
                }
            } finally {
                System.out.println("EOF...exit");
                socket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Can't find host");
            System.exit(1);
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
