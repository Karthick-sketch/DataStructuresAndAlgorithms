package operations;

import datastructures.linear.queue.PriorityQueue;
import datastructures.linear.queue.Queue;

public class QueueOperations {

  public static void operations() {
    System.out.println("Queue:");
    queueOperations();
    System.out.println("\nHigh Priority Queue:");
    highPriorityQueueOperations();
    System.out.println("\nLow Priority Queue:");
    lowPriorityQueueOperations();
    System.out.println();
  }

  public static void queueOperations() {
    Queue<String> queue = new Queue<>();
    queue.enqueue("Hello");
    queue.enqueue("World");
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }

  public static void highPriorityQueueOperations() {
    priorityQueueOperations(new PriorityQueue(true));
  }

  public static void lowPriorityQueueOperations() {
    priorityQueueOperations(new PriorityQueue(false));
  }

  private static void priorityQueueOperations(PriorityQueue queue) {
    queue.enqueue(81);
    queue.enqueue(24);
    queue.enqueue(88);
    queue.enqueue(37);
    queue.enqueue(59);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}
