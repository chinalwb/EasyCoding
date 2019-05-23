package easycoding.ch04.classLoader.fileSystemClassLoader;

import easycoding.ch04.classLoader.Constants;

import java.lang.reflect.Method;

public class FileSystemClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        FileSystemClassLoader classLoader1 = new FileSystemClassLoader(Constants.LOAD_PATH);
        FileSystemClassLoader classLoader2 = new FileSystemClassLoader(Constants.LOAD_PATH);
        Class clazz1 = classLoader1.loadClass("easycoding.ch04.classLoader.A");
        Class clazz2 = classLoader2.loadClass("easycoding.ch04.classLoader.A");
        Object a1 = clazz1.newInstance();
        Object a2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setA", Object.class);
        method.invoke(a1, a2);
    }
}
