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

/**
 * 读取序列化方式保存的密钥对象 并以字节流方式保存
 * @author wliu
 */
public class Skey_DES_SaveAsBytes {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(
                Constants.LOAD_PATH + "/DES_object.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(
                fileInputStream);
        Key key = (Key) objectInputStream.readObject();
        byte[] keyBytes = key.getEncoded();
        FileOutputStream fileOutputStream = new FileOutputStream(
                Constants.LOAD_PATH + "/DES_bytes.dat");
        fileOutputStream.write(keyBytes);
        
        // prints the keybytes content
        for (byte b : keyBytes) {
            System.out.print(b + ",");
        }
        System.out.println("len == " + keyBytes.length);
    }
}
