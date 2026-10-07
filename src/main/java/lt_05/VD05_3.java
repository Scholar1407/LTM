package lt_05;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

public class VD05_3 {

    public static void main(String[] args) {
        byte[] buffer;
        DataInputStream in;
        Date now;
        InetAddress ipAddress;
        int port;
        long secondsSince1900, secondsSince1970;
        Socket socket;
        String host;

        if (args.length == 0) {
            host = "time.nist.gov";
        } else {
            host = args[0];
        }

        try {
            ipAddress = InetAddress.getByName(host);
            port = 37;

            socket = new Socket(ipAddress, port);
            in = new DataInputStream(socket.getInputStream());

            socket.setSoTimeout(4000);
            
            buffer = new byte[4];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = in.readByte();
            }

            secondsSince1900 = 0;
            for (int i = 0; i < buffer.length; i++) {
                secondsSince1900 = (secondsSince1900 << 8) | (buffer[i] & 0x000000FF);
            }

            secondsSince1970 = (long) secondsSince1900 - 2208988800L;
            
            now = new Date(secondsSince1970 * 1000L);

            System.out.println("Thoi gian hien tai tu Server: " + now);

            socket.close();
        } catch (SocketException se) {
            System.err.println("Ket noi qua thoi gian (Timeout). Hay thu server khac.");
        } catch (Exception e) {
            System.err.println("Khong the giao tiep voi server: " + e.getMessage());
        }
    }
}