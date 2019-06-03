/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch07.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author wliu
 */
public class UserThreadFactory implements ThreadFactory {

    public final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);
    
    public UserThreadFactory(String featureGroupName) {
        namePrefix = "UserThreadFactory's " + featureGroupName + "-Worker-";
    }
    
    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println("UserThreadFactory - newThread - name - " + thread.getName());
        return thread;
    }
}

class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running - " + count.getAndIncrement());
    }
    
}
