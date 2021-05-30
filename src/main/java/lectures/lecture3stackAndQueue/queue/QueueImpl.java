package lectures.lecture3stackAndQueue.queue;

public class QueueImpl<E> implements Queue<E>{

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;

    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;


    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    // O(1)
    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length -1){
            tail = TAIL_DEFAULT;
        }

        data[++tail]= value; //инкрементируем tail перед присваиванием из-за того, что дефолтное значение решили принять как -1
         size++;
        return true;
    }

    // O(1)
    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {  // невалидное значение, по которому уже нельзя обращаться
            head = HEAD_DEFAULT;
        }
        E tempElem = data[head++];
        size--;
        return tempElem;
    }

    // O(1)
    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
