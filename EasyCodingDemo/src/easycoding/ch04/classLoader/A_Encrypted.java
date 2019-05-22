/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader;

/**
 *
 * @author wliu
 */
public class A_Encrypted {
    public void test() {
        ClassLoader classLoader = A_Encrypted.class.getClassLoader();
        System.out.println("I am in A_Encrypted class, class loader = " + classLoader);
    }
    
    public static void main(String[] args) {
        System.out.println("test");
    }
}


// Copy A_Encrypted.class to testDir
// cp /Users/wliu/Documents/Android/GitHub/EasyCoding/EasyCodingDemo/build/classes/easycoding/ch04/classLoader/A_Encrypted.class /Users/wliu/Github/EasyCoding/testDir/easycoding/ch04/classLoader
// 
// run: DesEncryptClass.java
// 
// Copy from testDir to build
// cp /Users/wliu/Github/EasyCoding/testDir/easycoding/ch04/classLoader/A_Encrypted.class /Users/wliu/Documents/Android/GitHub/EasyCoding/EasyCodingDemo/build/classes/easycoding/ch04/classLoader