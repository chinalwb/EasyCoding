package easycoding.ch06.comparator;

public class Cup extends Vessel {
    String name;
    int size;
    public Cup(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", size = " + this.size;
    }
}
