package easycoding.ch04.classLoader.threadContext;

import easycoding.ch04.classLoader.Constants;
import easycoding.ch04.classLoader.customClassLoaderDemo.ByPathDecryptClassLoader;

import java.lang.reflect.Method;

public class ThreadContextClassLoaderDemo {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            try {
//                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//                System.out.println(classLoader);
//                Class clazzA = Class.forName("easycoding.ch04.classLoader.A_Encrypted", true, classLoader);

                ClassLoader classLoader = new ByPathDecryptClassLoader(Constants.LOAD_PATH);
                Class clazzA = classLoader.loadClass("easycoding.ch04.classLoader.A_Encrypted");
                Object object = clazzA.newInstance();
                Method m = clazzA.getMethod("test");
                m.invoke(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        thread.setContextClassLoader(new ByPathDecryptClassLoader(Constants.LOAD_PATH));
        thread.start();
    }
}
