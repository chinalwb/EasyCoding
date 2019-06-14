package easycoding.ch07.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockQueueDemo {
    public static void main(String[] args) {

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue(4);
        Thread p = new Thread(new Producer(linkedBlockingQueue));
        Thread c = new Thread(new Consumer(linkedBlockingQueue));
        Thread c2 = new Thread(new Consumer(linkedBlockingQueue));
        p.start();
        c.start();
        c2.start();

        Runnable runnable = () -> {
            while (true) {
                int size = linkedBlockingQueue.size();
                System.out.println(">>> size == " + size);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    static class Producer implements Runnable {
        private LinkedBlockingQueue<Integer> linkedBlockingQueue;
        Producer(LinkedBlockingQueue linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            int x = 0;
            while (true) {
                this.linkedBlockingQueue.offer(++x);
                System.out.println(Thread.currentThread().getName() + " : Put " + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private LinkedBlockingQueue<Integer> linkedBlockingQueue;
        Consumer(LinkedBlockingQueue linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                if (this.linkedBlockingQueue.size() == 0) {
                    continue;
                }
                Integer x = this.linkedBlockingQueue.poll();
                System.out.println(Thread.currentThread().getName() + ": Take " + x);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
