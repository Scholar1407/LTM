package lt_03_screen;

public class VD02_1 {

    public static void main(String[] args) {
        Runnable r1 = new MyRunnable();
        Runnable r2 = new MyRunnable();
        Runnable r3 = new MyRunnable();

        Thread t1 = new Thread(r1, "Thread-1");
        Thread t2 = new Thread(r2, "Thread-2");
        Thread t3 = new Thread(r3, "Thread-3");

        t1.start();
        t3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (i < 50) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            i++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}