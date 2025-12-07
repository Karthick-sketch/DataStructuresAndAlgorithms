package operations;

import algorithms.search.*;
import algorithms.sort.InsertionSort;
import algorithms.sort.Sort;
import java.util.Arrays;
import java.util.Scanner;

public class SearchOperations {

  private static Scanner scanner;

  public static void operations(Scanner scn) {
    scanner = scn;
    operations();
  }

  private static void operations() {
    int[] arr = Randomize.randomizeArray(10);
    System.out.println("0. Back\n1. Linear Search");
    System.out.println("2. Jump Search\n3. Binary Search");
    System.out.print("> ");
    int ip = scanner.nextInt();
    if (ip != 0) {
      if (ip >= 1 && ip <= 3) {
        Search search;
        if (ip == 1) {
          System.out.print("Elements: " + Arrays.toString(arr) + "\n> ");
          search = new LinearSearch();
        } else {
          Sort sort = new InsertionSort();
          sort.sort(arr);
          System.out.print("Elements: " + Arrays.toString(arr) + "\n> ");
          if (ip == 2) {
            search = new JumpSearch();
          } else {
            search = new BinarySearch();
          }
        }
        int index = search.search(arr, scanner.nextInt());
        System.out.println(index == -1 ? "Not found" : "Index: " + index);
      }
      operations();
    }
  }
}
