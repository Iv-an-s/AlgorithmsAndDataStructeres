package lectures.lecture5Recursion;

import lectures.aboutArrayList.Array;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[]array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

//        выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
//        делим на подмассивы, которые больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) { //меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

//   вызов рекурсии для сортировки левой и правой части

        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) {
        int[] x = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length -1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));

    }
}
