package easycoding.ch07.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemoCheckWindow {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CheckWindow(i, semaphore));
            thread.start();
        }
    }

    static class CheckWindow implements Runnable {

        private Semaphore semaphore;
        private int seq;

        CheckWindow(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();
                System.out.println("The " + seq + " is being worked on...");
                Thread.sleep(Math.abs(new Random().nextInt(10)));
                if (this.seq % 2 == 0) {
                    System.out.println("This is a bad man: " + seq);
                } else {
                    System.out.println("This is a good man: " + seq);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.semaphore.release();
            }
        }
    }
}




