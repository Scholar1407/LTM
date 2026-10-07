package lt_03_thread;

class TableDongBo {

    synchronized void printTable(int n) {
        System.out.println("--- Bảng cửu chương " + n + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d x %2d = %3d%n", n, i, n * i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThreadDongBo extends Thread {

    TableDongBo t;
    int n;

    MyThreadDongBo(TableDongBo t, int n) {
        this.t = t;
        this.n = n;
    }

    @Override
    public void run() {
        t.printTable(n);
    }
}

public class TestSynchronization2 {

    public static void main(String args[]) {
        TableDongBo obj = new TableDongBo();
        for (int n = 2; n <= 10; n++) {
            MyThreadDongBo t = new MyThreadDongBo(obj, n);
            t.start();
        }
    }
}

