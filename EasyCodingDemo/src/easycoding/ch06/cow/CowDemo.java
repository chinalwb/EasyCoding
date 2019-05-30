package easycoding.ch06.cow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CowDemo {
    public static void main(String[] args) {

        List<Long> copy = new CopyOnWriteArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 20*10000; i++) {
            copy.add(System.nanoTime());
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000 / 1000);
    }
}
