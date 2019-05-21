/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

/**
 *
 * @author wliu
 */
public class DecryptClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
