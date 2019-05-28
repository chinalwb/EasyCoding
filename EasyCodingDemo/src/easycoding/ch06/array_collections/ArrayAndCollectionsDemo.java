package easycoding.ch06.array_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAndCollectionsDemo {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3};
        List<Integer> integerList = Arrays.asList(integerArray);
        // 编译通过 运行出错.
        // 因为 asList 返回的不是 ArrayList 而是Arrays中的一个内部类
        integerList.add(4);

        // List.toArray(T[] arr)
        // 传入一个数组, 这个数组的长度应该跟 list 的 size 一致
        // 此时运行效率是最高的
        // 如果数组的长度小于list 的 size, 则传入的数组对象直接被弃用
        // 然后根据 list 的 size 创建一个新的数组
        Integer[] getFromArray = new Integer[integerList.size()];
        integerList.toArray(getFromArray);
        System.out.println(getFromArray[0]);

    }
}
