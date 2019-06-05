package easycoding.ch07.countdownlatch;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CountDownLatch 的主要目标是: 让一个线程等待直到其他线程全部完成了要执行的任务.
 * <p>
 * 继续用 printer 来举例:
 * 现在有 5 个打印任务
 * 3 台打印机
 * 用3 个线程的线程池来完成这些任务
 * 对于单个任务来说: 在执行之前需要先拿到打印机的对象,然后执行任务,完成之后释放打印机资源
 * 对于整体来说: 设置一个 CountDownLatch, 每次执行完毕一个任务就 countdown 一次
 * 一直到全部完毕, count down latch 可以知道全部打印完毕了.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        String[] tasks = new String[]{
                "Task A",
                "Task B",
                "Task C",
                "Task D",
                "Task E",
        };

        PrintService printService = new PrintService(tasks);
        printService.print();

        while (true) {
            Thread.sleep(1000 * 3);
            System.out.println(">>> I am in main thread..");
        }
    }

    static class PrintService {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Semaphore semaphore = new Semaphore(3);
        private String[] tasks;

        PrintService(String[] tasks) {
            this.tasks = tasks;
        }

        void print() {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            Runnable printWorker = () -> {
                System.out.println("Starting printers ...");
                for (int i = 0; i < 5; i++) {
                    executorService.submit(new PrintWorker(semaphore, tasks[i], countDownLatch));
                }

                try {
//                    executorService.awaitTermination(1, TimeUnit.SECONDS);
//                    executorService.shutdownNow();
                    executorService.shutdown();
                    countDownLatch.await();
                    System.out.println("All print tasks have been done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(printWorker);
            thread.start();
        }
    }

    static class PrintWorker implements Runnable {
        private Semaphore semaphore;
        private String task;
        private CountDownLatch countDownLatch;

        PrintWorker(Semaphore semaphore, String task, CountDownLatch countDownLatch) {
            this.semaphore = semaphore;
            this.task = task;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();

                System.out.println("Going to print: " + this.task);
                int r = new Random().nextInt(10);
                System.out.println(this.task + " needs " + r + " seconds");
                Thread.sleep(r * 1000);
                System.out.println(this.task);
                System.out.println(this.task + " done.");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                countDownLatch.countDown();
            }
        }
    }
}
