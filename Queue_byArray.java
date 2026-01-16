class DynamicQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public DynamicQueue(int initialSize) {
        size = initialSize;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    public void enqueue(int value) {
        // Resize if queue is full
        if (rear == size - 1) {
            resize();
        }

        if (front == -1) {
            front = 0;
        }

        queue[++rear] = value;
        System.out.println("Enqueued: " + value);
    }

    // Resize array (double the size)
    private void resize() {
        int newSize = size * 2;
        int[] newQueue = new int[newSize];

        for (int i = 0; i <= rear; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue;
        size = newSize;

        System.out.println("Queue resized to size: " + size);
    }

    // Dequeue operation
    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = queue[front++];
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek operation
    public int peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

    // Display queue
    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Find minimum element
    public int findMin() {
        int min = queue[front];
        for (int i = front + 1; i <= rear; i++) {
            if (queue[i] < min) {
                min = queue[i];
            }
        }
        return min;
    }

    // Find maximum element
    public int findMax() {
        int max = queue[front];
        for (int i = front + 1; i <= rear; i++) {
            if (queue[i] > max) {
                max = queue[i];
            }
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {

        DynamicQueue q = new DynamicQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);   // resizing occurs here

        q.display();

        System.out.println("Peek element: " + q.peek());

        q.dequeue();
        q.display();

        System.out.println("Minimum element: " + q.findMin());
        System.out.println("Maximum element: " + q.findMax());
    }
}
