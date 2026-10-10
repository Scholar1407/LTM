package lt_06_screen;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class VD06_04_client {

    public static void main(String[] args) {
        try {
            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

            InetAddress myAddr = InetAddress.getLocalHost();
            System.out.println("FTP Client (doi tuong) IP " + myAddr.getHostAddress());

            System.out.print("Nhap IP Server: ");
            String host = kb.readLine();

            System.out.print("Nhap port Server: ");
            int port = Integer.parseInt(kb.readLine());

            try (Socket s = new Socket(host, port);
                 ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(s.getInputStream())) {

                System.out.println("Da ket noi server " + host + " o cong " + port);

                System.out.print("Nhap duong dan tap tin can xin: ");
                String tenFile = kb.readLine();

                oos.writeObject(tenFile);
                oos.flush();

                GoiTinFile goiTin = (GoiTinFile) ois.readObject();

                if (goiTin.thanhCong()) {
                    byte[] data = goiTin.getNoiDung();
                    String tenLuu = "nhan_" + goiTin.getTenFile();
                    try (FileOutputStream fos = new FileOutputStream(tenLuu)) {
                        fos.write(data);
                    }
                    System.out.println("Da nhan va luu tap tin tai " + tenLuu);
                } else {
                    System.out.println(goiTin.getLoi());
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("Khong tim thay host: " + e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi client: " + e);
        }
    }
}