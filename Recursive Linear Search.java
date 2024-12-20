import java.util.Scanner;

class RecursiveBinarySearch {
    // Recursive binary search method
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // Target not found
        }

        int mid = low + (high - low) / 2; // To avoid overflow

        if (arr[mid] == target) {
            return mid; // Target found
        }
        if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target); // Search in the right half
        } else {
            return binarySearch(arr, low, mid - 1, target); // Search in the left half
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int target = sc.nextInt();

        int result = binarySearch(arr, 0, n - 1, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        sc.close();
    }
}
