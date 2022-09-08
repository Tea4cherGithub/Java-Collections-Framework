package generic.list;

import java.util.Iterator;

public class SimpleList<T> implements ListContainer<T> {

    private T[] array;

    private int size;

    private int modCount;

    public SimpleList(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value) {

    }

    @Override
    public T set(int index, T newValue) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }

        };
    }
}
