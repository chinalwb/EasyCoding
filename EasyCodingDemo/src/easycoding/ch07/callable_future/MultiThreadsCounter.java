package easycoding.ch07.callable_future;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * This is a demo for calculating the sum of 1..10,000 with 10 threads
 */
public class MultiThreadsCounter {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int low = 0;
        int up = 10000;
        int threadsCount = 10;
        int[][] tasks = getTasks(low, up, threadsCount);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<>(10);
        CounterTask[] counterTasks = new CounterTask[threadsCount];
        int index = 0;
        for (int[] task : tasks) {
            counterTasks[index] = new CounterTask(task[0], task[1]);
            Future<Integer> future = threadPoolExecutor.submit(counterTasks[index]);
            futureList.add(future);
            index++;
        }

        List<Integer> finishedTask = new ArrayList<>(10);
        int total = 0;
        while (true) {
            for (Future<Integer> future : futureList) {
                if (future.isDone()) {
                    int t = future.get();
                    if (finishedTask.contains(t)) {
                        System.out.println("Already added >>>>>>>>> " + t);
                        continue;
                    }
                    System.out.println("Future is done -- " + future.get());
                    total += t;
                    finishedTask.add(t);
                    System.out.println("Completed tasks: " + finishedTask);
                }
            }

            if (isDone(futureList) && finishedTask.size() == 10) {
                break;
            }
        }

        threadPoolExecutor.shutdown();

        System.out.println(total);
    }

    private static <T> boolean isDone(List<Future<T>> futureList) {
        boolean isDone = true;
        for (Future future : futureList) {
            if (!future.isDone()) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    private static int[][] getTasks(int low, int up, int threadsCount) {
        int totalNumber = up - low;
        int eachTaskCount = totalNumber / threadsCount;
        int[][] tasks = new int[threadsCount][2];
        for (int i = 0; i < threadsCount; i++) {
            int t_low = eachTaskCount * i + 1;
            int t_up = eachTaskCount * i + eachTaskCount;

            if (i == threadsCount - 1 && t_up != up) {
                t_up = up;
            }
            tasks[i][0] = t_low;
            tasks[i][1] = t_up;

            System.out.println("Task " + i + ": low = " + t_low + ", up = " + t_up);
        }
        return tasks;
    }
}



class CounterTask implements Callable<Integer> {

    private int low;
    private int up;

    CounterTask(int low, int up) {
        this.low = low;
        this.up = up;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = low; i <= up; i++) {
            result += i;
        }
        // TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        int s = new Random().nextInt(5);
        System.out.println("low/up = " + low + "/" + up + ", sleep:: " + s);
        Thread.sleep(s);
        System.out.println("low/up = " + low + "/" + up + ", sum == " + result);
        return result;
    }
}
