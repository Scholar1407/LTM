package lt_04_screen;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class VD02_3 {

    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
          + "AppleWebKit/537.36 (KHTML, like Gecko) "
          + "Chrome/120.0 Safari/537.36";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten mien can doc (vd: tuoitre.vn): ");
        String input = sc.nextLine().trim();

        if (!input.startsWith("http://") && !input.startsWith("https://")) {
            input = "https://" + input;
        }

        String fileName = makeSafeFileName(input) + ".html";
        File outputFile = new File(fileName);

        try {
            URL u = new URL(input);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Language", "vi-VN,vi;q=0.9,en;q=0.8");

            conn.setInstanceFollowRedirects(true);
            conn.setConnectTimeout(10_000);
            conn.setReadTimeout(15_000);

            conn.connect();

            int status = conn.getResponseCode();
            System.out.println("\n=== THONG TIN KET NOI ===");
            System.out.println("URL goc    : " + input);
            System.out.println("URL cuoi   : " + conn.getURL());
            System.out.println("HTTP status: " + status + " " + conn.getResponseMessage());

            if (status != HttpURLConnection.HTTP_OK) {
                System.err.println("Server tra ve ma loi: " + status);
                return;
            }

            int lineCount = 0;
            try (InputStream in = conn.getInputStream();
                 BufferedWriter bw = new BufferedWriter(
                         new OutputStreamWriter(
                                 new FileOutputStream(outputFile),
                                 StandardCharsets.UTF_8))) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                StringBuilder lineBuf = new StringBuilder();

                while ((bytesRead = in.read(buffer)) != -1) {
                    String chunk = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    for (int i = 0; i < chunk.length(); i++) {
                        char c = chunk.charAt(i);
                        if (c == '\n') {
                            bw.write(lineBuf.toString());
                            bw.newLine();
                            lineBuf.setLength(0);
                            lineCount++;
                        } else if (c != '\r') {
                            lineBuf.append(c);
                        }
                    }
                }
                if (lineBuf.length() > 0) {
                    bw.write(lineBuf.toString());
                    lineCount++;
                }
            }

            System.out.println("\n=== KET QUA ===");
            System.out.println("File luu   : " + outputFile.getAbsolutePath());
            System.out.println("So dong    : " + lineCount);
            System.out.println("Kich thuoc : " + outputFile.length() + " bytes");

            openInBrowser(outputFile);

        } catch (MalformedURLException e) {
            System.err.println("URL khong hop le: " + input);
        } catch (IOException e) {
            System.err.println("Loi mang khi doc: " + input);
            System.err.println("Chi tiet: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static String makeSafeFileName(String url) {
        String name = url.replaceFirst("^https?://", "");
        name = name.replaceAll("[/\\\\:*?\"<>|]", "_");
        if (name.endsWith("_")) name = name.substring(0, name.length() - 1);
        return name.isEmpty() ? "page" : name;
    }

    private static void openInBrowser(File file) {
        try {
            if (Desktop.isDesktopSupported()
                    && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(file.toURI());
                System.out.println("\nDa mo file bang trinh duyet mac dinh.");
            } else {
                System.out.println("\nKhong ho tro mo trinh duyet tu dong.");
                System.out.println("Mo thu cong: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Khong the mo file: " + e.getMessage());
        }
    }
}