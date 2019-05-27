package easycoding.ch06.collections;

public class Tiger extends Animal {

    public Tiger(String name, float weight) {
        super(name, weight);
    }

    @Override
    public String getType() {
        return "Tiger";
    }
}
