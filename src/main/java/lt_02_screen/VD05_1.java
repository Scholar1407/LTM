package lt_02_screen;

import java.util.Scanner;

public class VD05_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int tuoi = sc.nextInt();
        System.out.println("Xin chao " + ten + ", ban " + tuoi + " tuoi.");
        sc.close();
    }
}
