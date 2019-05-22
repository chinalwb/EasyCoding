/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.urlClassLoaderDemo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import java.lang.reflect.Method;
import java.net.URI;

/**
 * 从指定目录下加载一个 class 文件
 * 
 * 实验方式:
 * 编译之后把本项目中的 A.class 复制到 /Users/wliu/Documents/Android/GitHub/EasyCoding/testDir
 * 然后运行本类
 * 
 * @author wliu
 */
public class LoadFromSpecificFilePath {

    private final static String LOAD_PATH = "/Users/wliu/Documents/Android/GitHub/EasyCoding/testDir";

    public static void main(String[] args) {
        try {
            File loadDir = new File(LOAD_PATH);
            // 从本地加载
            URI uri = loadDir.toURI();
            
            // 从网络加载
            // URI uri = new URI("http://localhost/myweb/easycoding.jar");
            URL[] urls = new URL[1];
            urls[0] = uri.toURL();
            URLClassLoader classLoader = new URLClassLoader(urls, LoadFromSpecificFilePath.class.getClassLoader());
            Class clazz = classLoader.loadClass("easycoding.ch04.classLoader.A");
            Object aObject = clazz.newInstance();
            Method method = clazz.getMethod("test", null);
            method.invoke(aObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


