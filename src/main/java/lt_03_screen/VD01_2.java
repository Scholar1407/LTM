package lt_03_screen;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class VD01_2 implements Runnable {

    private Thread clock_thread = null;

    public VD01_2() {
        clock_thread = new Thread(this, "Clock");
    }

    public void startClock() {
        clock_thread.start();
    }

    private String getTime() {
        Calendar cl = Calendar.getInstance();
        Date date = cl.getTime();
        DateFormat date_formatter = DateFormat.getTimeInstance();
        return date_formatter.format(date);
    }

    @Override
    public void run() {
        int count = 0;
        Thread my_thread = Thread.currentThread();

        while (clock_thread == my_thread && count < 10) {
            System.out.println(getTime());
            count++;

            if (count == 10) {
                clock_thread = null;
                break;
            }

            try {
                if (count == 5) {
                    Thread.sleep(3000);
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        VD01_2 clock = new VD01_2();
        clock.startClock();
    }
}