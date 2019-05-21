/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch04.encryption.symmetric;

import easycoding.ch04.classLoader.Constants;
import java.io.FileInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 读取密钥 对加密内容进行解密
 * @author wliu
 */
public class DesDecryption {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(
                Constants.LOAD_PATH + "/DES_Encrypt.txt");
        int num = fileInputStream.available();
        byte[] encryptedText = new byte[num];
        fileInputStream.read(encryptedText);
        
        FileInputStream keyInputStream = new FileInputStream(
            Constants.LOAD_PATH + "/DES_bytes.dat");
        int keyNum = keyInputStream.available();
        byte[] keyBytes = new byte[keyNum];
        keyInputStream.read(keyBytes);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DESede");
        
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(encryptedText);
        
        String originalString = new String(plainText, "UTF8");
        System.out.println("original String == " + originalString);
    }
}
