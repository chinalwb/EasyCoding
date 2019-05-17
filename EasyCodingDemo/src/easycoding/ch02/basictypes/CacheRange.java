/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.basictypes;

/**
 *
 * @author wliu
 */
public class CacheRange {
    public static void main(String[] args) {
        Long x1 = new Long(127);
        Long x2 = new Long(127);
        System.out.println("x1==x2 : " + (x1 == x2));
        Long x3 = Long.valueOf(127);
        Long x4 = Long.valueOf(127);
        System.out.println("x3 == x4: " + (x3 == x4));
        Long x5 = 127l;
        System.out.println("x3 == x5 " + (x3 == x5));
        
        
        Long x6 = Long.valueOf(128l);
        Long x7 = Long.valueOf(128l);
        System.out.println("x6 == x7: " + (x6 == x7));
        
        
        Long x8 = 126l;
        Long x9 = Long.valueOf(126l);
        x5--;
        System.out.println("x5==x8: " + (x5 == x8));
        System.out.println("x9==x8: " + (x9 == x8));
    }
}
