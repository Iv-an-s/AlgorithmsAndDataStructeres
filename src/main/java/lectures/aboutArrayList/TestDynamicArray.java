package lectures.aboutArrayList;

import lectures.lecture5Recursion.RecSortedArrayImpl;

public class TestDynamicArray {

    public static void main(String[] args) {

        //Array<Integer> data = new ArrayImpl<Integer>(4);
        //Array<Integer> data = new SortedArrayImpl<>();
        Array<Integer>data = new RecSortedArrayImpl<>();

        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);

        data.display();

        //data.sortBubble();
        //data.sortSelect();
        data.sortInsert();

        data.display();

        data.remove(Integer.valueOf(3)); // Объектная обертка нужна чтобы явно показать, что передаем значение а не индекс
        data.remove(2);
        data.display();

        System.out.println("data[1] = " + data.get(1));
        System.out.println("Find 4: " + data.contains(4));
        System.out.println("Find 2: " + data.contains(2));
        System.out.println("Find 222: " + data.contains(222));
    }
}
