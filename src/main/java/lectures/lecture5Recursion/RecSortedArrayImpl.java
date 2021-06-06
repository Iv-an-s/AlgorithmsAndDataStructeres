package lectures.lecture5Recursion;

import lectures.aboutArrayList.SortedArrayImpl;

public class RecSortedArrayImpl<E extends Comparable<? super E>> extends SortedArrayImpl<E> {

    @Override

    public int indexOf(E value) {
    return recBinaryFind(value, 0, size - 1);
    }

    private Integer recBinaryFind(E value, int low, int high) {
        if (low > high){  // первый базовый случай. Индексы пересеклись, а элемент не найден
             return -1;
        }

        int mid = low + (high-low)/2;
        if (data[mid].equals(value)){  // второй базовый случай. Элемент найден.
            return mid;
        } else if (value.compareTo(data[mid])>0) { // если поисковое значение больше элемeнта mid
            low = mid + 1;                          // тогда мы изменяем нижнюю границу
            return recBinaryFind(value, low, high);        // и рекурсивно вызываем этот же метод
        } else {                                           // иначе
            return recBinaryFind(value, low, mid-1); // изменяем верхнюю границу и рекурсивно вызываем этот же метод
        }
    }
}
