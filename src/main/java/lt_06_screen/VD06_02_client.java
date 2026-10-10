package lt_06_screen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class VD06_02_client {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        Socket s = new Socket("localhost", 1234);
        System.out.println("Da ket noi voi server!");

        oos = new ObjectOutputStream(s.getOutputStream());
        oos.flush();
        ois = new ObjectInputStream(s.getInputStream());

        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap so luong phan tu: ");
        int n = Integer.parseInt(myinput.readLine());

        int dat1[] = new int[n];
        int dat2[] = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            dat1[i] = rd.nextInt(100) + 1;
            dat2[i] = rd.nextInt(100) + 1;
        }

        System.out.print("Sinh mang 1 ngau nhien gom " + n + " phan tu: ");
        for (int i = 0; i < n; i++) {
            System.out.print(dat1[i]);
            if (i < n - 1) System.out.print(",");
        }
        System.out.println();

        System.out.print("Sinh mang 2 ngau nhien gom " + n + " phan tu: ");
        for (int i = 0; i < n; i++) {
            System.out.print(dat2[i]);
            if (i < n - 1) System.out.print(",");
        }
        System.out.println();

        ArrayObject a1 = new ArrayObject();
        a1.setArray(dat1);
        ArrayObject a2 = new ArrayObject();
        a2.setArray(dat2);

        oos.writeObject(a1);
        oos.writeObject(a2);
        oos.flush();

        ArrayObject res = (ArrayObject) ois.readObject();
        int r[] = res.getArray();

        System.out.print("Ket qua nhan duoc: ");
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i]);
            if (i < r.length - 1) System.out.print(",");
        }
        System.out.println();

        ois.close();
        oos.close();
        s.close();
    }
}