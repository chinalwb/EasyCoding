package easycoding.ch07.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量同步
 * 一个信号代表一个资源, 在使用资源之前需要先得到 semaphore
 * 用完之后释放
 * 如果得不到需要等待
 *
 * 假设有 10 个需要打印的文档
 * 有 3 台打印机
 * 同时发出打印的命令
 * 3 台打印机需要把这些全部打印完毕
 */
public class SemaphoreDemo {
    public static void main(String[] args) {


    }
}