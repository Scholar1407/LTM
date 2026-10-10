package lt_06.lt_06_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connect extends Thread {

    private Socket client = null;

    public Connect() {
    }

    public Connect(Socket client) {
        this.client = client;
        this.start();
    }

    private String formatArray(int[] arr) {
        if (arr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

            ArrayObject x = (ArrayObject) ois.readObject();
            ArrayObject y = (ArrayObject) ois.readObject();
            int[] a1 = x.getArray();
            int[] a2 = y.getArray();

            System.out.println();
            System.out.println("Nhận mảng 1: " + formatArray(a1));
            System.out.println();
            System.out.println("Nhận mảng 2: " + formatArray(a2));

            int[] r = new int[a1.length];
            for (int i = 0; i < a1.length; i++) {
                r[i] = a1[i] * a2[i];
            }

            System.out.println();
            System.out.println("Kết quả tính toán: " + formatArray(r));

            ArrayObject res = new ArrayObject();
            res.setArray(r);
            oos.writeObject(res);
            oos.flush();

            System.out.println();
            System.out.println("Đã gửi cho Client");

            ois.close();
            oos.close();
            client.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

