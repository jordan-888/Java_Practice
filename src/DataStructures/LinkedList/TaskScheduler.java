package DataStructures.LinkedList;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    int dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, int dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskLinkedList {
    private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addAtBeginning(int taskId, String taskName, int priority, int dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        TaskNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int taskId, String taskName, int priority, int dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        TaskNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    public void addAtPosition(int taskId, String taskName, int priority, int dueDate, int position) {
        // If position is 0, add at beginning
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        TaskNode current = head;
        int count = 0;

        // Traverse to position-1 (or until we complete the circle)
        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        if (count < position - 1) {
            System.out.println("Position out of bounds");
            return;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        while (current.next != head && current.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        if (current.taskId != taskId) {
            System.out.println("Task not found");
            return;
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        TaskNode current = head;
        System.out.println("\n=== Task Scheduler ===");
        do {
            System.out.printf("Task ID: %d | Name: %s | Priority: %d | Due Date: %d\n",
                    current.taskId, current.taskName, current.priority, current.dueDate);
            current = current.next;
        } while (current != head);
        System.out.println("======================\n");
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addAtBeginning(1, "Task 1", 1, 1);
        taskList.addAtEnd(2, "Task 2", 2, 2);
        taskList.addAtPosition(3, "Task 3", 3, 3, 1);

        taskList.display();
    }
}