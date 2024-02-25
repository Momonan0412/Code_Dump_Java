package Lists;

import java.util.Objects;

public class MyGenList <T> {
    private T[] array;
    private int size;
    private int capacity;

    public MyGenList() {
        capacity = 5;
        size = 0;
        array = (T[]) new Object[capacity];
    }

    public void add(T num) throws ArrayFullException {
        try {
            array[size] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num);
        }
    }

    public void addAt(int pos, T num) throws ArrayFullException {
        if (pos > size + 1 || pos <= 0) {
            throw new InvalidPositionException(size+1);
        }
        try {
            for (int i = size; i >= pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos-1] = num;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(num);
        }
    }

    public boolean remove(Object num) {
        for (int i = 0; i < size; i++) {
            if (num.equals(array[i]) || (num instanceof String && num.toString().equals(array[i].toString()))) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }


    public T removeAt(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        T ans = array[pos-1];
        for (int i = pos-1; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return ans;
    }

    public boolean contains(Object num) {
        for (int i = 0; i < size; i++) {
            if (num.equals(array[i]) || (num instanceof String && num.toString().equals(array[i].toString()))) {
                return true;
            }
        }
        return false;
    }

    public T get(int pos) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        return array[pos-1];
    }

    public T set(int pos, T num) {
        if (pos > size || pos <= 0) {
            throw new InvalidPositionException(size);
        }
        T orig = array[pos-1];
        array[pos-1] = num;
        return orig;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
