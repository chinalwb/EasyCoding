package easycoding.ch04.newInstance;

public class MyClass  implements  Cloneable {
    int x;
    Person person;

    public MyClass(Person person) {
        System.out.println("MyClass constructor gets called!");
        this.person = person;
    }



    @Override
    public MyClass clone() throws CloneNotSupportedException {
        return (MyClass) super.clone();
    }
}
