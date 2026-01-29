package datastructures.stacksqueueshashmapshashfunctions;
import java.util.Stack;

/**
 * Implement a Queue Using Two Stacks
 * Problem: Design a queue using two stacks such that enqueue and dequeue
 * operations are performed efficiently.
 * Approach: Use stack1 for enqueue and stack2 for dequeue. Transfer elements
 * between stacks as needed.
 */
public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue operations
    private Stack<Integer> stack2; // For dequeue operations

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation - O(1)
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation - Amortized O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int dequeued = stack2.pop();
        System.out.println("Dequeued: " + dequeued);
        return dequeued;
    }

    // Peek operation - Amortized O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get size of queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        System.out.println("=== Queue Using Two Stacks ===\n");

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("\nQueue size: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        // Dequeue elements
        System.out.println();
        queue.dequeue();
        queue.dequeue();

        System.out.println("\nQueue size after dequeue: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        // Enqueue more elements
        System.out.println();
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println("\nFinal queue size: " + queue.size());

        // Dequeue all remaining elements
        System.out.println("\nDequeuing all elements:");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }
}
