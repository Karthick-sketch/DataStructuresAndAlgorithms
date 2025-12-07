package operations;

import datastructures.linear.Queue;

public class QueueOperations {

  public static void operations() {
    Queue<String> queue = new Queue<>();
    queue.enqueue("Hello");
    queue.enqueue("World");
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}
