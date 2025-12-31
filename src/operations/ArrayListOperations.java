package operations;

import datastructures.linear.ArrayList;

public class ArrayListOperations {

  public static void operations() {
    ArrayList<Integer> arrayList = new ArrayList<>();
    System.out.println("Array List");
    arrayList.add(5);
    System.out.println("Added value 5");
    arrayList.add(10);
    System.out.println("Added value 10");
    System.out.println("Index of 1: " + arrayList.get(1));
    System.out.println(arrayList);
    arrayList.insert(7, 1);
    System.out.println("Inserted value 7 at index 1");
    arrayList.insert(8, 2);
    System.out.println("Inserted value 8 at index 2");
    System.out.println(arrayList);
    arrayList.set(6, 1);
    System.out.println("Updated at index 1 value to 6");
    System.out.println(arrayList);
    System.out.println("Deleted at index 2: " + arrayList.remove(2));
    System.out.println(arrayList);
    System.out.println("Deleted 10: " + arrayList.remove(Integer.valueOf(10)));
    System.out.println(arrayList);
    System.out.println("Size: " + arrayList.size());
  }
}
