class RecursionProblems {

    // Factorial using recursion
    static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    // Fibonacci using recursion
    static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Sum of array using recursion
    static int sumArray(int[] arr, int index) {
        if (index == arr.length)
            return 0;

        return arr[index] + sumArray(arr, index + 1);
    }

    // Check if array is sorted using recursion
    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1)
            return true;

        if (arr[index] > arr[index + 1])
            return false;

        return isSorted(arr, index + 1);
    }

    // Print array using recursion
    static void printArray(int[] arr, int index) {
        if (index == arr.length)
            return;

        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }

    // Find Minimum using recursion
    static int findMin(int[] arr, int index, int min) {
        if (index == arr.length)
            return min;

        if (arr[index] < min)
            min = arr[index];

        return findMin(arr, index + 1, min);
    }

    // Find Maximum using recursion
    static int findMax(int[] arr, int index, int max) {
        if (index == arr.length)
            return max;

        if (arr[index] > max)
            max = arr[index];

        return findMax(arr, index + 1, max);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Factorial
        System.out.println("Factorial of 5: " + factorial(5));

        // Fibonacci
        System.out.println("Fibonacci at position 6: " + fibonacci(6));

        // Array for operations
        int[] arr1 = {2, 4, 6, 8};

        // Sum of array
        System.out.println("Sum of array: " + sumArray(arr1, 0));

        // Sorted check
        int[] arr2 = {3, 5, 7, 9};
        System.out.println("Is array sorted? " + isSorted(arr2, 0));

        // Print array BEFORE min & max
        System.out.print("Array elements: ");
        printArray(arr1, 0);
        System.out.println();

        // Minimum and Maximum
        System.out.println("Minimum: " + findMin(arr1, 0, arr1[0]));
        System.out.println("Maximum: " + findMax(arr1, 0, arr1[0]));
    }
}
