public class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    // Insert at beginning
    // Time Complexity: O(1)
    static void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //  Insert at end
    // Time Complexity: O(1)
    static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    //  Display forward
    // Time Complexity: O(n)
    static void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    // Time Complexity: O(n)
    static void displayBackward() {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    //  Delete first node
    // Time Complexity: O(1)
    static void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    //  Delete last node
    // Time Complexity: O(1)
    static void deleteLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    //  Delete by value
    // Time Complexity: O(n)
    static void deleteByValue(int value) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == value) {

                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value " + value + " not found");
    }

    // Delete node before given value
    // Time Complexity: O(n)
    static void deleteBeforeValue(int value) {
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null || temp.prev == null) {
            System.out.println("No node exists before " + value);
            return;
        }

        Node toDelete = temp.prev;

        if (toDelete == head) {
            deleteFirst();
        } else {
            toDelete.prev.next = temp;
            temp.prev = toDelete.prev;
        }
    }

    // Delete node after given value
    // Time Complexity: O(n)
    static void deleteAfterValue(int value) {
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("No node exists after " + value);
            return;
        }

        Node toDelete = temp.next;

        if (toDelete == tail) {
            deleteLast();
        } else {
            temp.next = toDelete.next;
            toDelete.next.prev = temp;
        }
    }

    // Find minimum
    // Time Complexity: O(n)
    static int findMin() {
        Node temp = head;
        int min = Integer.MAX_VALUE;

        while (temp != null) {
            if (temp.data < min)
                min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    //  Find maximum
    // Time Complexity: O(n)
    static int findMax() {
        Node temp = head;
        int max = Integer.MIN_VALUE;

        while (temp != null) {
            if (temp.data > max)
                max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    // MAIN METHOD (All function calls here)
    public static void main(String[] args) {

        // Insert at beginning
        insertAtBeginning(10);
        insertAtBeginning(20);

        // Insert at end
        insertAtEnd(30);
        insertAtEnd(40);
        insertAtEnd(5);
        insertAtEnd(50);
        System.out.println("After Inserting value at beginning and at end: ");
        displayForward();
        displayBackward();
        System.out.println();

        // Delete first & last
        deleteFirst();
        deleteLast();
        System.out.println("Printing value after deleting first and last node: ");
        displayForward();
        System.out.println();

        System.out.println("Deleting node by value(20): ");
        // Delete by value
        deleteByValue(20);
        displayForward();
        System.out.println();
        System.out.println("Deleting the node before value(30): ");

        // Delete before value
        deleteBeforeValue(30);
        displayForward();
        System.out.println();

        System.out.println("Deleting the node after value(20): ");
        // Delete after value
        deleteAfterValue(20);
        displayForward();
        System.out.println();

        System.out.println("Printing after Minimum and maximum: ");
        // Min & Max
        System.out.println("Minimum value: " + findMin());
        System.out.println("Maximum value: " + findMax());
    }
}