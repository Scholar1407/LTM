package lt_06_screen;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Connect extends Thread {

    private Socket client = null;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Connect() {
    }

    public Connect(Socket client) {
        this.client = client;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.flush();
            ois = new ObjectInputStream(client.getInputStream());
        } catch (Exception e) {
            System.err.println(e);
        }
        this.start();
    }

    @Override
    public void run() {
        ArrayObject x = null;
        ArrayObject y = null;
        try {
            x = (ArrayObject) ois.readObject();
            y = (ArrayObject) ois.readObject();

            int a1[] = x.getArray();
            int a2[] = y.getArray();

            System.out.println("Nhan mang 1: " + Arrays.toString(a1).replace("[", "").replace("]", "").replace(" ", ""));
            System.out.println("Nhan mang 2: " + Arrays.toString(a2).replace("[", "").replace("]", "").replace(" ", ""));

            int r[] = new int[a1.length];
            for (int i = 0; i < a1.length; i++) {
                r[i] = a1[i] * a2[i];
            }

            System.out.println("Ket qua tinh toan: " + Arrays.toString(r).replace("[", "").replace("]", "").replace(" ", ""));

            ArrayObject res = new ArrayObject();
            res.setArray(r);
            oos.writeObject(res);
            oos.flush();

            System.out.println("Da gui cho Client");

            ois.close();
            oos.close();
            client.close();
        } catch (Exception e) {
        }
    }
}