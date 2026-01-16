class SortingAlgorithms {

    // ================= MERGE SORT =================
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted halves
    static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // ================= QUICK SORT =================

    // Average Time Complexity: O(n log n)
    // Worst Time Complexity: O(n^2)
    // Space Complexity: O(log n)
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function
    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Display array
    static void display(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        int[] arr1 = {5, 1, 4, 2, 8};
        int[] arr2 = {5, 1, 4, 2, 8};

        System.out.print("Original Array: ");
        display(arr1);

        // Merge Sort
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.print("After Merge Sort: ");
        display(arr1);

        // Quick Sort
        quickSort(arr2, 0, arr2.length - 1);
        System.out.print("After Quick Sort: ");
        display(arr2);
    }
}