package lt_03_thread;

public class VD03_1 {

    public static void main(String[] args) {
        MyThread08[] T = new MyThread08[3];
        for (int i = 0; i < T.length; i++) { // Khởi tạo và chạy lần lượt cả 3 thread 
            T[i] = new MyThread08();
            T[i].start();
        }
    }
}

class MyThread08 extends Thread {

    public static int x = 5;
    public static boolean stop = false;

    public static synchronized void Trans() {
        if (x > 0) { // Kiểm tra còn được trừ hay không 
            try {
                sleep(100);
            } catch (InterruptedException E) {
                return; // Nếu bị ngắt khi đang sleep thì thoát hàm luôn 
            }
            x--;
        }
    }

    @Override
    public void run() {
        do { // Mỗi thread lặp gọi Trans() cho tới khi x không còn dương 
            Trans();
            System.out.println(getName() + ": x = " + x);
        } while (x > 0);
    }
}

