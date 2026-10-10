package lt_03_screen;

public class VD03_3 {

    static class TableDongBo {

        public synchronized void printTable(int n) {
            System.out.println("=== BANG CUU CHUONG " + n + " ===");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%-10s %2d x %2d = %3d%n",
                        Thread.currentThread().getName(), n, i, n * i);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("--------------------------------");
        }
    }

    static class CuuChuongThread extends Thread {

        private TableDongBo table;
        private int number;

        public CuuChuongThread(TableDongBo table, int number) {
            super("Thread-" + number);
            this.table = table;
            this.number = number;
        }

        @Override
        public void run() {
            table.printTable(number);
        }
    }

    public static void main(String[] args) {
        TableDongBo obj = new TableDongBo();

        for (int i = 2; i <= 10; i++) {
            CuuChuongThread t = new CuuChuongThread(obj, i);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}