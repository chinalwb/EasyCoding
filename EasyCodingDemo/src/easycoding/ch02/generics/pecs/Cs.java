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
        List<? super Apple> appleList = null;
        List<Apple> applesList = new ArrayList<Apple>();
        appleList.add(new Apple());
        appleList.add(new AsianApple());
        csMethodAddAll(appleList, new AsianApple());
    }
    
    private static <T> boolean csMethodAddAll(List<? super T> tList, T... elements) {
        for (T t : elements) {
            tList.add(t);
        }
        return true;
    }
}
