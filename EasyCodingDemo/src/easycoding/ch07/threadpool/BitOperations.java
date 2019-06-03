/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch07.threadpool;
//1111111111111111111111111111111
//+ 1
//=
//10000000000000000000000000000000
//11111111111111111111111111111111
/**
 *
 * @author wliu
 */
public class BitOperations {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int y = x + 1;
        System.out.println("x == " + x);
        System.out.println("y == " + y);
        int z = -1;
        System.out.println("x binary string is: " + Integer.toBinaryString(x));
        System.out.println("y binary string is: " + Integer.toBinaryString(y));
        System.out.println("z binary string is: " + Integer.toBinaryString(z));
    }
}
