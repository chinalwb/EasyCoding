/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.encryption.symmetric;

import easycoding.ch04.classLoader.Constants;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 生成对称密钥 以 序列化的方式存储
 * @author wliu
 */
public class Skey_DES_SaveAsObject {

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(168); // keysize = 168
        SecretKey key = keyGenerator.generateKey();
        FileOutputStream fileOutputStream = new FileOutputStream(
                Constants.LOAD_PATH + "/DES_object.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                fileOutputStream);
        objectOutputStream.writeObject(key);
    }
}
