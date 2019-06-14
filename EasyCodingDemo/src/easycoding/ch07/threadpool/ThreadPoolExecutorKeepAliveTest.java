package easycoding.ch07.threadpool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorKeepAliveTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                6,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4)
        );

        threadPoolExecutor.execute(new Command("A", 2));
        threadPoolExecutor.execute(new Command("B", 4));
        threadPoolExecutor.execute(new Command("C", 10));
        threadPoolExecutor.execute(new Command("D", 10));
        threadPoolExecutor.execute(new Command("E", 10));
        threadPoolExecutor.execute(new Command("F", 10));
        threadPoolExecutor.execute(new Command("G", 10));
        threadPoolExecutor.execute(new Command("H", 10));

        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int activeWorkerCount = threadPoolExecutor.getActiveCount();
                System.out.println("active worker count == " + activeWorkerCount);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000 * 30);

            // 执行这两个任务的是留下来的 core thread
            threadPoolExecutor.execute(new Command("I", 1));
            threadPoolExecutor.execute(new Command("J", 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        System.out.println("Shutdown..");
//        threadPoolExecutor.shutdown();
//        try {
//            threadPoolExecutor.awaitTermination(100 * 1000, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Shutdown finish..");


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
