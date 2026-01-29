package datastructures.sortingalgorithms;
import java.util.Arrays;

/**
 * Heap Sort - Sort Job Applicants by Salary
 * Problem: A company receives job applications with different expected salary
 * demands.
 * Implement Heap Sort to sort these salary demands in ascending order.
 * 
 * Algorithm:
 * 1. Build a Max Heap from the array
 * 2. Extract the largest element (root) and place it at the end
 * 3. Reheapify the remaining elements and repeat until sorted
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class HeapSortJobSalaries {

    // Heap Sort implementation
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // JobApplicant class for more realistic scenario
    static class JobApplicant {
        String name;
        int expectedSalary;
        String position;
        int experience;

        JobApplicant(String name, int expectedSalary, String position, int experience) {
            this.name = name;
            this.expectedSalary = expectedSalary;
            this.position = position;
            this.experience = experience;
        }

        @Override
        public String toString() {
            return String.format("%s - %s ($%,d, %d yrs exp)",
                    name, position, expectedSalary, experience);
        }
    }

    // Sort JobApplicant objects by salary
    public static void heapSortApplicants(JobApplicant[] applicants) {
        int n = applicants.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyApplicants(applicants, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            JobApplicant temp = applicants[0];
            applicants[0] = applicants[i];
            applicants[i] = temp;

            heapifyApplicants(applicants, i, 0);
        }
    }

    private static void heapifyApplicants(JobApplicant[] applicants, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && applicants[left].expectedSalary > applicants[largest].expectedSalary) {
            largest = left;
        }

        if (right < n && applicants[right].expectedSalary > applicants[largest].expectedSalary) {
            largest = right;
        }

        if (largest != i) {
            JobApplicant swap = applicants[i];
            applicants[i] = applicants[largest];
            applicants[largest] = swap;

            heapifyApplicants(applicants, n, largest);
        }
    }

    // Print salary statistics
    private static void printSalaryStatistics(int[] salaries) {
        int sum = 0;
        int min = salaries[0];
        int max = salaries[0];

        for (int salary : salaries) {
            sum += salary;
            if (salary < min)
                min = salary;
            if (salary > max)
                max = salary;
        }

        double average = (double) sum / salaries.length;
        int median = salaries[salaries.length / 2];

        System.out.println("\n=== Salary Statistics ===");
        System.out.printf("Total applicants: %d\n", salaries.length);
        System.out.printf("Highest salary: $%,d\n", max);
        System.out.printf("Lowest salary: $%,d\n", min);
        System.out.printf("Average salary: $%,.2f\n", average);
        System.out.printf("Median salary: $%,d\n", median);
    }

    // Format salary array for display
    private static void printSalaries(int[] salaries) {
        System.out.print("[");
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("$%,d", salaries[i]);
            if (i < salaries.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Heap Sort - Job Applicant Salaries ===\n");

        // Test case 1 - Random salary expectations
        int[] salaries1 = { 75000, 95000, 65000, 85000, 70000, 90000, 80000 };
        System.out.println("Test Case 1: Random salary expectations");
        System.out.print("Original: ");
        printSalaries(salaries1);
        heapSort(salaries1);
        System.out.print("Sorted:   ");
        printSalaries(salaries1);
        printSalaryStatistics(salaries1);

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - JobApplicant objects
        JobApplicant[] applicants = {
                new JobApplicant("Alice Johnson", 95000, "Senior Developer", 5),
                new JobApplicant("Bob Smith", 75000, "Junior Developer", 2),
                new JobApplicant("Charlie Brown", 110000, "Tech Lead", 8),
                new JobApplicant("Diana Prince", 85000, "Developer", 4),
                new JobApplicant("Eve Adams", 65000, "Junior Developer", 1),
                new JobApplicant("Frank Miller", 120000, "Architect", 10),
                new JobApplicant("Grace Lee", 90000, "Senior Developer", 6)
        };

        System.out.println("\nTest Case 2: Sorting Job Applicants");
        System.out.println("Original applicants:");
        for (JobApplicant applicant : applicants) {
            System.out.println("  " + applicant);
        }

        heapSortApplicants(applicants);

        System.out.println("\nSorted applicants (by salary):");
        for (JobApplicant applicant : applicants) {
            System.out.println("  " + applicant);
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Large dataset
        int[] salaries3 = { 85000, 72000, 95000, 68000, 78000, 92000, 65000,
                105000, 88000, 75000, 98000, 82000, 90000, 70000 };
        System.out.println("\nTest Case 3: Large dataset");
        System.out.print("Original: ");
        printSalaries(salaries3);
        heapSort(salaries3);
        System.out.print("Sorted:   ");
        printSalaries(salaries3);
        printSalaryStatistics(salaries3);

        System.out.println("\n" + "=".repeat(50));

        // Test case 4 - Wide salary range
        int[] salaries4 = { 150000, 45000, 120000, 55000, 95000, 75000 };
        System.out.println("\nTest Case 4: Wide salary range");
        System.out.print("Original: ");
        printSalaries(salaries4);
        heapSort(salaries4);
        System.out.print("Sorted:   ");
        printSalaries(salaries4);
        printSalaryStatistics(salaries4);
    }
}
