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
public class GenericWildcard {
    public static void main(String[] args) {
        List<?> xList = new ArrayList<Object>();
        // xList.add("x");
    }
}
