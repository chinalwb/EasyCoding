package easycoding.ch06.collections;

import java.util.Collections;

public class Cat extends Animal {
    public Cat(String name, float weight) {
        super(name, weight);
    }


    @Override
    public String getType() {
        return "Cat";
    }
}
