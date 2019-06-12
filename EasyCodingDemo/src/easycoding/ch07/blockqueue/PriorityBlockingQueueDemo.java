package easycoding.ch07.blockqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<Person> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.put(new Person("Z"));
        priorityBlockingQueue.put(new Person("A"));
        try {
            while (!priorityBlockingQueue.isEmpty()) {
                Person p = priorityBlockingQueue.take();
                System.out.println(p.name);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Person implements Comparable<Person> {
        private String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }
}
