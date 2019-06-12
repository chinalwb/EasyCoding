package easycoding.ch07.blockqueue;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 2);
        long ms = calendar.getTime().getTime();
        System.out.println("Put ms == " + ms);
        DelayedElement delayedElement = new DelayedElement(ms, "X");
        delayQueue.add(delayedElement);

        try {
            DelayedElement v = delayQueue.take();
            System.out.println(v.data);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DelayedElement implements Delayed {

        private volatile long time;
        private String data;

        DelayedElement (long time, String data) {
            this.time = time;
            this.data = data;
        }

        private long now() {
            long millSeconds = System.currentTimeMillis();
            System.out.println("now ms == " + millSeconds);
            return millSeconds;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long d = unit.convert(time - now(), TimeUnit.MILLISECONDS);
            System.out.println("d == " + d);
            return d;
        }

        @Override
        public int compareTo(Delayed o) {
            return this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS) > 0 ? 1 : 0;
        }
    }
}
