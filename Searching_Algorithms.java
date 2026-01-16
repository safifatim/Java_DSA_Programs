class SearchingAlgorithms {


    static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    //  Binary Search (Recursive)
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    static int binarySearchRecursive(int[] arr, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearchRecursive(arr, mid + 1, high, target);
        else
            return binarySearchRecursive(arr, low, mid - 1, target);
    }

    // Recursive Linear Search
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    static int linearSearchRecursive(int[] arr, int index, int target) {

        if (index == arr.length)
            return -1;

        if (arr[index] == target)
            return index;

        return linearSearchRecursive(arr, index + 1, target);
    }

    // Find Minimum using Recursion
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    static int findMinRecursive(int[] arr, int index, int min) {

        if (index == arr.length)
            return min;

        if (arr[index] < min)
            min = arr[index];

        return findMinRecursive(arr, index + 1, min);
    }

    // Find Maximum using Recursion
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    static int findMaxRecursive(int[] arr, int index, int max) {

        if (index == arr.length)
            return max;

        if (arr[index] > max)
            max = arr[index];

        return findMaxRecursive(arr, index + 1, max);
    }

    // MAIN METHOD (All function calls here)
    public static void main(String[] args) {

        int[] arr = {3, 8, 12, 20, 25, 30};

        //  Iterative Binary Search (20)
        int index1 = binarySearchIterative(arr, 20);
        System.out.println("Binary Search Iterative (20): Index = " + index1);

        //  Recursive Binary Search (25)
        int index2 = binarySearchRecursive(arr, 0, arr.length - 1, 25);
        System.out.println("Binary Search Recursive (25): Index = " + index2);

        //  Recursive Linear Search (12)
        int index3 = linearSearchRecursive(arr, 0, 12);
        System.out.println("Recursive Linear Search (12): Index = " + index3);

        //  Min & Max using Recursion
        int min = findMinRecursive(arr, 0, arr[0]);
        int max = findMaxRecursive(arr, 0, arr[0]);

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }
}