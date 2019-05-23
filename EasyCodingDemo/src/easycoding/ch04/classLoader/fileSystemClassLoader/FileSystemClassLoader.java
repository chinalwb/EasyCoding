package easycoding.ch04.classLoader.fileSystemClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class FileSystemClassLoader extends ClassLoader {
    private String loadDir;

    public FileSystemClassLoader(String loadDir) {
        this.loadDir = loadDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String classPath = this.loadDir;
            URL[] urls = new URL[1];
            urls[0] = new File(classPath).toURI().toURL();
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            return urlClassLoader.loadClass(name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
