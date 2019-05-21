/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.encryption.symmetric;

import easycoding.ch04.classLoader.Constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import javax.crypto.Cipher;

/**
 * 读取密钥 对 Hello World 进行加密并保存
 * @author wliu
 */
public class DesEncryption {
    public static void main(String[] args) throws Exception {
        String s = "Hello World!";
        FileInputStream fileInputStream = new FileInputStream(
            Constants.LOAD_PATH + "/DES_object.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(
            fileInputStream);
        Key key = (Key) objectInputStream.readObject();
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] plainText = s.getBytes("UTF8");
        for (byte b : plainText) {
            System.out.print(b + ",");
        }
        System.out.println("");
        byte[] encryptedText = cipher.doFinal(plainText);
        for (byte b : encryptedText) {
            System.out.print(b + ",");
        }
        System.out.println("");
        FileOutputStream fileOutputStream = new FileOutputStream(
                Constants.LOAD_PATH + "/DES_Encrypt.txt");
        fileOutputStream.write(encryptedText);
    }
}
