import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 2, 9, 1, 5, 8, 6, 7, 3, 4 };

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // For each element in the array, except the first one
        for (int i = n - 1; i >= 0; i--) {
            // Swap the first element and the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the array again, except the last element
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        // Find the largest child of the current node
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the current node is not the largest child, swap it with the largest child
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Heapify the subtree with the largest child as the root
            heapify(arr, n, largest);
        }
    }
}
