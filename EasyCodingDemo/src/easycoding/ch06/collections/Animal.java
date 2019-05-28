package easycoding.ch06.collections;

public class Animal implements Comparable<Animal> {

    private String name;
    private float weight;

    public Animal(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal animal) {
        return this.weight > animal.weight ? 1 : this.weight == animal.weight ? 0 : -1;
    }

    public String getType() {
        return "Unknown";
    }

    @Override
    public String toString() {
        return "I am " + getType() + ", my name is: " + name + ", weight is : " + weight;
    }
}
