package easycoding.ch07.threadpool;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolExecutorRejectTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                6,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                (Runnable r) -> new Thread(r),
                new ThreadPoolExecutor.CallerRunsPolicy()
//                (Runnable r, ThreadPoolExecutor executor) -> {
//                    try {
//                        System.out.println("Rejected ... Keep retrying..");
//                        while (true) {
//                            Thread.sleep(1000);
//                            int qsize = executor.getQueue().size();
//                            System.out.println("queue size now >>> " + qsize);
//                            if (qsize < 4) {
//                                System.out.println("execute runnable");
//                                executor.execute(r);
//                                System.out.println("Shutting down..");
//                                executor.shutdown();
//                                executor.awaitTermination(1000 * 11, TimeUnit.SECONDS);
//                                System.out.println("Shutdown... Done!");
//                                break;
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
        );

        threadPoolExecutor.execute(new Command("A", 10));
        threadPoolExecutor.execute(new Command("B", 10));
        threadPoolExecutor.execute(new Command("C", 10));
        threadPoolExecutor.execute(new Command("D", 10));
        threadPoolExecutor.execute(new Command("E", 10));
        threadPoolExecutor.execute(new Command("F", 10));
        threadPoolExecutor.execute(new Command("G", 10));
        threadPoolExecutor.execute(new Command("H", 10));
        threadPoolExecutor.execute(new Command("I", 10));


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
