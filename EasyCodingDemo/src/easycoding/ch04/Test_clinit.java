/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04;

/**
 *
 * @author wliu
 */
public class Test_clinit {
    private static int x = 1;
    static {
        x = loadX();
    }
    
    private static int loadX() {
        return 2;
    }
    
    public static void main(String[] args) {
        System.out.println("x == " + x);
        
        A a = new A();
        a.test();
    }
}


class A {
    static int x = 1;
    
    static {
        x = 100 / getDivisor();
    }

    static int getDivisor() {
        return 0;
    }
    
    void test() {
        System.out.println("In class A");
    }
}