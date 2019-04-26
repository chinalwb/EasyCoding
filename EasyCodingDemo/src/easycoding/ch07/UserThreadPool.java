/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch07;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wliu
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);
        
       UserThreadFactory f1 = new UserThreadFactory("第一机房");
       UserThreadFactory f2 = new UserThreadFactory("第二机房");
       
       UserRejectHandler rejectHandler = new UserRejectHandler();
       
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                queue,
                f1,
                rejectHandler
        );
        
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                queue,
                f2,
                rejectHandler
        );
        
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
