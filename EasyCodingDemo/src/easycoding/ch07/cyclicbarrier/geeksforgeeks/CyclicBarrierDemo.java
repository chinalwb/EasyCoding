package easycoding.ch07.cyclicbarrier.geeksforgeeks;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// https://www.geeksforgeeks.org/java-util-concurrent-cyclicbarrier-java/
public class CyclicBarrierDemo {
    public static CyclicBarrier newBarrier = new CyclicBarrier(3);
    public static void main(String[] args) {
        Runnable test = ()-> {
            System.out.println("Number of parties required to trip the barrier = " + newBarrier.getParties());
            System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));

            Computation1 computation1 = new Computation1();
            Computation2 computation2 = new Computation2();

            Thread t1 = new Thread(computation1);
            Thread t2 = new Thread(computation2);

            t1.start();
            t2.start();

            try {
                newBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));
            newBarrier.reset();
            System.out.println("Barrier reset successful");
        };

        Thread thread = new Thread(test);
        thread.start();
    }
}

class Computation1 implements Runnable {
    public static int product = 0;

    @Override
    public void run() {
        product = 2 * 3;
        try {
            CyclicBarrierDemo.newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable {
    public static int sum = 0;

    @Override
    public void run() {
        System.out.println("Is the barrier broken? - " + CyclicBarrierDemo.newBarrier.isBroken());
        sum = 10 + 20;
        try {
            Thread.sleep(3000);
            CyclicBarrierDemo.newBarrier.await(3000, TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}