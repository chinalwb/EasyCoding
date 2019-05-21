/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.encryption.symmetric;

import static easycoding.ch04.classLoader.Constants.LOAD_PATH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author wliu
 */
public class DesEncryptClass {

    private final static String KEY_NAME = LOAD_PATH + "/DES_bytes.dat";
    private final static String CLASS_NAME = LOAD_PATH
            + "/easycoding/ch04/classloader/A_Encrypted.class";

    public static void main(String[] args) throws Exception {
        // Gets encrypt key
        FileInputStream fileInputStream = new FileInputStream(KEY_NAME);
        int num = fileInputStream.available();
        byte[] keyBytes = new byte[num];
        fileInputStream.read(keyBytes);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DESede");

        // Reads the class as InputStream
        FileInputStream classInputStream = new FileInputStream(CLASS_NAME);
        byte[] classBytes = new byte[classInputStream.available()];
        classInputStream.read(classBytes);

        // Encypt and output
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(classBytes);
        
        FileOutputStream fileOutputStream = new FileOutputStream(CLASS_NAME);
        fileOutputStream.write(encryptedBytes);
    }
}
