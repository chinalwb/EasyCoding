package easycoding.ch06.resize;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

public class ResizeDemo {
    public static void main(String[] args) {
//        MyArrayList<Integer> myArrayList = new MyArrayList<>();
//        for (int i = 0; i < 1002; i++) {
//            myArrayList.add(i);
//            myArrayList.printCapacity();
//        }

        HashMap myHashMap = new HashMap();
        for (int i = 0; i < 1001; i++) {
            myHashMap.put(new MyInteger(i), i);
            if (i == 10) {
                int x = i + 1;
                System.out.println(x);
            }
//            ((MyHashMap) myHashMap).printCapacity();
        }
    }
}
