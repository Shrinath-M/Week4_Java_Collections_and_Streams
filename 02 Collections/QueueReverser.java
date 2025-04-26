import java.util.LinkedList;
import java.util.Queue;

public class QueueReverser {
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Queue<T> reversedQueue = new LinkedList<>();

        // Use a stack to reverse elements
        LinkedList<T> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            reversedQueue.add(stack.pop());
        }

        return reversedQueue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        Queue<Integer> reversedQueue = reverseQueue(queue);
        System.out.println("Reversed Queue: " + reversedQueue);
    }
}

