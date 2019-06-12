package easycoding.ch07.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {

        private BlockingQueue queue = null;
        private int task = 0;

        Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    queue.put(task ++);
                    Thread.sleep(1000);
                    if (task > 10) {
                        break;
                    }
                }
                queue.put(Integer.MAX_VALUE);
                System.out.println(">> Stop producing");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue blockingQueue;

        Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Integer v = (Integer) blockingQueue.take();
                    if (v == Integer.MAX_VALUE) {
                        System.out.println("<< Quit consuming");
                    } else {
                        System.out.println("c = " + v);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


