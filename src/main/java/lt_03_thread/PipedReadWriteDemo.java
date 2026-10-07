package lt_03_thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedReadWriteDemo {

    public static void main(String[] args) throws IOException {
        final PipedOutputStream pout = new PipedOutputStream();
        final PipedInputStream pin = new PipedInputStream();
        pout.connect(pin);
        Thread thread1;
        thread1 = new Thread() {
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
                }
            }
        };
        Thread thread2;
        thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    int i;
                    while ((i = pin.read()) != -1) {
                        String loai = (i % 2 == 0) ? "so chan" : "so le";
                        System.out.println("PipedInputStream Reading i = " + i + " (" + loai + ")");
                    }
                    pin.close();
                } catch (IOException exe) {
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}

