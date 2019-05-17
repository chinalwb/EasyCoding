/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.generics.pecs;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author wliu
 */
public class Pe {
    private List<Fruit> fruitsList = new ArrayList<>();
    
    public static void main(String[] args) {
        List<Fruit> fruitsList = new ArrayList<Fruit>();
        fruitsList.add(new Apple());
        fruitsList.add(new Fruit());
        List<? extends Object> peList = fruitsList;
        // error because <? extends T> doesn't allow to put in elements 
//         peList.add(new Apple());
//        for (Fruit f : peList) {
//            System.out.println("f == " + f);
//        }
    }
    
    /**
     * Producer extends.
     * 
     * 生产者继承.
     * 只读!
     * 
     */
    private void peMethodAddAll(List<? extends Fruit> peList) {
        this.fruitsList.addAll(peList);
    }
    
    
}

class Fruit {

    @Override
    public String toString() {
        return "I am fruit";
    }
    
}

class Apple extends Fruit {

    @Override
    public String toString() {
        return "I am apple";
    }
}

class AsianApple extends Apple {

    @Override
    public String toString() {
        return "I am Asian apple";
    }

    
}

