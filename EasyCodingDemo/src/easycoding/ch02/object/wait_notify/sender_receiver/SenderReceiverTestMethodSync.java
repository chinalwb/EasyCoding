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
public class SenderReceiverTestMethodSync {
    public static void main(String[] args) throws Exception {
        DataPackage dataPackage = new DataPackage("Init");
        Thread senderThread = new Thread(new MethodSender(dataPackage));
        Thread receiverThread = new Thread(new MethodReceiver(dataPackage));
        senderThread.start();
        receiverThread.start();
    }
}

class MethodSender implements Runnable {

    private int count;
    private final DataPackage dataPackage;
    public MethodSender(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
    }
    
    @Override
    public void run() {
        while (true) {
            this.dataPackage.send("Data - " + ++count);
        }
    }
    
}

class MethodReceiver implements Runnable {

    private final DataPackage dataPackage;

    public MethodReceiver(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
    }
    
    @Override
    public void run() {
        while (true) {
            this.dataPackage.process();
        } 
    }
    
}
