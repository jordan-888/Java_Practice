package DataStructures.StacksQueuesHashMapsHashFunctions;

/**
 * Circular Tour Problem
 * Problem: Given a set of petrol pumps with petrol and distance to the next
 * pump,
 * determine the starting point for completing a circular tour.
 * Approach: Use a greedy approach to find the starting pump where the tour can
 * be completed.
 */
public class CircularTourProblem {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Find the starting point for circular tour
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int currentPetrol = 0;
        int totalPetrol = 0;
        int totalDistance = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += pumps[i].petrol;
            totalDistance += pumps[i].distance;
            currentPetrol += pumps[i].petrol - pumps[i].distance;

            // If current petrol becomes negative, we can't start from 'start'
            // So we try starting from the next pump
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        // If total petrol is less than total distance, tour is not possible
        if (totalPetrol < totalDistance) {
            return -1;
        }

        return start;
    }

    // Verify if the tour is possible from the given starting point
    public static boolean verifyTour(PetrolPump[] pumps, int start) {
        if (start == -1)
            return false;

        int n = pumps.length;
        int currentPetrol = 0;

        for (int i = 0; i < n; i++) {
            int index = (start + i) % n;
            currentPetrol += pumps[index].petrol - pumps[index].distance;

            if (currentPetrol < 0) {
                return false;
            }
        }

        return true;
    }

    // Print pump details
    private static void printPumps(PetrolPump[] pumps) {
        System.out.println("\nPump\tPetrol\tDistance");
        System.out.println("----\t------\t--------");
        for (int i = 0; i < pumps.length; i++) {
            System.out.printf("%d\t%d\t%d\n", i, pumps[i].petrol, pumps[i].distance);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Circular Tour Problem ===\n");

        // Test case 1 - Tour possible
        PetrolPump[] pumps1 = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        System.out.println("Test Case 1:");
        printPumps(pumps1);
        int start1 = findStartingPoint(pumps1);
        if (start1 != -1) {
            System.out.println("\nStarting pump: " + start1);
            System.out.println("Tour possible: " + verifyTour(pumps1, start1));
        } else {
            System.out.println("\nNo solution exists - Tour not possible");
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 2 - Tour not possible
        PetrolPump[] pumps2 = {
                new PetrolPump(2, 6),
                new PetrolPump(3, 5),
                new PetrolPump(1, 3),
                new PetrolPump(2, 5)
        };

        System.out.println("\nTest Case 2:");
        printPumps(pumps2);
        int start2 = findStartingPoint(pumps2);
        if (start2 != -1) {
            System.out.println("\nStarting pump: " + start2);
            System.out.println("Tour possible: " + verifyTour(pumps2, start2));
        } else {
            System.out.println("\nNo solution exists - Tour not possible");
        }

        System.out.println("\n" + "=".repeat(50));

        // Test case 3 - Tour possible from first pump
        PetrolPump[] pumps3 = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        System.out.println("\nTest Case 3:");
        printPumps(pumps3);
        int start3 = findStartingPoint(pumps3);
        if (start3 != -1) {
            System.out.println("\nStarting pump: " + start3);
            System.out.println("Tour possible: " + verifyTour(pumps3, start3));
        } else {
            System.out.println("\nNo solution exists - Tour not possible");
        }
    }
}
