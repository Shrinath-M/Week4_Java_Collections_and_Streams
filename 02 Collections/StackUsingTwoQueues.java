import java.util.*;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        queue1.add(x);
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Get the last element (top of stack)
        int poppedElement = queue1.remove();

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int topElement = queue1.peek();
        queue2.add(queue1.remove());

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.top());
    }
}
