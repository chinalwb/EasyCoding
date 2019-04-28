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
public class OuterClass {
    
    private static int outer_static_int = 0;
    private static final int outer_static_final_int = 0;
    private final int outer_final_x = 0;
    private int outer_x = -1;
    
    
    private void foo() {
        System.out.println("I am foo in OuterClass!");   
    }
    
    // static inner class
    // Can access to OuterClass's static and static final fields
    // Need to get an instance of OuterClass if wants to access to OuterClass's instance fileds or methods
    private static class StaticInnerClass {
        void test() {
            System.out.println("test = " + outer_static_int + outer_static_final_int);
            OuterClass innerClassDemo = new OuterClass();
            System.out.println("test 2 = " + innerClassDemo.outer_final_x + innerClassDemo.outer_x);
        }
    }
    
    // instance inner class
    // Can access to OuterClass's all types fields
    class InstanceInnerClass {
        // cannot declare a static variable within an instance inner class
        // private static int instance_inner_static = 0;
        
        // can declare a static final one
        private static final int instance_inner_static_final = 0;
        
        void innerTest() {
            outer_static_int = 1;
            System.out.println("outer static final int " + outer_static_final_int);
            outer_x = 1;
            System.out.println("outer final int " + outer_final_x);
            
            // Call method in inner class
            foo();
            // Call outer class's methods
            OuterClass.this.foo();
        }
        
        void foo() {
            System.out.println("I am foo() in InstanceInnerClass");
        }
    }
    
    
    
    public static void main(String[] args) {
        
        // Create an instance of static inner class
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.test();
        
        // Creates an instance of instance inner class
        OuterClass innerClassDemo = new OuterClass();
        InstanceInnerClass instanceInnerClass = innerClassDemo.new InstanceInnerClass();
        instanceInnerClass.innerTest();
        
        // Local inner class
        String xString = "Hello";
        String yString = "World!";
        innerClassDemo.localInnerClassTest(xString, yString);
        
        // Anonymous inner class
        innerClassDemo.anonymousClassTest();
    }
    
    /**
     * 
     * @param xString
     * @param yString 
     */
    private void localInnerClassTest(final String xString, String yString) {
        // this is a local variable, cannot access in local inner class
        int x = 0;
        
        // this is a local constant
        final int y = 0;
        
        // local inner class
        // Same to instance inner class, can access to all type of fields in the OuterClass
        // Plus: it is able to access to the local fields, but only the final ones
        class Greeting {
            // Same as InstanceInnerClass
            // Cannot declare a static variable in local inner class
            // But can declare a static final one
            
            // public static int local_inner_static = 1;
            public static final String farewell = "Bye bye";
            void greeting() {
                // Can access to all types fileds of OuterClass
                outer_static_int = 1;
                System.out.println("outer static final int " + outer_static_final_int);
                outer_x = 1;
                System.out.println("outer final int " + outer_final_x);
                
                // Access to local variables
                // Can only access to constants/final local variables
                // and:
                // Since 1.8. it is possible to access to effectively final variables
                System.out.println("local y == " + y + xString);
            }
        }
        
        // Create an instance of local inner class
        Greeting greeting = new Greeting();
        greeting.greeting();
    }
    
    /**
     * Anonymous class is the same as local inner class except it doesn't has a name
     */
    private void anonymousClassTest() {
        int x = 0;
        final int y = 1;
        new Thread() {
            @Override
            public void run() {
                System.out.println("I am in AnonymousInnerClass run()!" + y);
            }
            
        }.start();
    }
}
