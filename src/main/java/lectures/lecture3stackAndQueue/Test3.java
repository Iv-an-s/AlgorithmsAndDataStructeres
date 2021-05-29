package lectures.lecture3stackAndQueue;

public class Test3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(5);
        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println(stack);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack pop: " + removeFromStack(stack));
    }

    private static Integer removeFromStack(Stack<Integer> stack){
        return !stack.isEmpty() ? stack.pop() : null;
    }

    private static boolean addToStack(Stack<Integer>stack, Integer value){
        if (!stack.isFull()){
            stack.push(value);
            return true;
        }
        return false;
    }
}
