package lt_05_screen;

import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class VD05_4 {

    public static void main(String[] args) {
        String hostname = "time.nist.gov";
        try {
            Socket theSocket = new Socket(hostname, 13);
            InputStream timeStream = theSocket.getInputStream();
            StringBuffer time = new StringBuffer();
            int c;
            while ((c = timeStream.read()) != -1) {
                time.append((char) c);
            }
            String timeString = time.toString().trim();
            System.out.println("Ket qua nhan duoc la: " + timeString);

            String[] parts = timeString.split("\\s+");
            if (parts.length >= 3) {
                SimpleDateFormat inFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                inFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = inFormat.parse(parts[1] + " " + parts[2]);

                SimpleDateFormat outFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                outFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
                System.out.println("Giai ma ngay gio: " + outFormat.format(date));
            }

            theSocket.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}