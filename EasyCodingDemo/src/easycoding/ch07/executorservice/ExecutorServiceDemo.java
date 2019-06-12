package easycoding.ch07.executorservice;

import javax.swing.plaf.FontUIResource;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Future<String> future = executorService.submit(() -> {
//            try {
                Thread.sleep(1000 * 5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return "Hello";
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am in runnable, thread = " + Thread.currentThread().getName());
            }
        });

        try {
            if (!future.isDone()) {
                future.cancel(false);
            }
            String v = future.get();
            System.out.println(v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            System.out.println("Cancelled");
        }
        System.out.println("Exit main");

        // 如果不调用 shutdown 方法, main 方法虽然结束了 但是应用不能退出
        executorService.shutdownNow();
    }
}
