package lectures.lecture3stackAndQueue.stack;

import lectures.lecture3stackAndQueue.queue.PriorityQueue;
import lectures.lecture3stackAndQueue.queue.Queue;
import lectures.lecture3stackAndQueue.queue.QueueImpl;

public class Test3 {
    public static void main(String[] args) {
//        testStack();
//        testQueue();
        testPriorityQueue();
    }

    private static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekFront());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }


    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekFront());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println(stack);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack peek: " + stack.peek());
//        System.out.println("Stack pop: " + removeFromStack(stack));

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
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
