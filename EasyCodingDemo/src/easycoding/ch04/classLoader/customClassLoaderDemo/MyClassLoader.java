/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author wliu
 */
public class MyClassLoader extends ClassLoader {

    private final String loadDir;

    public MyClassLoader(String loadDir) {
        this.loadDir = loadDir;
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        System.out.println("in loadClass");
//        Class c = super.loadClass(name);
//        System.out.println("c == " + c);
//        return c;
//    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("in findClass");
        byte[] bytes = loadClassBytes(name);
        if (bytes == null) {
            System.err.println("Bytes is null");
            return null;
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassBytes(String className) {
        String classPath = className.replaceAll("\\.", "/") + ".class";
        String loadPath = this.loadDir + "/" + classPath;
        try {
            InputStream inputStream = new FileInputStream(new File(loadPath));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            while ((len = inputStream.read()) != -1) {
                byteArrayOutputStream.write(len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
