package easycoding.ch06.concurrenthashmap;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
//        ConcurrentHashMap c;
//        TreeMap treeMap;
//        HashMap hashMap;
//
        int hashCode = new Object().hashCode();
//        System.out.println(hashCode);
//        int hash = hashCode ^ hashCode >>> 16;
//        System.out.println(hash);
        int size = 128;
        int i = 0;
        do {
            i = (size) & (hashCode++);
            System.out.println(hashCode);
            System.out.println(i);
        } while (i != 0);

        Integer.parseInt("1001", 2);


//        int d = hashCode % size;
//        System.out.println(d);
    }
}
