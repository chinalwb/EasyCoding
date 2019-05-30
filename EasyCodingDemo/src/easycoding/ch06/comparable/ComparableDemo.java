package easycoding.ch06.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(6);
        personList.add(new Person("A", 1));
        personList.add(new Person("B", 10));
        personList.add(new Person("C", 3));

        // 升序
        Collections.sort(personList);

        // 降序
        Collections.sort(personList, Collections.reverseOrder());

        System.out.println(personList);
    }
}
