package easycoding.ch06.iterable;

import java.util.Iterator;

public class MyQueue implements Iterable<MyNode> {
    @Override
    public Iterator<MyNode> iterator() {
        return new Iterator<MyNode>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public MyNode next() {
                return null;
            }
        };
    }
}
