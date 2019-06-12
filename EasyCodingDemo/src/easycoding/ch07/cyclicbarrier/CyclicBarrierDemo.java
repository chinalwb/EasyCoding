package easycoding.ch07.cyclicbarrier;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 批量打印任务
 * 有一批任务 共有 N 个子任务
 * 有 3 台打印机, 每次都是同时处理
 * 打印完成一批再打印下一批
 */
public class CyclicBarrierDemo {
    private static boolean finished = false;
    private static int processIndex = 0;

    public static void main(String[] args) {
        String[] tasks = {
                "Task - 1",
                "Task - 2",
                "Task - 3",
                "Task - 4",
                "Task - 5",
                "Task - 6",
                "Task - 7",
                "Task - 8",
                "Task - 9",
                "Task - 10",
        };


        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();

        while (!finished) {
            System.out.println(">>>>>> index : " + processIndex);
            CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
            List<String> tasksList = getTasksList(processIndex, tasks);
            cyclicBarrierDemo.doWork(tasksList, cyclicBarrier);
            try {
                cyclicBarrier.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                processIndex += 3;
                System.out.println(">>>>>> Next round:: " + processIndex);
                if (processIndex > tasks.length) {
                    finished = true;
                }
            }
        }

        System.out.println("Completed!");
    }

    private static List<String> getTasksList(int startIndex, String[] tasks) {
        int endIndex = Math.min(startIndex + 3, tasks.length);
        String[] newTasks = Arrays.copyOfRange(tasks, startIndex, endIndex);
        List<String> tasksList = Arrays.asList(newTasks);
        return tasksList;
    }

    private void doWork(List<String> tasksList, CyclicBarrier cyclicBarrier) {
        for (String task : tasksList) {
            Thread thread = new Thread(new Printer(task, cyclicBarrier));
            thread.start();
        }
    }

    static class Printer implements Runnable {

        private String task;
        private CyclicBarrier cyclicBarrier;

        Printer(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {
                Random random = new Random();
                int costTime = random.nextInt(5);
                System.out.println(task + " needs: " + costTime + " seconds");
                Thread.sleep(costTime * 1000);
//                int numberWaiting = cyclicBarrier.getNumberWaiting();
//                System.out.println(">> Number Waiting == " + numberWaiting);
                System.out.println("Task == " + task);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
