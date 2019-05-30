package easycoding.ch06.comparator;

public class MiniCup extends Cup implements Comparable<Cup> {
    public MiniCup(String name, int size) {
        super(name, size);
    }

    @Override
    public int compareTo(Cup o) {
        return this.size > o.size ? 1 : this.size == o.size ? 0 : -1;
    }
}
