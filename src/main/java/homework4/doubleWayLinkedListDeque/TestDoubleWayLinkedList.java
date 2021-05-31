package homework4.doubleWayLinkedListDeque;

public class TestDoubleWayLinkedList {
    public static void main(String[] args) {
        DoubleWayLinkedList <Integer> doubleWayLinkedList = new DoubleWayLinkedList<>();

        doubleWayLinkedList.insertFirst(1);
        doubleWayLinkedList.insertFirst(2);
        doubleWayLinkedList.insertFirst(3);
        doubleWayLinkedList.insertLast(4);
        doubleWayLinkedList.insertLast(5);
        doubleWayLinkedList.insertLast(6);

       doubleWayLinkedList.display();

        System.out.println("-----------");

        for(Integer integer : doubleWayLinkedList){
            System.out.print(integer);
        }

        System.out.println("removed last = " + doubleWayLinkedList.removeLast());
        System.out.println("removed first = " + doubleWayLinkedList.removeFirst());

        doubleWayLinkedList.display();

    }
}
