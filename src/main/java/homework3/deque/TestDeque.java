package homework3.deque;

public class TestDeque {
    public static void main(String[] args) {
        DequeImpl deque = new DequeImpl(5);

        System.out.println("Insert (1) on the right: " + deque.insertRight(1)); // = insert()
        System.out.println("Insert (2) on the right: " + deque.insertRight(2));
        System.out.println("Insert (8) on the left: " + deque.insertLeft(8));
        System.out.println("Insert (9) on the left: " + deque.insertLeft(9));
        System.out.println("Insert (10) on the left: " + deque.insertLeft(10));
        System.out.println("Insert (11) on the left: " + deque.insertLeft(11));

        System.out.println(deque.size());

        while (!deque.isEmpty()){
            System.out.println(deque.removeRight());
        }
    }
}
