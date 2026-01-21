package DataStructures.StacksQueuesHashMapsHashFunctions;

import java.util.Stack;
import java.util.Arrays;

/**
 * Stock Span Problem
 * Problem: For each day in a stock price array, calculate the span
 * (number of consecutive days the price was less than or equal to the current
 * day's price).
 * Approach: Use a stack to keep track of indices of prices in descending order.
 */
public class StockSpanProblem {

    // Calculate stock span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while current price is greater than or equal to stack
            // top price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1 (all previous days)
            // Otherwise, span is the difference between current index and top of stack
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index to stack
            stack.push(i);
        }

        return span;
    }

    // Print stock prices and their spans
    private static void printStockSpan(int[] prices, int[] span) {
        System.out.println("\nDay\tPrice\tSpan");
        System.out.println("---\t-----\t----");
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%d\t%d\t%d\n", i + 1, prices[i], span[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stock Span Problem ===\n");

        // Test case 1
        int[] prices1 = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println("Stock prices: " + Arrays.toString(prices1));
        int[] span1 = calculateSpan(prices1);
        printStockSpan(prices1, span1);

        System.out.println("\n" + "=".repeat(40));

        // Test case 2
        int[] prices2 = { 10, 4, 5, 90, 120, 80 };
        System.out.println("\nStock prices: " + Arrays.toString(prices2));
        int[] span2 = calculateSpan(prices2);
        printStockSpan(prices2, span2);

        System.out.println("\n" + "=".repeat(40));

        // Test case 3 - Increasing prices
        int[] prices3 = { 30, 40, 50, 60, 70 };
        System.out.println("\nStock prices (increasing): " + Arrays.toString(prices3));
        int[] span3 = calculateSpan(prices3);
        printStockSpan(prices3, span3);

        System.out.println("\n" + "=".repeat(40));

        // Test case 4 - Decreasing prices
        int[] prices4 = { 70, 60, 50, 40, 30 };
        System.out.println("\nStock prices (decreasing): " + Arrays.toString(prices4));
        int[] span4 = calculateSpan(prices4);
        printStockSpan(prices4, span4);
    }
}
