/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

import easycoding.ch04.classLoader.Constants;
import java.lang.reflect.Method;

/**
 * 演示: 在运行时加载class 文件并解密,调用.
 * @author wliu
 */
public class ByPathDecryptClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        ByPathDecryptClassLoader classLoader = new ByPathDecryptClassLoader(Constants.LOAD_PATH);
        Class clazz = classLoader.findClass("easycoding.ch04.classLoader.A_Encrypted");
        if (clazz != null) {
            Object object = clazz.newInstance();
            Method method = clazz.getMethod("test");
            method.invoke(object);
        }
    }
}
