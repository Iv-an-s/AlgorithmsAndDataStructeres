package homework5;

public class Pow {
    private static int accum = 1;
    private static boolean sign = true; // true == +, false == -

    private static double pow(int base, int degree){
        if (degree < 0){
            sign = false;
        }
        if(degree == 0){
            return accum;
        }
        if (degree ==1) {
            accum *= base;
            return accum;
        }
        accum*=base;
        pow(base, Math.abs(degree) -1);
        return sign ? accum : (double) 1/accum;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, -4));
    }
}
