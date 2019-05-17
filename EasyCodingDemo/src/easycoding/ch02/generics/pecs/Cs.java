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
public class Cs {

    public static void main(String[] args) {
        List<Apple> applesList = new ArrayList<Apple>();
        applesList.add(new Apple());
        applesList.add(new AsianApple());

        // 不能添加元素
        List<? extends Apple> peList = applesList;
        doSomethingForPeList(peList);

        // 可以添加元素 但是讀取出來的是 object -- 泛型丢失
        List<? super Apple> csList = applesList;

        // 添加进去的都是 extends Apple 的类
        csList.add(new AsianApple());
        csList.add(new Apple());
        
        List<Fruit> asianApples = new ArrayList<>();
        // peList = asianApples;
        csList = asianApples;

        // ceList.add(new Fruit()); // compiler error
//        csMethodAddAll(ceList, new Fruit());
    }

    private static <T> boolean csMethodAddAll(List<? super T> tList, T... elements) {
        for (T t : elements) {
            tList.add(t);
        }
        return true;
    }
    
    private static void doSomethingForPeList(List<? extends Apple> apples) {
        
    }
}
