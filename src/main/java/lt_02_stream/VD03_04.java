package lt_02_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VD03_04 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi tu ban phim: ");
        String input = scanner.nextLine();

        String[] tokens = input.trim().split("\\s+");
        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        StringBuilder stringBuf = new StringBuilder();

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            try {
                integers.add(Integer.parseInt(token));
            } catch (NumberFormatException e1) {
                try {
                    doubles.add(Double.parseDouble(token));
                } catch (NumberFormatException e2) {
                    if (stringBuf.length() > 0) stringBuf.append(" ");
                    stringBuf.append(token);
                }
            }
        }

        String path = "D:\\ASM2-scholar\\Projects\\LTM\\output\\filedata.txt";
        File file = new File(path);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(integers.size());
        for (int n : integers) {
            dos.writeInt(n);
        }
        dos.writeUTF(stringBuf.toString());
        double doubleVal = doubles.isEmpty() ? 0.0 : doubles.get(0);
        dos.writeDouble(doubleVal);
        dos.flush();
        dos.close();

        FileInputStream fis = new FileInputStream(path);
        DataInputStream dis = new DataInputStream(fis);

        int item = dis.readInt();
        System.out.print("So nguyen: ");
        for (int i = 0; i < item; i++) {
            int n = dis.readInt();
            System.out.print(n + " ");
        }
        System.out.println("\nChuoi: " + dis.readUTF());
        System.out.println("So thuc: " + dis.readDouble());

        dis.close();
        scanner.close();
    }
}

