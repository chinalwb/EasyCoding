package easycoding.ch04.classLoader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * AppClassLoader -> ExtClassLoader -> null (BootstrapClassLoader是 C++ 实现, Java 方法中返回 null) 
 * class loader == sun.misc.Launcher$AppClassLoader@2a139a55
 * class loader == sun.misc.Launcher$ExtClassLoader@7852e922
 * class loader == null
 * 
 * @author wliu
 */
public class ClassLoaderParentsDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderParentsDemo.class.getClassLoader();
        System.out.println("class loader == " + classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println("class loader == " + classLoader);
        }
        
    }
}
