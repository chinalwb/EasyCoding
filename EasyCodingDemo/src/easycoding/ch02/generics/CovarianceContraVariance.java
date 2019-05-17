/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wliu
 */
public class CovarianceContraVariance {
    public static void main(String[] args) {
        List<String> stringsList = new ArrayList<>();
        List rawList = stringsList;
        rawList.add(1);
        // ClassCastException
//        for (String x : stringsList) {
//            System.out.println("x == " + x);
//        }
        
        List<Object> objectsList = rawList;
        
        Integer[] myInts = {1,2,3,4};
Number[] myNumber = myInts;
myNumber[0] = 3.14; 
    }
}

