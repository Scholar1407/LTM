package lt_06_screen;

import java.io.Serializable;

public class SinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    private String mssv;
    private String hoTen;
    private double diemTB;
    private transient String matKhau;

    public SinhVien(String mssv, String hoTen, double diemTB, String matKhau) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return mssv + " - " + hoTen + " - DTB: " + diemTB + " - Mat khau: " + matKhau;
    }
}