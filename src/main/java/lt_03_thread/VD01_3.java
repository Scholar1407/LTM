package lt_03_thread;

public class VD01_3 {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(new DemThread());
        worker.start();
        
        worker.join();
        System.out.println("Main: Thread worker da ket thuc.");
    }
}

class DemThread implements Runnable {
    @Override
    public void run() {
        int dem = 0;
        try {
            while (dem <= 10) {
                System.out.println("Dang chay ... dem = " + dem);
                if (dem == 10) {
                    System.out.println("Thread dung tai dem = 10");
                    break;
                }
                dem++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread bi dung boi interrupt khi dang sleep, dem cuoi = " + dem);
        }
    }
}

