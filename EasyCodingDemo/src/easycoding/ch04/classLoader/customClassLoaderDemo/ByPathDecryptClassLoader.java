/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.classLoader.customClassLoaderDemo;

import easycoding.ch04.classLoader.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * 自定义类加载器, 加载指定目录下的加密文件.
 * 
 * @author wliu
 */
public class ByPathDecryptClassLoader extends ClassLoader {

    private final String loadDir;

    public ByPathDecryptClassLoader(String loadDir) {
        this.loadDir = loadDir;
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.contains("A_")) {
            byte[] bytes = loadClassBytes(name);
            if (bytes == null) {
                System.err.println("Cannot find class");
                return null;
            }
            return defineClass(name, bytes, 0, bytes.length);
        }

        return null;
    }

    private byte[] loadClassBytes(String name) {
        System.out.println("load class bytes.");
        String classPath = name.replaceAll("\\.", "/") + ".class";
         String loadPath = this.loadDir + "/" + classPath;
        try {
            InputStream keyInputStream = new FileInputStream(Constants.LOAD_PATH + "/DES_bytes.dat");
            byte[] keyBytes = new byte[keyInputStream.available()];
            keyInputStream.read(keyBytes);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            File file = new File(loadPath);
            InputStream classInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher)) {
                int b;
                while ((b = classInputStream.read()) != -1) {
                    cipherOutputStream.write(b);
                }
            }

            byte[] classData = byteArrayOutputStream.toByteArray();
            return classData;
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
