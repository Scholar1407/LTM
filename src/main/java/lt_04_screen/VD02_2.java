package lt_04_screen;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class VD02_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten mien can doc (vd: vnexpress.net): ");
        String input = sc.nextLine().trim();

        if (!input.startsWith("http://") && !input.startsWith("https://")) {
            input = "https://" + input;
        }

        String fileName = makeSafeFileName(input) + ".html";
        File outputFile = new File(fileName);

        try {
            URL u = new URL(input);
            URLConnection uc = u.openConnection();

            uc.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) "
                    + "Chrome/120.0 Safari/537.36");

            try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8));
                 BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputFile),
                                StandardCharsets.UTF_8))) {

                String thisLine;
                int lineCount = 0;

                while ((thisLine = br.readLine()) != null) {
                    bw.write(thisLine);
                    bw.newLine();
                    lineCount++;
                }

                System.out.println("\n=== KET QUA ===");
                System.out.println("URL        : " + input);
                System.out.println("File luu   : " + outputFile.getAbsolutePath());
                System.out.println("So dong    : " + lineCount);
                System.out.println("Kich thuoc : " + outputFile.length() + " bytes");
            }

            openInBrowser(outputFile);

        } catch (MalformedURLException e) {
            System.err.println("URL khong hop le: " + input);
            System.err.println("Chi tiet: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Khong the doc noi dung tu: " + input);
            System.err.println("Chi tiet: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static String makeSafeFileName(String url) {
        String name = url.replaceFirst("^https?://", "");
        name = name.replaceAll("[/\\\\:*?\"<>|]", "_");
        if (name.endsWith("_")) {
            name = name.substring(0, name.length() - 1);
        }
        if (name.isEmpty()) {
            name = "page";
        }
        return name;
    }

    private static void openInBrowser(File file) {
        try {
            if (Desktop.isDesktopSupported()
                    && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(file.toURI());
                System.out.println("\nDa mo file bang trinh duyet mac dinh.");
            } else {
                System.out.println("\nKhong ho tro mo trinh duyet tu dong.");
                System.out.println("Ban co the mo thu cong file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Khong the mo file: " + e.getMessage());
            System.out.println("Ban co the mo thu cong file: " + file.getAbsolutePath());
        }
    }
}