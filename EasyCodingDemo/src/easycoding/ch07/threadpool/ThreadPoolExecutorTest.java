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
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4)
        );

        threadPoolExecutor.execute(new Command("A"));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        threadPoolExecutor.execute(new Command("B"));
        threadPoolExecutor.execute(new Command("C"));
        threadPoolExecutor.execute(new Command("D"));
        threadPoolExecutor.execute(new Command("E"));
        threadPoolExecutor.execute(new Command("F"));
        threadPoolExecutor.execute(new Command("G"));
        threadPoolExecutor.execute(new Command("H"));
        threadPoolExecutor.execute(new Command("I"));
    }

    static class Command implements Runnable {
        private String task;
        Command(String task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 1);
                System.out.println(new Date() + " - " + Thread.currentThread().getName() + " : " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
