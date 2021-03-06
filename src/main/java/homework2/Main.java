package homework2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int size;
    private static int [] bigArray;

    static {
        bigArray = createBigArray(100000);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // bubbleSort(); // 21624 ms. Array has 100 000 elements
        //selectSort();  // 7765 ms. Array has 100 000 elements
        insertSort(); // 2097 ms. Array has 100 000 elements
        System.out.println(System.currentTimeMillis()-start);
    }

    private static void bubbleSort(){
        for (int i = 0; i < bigArray.length-1; i++){
            for (int j = 0; j < bigArray.length - i-1; j++) {
                if (bigArray[j] > bigArray[j+1]){
                    int temp = bigArray[j+1];
                    bigArray[j+1] = bigArray[j];
                    bigArray[j]=temp;
                }
            }
        }
    }

    private static void selectSort(){
        for (int i = 0; i < size-1; i++) {
            int tempIndex = i;
            for (int j = i+1; j < size; j++) {
                if (bigArray[tempIndex]>bigArray[j]){
                    tempIndex = j;
                }
            }
            int temp = bigArray[tempIndex];
            bigArray[tempIndex] = bigArray[i];
            bigArray[i] = temp;
        }
    }

    private static void insertSort(){
        for (int i = 1; i < size ; i++) {
            int temp = bigArray[i];
            int index = i;
            while (index > 0 && bigArray[index-1] > temp){
                bigArray[index] = bigArray[index-1];
                index--;
            }
            bigArray[index] = temp;
        }


    }


    private static void display(int [] array){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size-1; i++){
            sb.append(array[i]);
            sb.append(", ");
        }
        sb.append(array[size-1]);
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static int findElement(int element) { // ???????????????????? ???????????? ???????????????????? ????????????????, ?????????? -1
        for (int i = 0; i < size; i++) {
            if (bigArray[i] == element){
                return i;
            }
        }
        return -1;
    }

    private static void addElement(int element) {  // ?????????????????? ?? ?????????? ??????????????
        checkAndGrow();
        bigArray[size] = element;
        size++;
    }

    private static int calculateVolume(int arraylength) {
        return arraylength == 0 ? 1 : arraylength * 2;
    }

    private static void checkAndGrow() {
        if (Main.size == bigArray.length){
            Arrays.copyOf(bigArray, calculateVolume(bigArray.length));
        }
    }

    private static int deleteElement(int index) {
        if(index<0 || index >= size) {
            String errorMsg = String.format("Incorrect 'index': %d; max value is: %d", index, size-1);
            throw new IndexOutOfBoundsException(errorMsg);
        }

            int removedValue = bigArray[index];
            if ((size - index - 1) > 0){
                System.arraycopy(bigArray, index +1, bigArray, index, size - index -1);
            }
            bigArray [--size] = 0; //  ???????????????????? ?????????? ???????????????????? ???????????????? ?????? ?????????????? ????????????????????????????, ?? ?????????? ????????????????????
            return removedValue;
        }

    private static int[] createBigArray(int size) {
        int[] bigArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt(1000);
        }
        Main.size = size;
        return bigArray;
    }
}
