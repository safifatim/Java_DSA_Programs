class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {

    private Node front;
    private Node rear;

    // Constructor
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued: " + value);
    }

    // Dequeue operation
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek operation
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Display queue
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find minimum value
    public int findMin() {
        int min = front.data;
        Node temp = front;

        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    // Find maximum value
    public int findMax() {
        int max = front.data;
        Node temp = front;

        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {

        LinkedListQueue q = new LinkedListQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Peek element: " + q.peek());

        q.dequeue();
        q.display();

        System.out.println("Minimum value: " + q.findMin());
        System.out.println("Maximum value: " + q.findMax());
    }
}
