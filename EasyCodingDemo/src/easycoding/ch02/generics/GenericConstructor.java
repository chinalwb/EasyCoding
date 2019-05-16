/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.generics;

/**
 *
 * @author wliu
 */
public class GenericConstructor<T, E> {
 
    private T x;
    public GenericConstructor(E e) {
        // E 是泛型参数
    }
    
    public <E> E doSomething(E[] eArr) {
        return eArr[0];
    }
}
