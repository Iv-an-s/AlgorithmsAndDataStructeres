package homework2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] bigArray = createBigArray(100);
        for (int i = 0; i < bigArray.length; i++) {
            System.out.println(bigArray[i]);
        }
    }

    private static int[] createBigArray(int size) {
        int[] bigArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt(1000);
        }
        return bigArray;
    }


}
