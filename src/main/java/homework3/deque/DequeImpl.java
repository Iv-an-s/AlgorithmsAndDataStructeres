package homework3.deque;

import lectures.lecture3stackAndQueue.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl <E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == 0){
            head = data.length-1;
            data[head]= value;
        }else{
            data[--head]=value;
        }


        size++;
        return true;

    }

    @Override
    public E removeRight() {

        if (isEmpty()) {
            return null;
        }
        if (tail == TAIL_DEFAULT) {  // невалидное значение, по которому уже нельзя обращаться
            tail = data.length-1;
            E tempElem = data[tail--];
            size--;
            return tempElem;
        } else {
            E tempElem = data[tail--];
            size--;
            return tempElem;
        }
    }

    @Override
    public boolean insertRight(E value) {
        return insert(value);
    }

    @Override
    public E removeLeft() {
        return remove();
    }
}
