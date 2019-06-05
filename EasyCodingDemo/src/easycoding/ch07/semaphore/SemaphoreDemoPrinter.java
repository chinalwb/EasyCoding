package easycoding.ch07.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemoPrinter {
    private static final String[] tasks = new String[]{
            "Task A",
            "Task B",
            "Task C",
            "Task D",
            "Task E",
    };

    public static void main(String[] args) {
        PrinterService.print(tasks);
    }


    static class PrinterService {
        private static Semaphore semaphore = new Semaphore(1);
        static void print(String[] tasks) {
            int size = tasks.length;
            for (int i = 0; i < size; i++) {
                Thread thread = new Thread(new Printer(tasks[i], semaphore));
                thread.start();
            }
        }

        static class Printer implements Runnable {
            private Semaphore semaphore;
            private String task;
            Printer(String task, Semaphore semaphore) {
                this.task = task;
                this.semaphore = semaphore;
            }

            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Printing ... " + this.task);
                    int r = new Random().nextInt(10);
                    System.out.println(this.task + " needs " + r + " seconds");
                    Thread.sleep(r * 1000);
                    System.out.println(this.task + " Done..");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }
    }

}