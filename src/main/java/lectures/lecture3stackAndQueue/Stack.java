package lectures.lecture3stackAndQueue;

public interface Stack <E>{

    void push (E value);

    E pop();

    E peek();

    int size();

    boolean isEmpty();

    void display();

}
