/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch01;

import java.nio.charset.Charset;

/**
 *
 * @author wliu
 */
public class Utf16 {
    public static void main(String[] args) {
        String x = "䆧";
        System.out.println("x.len == " + x.getBytes().length);
        byte[] xBytes = x.getBytes();
        for (byte b : xBytes) {
            System.out.print(" " + Integer.toHexString(b));
        }
        System.out.println("");
        char c = x.charAt(0);
        System.out.println("c == " + c + ", code point == " + Integer.toHexString(c));
        
        String charsetName = Charset.defaultCharset().name();
        System.out.println("Default charset name == " + charsetName);
    }
}
