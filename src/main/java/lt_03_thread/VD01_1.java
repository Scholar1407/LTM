package lt_03_thread;

public class VD01_1 {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.start();
        t2.start();

        try {
            // Luong thu 3 thuc thi tre hon luong thu nhat 2s
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 20) {
            System.out.println(getName() + " " + i);
            i++;
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


