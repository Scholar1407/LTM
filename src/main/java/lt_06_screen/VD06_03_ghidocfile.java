package lt_06_screen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VD06_03_ghidocfile {

    public static void main(String[] args) {
        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Nhap duong dan file dssv.txt: ");
            String tenFileTxt = myinput.readLine();

            System.out.print("Nhap duong dan file dssv.dat: ");
            String tenFileDat = myinput.readLine();

            ArrayList<SinhVien> ds = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(tenFileTxt))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    String[] parts = line.split("\\|");
                    if (parts.length == 4) {
                        String mssv = parts[0].trim();
                        String hoTen = parts[1].trim();
                        double diemTB = Double.parseDouble(parts[2].trim());
                        String matKhau = parts[3].trim();
                        ds.add(new SinhVien(mssv, hoTen, diemTB, matKhau));
                    }
                }
            } catch (IOException e) {
                System.out.println("Loi doc file txt: " + e);
                return;
            }

            System.out.println("Truoc khi ghi:");
            for (SinhVien sv : ds) {
                System.out.println(" " + sv);
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFileDat))) {
                oos.writeObject(ds);
            } catch (IOException e) {
                System.out.println("Loi ghi file: " + e);
                return;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFileDat))) {
                @SuppressWarnings("unchecked")
                ArrayList<SinhVien> dsDoc = (ArrayList<SinhVien>) ois.readObject();
                System.out.println("Sau khi doc lai tu " + tenFileDat + " (truong transient matKhau bi mat):");
                for (SinhVien sv : dsDoc) {
                    System.out.println(" " + sv);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Loi doc file: " + e);
            }

        } catch (IOException e) {
            System.out.println("Loi nhap lieu: " + e);
        }
    }
}