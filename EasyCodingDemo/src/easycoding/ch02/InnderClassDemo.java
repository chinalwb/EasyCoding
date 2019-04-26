/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02;

/**
 *
 * @author wliu
 */
public class InnderClassDemo {
    
    static class StaticInnerClass {
        private int s_x = 1;
    }
    
    class InstanceInnerClass {
        private int i_x = 1;
    }
    
    public static void main(String[] args) {
        
        // Local inner class
        class MethodInnerClassA {
            private int m_x = 1;
        }
        
        class MethodInnerClassB {
            private int m_x = 1;
        }
        
        // Anonymous inner class
        (new Thread(){}).start();
        (new Thread(){}).start();
        
        System.out.println("Test Done!");
    }
}
