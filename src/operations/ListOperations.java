package operations;

import datastructures.linear.list.ArrayList;
import datastructures.linear.list.DoublyLinkedList;
import datastructures.linear.list.LinkedList;
import datastructures.linear.list.List;

public class ListOperations {

  public static void operations() {
    System.out.println("Array List");
    operations(new ArrayList<>());
    System.out.println("\nLinked List");
    operations(new LinkedList<>());
    System.out.println("\nDoubly Linked List");
    operations(new DoublyLinkedList<>());
  }

  private static void operations(List<Integer> list) {
    list.add(5);
    System.out.println("Added value 5");
    list.add(10);
    System.out.println("Added value 10");
    System.out.println("Index of 1: " + list.get(1));
    System.out.println(list);
    list.insert(7, 1);
    System.out.println("Inserted value 7 at index 1");
    list.insert(8, 2);
    System.out.println("Inserted value 8 at index 2");
    System.out.println(list);
    list.set(6, 1);
    System.out.println("Updated at index 1 value to 6");
    System.out.println(list);
    System.out.println("Deleted at index 2: " + list.remove(2));
    System.out.println(list);
    System.out.println("Deleted 10: " + list.remove(Integer.valueOf(10)));
    System.out.println(list);
    System.out.println("Size: " + list.size());
  }
}
