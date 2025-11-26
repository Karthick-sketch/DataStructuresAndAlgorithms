package operations;

import algorithms.search.*;
import algorithms.sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class SearchOperations {

  public static void operations() {
    operations(Randomize.randomizeArray(10));
  }

  private static void operations(int[] arr) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("1. Linear Search\n2. Jump Search\n3. Binary Search\n> ");
    int ip = scanner.nextInt();
    if (ip >= 1 && ip <= 3) {
      System.out.print("Elements: " + Arrays.toString(arr) + "\n> ");
      Search search;
      if (ip == 1) {
        search = new LinearSearch();
      } else {
        Sort.insertionSort(arr);
        if (ip == 2) {
          search = new JumpSearch();
        } else {
          search = new BinarySearch();
        }
      }
      int index = search.search(arr, scanner.nextInt());
      System.out.println(index == -1 ? "Not found" : "Index: " + index);
    } else {
      operations(arr);
    }
    scanner.close();
  }
}
