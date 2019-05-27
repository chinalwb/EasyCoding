package easycoding.ch06.collections;

public class Cat extends Animal {
    public Cat(String name, float weight) {
        super(name, weight);
    }

    @Override
    public String getType() {
        return "Cat";
    }
}
