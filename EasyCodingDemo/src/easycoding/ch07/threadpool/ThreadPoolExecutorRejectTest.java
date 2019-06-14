package easycoding.ch07.threadpool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                6,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4)
        );

        Runnable monitor = () -> {
            while (true) {
                int wc = threadPoolExecutor.getPoolSize();
                int activeThreadCount = threadPoolExecutor.getActiveCount();
                long taskCount = threadPoolExecutor.getTaskCount();
                long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
                System.out.println("Thread pool: Worker count == " + wc + " active thread count: " + activeThreadCount + ", total task count: " + taskCount + ", completed task count = " + completedTaskCount);
                if (activeThreadCount == 0 && taskCount > 0 && taskCount == completedTaskCount) {
                    System.out.println(">>> Completed all tasks!");
                    threadPoolExecutor.shutdownNow();
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

//        Thread monitorThread = new Thread(monitor);
//        monitorThread.start();

        threadPoolExecutor.execute(new Command("A", 10));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.execute(new Command("B", 4));
        threadPoolExecutor.execute(new Command("C", 10));
        threadPoolExecutor.execute(new Command("D", 10));
        threadPoolExecutor.execute(new Command("E",10));
        threadPoolExecutor.execute(new Command("F", 10));


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.execute(new Command("G", 10));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.execute(new Command("H", 10));


        System.out.println("Shutdown..");
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(100 * 1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Shutdown finish..");


    }

    static class Command implements Runnable {
        private String task;
        private int time;
        Command(String task, int time) {
            this.task = task;
            this.time = time;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * this.time);
                System.out.println(new Date() + " - " + Thread.currentThread().getName() + " : " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
