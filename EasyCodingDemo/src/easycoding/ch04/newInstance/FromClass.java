package easycoding.ch04.newInstance;

import sun.misc.Unsafe;

public class FromClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {
        Class clazz = Class.forName("easycoding.ch04.newInstance.MyClass");
//        Object o = clazz.newInstance();
//        System.out.println(o);

//        Object o = Unsafe.getUnsafe().allocateInstance(clazz);
//        System.out.println(o);

        MyClass myClass = new MyClass(new Person("A", 1));
        MyClass m2 = myClass.clone();
        System.out.println(m2.person.name);
    }
}
