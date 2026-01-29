package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Insertion Sort - Sort Employee IDs
 * Problem: A company stores employee IDs in an unsorted array. Implement
 * Insertion Sort to sort them in ascending order.
 * 
 * Algorithm:
 * 1. Divide the array into sorted and unsorted parts
 * 2. Pick an element from the unsorted part
 * 3. Insert it into its correct position in the sorted part
 * 4. Repeat for all elements
 * 
 * Time Complexity: O(n²) worst case, O(n) best case
 * Space Complexity: O(1)
 */
public class InsertionSortEmployeeIDs {

    // Insertion Sort implementation
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            employeeIDs[j + 1] = key;
        }
    }

    // Insertion Sort with step-by-step visualization
    public static void insertionSortWithVisualization(int[] employeeIDs) {
        int n = employeeIDs.length;

        System.out.println("Initial Employee IDs: " + Arrays.toString(employeeIDs));
        System.out.println("\nSorting process:");

        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            System.out.printf("\nStep %d: Inserting %d\n", i, key);
            System.out.println("  Sorted part: " + Arrays.toString(Arrays.copyOfRange(employeeIDs, 0, i)));

            // Move elements greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            employeeIDs[j + 1] = key;
            System.out.println("  After insertion: " + Arrays.toString(employeeIDs));
        }
    }

    // Employee class for more realistic scenario
    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("ID:%d(%s)", id, name);
        }
    }

    // Sort Employee objects by ID
    public static void insertionSortEmployees(Employee[] employees) {
        int n = employees.length;

        for (int i = 1; i < n; i++) {
            Employee key = employees[i];
            int j = i - 1;

            while (j >= 0 && employees[j].id > key.id) {
                employees[j + 1] = employees[j];
                j--;
            }

            employees[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Insertion Sort - Employee IDs ===\n");

        // Test case 1 - Random employee IDs
        int[] ids1 = { 1045, 1012, 1089, 1003, 1067, 1034, 1098 };
        System.out.println("Test Case 1: Random employee IDs");
        System.out.println("Original: " + Arrays.toString(ids1));
        insertionSort(ids1);
        System.out.println("Sorted:   " + Arrays.toString(ids1));

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - With visualization
        int[] ids2 = { 2045, 2012, 2089, 2003, 2067 };
        System.out.println("\nTest Case 2: Sorting with visualization");
        insertionSortWithVisualization(ids2);

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Nearly sorted
        int[] ids3 = { 3001, 3002, 3003, 3005, 3004, 3006 };
        System.out.println("\nTest Case 3: Nearly sorted IDs");
        System.out.println("Original: " + Arrays.toString(ids3));
        insertionSort(ids3);
        System.out.println("Sorted:   " + Arrays.toString(ids3));

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Employee objects
        Employee[] employees = {
                new Employee(1045, "Alice"),
                new Employee(1012, "Bob"),
                new Employee(1089, "Charlie"),
                new Employee(1003, "David"),
                new Employee(1067, "Eve")
        };

        System.out.println("\nTest Case 4: Sorting Employee objects");
        System.out.print("Original: ");
        for (Employee emp : employees) {
            System.out.print(emp + " ");
        }

        insertionSortEmployees(employees);

        System.out.print("\nSorted:   ");
        for (Employee emp : employees) {
            System.out.print(emp + " ");
        }
        System.out.println();

        System.out.println("\n" + "=".repeat(50));

        // Test case 5 - Single element
        int[] ids5 = { 5001 };
        System.out.println("\nTest Case 5: Single employee ID");
        System.out.println("Original: " + Arrays.toString(ids5));
        insertionSort(ids5);
        System.out.println("Sorted:   " + Arrays.toString(ids5));

        System.out.println("\n" + "=".repeat(50));

        // Test case 6 - Duplicate IDs
        int[] ids6 = { 6001, 6005, 6001, 6003, 6005, 6002 };
        System.out.println("\nTest Case 6: Duplicate employee IDs");
        System.out.println("Original: " + Arrays.toString(ids6));
        insertionSort(ids6);
        System.out.println("Sorted:   " + Arrays.toString(ids6));
    }
}
