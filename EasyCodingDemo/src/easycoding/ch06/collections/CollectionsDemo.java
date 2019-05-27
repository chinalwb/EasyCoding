package easycoding.ch06.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> immutableList = Collections.singletonList(1);
//        immutableList.add(2);
        System.out.println(immutableList.size());

        String x = "A";

        int index = Collections.binarySearch(immutableList, 1);
        System.out.println(index);
    }
}
