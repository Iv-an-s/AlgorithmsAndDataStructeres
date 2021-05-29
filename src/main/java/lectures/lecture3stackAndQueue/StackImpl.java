package lectures.lecture3stackAndQueue;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E>{

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    // O(1)
    @Override
    public void push(E value) {
        data[size++] = value;
    }

    // O(1)
    @Override
    public E pop() {
        E value = peek();
        data [--size] = null;
        return value;
    }

    // O(1)
    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < (size-1)){
                sb.append("-->");
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public void display() {
        System.out.println(this);
    }
}
