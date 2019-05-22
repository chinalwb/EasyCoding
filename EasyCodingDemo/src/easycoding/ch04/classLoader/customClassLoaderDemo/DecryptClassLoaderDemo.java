/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

import java.lang.reflect.Method;

/**
 * 在执行之前需要先把加密的文件放到: /Users/wliu/Github/EasyCoding/EasyCodingDemo/build/classes/easycoding/ch04/classLoader
 * 如何得到加密的文件?
 * 1. 编译 A_Encrypted.java 得到 A_Encrypted.class
 * 2. 把 A_Encrypted.class copy 到 /Users/wliu/Github/EasyCoding/testDir/easycoding/ch04/classloader
 * 3. 运行 easycoding.ch04.encryption.symmetric.DesEncryptClass.java 进行加密
 * 4. 把加密后的文件 copy 到 /Users/wliu/Github/EasyCoding/EasyCodingDemo/build/classes/easycoding/ch04/classLoader
 * 演示: 在运行时加载class 文件并解密,调用.
 * @author wliu
 */
public class DecryptClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        DecryptClassLoader classLoader = new DecryptClassLoader();
        Class clazz = classLoader.loadClass("easycoding.ch04.classLoader.A_Encrypted", false);
        if (clazz != null) {
            Object object = clazz.newInstance();
            Method method = clazz.getMethod("test");
            method.invoke(object);
        }
    }
}
