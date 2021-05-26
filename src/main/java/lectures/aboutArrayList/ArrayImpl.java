package lectures.aboutArrayList;

import java.util.Arrays;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E>{


    private static final int DEFAULT_CAPACITY = 8;

    protected E [] data;
    protected int size; // сколько элементов сейчас в нашей коллекции

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public ArrayImpl(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    // O(1)
    // В ситуации, когда нужно увеличить размерность массива - О(n)
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
        // При постфиксной записи инкремента вначале текущее значение отдается как индекс,
        // и только затем инкрементируется!!!
    }

    protected void checkAndGrow() {
        if (data.length == size){
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    // O(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            String errorMsg = String.format("Incorrect 'index': %d; max value is: %d", index, size-1);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }

    //O(n)
    @SuppressWarnings("SimplifiableConditionalExpression")
    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index == -1 ? false : remove(index) !=null;
    }

    //O(n)
    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedValue = data[index];
        if ((size - index - 1) > 0){
            System.arraycopy(data, index +1, data, index, size - index -1);
        }
        data[--size] = null; //  префиксная форма декремента означает что вначале декрементируем, а затем используем
        return removedValue;
    }

    // O(n)
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size-1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }



    // compare - O(n^2): n проходов, в каждом проходе в худшем случае n сравнений
    // exchange - O(n^2): также n проходв и в худшем случае n замен
    @Override
    public void sortBubble() {
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (data[j].compareTo(data[j+1]) >0){
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    //O(n^2) - compare
    // O(n) - exchange
    @Override
    public void sortSelect() {
        for (int i = 0; i < size-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (data[minIndex].compareTo(data[j])>0){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                swap(i, minIndex);
            }
        }
    }


    //O(n^2) --> O(n) - compare
    //O(n) --> O(0) - exchange
    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in -1].compareTo(temp)>=0){
                data[in] = data[in-1];
                in--;
            }
            data[in] = temp;
        }
    }
}
