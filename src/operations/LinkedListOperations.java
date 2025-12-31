package operations;

import datastructures.linear.linkedlist.DoublyLinkedList;
import datastructures.linear.linkedlist.LinkedList;
import datastructures.linear.linkedlist.SinglyLinkedList;

public class LinkedListOperations {

  public static void operations() {
    System.out.println("Singly Linked List");
    operations(new SinglyLinkedList<>());
    System.out.println("\nDoubly Linked List");
    operations(new DoublyLinkedList<>());
  }

  private static void operations(LinkedList<Integer> linkedList) {
    linkedList.add(5);
    System.out.println("Added value 5");
    linkedList.add(10);
    System.out.println("Added value 10");
    System.out.println("Index of 1: " + linkedList.get(1));
    System.out.println(linkedList);
    linkedList.insert(7, 1);
    System.out.println("Inserted value 7 at index 1");
    linkedList.insert(8, 2);
    System.out.println("Inserted value 8 at index 2");
    System.out.println(linkedList);
    linkedList.set(6, 1);
    System.out.println("Updated at index 1 value to 6");
    System.out.println(linkedList);
    System.out.println("Deleted at index 2: " + linkedList.remove(2));
    System.out.println(linkedList);
    System.out.println("Deleted 10: " + linkedList.remove(Integer.valueOf(10)));
    System.out.println(linkedList);
    System.out.println("Size: " + linkedList.size());
  }
}
