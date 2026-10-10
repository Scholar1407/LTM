package lt_03_screen;

public class VD01_3 {

    public static void main(String[] args) {
        Thread worker = new Thread(new DemThread());
        worker.start();
    }
}

class DemThread implements Runnable {

    @Override
    public void run() {
        int dem = 0;
        try {
            while (dem <= 10) {
                System.out.println("Dang chay... dem = " + dem);
                
                if (dem == 10) {
                    break;
                }
                
                dem++;
                Thread.sleep(500);
            }
            System.out.println("Thread da hoan thanh va dung tai dem = " + dem);
        } catch (InterruptedException e) {
            System.out.println("Thread bi dung boi interrupt() khi dang sleep, dem cuoi = " + dem);
        }
    }
}