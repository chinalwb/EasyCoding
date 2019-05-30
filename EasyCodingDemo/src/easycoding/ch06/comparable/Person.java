package easycoding.ch06.comparable;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age > person.age ? 1 : this.age == person.age ? 0 : -1;
    }

    @Override
    public String toString() {
        return "name : " + this.name + ", age = " + this.age;
    }
}
