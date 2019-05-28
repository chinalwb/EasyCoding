package easycoding.ch06.resize;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {
    private int capacity = 0;

    public MyArrayList() {
        super();
    }

    public MyArrayList(int capacity) {
        super(capacity);
    }


    public void printCapacity() {
        try {
            Field elementData = ArrayList.class.getDeclaredField("elementData");
            elementData.setAccessible(true);
            Object[] arr = (Object[]) elementData.get(this);
            if (arr.length != capacity) {
                capacity = arr.length;
                System.out.println("Capacity == " + arr.length + ", size == " + this.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
