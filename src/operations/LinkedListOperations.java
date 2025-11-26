package operations;

import datastructures.linear.DoublyLinkedList;
import datastructures.linear.LinkedList;
import datastructures.linear.SinglyLinkedList;

public class LinkedListOperations {

  public static void operations() {
    System.out.println("Singly Linked List");
    operations(new SinglyLinkedList<>());
    System.out.println("\nDoubly Linked List");
    operations(new DoublyLinkedList<>());
  }

  private static void operations(LinkedList<Integer> linkedList) {
    linkedList.add(5);
    linkedList.add(10);
    System.out.println("Index of 1: " + linkedList.get(1));
    System.out.println(linkedList);
    linkedList.insert(7, 1);
    linkedList.insert(8, 2);
    System.out.println(linkedList);
    linkedList.update(6, 1);
    System.out.println(linkedList);
    linkedList.delete(2);
    System.out.println(linkedList);
    System.out.println("Size: " + linkedList.size());
  }
}
