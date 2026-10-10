package lt_06.lt_06_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ArrayClient {

    private static String formatArray(int[] arr) {
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

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Socket s = new Socket("localhost", 1234);
        System.out.println("Đã kết nối với server!");
        System.out.println();

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        System.out.println();

        Random rand = new Random();
        int[] dat1 = new int[n];
        int[] dat2 = new int[n];

        for (int i = 0; i < n; i++) {
            dat1[i] = rand.nextInt(100) + 1;
            dat2[i] = rand.nextInt(50) + 1;
        }

        System.out.println("Sinh mảng 1 ngẫu nhiên gồm " + n + " phần tử: " + formatArray(dat1));
        System.out.println();
        System.out.println("Sinh mảng 2 ngẫu nhiên gồm " + n + " phần tử: " + formatArray(dat2));
        System.out.println();

        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

        ArrayObject a1 = new ArrayObject();
        a1.setArray(dat1);
        ArrayObject a2 = new ArrayObject();
        a2.setArray(dat2);

        oos.writeObject(a1);
        oos.writeObject(a2);
        oos.flush();

        ArrayObject res = (ArrayObject) ois.readObject();
        int[] r = res.getArray();

        System.out.println("Kết quả nhận được: " + formatArray(r));

        s.close();
        scanner.close();
    }
}

