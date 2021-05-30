package homework3.deque;

import lectures.lecture3stackAndQueue.queue.Queue;

public interface Deque <E> extends Queue<E> {


    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

}