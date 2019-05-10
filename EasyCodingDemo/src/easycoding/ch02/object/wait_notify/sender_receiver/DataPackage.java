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
public class DataPackage {
    private String data;
    private boolean processed;
    
    public DataPackage(String data) {
        this.data = data;
    }

    public String getData() {
        this.setProcessed(true);
        return data;
    }

    public void setData(String data) {
        this.data = data;
        this.setProcessed(false);
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
    
    public synchronized void send(String data) {
        try {
            while (!this.isProcessed()) {
                System.out.println("Data has not been processed");
                this.wait();
            }
            
            this.setData(data);
//            System.out.println(">>> set data: " + data);
            Thread.sleep(1000);            
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public synchronized void process() {
        try {
            while (this.isProcessed()) {
                System.out.println("Data has been processed");
                this.wait();
            }
            
            String data = this.getData();
            System.out.println("<<< get data: " + data);
            Thread.sleep(1000);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
