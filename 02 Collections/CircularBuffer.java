import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }


    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }
    public void displayBuffer() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.displayBuffer();

        buffer.enqueue(4);
        buffer.displayBuffer();

        buffer.enqueue(5);
        buffer.displayBuffer();
    }
}

