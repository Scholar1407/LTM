package lt_04_inetaddress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class VD02_2 {

    public static void disableSSLCertificateChecking() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        disableSSLCertificateChecking();

        String s = "https://dantri.vn/";  
        String thisLine;  
        String outputPath = "dantri.html";  

        try {
            URL u = new URL(s);  
            try (
                DataInputStream dis = new DataInputStream(u.openStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(dis, "UTF-8"));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))
            ) {
                while ((thisLine = br.readLine()) != null) {
                    System.out.println(thisLine);  
                    bw.write(thisLine);           
                    bw.newLine();                  
                }
                System.out.println("\n[THÔNG BÁO] Đã lưu thành công mã nguồn vào file: " + outputPath);
            } catch (IOException e) {
                System.err.println("Lỗi đọc/ghi dữ liệu: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.err.println("URL không hợp lệ: " + e.getMessage());
        }
    }
}