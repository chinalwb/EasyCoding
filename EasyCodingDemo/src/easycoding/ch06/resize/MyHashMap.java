package easycoding.ch06.resize;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MyHashMap extends HashMap {
    private int capacity;
    public MyHashMap() {
        super();
    }

    public MyHashMap(int size) {
        super(size);
    }

    public void printCapacity() {
        try {
            Field thresholdField = HashMap.class.getDeclaredField("threshold");
            thresholdField.setAccessible(true);
            Field loadFactorField = HashMap.class.getDeclaredField("loadFactor");
            loadFactorField.setAccessible(true);

            int threshold = (int) thresholdField.get(this);
            float loadFactor = (float) loadFactorField.get(this);
            int capacityTmp = (int) (threshold / loadFactor);
            if (capacityTmp != this.capacity) {
                this.capacity = capacityTmp;
                System.out.println("Capacity == " + this.capacity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
