package lt_04_inetaddress;

import java.net.MalformedURLException;
import java.net.URL;

public class VD02_1 {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://mail.google.com:80/mail");
            System.out.println("The protocol is: " + u.getProtocol());
            System.out.println("The host is: " + u.getHost());
            System.out.println("The port is: " + u.getPort());
            System.out.println("The file is: " + u.getFile());
            System.out.println("The anchor is: " + u.getRef());
            System.out.println("The query is: " + u.getQuery());
        } catch (MalformedURLException e) { 
        }
    }
}
