package easycoding.ch06.generics;

import easycoding.ch06.collections.Animal;
import easycoding.ch06.collections.Cat;
import easycoding.ch06.collections.KittyCat;
import easycoding.ch06.collections.Tiger;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        List<Cat> catsList = new ArrayList<>(8);
        catsList.add(new Cat("A", 1.1f));
        catsList.add(new KittyCat("KittyCat", 0.9f));

        List<Object> objectsList = new ArrayList<>();
        List<? extends Animal> animals = catsList;
        List<KittyCat> kittyCatList = new ArrayList<>();
        animals = kittyCatList;


        doX(kittyCatList);
//        doX(animals);
        doX(catsList);
//        doX(objectsList);
    }

    private static void doX(List<? extends Cat> catsList) {

    }
}
