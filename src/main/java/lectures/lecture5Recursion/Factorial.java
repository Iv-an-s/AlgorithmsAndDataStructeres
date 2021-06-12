package lectures.lecture5Recursion;

public class Factorial {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE * Integer.MAX_VALUE);
//        int m = factorial(5);
//        System.out.println(factorial(5));
        System.out.println(tailFact(5));
    }

    private static int factorial(int n) {
        if(n <=1){
            return 1;
        }
        return n * factorial(n-1);
    }

    private static int tailFact(int n){
        return fact(1, n);
    }

    // Хвостовая рекурсия
    private static int fact(int acc, int n){
        if (n < 0){
            throw new IllegalArgumentException("n shuld be 0 or positive value!");
        }
        if (n == 0 || n == 1){
            return acc;
        }

        return fact(acc * n, n - 1);
    }


}
