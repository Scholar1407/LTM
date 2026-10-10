package lt_06_screen;

import java.io.Serializable;

public class GoiTinFile implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tenFile;
    private byte[] noiDung;
    private String loi;

    public GoiTinFile(String tenFile, byte[] noiDung, String loi) {
        this.tenFile = tenFile;
        this.noiDung = noiDung;
        this.loi = loi;
    }

    public String getTenFile() {
        return tenFile;
    }

    public byte[] getNoiDung() {
        return noiDung;
    }

    public String getLoi() {
        return loi;
    }

    public boolean thanhCong() {
        return loi == null;
    }
}