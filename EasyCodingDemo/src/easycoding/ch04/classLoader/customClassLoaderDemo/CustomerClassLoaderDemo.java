/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

import easycoding.ch04.classLoader.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author wliu
 */
public class CustomerClassLoaderDemo {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader(Constants.LOAD_PATH);
        try {
            Class<?> clazzA = myClassLoader.findClass("easycoding.ch04.classLoader.A");
            Object object = clazzA.newInstance();
            Method method = clazzA.getMethod("test");
            method.invoke(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
