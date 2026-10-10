package lt_03_screen;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class VD04_1 {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream pout = new PipedOutputStream();
        final PipedInputStream pin = new PipedInputStream();

        pout.connect(pin);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 50; i <= 60; i++) {
                        pout.write(i);
                        System.out.println("PipedOutputStream Writing i = " + i);
                        Thread.sleep(1000);
                    }
                    pout.close();

                } catch (IOException | InterruptedException exe) {
                    exe.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    int i;
                    while ((i = pin.read()) != -1) {
                        String loaiSo = (i % 2 == 0) ? "so chan" : "so le";
                        System.out.println("PipedInputStream Reading i = " + i + " -> " + loaiSo);
                    }
                    pin.close();
                } catch (IOException exe) {
                    exe.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}