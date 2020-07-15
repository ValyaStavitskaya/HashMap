package myCollection;

import java.util.Iterator;

public class MyIteratorForCollection<E> implements Iterator<E> {
    private Object[] data;
    private int index;

    public MyIteratorForCollection(Object[] objects) {
        this.data = objects;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public E next() {
        Object result = data[index];
        index++;
        return (E)result;
    }
}
