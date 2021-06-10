package lectures.lecture5Recursion;

public class CountDown {
    public static void main(String[] args) {
//        countDownLoop(5);
        countDownRecurtion(5);
    }

    private static void countDownRecurtion(int n) {
        if (n<=0){
            return;
        }
        System.out.println(n);
        countDownRecurtion(--n);

    }

    private static void countDownLoop(int n) {
//        while (true){
        while (n > 0){
            System.out.println(n);
            n--;
//            if (n <= 0){
//                break;
//            }
        }
    }
}
