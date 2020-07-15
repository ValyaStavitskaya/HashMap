package myCollection;

import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements Collection<E> {

    private Object[] array = new Object[0];

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object object) {
        for (Object o : array) {
            if (o.equals(object))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIteratorForCollection<E>(array);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            System.arraycopy(array, 0, a, 0, size());
        }
        System.arraycopy(array, 0, a, 0, size());
        if (a.length > size())
            a[size()] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = e;
        array = newArray;

        return true;
    }

    private Object[] createCopy(Object[] array) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }


    @Override
    public boolean remove(Object object) {
        if (contains(object)) {
            Object[] result = new Object[array.length - 1];
            int k = 0;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i].equals(object)) {
                    k = 1;
                }

                result[i] = array[i + k];
            }
            array = result;
            return true;

        } else return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        int count = 0;
        for (int i = 0; i < collection.size(); i++) {
            if (contains(collection.toArray()[i]))
                count++;
        }
        if (count == collection.size())
            return true;
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E e : collection) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int count = 0;
        MyArrayList result = new MyArrayList();
        result.array = createCopy(array);
        for (int i = 0; i < collection.size(); i++) {
            if (result.contains(collection.toArray()[i])) {
                result.remove(collection.toArray()[i]);
                count++;
            }
        }
        array = result.array;
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        MyArrayList result = new MyArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < collection.size(); j++) {
                if (array[i].equals(collection.toArray()[j]))
                    result.add(array[i]);
            }
        }
        array = result.array;
        return true;
    }

    @Override
    public void clear() {
        array = new Object[0];

    }

    public Object get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        String result = "";
        for (Object o : array) {
            result += o + ", ";
        }
        if (result.length() != 0)
            result = result.substring(0, result.length() - 2);
        return "[" + result + "]";

    }


}
