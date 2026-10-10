package lt_03_screen;

public class VD03_2 {

    static class Table {

        synchronized void printTable(int n) {
            for (int i = 1; i <= 5; i++) {
                System.out.printf("%-10s %3d x %2d = %4d%n",
                        Thread.currentThread().getName(), n, i, n * i);

                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("--------------------------------");
        }
    }

    static class MyThread1 extends Thread {

        Table t;

        MyThread1(Table t, String name) {
            super(name);
            this.t = t;
        }

        @Override
        public void run() {
            t.printTable(5);
        }
    }

    static class MyThread2 extends Thread {

        Table t;

        MyThread2(Table t, String name) {
            super(name);
            this.t = t;
        }

        @Override
        public void run() {
            t.printTable(100);
        }
    }

    public static void main(String[] args) {
        Table obj = new Table();

        MyThread1 t1 = new MyThread1(obj, "Thread-1");
        MyThread2 t2 = new MyThread2(obj, "Thread-2");

        t1.start();
        t2.start();
    }
}