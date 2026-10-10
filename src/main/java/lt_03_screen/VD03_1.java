package lt_03_screen;

public class VD03_1 {

    public static void main(String[] args) {
        MyThread08[] T = new MyThread08[3];

        for (int i = 0; i < T.length; i++) {
            T[i] = new MyThread08();
            T[i].start();
        }
    }
}

class MyThread08 extends Thread {

    public static int x = 5;
    public static boolean stop = false;

    public static synchronized void Trans() {
        if (x > 0) {
            try {
                sleep(100);
            } catch (InterruptedException E) {
                return;
            }
            x--;
        }
    }

    @Override
    public void run() {
        do {
            Trans();
            System.out.println(Thread.currentThread().getName() + " -> x = " + x);
        } while (x > 0);
    }
}