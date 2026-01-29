package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Quick Sort - Sort Product Prices
 * Problem: An e-commerce company wants to display product prices in ascending
 * order. Implement Quick Sort.
 * 
 * Algorithm:
 * 1. Pick a pivot element (last element in this implementation)
 * 2. Partition the array: elements smaller than pivot on left, larger on right
 * 3. Recursively apply Quick Sort on left and right partitions
 * 
 * Time Complexity: O(n log n) average, O(n²) worst case
 * Space Complexity: O(log n) for recursion stack
 */
public class QuickSortProductPrices {

    // Quick Sort implementation
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition method - places pivot at correct position
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and prices[high] (pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Wrapper method for easier usage
    public static void quickSort(double[] prices) {
        quickSort(prices, 0, prices.length - 1);
    }

    // Quick Sort with random pivot
    public static void quickSortRandomPivot(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandomPivot(prices, low, high);
            quickSortRandomPivot(prices, low, pivotIndex - 1);
            quickSortRandomPivot(prices, pivotIndex + 1, high);
        }
    }

    private static int partitionRandomPivot(double[] prices, int low, int high) {
        // Choose random pivot
        int randomIndex = low + (int) (Math.random() * (high - low + 1));

        // Swap random element with last element
        double temp = prices[randomIndex];
        prices[randomIndex] = prices[high];
        prices[high] = temp;

        return partition(prices, low, high);
    }

    // Product class for more realistic scenario
    static class Product {
        String name;
        double price;
        String category;

        Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("%s ($%.2f) [%s]", name, price, category);
        }
    }

    // Sort Product objects by price
    public static void quickSortProducts(Product[] products, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionProducts(products, low, high);
            quickSortProducts(products, low, pivotIndex - 1);
            quickSortProducts(products, pivotIndex + 1, high);
        }
    }

    private static int partitionProducts(Product[] products, int low, int high) {
        double pivot = products[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (products[j].price <= pivot) {
                i++;
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
            }
        }

        Product temp = products[i + 1];
        products[i + 1] = products[high];
        products[high] = temp;

        return i + 1;
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
        System.out.println("=== Quick Sort - Product Prices ===\n");

        // Test case 1 - Random product prices
        double[] prices1 = { 299.99, 149.50, 499.00, 89.99, 199.75, 349.50, 599.00 };
        System.out.println("Test Case 1: Random product prices");
        System.out.print("Original: ");
        printPrices(prices1);
        quickSort(prices1);
        System.out.print("Sorted:   ");
        printPrices(prices1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - Product objects
        Product[] products = {
                new Product("Laptop", 899.99, "Electronics"),
                new Product("Mouse", 25.50, "Accessories"),
                new Product("Keyboard", 75.00, "Accessories"),
                new Product("Monitor", 299.99, "Electronics"),
                new Product("Headphones", 149.99, "Audio"),
                new Product("Webcam", 89.50, "Electronics"),
                new Product("USB Cable", 12.99, "Accessories")
        };

        System.out.println("\nTest Case 2: Sorting Product objects");
        System.out.println("Original products:");
        for (Product product : products) {
            System.out.println("  " + product);
        }

        quickSortProducts(products, 0, products.length - 1);

        System.out.println("\nSorted products (by price):");
        for (Product product : products) {
            System.out.println("  " + product);
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Large dataset
        double[] prices3 = { 199.99, 299.50, 149.99, 399.00, 249.75, 499.50, 99.99,
                599.00, 349.50, 179.25, 449.99, 279.00, 399.50, 169.99 };
        System.out.println("\nTest Case 3: Large dataset");
        System.out.print("Original: ");
        printPrices(prices3);
        quickSort(prices3);
        System.out.print("Sorted:   ");
        printPrices(prices3);

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - With random pivot
        double[] prices4 = { 599.00, 299.00, 799.00, 199.00, 499.00, 399.00 };
        System.out.println("\nTest Case 4: Quick Sort with random pivot");
        System.out.print("Original: ");
        printPrices(prices4);
        quickSortRandomPivot(prices4, 0, prices4.length - 1);
        System.out.print("Sorted:   ");
        printPrices(prices4);

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Duplicate prices
        double[] prices5 = { 99.99, 149.99, 99.99, 199.99, 149.99, 99.99 };
        System.out.println("\nTest Case 5: Duplicate prices");
        System.out.print("Original: ");
        printPrices(prices5);
        quickSort(prices5);
        System.out.print("Sorted:   ");
        printPrices(prices5);
    }
}
