package lt_03_thread;

public class VD02_1 {

    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r, "Thread-1");
        Thread t2 = new Thread(r, "Thread-2");
        Thread t3 = new Thread(r, "Thread-3");

        // Thread 1 va Thread 3 chay truoc
        t1.start();
        t3.start();

        try {
            // Thread 2 chay sau Thread 3 ba giay (3s)
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
        while (i < 20) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            i++;
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


