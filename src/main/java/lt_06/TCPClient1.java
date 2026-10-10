package lt_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TCPClient1 {

    public static void main(String[] args) throws IOException {
        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = new Socket();
        try {
            socket.bind(null);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Client <" + localHost.getHostName() + " / " + localHost.getHostAddress() + " / Port " + socket.getLocalPort() + ">");

            String host = "";
            int port = 100;

            if (args.length == 2) {
                host = args[0];
                port = Integer.parseInt(args[1]);
            } else {
                System.out.print("Nhap IP Server: ");
                host = myinput.readLine().trim();
                System.out.print("Nhap port Server: ");
                String portStr = myinput.readLine().trim();
                if (!portStr.isEmpty()) {
                    port = Integer.parseInt(portStr);
                }
            }

            InetAddress addr = InetAddress.getByName(host);
            socket.connect(new InetSocketAddress(addr, port));

            try {
                System.out.println("Da ket noi Server <" + addr.getHostName() + " / " + addr.getHostAddress() + " / Port " + port + " >");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                while (true) {
                    System.out.print("Gui chuoi: ");
                    String strin = myinput.readLine();
                    if (strin == null || strin.equalsIgnoreCase("exit")) {
                        out.println("exit");
                        break;
                    }
                    out.println(strin);
                    String strout = in.readLine();
                    if (strout != null) {
                        System.out.println("Nhan ket qua: " + strout);
                    } else {
                        System.out.println("Echo bad -- khong nhan duoc du lieu.");
                    }
                }
            } finally {
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


