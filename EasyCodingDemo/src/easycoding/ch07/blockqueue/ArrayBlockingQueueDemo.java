package easycoding.ch07.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
//        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(2);
        Thread producer = new Thread(new Putter(linkedBlockingQueue));
        Thread consumer = new Thread(new Taker(linkedBlockingQueue));
        producer.start();
        consumer.start();
    }

    static class Putter implements Runnable {
        private BlockingQueue blockingQueue;
        private Putter(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    this.blockingQueue.add("" + i);// add 直接抛出异常: java.lang.IllegalStateException: Queue full
                    System.out.println("Put : " + i);
                    Thread.sleep(100);
                }
                this.blockingQueue.put("E");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Taker implements Runnable {
        private BlockingQueue<String> blockingQueue;
        private Taker(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(3000);
                    String v = this.blockingQueue.take();
                    System.out.println("Take : " + v);
                    if (v.equals("E")) {
                        System.out.println("End");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
