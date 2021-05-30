package lectures.lecture3stackAndQueue.queue;

public class PriorityQueue <E extends Comparable<? super E>> implements Queue <E>{

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int maxSize) {
        this.data = (E[]) new Comparable[maxSize];
    }

    /**
     * В методе insert мы вынуждены в худшем случае делать n операций сравнения и n операций сдвига
     * эффективность оценивается уже не в О(1), как в стеке или в Queue, а в О(N).
     */

    @Override
    // ключ с наименьшим значением - более приоритетный
    public boolean insert(E value) {
        if (isFull()){
            return false;
        }
        int index;
        for (index = size-1; index >=0; index --){
            if (value.compareTo(data[index])>0){  // если принимаемое значение больше в сравнении со значением, расположенным
        // по индексу, значит оно менее приоритетно, и значение в массиве мы должны сдвинуть вправо (освободить место)
                data[index + 1] = data[index];
            }else {
                break;
            }
        }
        data[index +1] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public E peekFront() {
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
    public boolean isFull() {
        return size == data.length;
    }
}
