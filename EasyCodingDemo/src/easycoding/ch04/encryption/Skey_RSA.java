/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.encryption;

import easycoding.ch04.classLoader.Constants;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 生成一个密钥对, 分别保存到公钥文件和私钥文件.
 * 
 * @author wliu
 */
public class Skey_RSA {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        // 保存公钥
        FileOutputStream fileOutputStream = new FileOutputStream(Constants.LOAD_PATH + "/RSA_Public_key.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(publicKey);
        
        // 保存私钥
        FileOutputStream privateFileOutputStream = new FileOutputStream(Constants.LOAD_PATH + "/RSA_Private_key.dat");
        ObjectOutputStream privateObjectOutputStream = new ObjectOutputStream(privateFileOutputStream);
        privateObjectOutputStream.writeObject(privateKey);
    }
 
}
