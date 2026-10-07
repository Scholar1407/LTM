package lt_03_thread;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockThreadApplication implements Runnable {

    private Thread clock_thread = null;

    public ClockThreadApplication() {
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
            count++;
            System.out.println("Lan " + count + ": " + getTime());
            
            if (count == 10) {
                clock_thread = null;
                break;
            }

            try {
                if (count == 5) {
                    Thread.sleep(3000); // Sau 5 lan hien thi, tam nghi 3 giay
                } else {
                    Thread.sleep(1000); // Hien thi moi giay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ClockThreadApplication clock = new ClockThreadApplication();
        clock.startClock();
    }
}

