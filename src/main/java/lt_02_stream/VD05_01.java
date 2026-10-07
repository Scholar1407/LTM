package lt_02_stream;

import java.util.Scanner;

public class VD05_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ten = "";
        int tuoi = -1;

        // Ràng buộc tên: không được để trống
        while (true) {
            System.out.print("Nhap ten: ");
            ten = sc.nextLine().trim();
            if (!ten.isEmpty()) {
                break;
            }
            System.out.println("Loi: Ten khong duoc de trong. Vui long nhap lai!");
        }

        // Ràng buộc tuổi: phải là số nguyên dương hợp lệ (1 - 120)
        while (true) {
            System.out.print("Nhap tuoi: ");
            String inputTuoi = sc.nextLine().trim();
            try {
                tuoi = Integer.parseInt(inputTuoi);
                if (tuoi > 0 && tuoi <= 120) {
                    break;
                } else {
                    System.out.println("Loi: Tuoi phai trong khoang tu 1 den 120. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Tuoi phai la mot so nguyen. Vui long nhap lai!");
            }
        }

        System.out.println("Xin chao " + ten + ", ban " + tuoi + " tuoi.");
        sc.close();
    }
}

