package lectures.lecture6Trees;

public interface Tree<E extends Comparable<? super E>> {

    boolean isBalanced();

    enum TraverseMode {
        IN_ORDER,  // в порядке возрастания
        PRE_ORDER, // сначала родитель, затем дочерние элементы
        POST_ORDER // сначала потомки, затем родитель
    }

    boolean add(E value);

    boolean contains(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraverseMode mode); // обход дерева в нужном порядке (mode)
}
