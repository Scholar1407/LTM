package lt_06_screen;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class VD06_04_server {

    public static final int PORT = 100;

    public static void main(String[] args) {
        try {
            InetAddress myAddr = InetAddress.getLocalHost();
            try (ServerSocket ss = new ServerSocket(PORT)) {
                System.out.println("FTP server (doi tuong) IP " + myAddr.getHostAddress() + " dang lang nghe cong " + PORT);
                while (true) {
                    Socket s = ss.accept();
                    new XuLyClient(s).start();
                }
            }
        } catch (IOException e) {
            System.out.println("Loi server: " + e);
        }
    }

    static class XuLyClient extends Thread {

        private final Socket s;

        XuLyClient(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try (Socket socket = s;
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                String tenFile = (String) ois.readObject();
                System.out.println("Client / " + socket.getInetAddress().getHostAddress() + " xin tap tin " + tenFile);

                File f = new File(tenFile);
                GoiTinFile goiTin;

                if (f.isFile()) {
                    goiTin = new GoiTinFile(f.getName(), Files.readAllBytes(f.toPath()), null);
                } else {
                    goiTin = new GoiTinFile(tenFile, null, "LOI: Khong tim thay tap tin!");
                }

                oos.writeObject(goiTin);
                oos.flush();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Loi xu ly client: " + e);
            }
        }
    }
}