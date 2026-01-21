package DataStructures.StacksQueuesHashMapsHashFunctions;

import java.util.Stack;

/**
 * Sort a Stack Using Recursion
 * Problem: Given a stack, sort its elements in ascending order using recursion.
 * Approach: Pop elements recursively, sort the remaining stack, and insert the
 * popped element back at the correct position.
 */
public class SortStackRecursion {

    // Main method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int temp = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the popped element back in sorted order
            insertInSortedOrder(stack, temp);
        }
    }

    // Helper method to insert element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: if stack is empty or element is greater than top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int temp = stack.pop();

        // Recursively insert the element
        insertInSortedOrder(stack, element);

        // Push back the removed element
        stack.push(temp);
    }

    // Utility method to print stack
    private static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Stack<Integer> temp = new Stack<>();
        System.out.print("Stack (top to bottom): ");

        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.print(val + " ");
            temp.push(val);
        }

        // Restore original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("=== Sort Stack Using Recursion ===\n");

        // Push elements
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original stack:");
        printStack(stack);

        // Sort the stack
        sortStack(stack);

        System.out.println("\nSorted stack (ascending order):");
        printStack(stack);

        System.out.println("\nPopping elements in sorted order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
