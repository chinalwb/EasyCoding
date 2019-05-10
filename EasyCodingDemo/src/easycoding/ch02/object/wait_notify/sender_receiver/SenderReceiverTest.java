/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.object.wait_notify.sender_receiver;

/**
 *
 * @author wliu
 */
public class SenderReceiverTest {
    public static void main(String[] args) {
        DataPackage dataPackage = new DataPackage("Init data");
        Thread senderThread = new Thread(new Sender(dataPackage));
        Thread receiverThread = new Thread(new Receiver(dataPackage));
        senderThread.start();
        receiverThread.start();
        
    }
}

class Sender implements Runnable {

    private int i = 0;
    private DataPackage dataPackage;
    public Sender(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.dataPackage) {
                try {
                    while (!this.dataPackage.isProcessed()) {
                        this.dataPackage.wait();
                    }
                    Thread.sleep(500);
                    String data = "Data - " + ++i;
                    this.dataPackage.setData(data);
                    System.out.println("Sender sent data >>> " + data);
                    this.dataPackage.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}

class Receiver implements Runnable {
    private DataPackage dataPackage;
    public Receiver(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (this.dataPackage) {
                try {
                    while (this.dataPackage.isProcessed()) {
                        this.dataPackage.wait();
                    }
                    Thread.sleep(2000);
                    String data = this.dataPackage.getData();
                    System.out.println("Receiver processed data >>> " + data);
                    this.dataPackage.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
