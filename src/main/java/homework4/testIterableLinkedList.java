package homework4;

import lectures.lecture4.LinkedList;

public class testIterableLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new IterableSimpleLinkedListImpl<>();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        for(Integer integer : list){
            System.out.println(integer);
        }
    }
}
