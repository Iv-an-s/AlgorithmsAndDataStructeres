package lectures.aboutArrayList;

public interface Array <E> {

    void add(E value);

    E get(int index);

    boolean remove(E value);

    E remove(int index);

    int indexOf(E value); //Если такого элемента нет, метод должен возвращать -1

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display(); // распечатываем в консоль текущее состояение коллекции

    void sortBubble();

    void sortSelect();

    void sortInsert();

}
