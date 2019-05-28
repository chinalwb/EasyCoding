package easycoding.ch06.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Animal> animalsList = new ArrayList<>(8);
        animalsList.add(new Cat("A2", 1.2f));
        animalsList.add(new Cat("A1", 1.1f));
        animalsList.add(new Cat("A5", 1.5f));
        animalsList.add(new Cat("A4", 1.4f));
        animalsList.add(new Cat("A3", 1.3f));
        animalsList.add(new KittyCat("B1", 0.9f));
        animalsList.add(new Tiger("C1", 110f));

        printList(animalsList);

        Collections.sort(animalsList);

        System.out.println("Sorting... >>>>");

        printList(animalsList);
    }

    private static void printList(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
