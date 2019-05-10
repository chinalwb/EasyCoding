/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.object.wait_notify.producer_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wliu
 */
public class ProducerConsumerTest {
    
    public static void main(String[] args) {
        List<Integer> taskList = new ArrayList<>();
        Thread producerThread = new Thread(new Producer(taskList, 5));
        Thread consumerThread = new Thread(new Consumer(taskList));
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private final List<Integer> taskList;
    private final int maxSize;
    public Producer(List<Integer> dataList, int maxSize) {
        this.taskList = dataList;
        this.maxSize = maxSize;
    }
    
    @Override
    public void run() {
        int taskId = 0;
        while (true) {
            synchronized(this.taskList) {
                try {
                    while (this.taskList.size() >= this.maxSize) {
                        System.out.println("--- task list is full, wait ----");
                        this.taskList.wait();
                    }
                    
                    
                    ++taskId;
                    this.taskList.add(taskId);
                    System.out.println(">>>> Added new task: " + taskId);
                    Thread.sleep(2000);
                    this.taskList.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


class Consumer implements Runnable {

    private final List<Integer> taskList;
    
    public Consumer(List<Integer> taskList) {
        this.taskList = taskList;
    }

    
    @Override
    public void run() {
        while (true) {
            synchronized (this.taskList) {
                try {
                    while (this.taskList.isEmpty()) {
                        System.out.println("---- TaskList is empty, wait ----");
                        this.taskList.wait();
                    }
                    
                    Thread.sleep(1000);
                    int taskId = this.taskList.remove(0);
                    System.out.println("<<<< get task: " + taskId);
                    this.taskList.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}