package easycoding.ch07.scheduledexecutorservice;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("Start :: " + new Date().toString());
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("End :: " + new Date().toString() + " - I am in runnable..");
//            }
//        }, 0, 1000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start :: " + new Date().toString());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("End :: " + new Date().toString() + " - I am in runnable..");
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
