/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.basictypes;

/**
 *
 * @author wliu
 */
public class StringBuilderTest {

    public static void main(String[] args) throws Exception {
        // 
//        testBuilder();
        testBuffer();
    }

    private static void testBuilder() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            UpdaterRunnableStringBuilder updaterRunnable = new UpdaterRunnableStringBuilder(stringBuilder);
            threads[i] = new Thread(updaterRunnable);
            threads[i].start();
        }
        while (!finish(threads)) {
            Thread.sleep(100);
        }
        System.out.println("string builder length == " + stringBuilder.length());
    }
    
    private static void testBuffer() throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        Thread[] threads = new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            UpdaterRunnableStringBuffer updaterRunnable = new UpdaterRunnableStringBuffer(stringBuffer);
            threads[i] = new Thread(updaterRunnable);
            threads[i].start();
        }
        while (!finish(threads)) {
            Thread.sleep(100);
        }
        System.out.println("string builder length == " + stringBuffer.length());
    }

    private static boolean finish(Thread[] threads) {
        boolean finished = true;
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                finished = false;
                break;
            }
        }
        return finished;
    }
}

class UpdaterRunnableStringBuilder implements Runnable {

    private StringBuilder stringBuilder;

    public UpdaterRunnableStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            this.stringBuilder.append("X");
        }
    }

}

class UpdaterRunnableStringBuffer implements Runnable {

    private StringBuffer stringBuffer;

    public UpdaterRunnableStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            this.stringBuffer.append("X");
        }
    }

}
