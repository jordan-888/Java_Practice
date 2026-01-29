package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Merge Sort - Sort Book Prices
 * Problem: A bookstore maintains a list of book prices. Implement Merge Sort to
 * sort the prices in ascending order.
 * 
 * Algorithm:
 * 1. Divide the array into two halves recursively
 * 2. Sort both halves individually
 * 3. Merge the sorted halves by comparing elements
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class MergeSortBookPrices {

    // Merge Sort implementation
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    private static void merge(double[] prices, int left, int mid, int right) {
        // Calculate sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        // Merge the temporary arrays back
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Wrapper method for easier usage
    public static void mergeSort(double[] prices) {
        mergeSort(prices, 0, prices.length - 1);
    }

    // Book class for more realistic scenario
    static class Book {
        String title;
        double price;

        Book(String title, double price) {
            this.title = title;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s ($%.2f)", title, price);
        }
    }

    // Sort Book objects by price
    public static void mergeSortBooks(Book[] books, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortBooks(books, left, mid);
            mergeSortBooks(books, mid + 1, right);
            mergeBooks(books, left, mid, right);
        }
    }

    private static void mergeBooks(Book[] books, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = books[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = books[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].price <= rightArray[j].price) {
                books[k] = leftArray[i];
                i++;
            } else {
                books[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            books[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            books[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Print array with formatting
    private static void printPrices(double[] prices) {
        System.out.print("[");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("$%.2f", prices[i]);
            if (i < prices.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Merge Sort - Book Prices ===\n");

        // Test case 1 - Random book prices
        double[] prices1 = { 29.99, 15.50, 45.00, 12.99, 38.75, 22.50, 50.00 };
        System.out.println("Test Case 1: Random book prices");
        System.out.print("Original: ");
        printPrices(prices1);
        mergeSort(prices1);
        System.out.print("Sorted:   ");
        printPrices(prices1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - Book objects
        Book[] books = {
                new Book("Java Programming", 45.99),
                new Book("Data Structures", 38.50),
                new Book("Algorithms", 52.00),
                new Book("Python Basics", 29.99),
                new Book("Web Development", 41.25),
                new Book("Machine Learning", 65.00),
                new Book("Database Systems", 48.75)
        };

        System.out.println("\nTest Case 2: Sorting Book objects");
        System.out.println("Original books:");
        for (Book book : books) {
            System.out.println("  " + book);
        }

        mergeSortBooks(books, 0, books.length - 1);

        System.out.println("\nSorted books (by price):");
        for (Book book : books) {
            System.out.println("  " + book);
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Large dataset
        double[] prices3 = { 19.99, 25.50, 12.99, 35.00, 18.75, 42.50, 9.99,
                55.00, 28.50, 16.25, 38.99, 22.00, 31.50, 14.99 };
        System.out.println("\nTest Case 3: Large dataset");
        System.out.print("Original: ");
        printPrices(prices3);
        mergeSort(prices3);
        System.out.print("Sorted:   ");
        printPrices(prices3);

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Already sorted
        double[] prices4 = { 10.00, 20.00, 30.00, 40.00, 50.00 };
        System.out.println("\nTest Case 4: Already sorted prices");
        System.out.print("Original: ");
        printPrices(prices4);
        mergeSort(prices4);
        System.out.print("Sorted:   ");
        printPrices(prices4);

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Reverse sorted
        double[] prices5 = { 50.00, 40.00, 30.00, 20.00, 10.00 };
        System.out.println("\nTest Case 5: Reverse sorted prices");
        System.out.print("Original: ");
        printPrices(prices5);
        mergeSort(prices5);
        System.out.print("Sorted:   ");
        printPrices(prices5);
    }
}
